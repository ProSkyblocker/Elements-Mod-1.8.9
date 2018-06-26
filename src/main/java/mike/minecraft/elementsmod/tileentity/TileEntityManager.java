package mike.minecraft.elementsmod.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityManager {
	
	public static void mainRegistry(){
		registerTE();
	}
	
	public static void registerTE(){
		GameRegistry.registerTileEntity(TileEntitySpawn.class, "TE_blockspawn");
		GameRegistry.registerTileEntity(TileEntityLantern.class, "TE_blocklantern");
	}
}
