package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;

public class EnderStaff extends Item implements IMetadata {
	private static String name = "enderstaff";
	
	public EnderStaff(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxStackSize(1);
		this.setMaxDamage(100);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target) {
		BlockPos pos = player.getPosition();
			if(player.inventory.hasItemStack(new ItemStack(ItemManager.mana, 1, 2)) || player.capabilities.isCreativeMode){
				target.attackEntityFrom(DamageSource.generic, (target.getMaxHealth() / 3));
				target.setPosition(pos.getX() + 7, pos.getY(), pos.getZ() + 5);
				player.inventory.consumeInventoryItem(new ItemStack(ItemManager.mana, 1, 2).getItem());
				stack.damageItem(5, player);
				return true;
		}
		return true;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
