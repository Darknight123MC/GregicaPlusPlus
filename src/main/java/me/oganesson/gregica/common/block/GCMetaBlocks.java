package me.oganesson.gregica.common.block;

import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.block.metablock.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class GCMetaBlocks {

    public GCMetaBlocks(){}
    
    public static final GCMetaCasing GC_BLOCK_CASING = new GCMetaCasing();
    public static final GCMetaCells GC_ESSENTIA_CELLS = new GCMetaCells();
    
    public static final GCLapotronicCasing GC_LAPOTRONIC_CASING = new GCLapotronicCasing();
    
    public static final GCMetaGlasses TRANSPARENT_CASING = new GCMetaGlasses("glasses_casing");
    public static final GCMetaGlasses1 TRANSPARENT_CASING1 = new GCMetaGlasses1("glasses_casing1");


    public static boolean isEssentiaCell(IBlockState state) {
        if (!state.getBlock().equals(GC_ESSENTIA_CELLS)) {
            return false;
        }
        if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T1))) {
            return true;
        } else if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T2))) {
            return true;
        } else if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T3))) {
            return true;
        } else return state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T4));
    }
    public static boolean isMachineCasing(IBlockState state) {
        return state.getBlock().equals(MetaBlocks.MACHINE_CASING);
    }

    public static int getCellTier(IBlockState state) {
        if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T1))) {
            return 1;
        } else if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T2))) {
            return 2;
        } else if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T3))) {
            return 3;
        } else if (state.equals(GC_ESSENTIA_CELLS.getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T4))) {
            return 4;
        }
        return -1;
    }

    public static GCMetaCasing.MetalCasingType getType(IBlockState state){
        return GC_BLOCK_CASING.getState(state);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(GC_BLOCK_CASING);
        registerItemModel(GC_ESSENTIA_CELLS);
        registerItemModel(GC_LAPOTRONIC_CASING);
        registerItemModel(TRANSPARENT_CASING);
        registerItemModel(TRANSPARENT_CASING1);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

}