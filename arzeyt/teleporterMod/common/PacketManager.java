package arzeyt.teleporterMod.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketManager implements IPacketHandler{

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
            try {
                    ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.data);
                    ObjectInputStream objStream = new ObjectInputStream(byteStream);
                    IPacket ipacket = (IPacket) objStream.readObject();

                    ipacket.handle(manager, player);
                    
            } catch(Throwable e) {
                    e.printStackTrace();
            }
    }

    public static Packet250CustomPayload buildPacket(IPacket ipacket) {
            try {
                    Packet250CustomPayload payload = new Packet250CustomPayload();
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    ObjectOutputStream objStream = new ObjectOutputStream(byteStream);

                    objStream.writeObject(ipacket);

                    payload.channel = "ThaumicTeleporter";
                    payload.data = byteStream.toByteArray();
                    payload.length = payload.data.length;

                    return payload;
            } catch(IOException e) {
                    e.printStackTrace();
            }

            return null;
    }
}
