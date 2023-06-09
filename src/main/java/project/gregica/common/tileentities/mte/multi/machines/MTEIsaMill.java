package project.gregica.common.tileentities.mte.multi.machines;


import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.damagesources.DamageSources;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.core.advancement.AdvancementTriggers;
import project.gregica.api.capability.GCCapabilities;
import project.gregica.api.capability.isa_mill.IsaMillProperties;
import project.gregica.api.item.IBall;
import project.gregica.api.recipe.GCRecipeMaps;
import project.gregica.client.GCTextures;
import project.gregica.common.block.GCMetaBlocks;
import project.gregica.common.block.metablock.GCMetaCasing;
import project.gregica.common.block.metablock.GCMetaGearBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;

public class MTEIsaMill extends RecipeMapMultiblockController {

    private int ball_tier = 0;

    public MTEIsaMill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.ISAMILL_GRINDER);
        this.recipeMapWorkable = new MTEIsaMill.IsaMillLogic(this);
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ISA_MILL_CASING);
    }

    protected IBlockState getCasingState1() {
        return GCMetaBlocks.GC_META_GEAR_BOX.getState(GCMetaGearBox.GearBoxType.ISA_MILL_GEARBOX);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEE", "EEE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("CCC", "CSC", "CCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()))
                .where('E', states(getCasingState()).setMinGlobalLimited(31)
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(GCCapabilities.GRINDBALL).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                         .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('G', states(getCasingState1()))
                //.where('#', any())
                .build();
    }

    public IBall getBallHolder() {
        List<IBall> abilities = getAbilities(GCCapabilities.GRINDBALL);
        if (abilities.isEmpty())
            return null;
        return abilities.get(0);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCTextures.ISA_MILL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEIsaMill(metaTileEntityId);
    }

    private boolean onRotorHolderInteract(@Nonnull EntityPlayer player) {
        if (player.isCreative()) return false;

        if (!getWorld().isRemote && this.isActive()) {
            player.attackEntityFrom(DamageSources.getTurbineDamage(), 7);
            AdvancementTriggers.ROTOR_HOLDER_DEATH.trigger((EntityPlayerMP) player);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn) || super.onRightClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public boolean onWrenchClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn) || super.onWrenchClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn);
    }

    @Override
    public void onLeftClick(EntityPlayer player, EnumFacing facing, CuboidRayTraceResult hitResult) {
        onRotorHolderInteract(player);
    }

    @Override
    public void update() {
        super.update();

        List<IBall> abilities = getAbilities(GCCapabilities.GRINDBALL);

        if(!abilities.isEmpty() && abilities.get(0) != null)
            this.ball_tier = getBallHolder().getGrinderTier();
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        Textures.ROTOR_HOLDER_OVERLAY.renderSided(getFrontFacing(), renderState, translation, pipeline);
        GCTextures.ISA_MILL.renderSided(renderState, translation, pipeline, getFrontFacing(), isStructureFormed(), this.getRecipeLogic().isActive());
    }

    public class IsaMillLogic extends MultiblockRecipeLogic{

        private final MTEIsaMill metaTileEntity;

        public IsaMillLogic(MTEIsaMill tileEntity) {
            super(tileEntity);
            this.metaTileEntity = tileEntity;
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (!super.checkRecipe(recipe))
                return false;

            return recipe.getProperty(IsaMillProperties.getInstance(), 0) == ball_tier;
        }

        protected boolean canProgressRecipe() {
            return (super.canProgressRecipe() && !((IMultiblockController)this.metaTileEntity).isStructureObstructed() && this.metaTileEntity.getBallHolder().hasBall());
        }
    }
}
