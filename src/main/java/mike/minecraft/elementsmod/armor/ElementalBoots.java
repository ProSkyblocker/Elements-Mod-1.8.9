package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ElementalBoots extends ItemArmor implements IMetadata {
	public static ArmorMaterial EBOOTS = EnumHelper.addArmorMaterial("EBOOTS", "elements:eboots", 
			29, new int[]{0,0,0,4}, 9);
	private static String name = "elementalBoots";

	public ElementalBoots() {
		super(EBOOTS, 1, 3);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

}
