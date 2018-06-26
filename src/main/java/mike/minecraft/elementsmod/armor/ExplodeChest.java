package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ExplodeChest extends ItemArmor implements IMetadata {
	
	public static ArmorMaterial EXCHEST = EnumHelper.addArmorMaterial("EXCHEST", "elements:exchest", 
			15, new int[]{0, 7, 0, 0}, 10);
	private static String name = "explodeChestplate";

	public ExplodeChest() {
		super(EXCHEST, 1, 1);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() {return name; }

}
