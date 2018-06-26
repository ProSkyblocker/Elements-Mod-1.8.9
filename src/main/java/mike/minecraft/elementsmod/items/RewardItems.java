package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RewardItems extends Item implements IMetadata {
	private String name = "reward";
	public String[] metaNames = {"airmedal"};

	public RewardItems() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		/*
		 * returns the normal prefix for getUnlocalizedName() in Item
		 * plus it adds the metadata name at the ending
		 */
		return super.getUnlocalizedName() + "." + metaNames[stack.getItemDamage()];
		
	}
	
	@Override // puts the versions of the item into the creative menu
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List items) {
		for(int meta = 0; meta < metaNames.length; meta++){
			items.add(new ItemStack(this, 1, meta)); 
		}
	};
	
	@Override
	public String getNameFromDamage(int metadata){
		return name + metaNames[metadata];
	}
	
	public void registerVariants(){ // registers the versions of the item
		ModelResourceLocation[] variants = new ModelResourceLocation[metaNames.length];
		for(int i = 0; i < metaNames.length; i++){
			variants[i] = new ModelResourceLocation(ElementsMod.MODID + ":" + getNameFromDamage(i), "inventory");
		}
		ModelBakery.registerItemVariants(ItemManager.rewards, variants);
	}
	
	@Override
	public String getName(){
		return name;
	}

}
