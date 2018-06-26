package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ExplodeBoots extends ItemArmor implements IMetadata {
	public static ArmorMaterial EXBOOTS = EnumHelper.addArmorMaterial("EXBOOTS", "elements:exboots", 
			14, new int[]{0,0,0,1}, 10);
	private static String name = "explodeBoots";

	public ExplodeBoots() {
		super(EXBOOTS, 1, 3);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

}
