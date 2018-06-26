package mike.minecraft.elementsmod;

import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.entity.ElementsEntityRegistry;
import mike.minecraft.elementsmod.gen.ElementsWorldGen;
import mike.minecraft.elementsmod.handlers.ElementEvents;
import mike.minecraft.elementsmod.handlers.RecipeHandler;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.proxy.CommonProxy;
import mike.minecraft.elementsmod.tileentity.TileEntityManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.GoalColor;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ElementsMod.MODID, name = ElementsMod.MOD_NAME, version = ElementsMod.MOD_VERSION)
public class ElementsMod {

	public static final String MODID = "elements";
	public static final String MOD_NAME = "Elements Mod";
	public static final String MOD_VERSION = "1.0";
	public static final String COMMON_PROXY = "mike.minecraft.elementsmod.proxy.CommonProxy";
	public static final String CILENT_PROXY = "mike.minecraft.elementsmod.proxy.CilentProxy";
	
	@Instance
	public static ElementsMod instance = new ElementsMod();

	@SidedProxy(clientSide = CILENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;

	public static ElementsTab tab = new ElementsTab("elements");
	public static ElementsTab.LuckyTab ltab = tab.getExtraTab("lucky");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ItemManager.mainRegistry();
		BlockManager.mainRegistry();
		ToolManager.mainRegistry();
		ArmorRegistry.mainRegistry();
		TileEntityManager.mainRegistry();
		ElementsEntityRegistry.mainRegistry();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		RecipeHandler.registerRecipies();
		AchievementManager.mainRegistry();

		proxy.renderItems();
		proxy.renderBlocks();
		proxy.renderTools();
		proxy.registerEntities();

		MinecraftForge.EVENT_BUS.register(new ElementEvents());

		GameRegistry.registerFuelHandler(new ElementalFuelHandler());
		GameRegistry.registerWorldGenerator(new ElementsWorldGen(), 0);

		this.registerDungeonStuffs();
	}

	public void registerDungeonStuffs() {
		DungeonHooks.addDungeonMob("elementmaster", 150);
		ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.gunpowder));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
				new WeightedRandomChestContent(new ItemStack(ItemManager.apple), 1, 5, 6));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
				new WeightedRandomChestContent(new ItemStack(ItemManager.apple, 1, 1), 1, 5, 4));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH,
				new WeightedRandomChestContent(new ItemStack(Items.emerald), 1, 15, 10));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH,
				new WeightedRandomChestContent(new ItemStack(ItemManager.apple), 1, 5, 8));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 3), 1, 1, 4));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 3), 1, 1, 4));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 3), 1, 1, 4));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH,
				new WeightedRandomChestContent(new ItemStack(ItemManager.apple), 1, 5, 8));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 6), 1, 3, 7));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 6), 1, 5, 13));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING,
				new WeightedRandomChestContent(new ItemStack(ItemManager.piece, 1, 6), 1, 5, 13));
	}

	public class ElementalFuelHandler implements IFuelHandler {

		@Override
		public int getBurnTime(ItemStack fuel) {
			if (fuel.isItemEqual(new ItemStack(ItemManager.crystals, 1, 1)))
				return 1800;
			if (fuel.isItemEqual(new ItemStack(ItemManager.crystals, 1, 5)))
				return 700;
			if (fuel.isItemEqual(new ItemStack(ItemManager.piece, 1, 6)))
				return 1000;
			return 0;
		}

	}
}
