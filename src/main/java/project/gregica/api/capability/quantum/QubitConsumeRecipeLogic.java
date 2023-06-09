package project.gregica.api.capability.quantum;


import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.Recipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import javax.annotation.Nonnull;

public class QubitConsumeRecipeLogic extends MultiblockRecipeLogic {


    private int recipeQubit;
    private boolean hasEnoughQubit = true;

    public QubitConsumeRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
        super(metaTileEntity);
    }

    public IQubitContainer getInputQubitContainer() {
        QubitRecipeMapMultiblockController controller = (QubitRecipeMapMultiblockController) metaTileEntity;
        return controller.getInputQubitContainer();
    }

    @Override
    protected int[] calculateOverclock(@Nonnull Recipe recipe) {
        if (recipeQubit > 0) {
            return new int[]{recipe.getEUt(), recipe.getDuration()};
        }
        return super.calculateOverclock(recipe);
    }

    @Override
    protected void setupRecipe(Recipe recipe) {
        super.setupRecipe(recipe);
        recipeQubit = recipe.getProperty(OutputQubitProperty.getInstance(), 0);
    }

    @Override
    protected void completeRecipe() {
        super.completeRecipe();
        recipeQubit = 0;
        hasEnoughQubit = true;
    }

    @Override
    public void updateRecipeProgress() {
        if (this.recipeQubit == 0 || this.drawQubit(this.recipeQubit)) {
            super.updateRecipeProgress();
            hasEnoughQubit = true;
        } else {
            hasEnoughQubit = false;
        }
    }

    protected boolean drawQubit(int qubit) {
        long resultQubit = this.getInputQubitContainer().getQubitStored() - (long) qubit;
        if (resultQubit >= 0L && resultQubit <= this.getInputQubitContainer().getQubitCapacity()) {
            this.getInputQubitContainer().changeQubit(-qubit);
            return true;
        } else {
            return false;
        }
    }

    public boolean isHasEnoughQubit() {
        return hasEnoughQubit;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        if (progressTime > 0) {
            compound.setInteger("RecipeQubit", this.recipeQubit);
        }
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound) {
        super.deserializeNBT(compound);
        this.isActive = false;
        if (progressTime > 0) {
            this.isActive = true;
            this.recipeQubit = compound.getInteger("RecipeQubit");
        }
    }

    @Override
    public void writeInitialData(PacketBuffer buf) {
        super.writeInitialData(buf);
        buf.writeBoolean(this.hasEnoughQubit);
    }

    @Override
    public void receiveInitialData(PacketBuffer buf) {
        super.receiveInitialData(buf);
        this.hasEnoughQubit = buf.readBoolean();
    }
}