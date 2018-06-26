package mike.minecraft.elementsmod.blocks;

import mike.minecraft.elementsmod.items.ItemManager;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockManager {
	
	public static WorldCrystalOre wore;
	public static NetherCrystalOre noce;
	public static EnderCrystalOre eco;
	public static ElementalLuckyBlock elb;
	public static LuckEBlock leb;
	public static UnluckyBlock ub;
	public static BlockSpawn spawn;
	public static BlockLantern lantern;
	public static LightCrystalOre lco;
	public static LuckyEssenceOre leo;
	public static BlockCandyOre bco;
	public static FakeDiamondBlock fdb;
	public static BlockSkyBlock bsb;
	public static BlockRollerCoaster brc;
	public static AirOre ao;

	
	public static void mainRegistry(){
		initBlocks();
		registerBlocks();
	
	}
	
	public static void initBlocks(){
		wore = new WorldCrystalOre(Material.rock, ItemManager.crystals, 0);
		noce = new NetherCrystalOre();
		eco = new EnderCrystalOre(ItemManager.crystals, 2);
		elb = new ElementalLuckyBlock();
		spawn = new BlockSpawn();
		lantern = new BlockLantern();
		lco = new LightCrystalOre();
		leo = new LuckyEssenceOre();
		leb = new LuckEBlock();
		ub = new UnluckyBlock();
		bco = new BlockCandyOre();
		fdb = new FakeDiamondBlock();
		bsb = new BlockSkyBlock();
		brc = new BlockRollerCoaster();
		ao = new AirOre();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(wore, wore.getName());
		GameRegistry.registerBlock(noce, noce.getName());
		GameRegistry.registerBlock(eco, eco.getName());
		GameRegistry.registerBlock(elb, ElementalLuckyBlock.ElementalItemBlock.class, elb.getName());
		GameRegistry.registerBlock(leb, LuckEBlock.LuckEItemBlock.class, leb.getName());
		GameRegistry.registerBlock(ub, UnluckyBlock.UnluckyItemBlock.class, ub.getName());
		GameRegistry.registerBlock(spawn, spawn.getName());
		GameRegistry.registerBlock(lantern, lantern.getName());
		GameRegistry.registerBlock(lco, lco.getName());
		GameRegistry.registerBlock(leo, leo.getName());
		GameRegistry.registerBlock(bco, bco.getName());
		GameRegistry.registerBlock(fdb, fdb.getName());
		GameRegistry.registerBlock(bsb, BlockSkyBlock.SkyItemBlock.class, bsb.getName());
		GameRegistry.registerBlock(brc, BlockRollerCoaster.RollerItemBlock.class, brc.getName());
		GameRegistry.registerBlock(ao, ao.getName());
	}

}
