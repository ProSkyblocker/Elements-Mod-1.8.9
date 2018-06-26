package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ElementalChest extends ItemArmor implements IMetadata {
	public static ArmorMaterial ECHEST = EnumHelper.addArmorMaterial("ECHEST", "elements:echest", 
			32, new int[]{0, 8, 0, 0}, 9);
	private static String name = "elementalChestplate";

	public ElementalChest() {
		super(ECHEST, 1, 1);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() {return name; }

}
