package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class LightPickaxe extends ItemPickaxe implements IMetadata {
	public String name = "lightpickaxe";
	public static ToolMaterial LP = EnumHelper.addToolMaterial("LP", 3, 700, 5f, 3, 15);
	
	public LightPickaxe() {
		super(LP);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName() { return name; }

	

}
