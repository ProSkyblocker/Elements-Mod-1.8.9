package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ExplodeHelm extends ItemArmor implements IMetadata {
	
	public static ArmorMaterial EXHELMET = EnumHelper.addArmorMaterial("EXHELMET", "elements:exhelmet", 
			14, new int[]{2, 0, 0, 0}, 10);
	private static String name = "explodeHelmet";

	public ExplodeHelm() {
		super(EXHELMET, 1, 0);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

}


