package arzeyt.teleporterMod.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@Mod(modid="ThaumicTeleporter", name = "Thaumic Teleporter", version = "0.1", dependencies = "required-after:Thaumcraft")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, 
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"ThaumicTeleporter"}, packetHandler = PacketManager.class))

public class TeleporterMod {

}
