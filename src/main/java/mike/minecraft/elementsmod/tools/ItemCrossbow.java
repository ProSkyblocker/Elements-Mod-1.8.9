package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemCrossbow extends ItemBow implements IMetadata {
	private static String name = "crossbow";
	
	public ItemCrossbow(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxDamage(890);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		 	int j = this.getMaxItemUseDuration(stack) - 500;
	        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(player, stack, j);
	        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return stack;
	        j = event.charge;

	        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

	        if (flag || player.inventory.hasItem(Items.arrow)) {
	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D) {
	                return stack;
	            }

	            if (f > 1.0F) {
	                f = 1.0F;
	            }

	            EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);

	            if (f == 1.0F) {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

	            if (k > 0) {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

	            if (l > 0){
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
	                entityarrow.setFire(100);
	            }

	            stack.damageItem(1, player);
	            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag) {
	                entityarrow.canBePickedUp = 2;
	            } else {
	                player.inventory.consumeInventoryItem(Items.arrow);
	            }

	            player.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

	            if (!world.isRemote) {
	                world.spawnEntityInWorld(entityarrow);
	            }
	        }
		return stack;
	}

	@Override
	public String getName(){
		return name;
	}
}
