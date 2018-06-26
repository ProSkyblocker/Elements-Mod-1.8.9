package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityElementsPearl;
import mike.minecraft.elementsmod.throwables.ExStarThrowable;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEEnderPearl extends Item implements IMetadata {
	private static String name = "itemeenderpearl";
	
	public ItemEEnderPearl() {
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
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.spawnEntityInWorld(new EntityElementsPearl(world, player));
		}
		return stack;
	}
		
	@Override
	public String getName() {
		return name;
	}

}
