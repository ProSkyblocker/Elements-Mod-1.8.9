package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityElementsPearl;
import mike.minecraft.elementsmod.throwables.EntityFlameOrb;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemFlameOrb extends Item implements IMetadata {
	private static String name = "itemflameorb";
	
	public ItemFlameOrb() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxStackSize(20);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		BlockPos pos = player.getPosition();
		
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		
		if(!world.isRemote){
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), "note.harp", 10.0f, 5.0f, false);
			world.spawnEntityInWorld(new EntityFlameOrb(world, player));
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		stack.setStackDisplayName(EnumChatFormatting.DARK_RED + "Flame Orb");
	}
	
	@Override
	public String getName() { return name; }
	

}
