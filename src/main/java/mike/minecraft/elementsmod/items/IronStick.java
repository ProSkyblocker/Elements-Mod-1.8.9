package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.item.Item;

public class IronStick extends Item implements IMetadata {
	private static String name = "ironstick";

	public IronStick() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public String getName(){
		return name;
	}

}
