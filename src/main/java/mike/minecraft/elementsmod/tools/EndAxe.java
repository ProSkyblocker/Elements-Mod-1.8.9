package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.common.util.EnumHelper;

public class EndAxe extends ItemAxe implements IMetadata {
	private static String name = "endaxe";
	protected static ToolMaterial ENDER = EnumHelper.addToolMaterial("ENDER", 3, 1540, 10, 8, 15);

	public EndAxe() {
		super(ENDER);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		
	}
	
	@Override
	public String getName() {
		return name;
	}

}
