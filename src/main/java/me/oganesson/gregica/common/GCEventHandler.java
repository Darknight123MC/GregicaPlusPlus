package me.oganesson.gregica.common;

import gregtech.api.GregTechAPI;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.common.unification.materials.GCMaterial;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class GCEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onMaterialRegister(GregTechAPI.MaterialEvent event){
        GCMaterial.register();
    }
}
