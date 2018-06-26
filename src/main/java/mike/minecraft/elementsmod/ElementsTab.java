package mike.minecraft.elementsmod;

import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElementsTab extends CreativeTabs {

	public ElementsTab(String label) {
		super(label);
		}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ItemManager.piece;
	}
	
	public LuckyTab getExtraTab(String label){
		return new LuckyTab(label);
	}
	
	
public class LuckyTab extends CreativeTabs {

	public LuckyTab(String label) {
		super(label);
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockManager.elb);
	}
	
}
}


