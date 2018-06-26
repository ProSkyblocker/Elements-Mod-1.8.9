package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TEItems extends Item implements IMetadata {
	private String name = "teitems";
	public String[] metaNames = {"spawnitem", "lanterni"};

	public TEItems() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		
		if(stack.getMetadata() == 0){
			world.setBlockState(pos.up(), BlockManager.spawn.getDefaultState());
		} else {
			world.setBlockState(pos.up(), BlockManager.lantern.getDefaultState());
		}
		return true;
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
		ModelBakery.registerItemVariants(ItemManager.spawn, variants);
	}
	
	@Override
	public String getName() {
		return name;
	}

}
