package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class DayNightChanger extends Item implements IMetadata {
	private static String name = "daynightchange";

	public DayNightChanger() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxDamage(20);
		this.setMaxStackSize(1);
	}
	
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.DARK_GRAY + "Burn those pesky monsters!");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		long time = world.getWorldTime();
		if(time >= 0 && 14000 > time){
			world.setWorldTime(14000);
		} else {
			world.setWorldTime(0);
		}
		stack.damageItem(1, player);
		
		return stack;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
