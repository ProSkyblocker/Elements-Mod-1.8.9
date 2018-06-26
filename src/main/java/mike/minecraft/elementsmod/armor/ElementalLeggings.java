package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ElementalLeggings extends ItemArmor implements IMetadata {
	public static ArmorMaterial ELEGS = EnumHelper.addArmorMaterial("ELEGS", "elements:elegs", 
			30, new int[]{0,0,4,0}, 9);
	private static String name = "elementalLeggings";

	public ElementalLeggings() {
		super(ELEGS, 2, 2);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		
	}
	
	@Override
	public String getName() { return name; }

}
