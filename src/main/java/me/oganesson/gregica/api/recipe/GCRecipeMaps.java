package me.oganesson.gregica.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.BlastRecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import me.oganesson.gregica.api.capability.quantum.QubitConsumerRecipeBuilder;
import me.oganesson.gregica.api.capability.quantum.QubitProducerRecipeBuilder;
import me.oganesson.gregica.api.recipe.builder.NoCoilTemperatureRecipeBuilder;
import me.oganesson.gregica.api.recipe.builder.PressureRecipeBuilder;
import me.oganesson.gregica.api.recipe.builder.TemperaturePressureRecipeBuilder;
import me.oganesson.gregica.client.GCGuiTextures;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.gcpp.recipe.GCPPRecipeMaps")
@ZenRegister
public class GCRecipeMaps {

    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, new QubitProducerRecipeBuilder(), false);

    public static final RecipeMap<QubitConsumerRecipeBuilder> RESEARCH_STATION = new RecipeMap<>("research_station",
            2, 1, 0, 0, new QubitConsumerRecipeBuilder(), false);

    public static final RecipeMap<FuelRecipeBuilder> NR_MKI = new RecipeMap<>("naquadah_reactor_mki",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);

    public static final RecipeMap<FuelRecipeBuilder> NR_MKII = new RecipeMap<>("naquadah_reactor_mkii",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKIII = new RecipeMap<>("naquadah_reactor_mkiii",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKIV = new RecipeMap<>("naquadah_reactor_mkiv",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKV = new RecipeMap<>("naquadah_reactor_mkv",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);

    public static final RecipeMap<QubitConsumerRecipeBuilder> ASSEMBLY_LINE_RECIPES = new RecipeMap<>("assembly_line_recipes",
            16, false, 1, false, 4, false, 0, false, new QubitConsumerRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR = new RecipeMap<>("replication",
            1, 1, 4, 1, new SimpleRecipeBuilder(), false);
    public static final RecipeMap<SimpleRecipeBuilder> LOGS_CREATE = new RecipeMap<>("log_create",
            2, 8, 1, 0, new SimpleRecipeBuilder(), false);

    //TJ and GCYS
    public static final RecipeMap<SimpleRecipeBuilder> LAMINATOR_RECIPES = new RecipeMap<>("laminator", 1, 6, 1, 2, 0, 2, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSoundEvents.ASSEMBLER);
    public static final RecipeMap<SimpleRecipeBuilder> FSZM_RECIPES = new RecipeMap<>("free_stand_zone_melter", 1, 1, 1, 1, 0, 1, 0, 1, new SimpleRecipeBuilder(), false).setSlotOverlay(false, false, GuiTextures.HEATING_OVERLAY_1).setSlotOverlay(true, false, GuiTextures.CRYSTAL_OVERLAY);
    public static final RecipeMap<SimpleRecipeBuilder> EXPOSURE_CHAMBER_RECIPES = new RecipeMap<>("exposure_chamber", 0, 4, 0, 4, 0, 2, 0, 2, new SimpleRecipeBuilder(), false).setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL).setSound(GTSoundEvents.ASSEMBLER);

    // Machines

    public static final RecipeMap<SimpleRecipeBuilder> DRYER_RECIPES = new RecipeMap<>("dryer_recipes", 0, 1, 0, 2, 0, 1, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<BlastRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallization_recipes", 0, 6, 1, 1, 0, 3, 0, 0, new BlastRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<PressureRecipeBuilder> PRESSURE_CHAMBER_RECIPES = new RecipeMap<>("pressure_chamber_recipes", 1, 4, 1, 1, 0, 0, 0, 0, new PressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    public static final RecipeMap<SimpleRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 1, 0, 0, 1, 1, 1, 4, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> BURNER_REACTOR_RECIPES = new RecipeMap<>("burner_reactor_recipes", 0, 3, 0, 2, 0, 3, 0, 3, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> CRYOGENIC_REACTOR_RECIPES = new RecipeMap<>("cryogenic_reactor_recipes", 0, 3, 0, 2, 0, 2, 0, 2, new NoCoilTemperatureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> CVD_RECIPES = new RecipeMap<>("cvd_recipes", 0, 2, 0, 2, 0, 3, 0, 3, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<TemperaturePressureRecipeBuilder> PLASMA_CVD_RECIPES = new RecipeMap<>("plasma_cvd_recipes", 0, 2, 0, 2, 0, 4, 0, 4, new TemperaturePressureRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoCoilTemperatureRecipeBuilder> MOLECULAR_BEAM_RECIPES = new RecipeMap<>("molecular_beam_recipes", 1, 5, 1, 1, 0, 2, 0, 1, new NoCoilTemperatureRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GCGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GCGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, GCGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, GCGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, GCGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, GCGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(GCGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> SONICATION_RECIPES = new RecipeMap<>("sonication_recipes", 0, 0, 0, 1, 2, 2, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.BREWER_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, GCGuiTextures.FOIL_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CENTRIFUGE);

    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATOR_RECIPES = new RecipeMap<>("ion_implanter_recipes", 1, 3, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> SUPERHEAVY_RECIPES = new RecipeMap<>("superheavy_reactor_recipes", 0, 2, 0, 4, 0, 4, 0, 2, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTValues.FOOLS.get() ? GTSoundEvents.SCIENCE : GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> DRILLING_RECIPES = new RecipeMap<>("drill_recipes", 1, 1, 0, 1, 0, 0, 0, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    // Generators

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK1_RECIPES = new RecipeMap<>("taranium_reactor_mk1_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK2_RECIPES = new RecipeMap<>("taranium_reactor_mk2_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<FuelRecipeBuilder> TARANIUM_REACTOR_MK3_RECIPES = new RecipeMap<>("taranium_reactor_mk3_recipes", 0, 0, 0, 0, 1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    // Other

    public static final RecipeMap<SimpleRecipeBuilder> STEAM_EJECTOR_RECIPES = new RecipeMap<>("vacuum_ejector", 0, 0, 0, 0, 1, 1, 0, 0, new SimpleRecipeBuilder(), true)
            .setSlotOverlay(false, true, true, GuiTextures.EXTRACTOR_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CENTRIFUGE);
}
