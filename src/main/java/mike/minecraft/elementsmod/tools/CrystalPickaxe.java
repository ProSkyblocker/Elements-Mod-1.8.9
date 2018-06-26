package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class CrystalPickaxe extends ItemPickaxe implements IMetadata {
	private static String name = "crystalpick";
	public static ToolMaterial CRYSTALP = EnumHelper.addToolMaterial("CRYSTALP", 3, 1, 30.0f, 48, 18);

	public CrystalPickaxe() {
		super(CRYSTALP);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
	}
	
	@Override
	public String getName(){
		return name;
	}

}
