package arzeyt.teleporterMod.common;

import java.io.Serializable;

import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;

public interface IPacket extends Serializable{

	public void handle(INetworkManager manager, Player player);
}
