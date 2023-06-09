package project.gregica.config;

import project.gregica.Gregica;
import project.gregica.api.GCValues;
import net.minecraftforge.common.config.Config;

public class GCConfig {
    
    public static volatile boolean configLoaded = false;
//
//    @Config.Comment("Config options of miscellaneous features")
//    public static Misc Miscs = new Misc();

//    @Config.Comment("Config options for modification of GTCEu Processing Chains")
//    @Config.Name("Processing Chain Override Options")
//    public static ChainOverrides chainOverrides = new ChainOverrides();
//
//    @Config.Comment("Config options for modification of GTCEu Circuit Recipes")
//    @Config.Name("Circuit Recipe Override Options")
//    public static CircuitOverrides circuitOverrides = new CircuitOverrides();
//
//    @Config.Comment("Config options of machines")
//    public static Machines Machines = new Machines();
//
//    @Config.Comment("Config options of pollution system")
//    public static Pollution Pollution = new Pollution();
//
//    @Config.Comment("Config options of nerf other mods")
//    public static Nerf nerf = new Nerf();
//
    @Config(modid = Gregica.MOD_ID)
    public static class Misc {
        @Config.Comment("List of Soldering fluid [<fluid>:<amount>] amount=[1 ~ 64000]")
        @Config.RequiresMcRestart
        public static String[] solderingFluidList = new String[]{"soldering_alloy:72", "tin:144"};

        @Config.Comment("Enable the TJCore combat")
        @Config.RequiresMcRestart
        public static boolean enableTjcore = false;
        
        @Config.RequiresMcRestart
        public static boolean enableMetaItemShows_en_us_nameOnOtherLanguage = true;
        
        @Config.RequiresMcRestart
        public static boolean forceBilingualName = false;
    }

    public static class CircuitOverrides {

        @Config.Comment({"Requires Cubic Zirconia and more components in order to produce Crystal SOCs, instead of just Crystal CPUs.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean harderCrystalCircuits = true;

        @Config.Comment({"Requires Kapton K in order to produce Wetware Circuit Boards, instead of Multi-layer Epoxy.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean harderWetwareCircuits = true;
    }

    public static class ChainOverrides {

        @Config.Comment({"Disables centrifuging of Rare Earth, requiring Gregicality's process.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disableRareEarthProcessing = true;

        @Config.Comment({"Disables electrolyzing of Platinum Group Sludge, requiring Gregicality's process.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disablePlatinumProcessing = true;

        @Config.Comment({"Disables electrolyzing of Tungstic Acid, requiring Gregicality's process.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disableTungstenProcessing = true;

        @Config.Comment({"Disables mixing of Graphene, requiring Gregicality's process.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disableGrapheneProcessing = true;

        @Config.Comment({"Disables electrolysis of Tantalite and Pyrochlore, requiring Gregicality's processes for Niobium and Tantalum.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disableNiobiumTantalumProcessing = true;

        @Config.Comment({"Disables production of Ammonia from Nitrogen and Hydrogen, requiring Gregicality's process.", "Default: false"})
        @Config.RequiresMcRestart
        public static boolean disableAmmoniaProcessing = false;

        @Config.Comment({"Disables electrolysis of Molybdenite, Powellite, and Wulfenite, requiring Gregicality's processes for Molybdenum.", "Default: true"})
        @Config.RequiresMcRestart
        public static boolean disableMolybdenumProcessing = true;
    }

    @Config(modid = Gregica.MOD_ID)
    public static class Machines {

        @Config.Comment("Enable the Research Station")
        @Config.RequiresMcRestart
        public static boolean enableResearch = true;
    }
    
    @Config(modid = Gregica.MOD_ID)
    public static class Pollution {

        @Config.Comment({"Enable the Pollution System.", "Strict requirements GTCEu version:" + GCValues.CEu_VERSION})
        @Config.RequiresMcRestart
        public static boolean enablePollution = true;

    }
    
    @Config(modid = Gregica.MOD_ID)
    public static class Nerf{
        
        @Config.Comment({"Enable nerf the steam solar boiler.The output will decrease to 1/3 as time goes on."})
        @Config.RequiresMcRestart
        public static boolean enableNerfSteamSolarBoiler = true;
    
        @Config.Comment({"Enable nerf the parallel hatch,limit the max parallel to 64."})
        @Config.RequiresMcRestart
        public static boolean enableNerfGCYMParallelHatch = true;
        
    }
}
