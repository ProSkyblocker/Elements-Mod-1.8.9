package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ExplodeLegs extends ItemArmor implements IMetadata {
	public static ArmorMaterial EXLEGS = EnumHelper.addArmorMaterial("EXLEGS", "elements:exlegs", 
			14, new int[]{0,0,3,0}, 10);
	private static String name = "explodeLeggings";

	public ExplodeLegs() {
		super(EXLEGS, 2, 2);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

}
