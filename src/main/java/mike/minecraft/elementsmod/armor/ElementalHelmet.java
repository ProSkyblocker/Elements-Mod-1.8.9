package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ElementalHelmet extends ItemArmor implements IMetadata {
	
	public static ArmorMaterial EHELMET = EnumHelper.addArmorMaterial("EHELMET", "elements:ehelmet", 
			29, new int[]{4, 0, 0, 0}, 9);
	private static String name = "elementalHelmet";

	public ElementalHelmet() {
		super(EHELMET, 1, 0);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

}
