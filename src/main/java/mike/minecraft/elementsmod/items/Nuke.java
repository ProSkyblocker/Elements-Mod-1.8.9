package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityNuke;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Nuke extends Item implements IMetadata {
	private static String name = "nuke";

	public Nuke() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxStackSize(16);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		
		if(!world.isRemote){
			world.spawnEntityInWorld(new EntityNuke(world, player));
		}
		return stack;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
