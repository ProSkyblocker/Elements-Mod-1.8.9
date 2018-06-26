package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class NetherStaff extends Item implements IMetadata {
	private static String name = "netherstaff";
	
	public NetherStaff(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxDamage(200);
		this.setMaxStackSize(1);
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		BlockPos pos = player.getPosition();
		
		if(player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(ItemManager.mana, 1, 1))){
		
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 150, 1));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 150, 1));
		
			EntityLargeFireball fireball = new EntityLargeFireball(world, player, pos.getX() + 3f, pos.getY(), pos.getZ() + 10f);
			world.spawnEntityInWorld(fireball);
			player.inventory.consumeInventoryItem(new ItemStack(ItemManager.mana, 1, 1).getItem());
			stack.damageItem(5, player);
			return stack;
		}
		return stack;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
