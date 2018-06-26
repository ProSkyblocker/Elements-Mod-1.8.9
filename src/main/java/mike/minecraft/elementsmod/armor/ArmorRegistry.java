package mike.minecraft.elementsmod.armor;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArmorRegistry {
	
	public static NetherBootArmor nb;
	public static ElementalHelmet eHelm;
	public static ElementalChest eChest;
	public static ElementalLeggings eLegs;
	public static ElementalBoots eBoots;
	public static ExplodeHelm eh;
	public static ExplodeChest ec;
	public static ExplodeLegs el;
	public static ExplodeBoots eb;
	public static CloudCape cc;
	
	public static void mainRegistry(){
		initArmor();
		registerArmor();
	}
	
	public static void initArmor(){
		nb = new NetherBootArmor();
		eHelm = new ElementalHelmet();
		eChest = new ElementalChest();
		eLegs = new ElementalLeggings();
		eBoots = new ElementalBoots();
		eh = new ExplodeHelm();
		ec = new ExplodeChest();
		el = new ExplodeLegs();
		eb = new ExplodeBoots();
		cc = new CloudCape();
	}
	
	public static void registerArmor(){
		GameRegistry.registerItem(nb, nb.getName());
		GameRegistry.registerItem(eBoots, eBoots.getName());
		GameRegistry.registerItem(eChest, eChest.getName());
		GameRegistry.registerItem(eLegs, eLegs.getName());
		GameRegistry.registerItem(eHelm, eHelm.getName());
		GameRegistry.registerItem(eh, eh.getName());
		GameRegistry.registerItem(ec, ec.getName());
		GameRegistry.registerItem(el, el.getName());
		GameRegistry.registerItem(eb, eb.getName());
		GameRegistry.registerItem(cc, cc.getName());

	}

}
