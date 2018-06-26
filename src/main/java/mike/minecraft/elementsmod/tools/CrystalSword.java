package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class CrystalSword extends ItemSword implements IMetadata{
	private static String name = "crystalsword";
	public static ToolMaterial CRYSTALS = EnumHelper.addToolMaterial("CRYSTALS", 3, 1, 5.5f, 999996, 18);
	
	public CrystalSword(){
		super(CRYSTALS);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
	}
		
	@Override
	public String getName(){
		return name;
	}

	

}
