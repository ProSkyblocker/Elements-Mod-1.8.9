package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static ElementPiece piece;
	public static ElementCrystal crystals;
	public static RewardItems rewards;
	public static IronStick iron;
	public static ElementMana mana;
	public static ExThrowingStar exStar;
	public static ItemEEnderPearl ePearl;
	public static NetherMeal meal;
	public static ItemFlameOrb flame;
	public static TEItems spawn;
	public static ElementalApple apple;
	public static BossSpawn boss;
	public static LuckyPotion lp;
	public static UnluckyPotion up;
	public static LuckEPotion lep;
	public static DayNightChanger dn;
	public static CandyDrops cd;
	public static PotionGrenadeWeak pgw;
	public static PotionGrenadeHarm pgh;
	public static Nuke nuke;
	public static InstantNetherPortal portal;
	public static CloudBerry cb;
	
	
	public static void mainRegistry(){
		initItems();
		registerItems();
		crystals.registerVariants();
		mana.registerVariants();
		rewards.registerVariants();
		apple.registerVariants();
		boss.registerVariants();
		piece.registerVariants();
		spawn.registerVariants();
		cd.registerVariants();
	}
	

	
	public static void initItems(){
		piece = new ElementPiece();
		iron = new IronStick();
		crystals = new ElementCrystal();
		mana = new ElementMana();
		exStar = new ExThrowingStar();
		ePearl = new ItemEEnderPearl();
		meal = new NetherMeal();
		flame = new ItemFlameOrb();
		spawn = new TEItems();
		apple = new ElementalApple();
		boss = new BossSpawn();
		lp = new LuckyPotion();
		lep = new LuckEPotion();
		up = new UnluckyPotion();
		dn = new DayNightChanger();
		cd = new CandyDrops();
		pgw = new PotionGrenadeWeak();
		pgh = new PotionGrenadeHarm();
		nuke = new Nuke();
		portal = new InstantNetherPortal();
		cb = new CloudBerry();
		rewards = new RewardItems();
	}
	
	
	
	
	public static void registerItems(){
		GameRegistry.registerItem(piece, piece.getName());
		GameRegistry.registerItem(crystals, crystals.getName());
		GameRegistry.registerItem(iron, iron.getName());
		GameRegistry.registerItem(mana, mana.getName());
		GameRegistry.registerItem(exStar, exStar.getName());
		GameRegistry.registerItem(ePearl, ePearl.getName());
		GameRegistry.registerItem(meal, meal.getName());
		GameRegistry.registerItem(flame, flame.getName());
		GameRegistry.registerItem(spawn, spawn.getName());
		GameRegistry.registerItem(apple, apple.getName());
		GameRegistry.registerItem(boss, boss.getName());
		GameRegistry.registerItem(lp, lp.getName());
		GameRegistry.registerItem(lep, lep.getName());
		GameRegistry.registerItem(up, up.getName());
		GameRegistry.registerItem(dn, dn.getName());
		GameRegistry.registerItem(cd, cd.getName());
		GameRegistry.registerItem(pgw, pgw.getName());
		GameRegistry.registerItem(pgh, pgh.getName());
		GameRegistry.registerItem(nuke, nuke.getName());
		GameRegistry.registerItem(portal, portal.getName());
		GameRegistry.registerItem(cb, cb.getName());
		GameRegistry.registerItem(rewards, rewards.getName());
	}

}
