package mike.minecraft.elementsmod.tools;

import java.util.List;

import com.google.common.collect.Multimap;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IronShield extends Item implements IMetadata {
	private static String name = "ironshield";

	public IronShield(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxDamage(500);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.RED + "-2 damage from mobs");
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 0));
		
		target.motionZ += 1 + target.getRNG().nextInt(7);
		stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		Item repairer = repair.getItem();
		
		if(repairer == this || repairer == Items.iron_ingot){
			return true;
		}
		return false;
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap map = super.getAttributeModifiers(stack);
		map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", 0, 0));
		return map;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
		if(isSelected){
			EntityPlayer player = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20, 0));
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D() {
	     return true;
	 }
	 
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BLOCK;
	}
	
	@Override
	public int getItemEnchantability() {
        return 2;
    }
	
	@Override
	public String getName(){ return name; }
	

}
