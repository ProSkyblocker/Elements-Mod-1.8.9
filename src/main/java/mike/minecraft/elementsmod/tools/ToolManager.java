package mike.minecraft.elementsmod.tools;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ToolManager {
	
	public static WorldCrystalSword wcs;
	public static WorldStaff ws;
	public static EndAxe es;
	public static WorldMultiTool multi;
	public static EnderStaff estaff;
	public static NetherStaff nstaff;
	public static TriDimensionalHammer hammer;
	public static NetherPick np;
	public static IronShield is;
	public static LuckySword ls;
	public static LightPickaxe lp;
	public static ExplosivePick ep;
	public static ElementalBigSword ebs;
	public static ItemCrossbow icb;
	public static TripleArrowCrossbow tac;
	public static CrystalSword cs;
	public static CrystalPickaxe cp;
	public static AirScythe as;
	
	public static void mainRegistry(){
		initTools();
		registerTools();
	}
	
	public static void initTools(){
		wcs = new WorldCrystalSword();
		ws = new WorldStaff();
		es = new EndAxe();
		multi = new WorldMultiTool();
		estaff = new EnderStaff();
		nstaff = new NetherStaff();
		hammer = new TriDimensionalHammer();
		np = new NetherPick();
		is = new IronShield();
		ls = new LuckySword();
		lp = new LightPickaxe();
		ep = new ExplosivePick();
		ebs = new ElementalBigSword();
		icb = new ItemCrossbow();
		tac = new TripleArrowCrossbow();
		cs = new CrystalSword();
		cp = new CrystalPickaxe();
		as = new AirScythe();
	}
	
	
	public static void registerTools(){
		GameRegistry.registerItem(wcs, wcs.getName());
		GameRegistry.registerItem(ws, ws.getName());
		GameRegistry.registerItem(es, es.getName());
		GameRegistry.registerItem(multi, multi.getName());
		GameRegistry.registerItem(estaff, estaff.getName());
		GameRegistry.registerItem(nstaff, nstaff.getName());
		GameRegistry.registerItem(hammer, hammer.getName());
		GameRegistry.registerItem(np, np.getName());
		GameRegistry.registerItem(is, is.getName());
		GameRegistry.registerItem(ls, ls.getName());
		GameRegistry.registerItem(lp, lp.getName());
		GameRegistry.registerItem(ep, ep.getName());
		GameRegistry.registerItem(ebs, ebs.getName());
		GameRegistry.registerItem(icb, icb.getName());
		GameRegistry.registerItem(tac, tac.getName());
		GameRegistry.registerItem(cs, cs.getName());
		GameRegistry.registerItem(cp, cp.getName());
		GameRegistry.registerItem(as, as.getName());
	}

}
