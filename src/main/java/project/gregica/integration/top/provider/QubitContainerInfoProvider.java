package project.gregica.integration.top.provider;

import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.integration.theoneprobe.provider.CapabilityInfoProvider;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.TextStyleClass;
import project.gregica.api.capability.GCCapabilities;
import project.gregica.api.capability.quantum.IQubitContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;

public class QubitContainerInfoProvider extends CapabilityInfoProvider<IQubitContainer> {

    @Override
    protected Capability<IQubitContainer> getCapability() {
        return GCCapabilities.QBIT_CAPABILITY;
    }

    @Override
    public String getID() {
        return "gregica:qubit_container_provider";
    }

    @Override
    protected boolean allowDisplaying(IQubitContainer capability) {
        return !capability.isOneProbeHidden();
    }

    @Override
    protected void addProbeInfo(IQubitContainer capability, IProbeInfo probeInfo, EntityPlayer entityPlayer, TileEntity tileEntity, IProbeHitData iProbeHitData) {
        long qubitStored = capability.getQubitStored();
        long maxStorage = capability.getQubitCapacity();
        if (maxStorage == 0) return; //do not add empty max storage progress bar
        IProbeInfo horizontalPane = probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER));
        String additionalSpacing = tileEntity.hasCapability(GregtechTileCapabilities.CAPABILITY_WORKABLE, entityPlayer.getHorizontalFacing()) ? "   " : "";
        horizontalPane.text(TextStyleClass.INFO + "{*gregica.top.qubit_stored*} " + additionalSpacing);
        horizontalPane.progress(qubitStored, maxStorage, probeInfo.defaultProgressStyle()
                .suffix("/" + maxStorage + " qubit")
                .borderColor(0x00000000)
                .backgroundColor(0x00000000)
                .filledColor(0xFFFFE000)
                .alternateFilledColor(0xFFEED000));
    }

}