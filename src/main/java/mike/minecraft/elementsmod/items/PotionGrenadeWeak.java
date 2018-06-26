package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityWeakGrenade;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PotionGrenadeWeak extends ItemSimpleFoiled implements IMetadata {
	private static String name = "weakgrenade";

	public PotionGrenadeWeak() {
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
			world.spawnEntityInWorld(new EntityWeakGrenade(world, player));
		}
		return stack;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
