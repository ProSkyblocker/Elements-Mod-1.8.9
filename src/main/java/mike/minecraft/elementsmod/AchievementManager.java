package mike.minecraft.elementsmod;

import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementManager {
	
	public static Achievement worldCrystal;
	public static Achievement netherCrystal;
	public static Achievement enderCrystal;
	public static Achievement worldSword;
	public static Achievement luckyblock;
	public static Achievement luckypotion;
	public static Achievement netherpick;
	public static Achievement endaxe;
	public static Achievement lightgem;
	public static Achievement luckyessence;
	public static Achievement luckysword;
	public static Achievement spawntable;
	public static Achievement lantern;
	public static Achievement worldstaff;
	public static Achievement netherstaff;
	public static Achievement endstaff;
	public static Achievement lightpick;
	public static Achievement bigsword;
	public static Achievement hammer;
	public static Achievement crossbow;
	public static Achievement tbow;
	public static Achievement wmt;
	public static Achievement exg;
	public static Achievement tb;
	public static Achievement qb;
	public static Achievement echest;
	public static Achievement nuke;
	public static Achievement cs;
	public static Achievement cp;
	public static Achievement ag;
	public static Achievement scythe;
	public static Achievement bs, lb, am;
	
	private static ItemStack wc = new ItemStack(ItemManager.crystals, 1, 0);
	private static ItemStack nc = new ItemStack(ItemManager.crystals, 1, 1);
	private static ItemStack ec = new ItemStack(ItemManager.crystals, 1, 2);
	private static ItemStack lg = new ItemStack(ItemManager.crystals, 1, 3);
	private static ItemStack le = new ItemStack(ItemManager.crystals, 1, 4);
	private static ItemStack eg = new ItemStack(ItemManager.crystals, 1, 5);
	private static ItemStack st = new ItemStack(ItemManager.spawn, 1, 0);
	private static ItemStack l = new ItemStack(ItemManager.spawn, 1, 1);
	private static ItemStack time = new ItemStack(ItemManager.piece, 1, 3);
	private static ItemStack qeb = new ItemStack(ItemManager.piece, 1, 4);
	private static ItemStack air = new ItemStack(ItemManager.crystals, 1, 6);
	
	public static void mainRegistry(){
		registerAchievements();
		registerPage();
	}
	
	public static void registerAchievements(){
		worldCrystal = new Achievement("achievement.collectworldcrystal", "collectworldcrystal", 0, 0, wc, (Achievement) null);
		netherCrystal = new Achievement("achievement.collectnethercrystal", "collectnethercrystal", 0, 2, nc, worldCrystal);
		enderCrystal = new Achievement("achievement.collectendcrystal", "collectendcrystal", 0, 4, ec, netherCrystal);
		lightgem = new Achievement("achievement.collectlightgem", "collectlightgem", -6, 2, lg, (Achievement) null);
		luckyessence = new Achievement("achievement.collectluckessence", "collectluckessence", -8, 0, le, (Achievement) null);
		worldSword = new Achievement("achievement.getworldsword", "getworldsword", 2, 0, ToolManager.wcs, worldCrystal);
		luckyblock = new Achievement("achievement.getluckyblock", "getluckyblock", -2, 0, BlockManager.elb, luckyessence);
		luckypotion = new Achievement("achievement.getluckypotion", "getluckypotion", -6, 0, ItemManager.lp, luckyessence);
		luckysword = new Achievement("achievement.getluckysword", "getluckysword", -4, 0 , ToolManager.ls, luckyessence);
		netherpick = new Achievement("achievement.getnetherpick", "getnetherpick", 2, 2, ToolManager.np, netherCrystal);
		endaxe = new Achievement("achievement.getendaxe", "getendaxe", 2, 4, ToolManager.es, enderCrystal);
		spawntable = new Achievement("achievement.getspawntable", "getspawntable", 8, 0, st, worldCrystal);
		lantern = new Achievement("achievement.getlantern", "getlantern", -2, 2, l, lightgem);
		worldstaff = new Achievement("achievement.getworldstaff", "getworldstaff", 6, 0, ToolManager.ws, worldCrystal);
		netherstaff = new Achievement("achievement.getnetherstaff", "getnetherstaff", 4, 2, ToolManager.nstaff, netherCrystal);
		endstaff = new Achievement("achievement.getendstaff", "getendstaff", 4, 4, ToolManager.estaff, enderCrystal);
		lightpick = new Achievement("achievement.getlightpick", "getlightpick", -4, 2, ToolManager.lp, lightgem);
		bigsword = new Achievement("achievement.getbigsword", "getbigsword", -6, 4, ToolManager.ebs, (Achievement) null);
		hammer = new Achievement("achievement.gethammer", "gethammer", -4, 4, ToolManager.hammer, bigsword);
		crossbow = new Achievement("achievement.getcrossbow", "getcrossbow", -6, 6, ToolManager.icb, (Achievement) null);
		tbow = new Achievement("achievement.gettbow", "gettbow", -4, 6, ToolManager.tac, crossbow);
		wmt = new Achievement("achievement.getworldtool", "getworldtool", 4, 0, ToolManager.multi, worldCrystal);
		exg = new Achievement("achievement.getexgem", "getexgem", 0, 6, eg, (Achievement) null);
		tb = new Achievement("achievement.gettimebomb", "gettimebomb", 2, 6, time, exg);
		qb = new Achievement("achievement.getquickbomb", "getquickbomb", 2, 8, qeb, tb);
		echest = new Achievement("achievement.getexchest", "getexchest", 4, 6, ArmorRegistry.ec, exg);
		nuke = new Achievement("achievement.getnuke", "getnuke", 6, 6, ItemManager.nuke, exg);
		cs = new Achievement("achievement.getcs", "getcs", -6, 8, ToolManager.cs, (Achievement) null);
		cp = new Achievement("achievement.getcp", "getcp", -4, 8, ToolManager.cp, (Achievement) null);
		ag = new Achievement("achievement.getair", "getair", 0, -2, air, (Achievement) null);
		scythe = new Achievement("achievement.scythe", "scythe", 2, -2, ToolManager.as, ag);
		bs = new Achievement("achievement.bsb", "bsb", -6, -2, BlockManager.spawn, (Achievement) null);
		lb = new Achievement("achievement.lh", "lh", -4, -2, BlockManager.lantern, (Achievement) null);
		am = new Achievement("achievement.fly", "fly", 4, -2, ArmorRegistry.cc, ag);
		
		luckyblock.setSpecial();
		hammer.setSpecial();
		nuke.setSpecial();
		cs.setSpecial();
		cp.setSpecial();
		bs.setSpecial();
		lb.setSpecial();
		
		worldCrystal.registerStat();
		netherCrystal.registerStat();
		enderCrystal.registerStat();
		lightgem.registerStat();
		luckyessence.registerStat();
		worldSword.registerStat();
		luckyblock.registerStat();
		luckypotion.registerStat();
		luckysword.registerStat();
		netherpick.registerStat();
		endaxe.registerStat();
		spawntable.registerStat();
		lantern.registerStat();
		worldstaff.registerStat();
		netherstaff.registerStat();
		endstaff.registerStat();
		lightpick.registerStat();
		bigsword.registerStat();
		hammer.registerStat();
		crossbow.registerStat();
		tbow.registerStat();
		wmt.registerStat();
		exg.registerStat();
		tb.registerStat();
		qb.registerStat();
		echest.registerStat();
		nuke.registerStat();
		cs.registerStat();
		cp.registerStat();
		ag.registerStat();
		scythe.registerStat();
		bs.registerStat();
		lb.registerStat();
		am.registerStat();
	}

	public static void registerPage(){
		AchievementPage page = new AchievementPage("Elements Mod", new Achievement[]{
				worldCrystal, netherCrystal, enderCrystal, lightgem, luckyessence, 
				worldSword, luckyblock, netherpick, endaxe, luckypotion, luckysword,
				spawntable, lantern, worldstaff, netherstaff, endstaff, lightpick,
				bigsword, hammer, crossbow, tbow, wmt, exg, tb, qb, echest, nuke, cs,
				cp, ag, scythe, bs, lb, am});
		AchievementPage.registerAchievementPage(page);
	}
	
	

}
