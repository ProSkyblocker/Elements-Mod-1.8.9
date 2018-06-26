package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ElementalBigSword extends ItemSword implements IMetadata {
	private static String name = "elementsbigsword";
	public static ToolMaterial BIGSWORD = EnumHelper.addToolMaterial("BIGSWORD", 3, 1895, 5.5f, 12, 6);
	
	
	public ElementalBigSword(){
		super(BIGSWORD);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName(){
		return name;
	}

}
