package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class WorldCrystalSword extends ItemSword implements IMetadata {

	public static ToolMaterial WORLDCRYSTAL = EnumHelper.addToolMaterial("WORLDCRYSTAL", 3, 1450, 10.0f, 6.0f, 14);
	private static String name = "worldsword";
	
	
	public WorldCrystalSword() {
		super(WORLDCRYSTAL);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		
	}
	
	@Override
	public String getName(){
		return name;
	}

}
