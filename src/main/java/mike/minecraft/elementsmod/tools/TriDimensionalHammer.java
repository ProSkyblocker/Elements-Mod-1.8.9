package mike.minecraft.elementsmod.tools;

import com.google.common.collect.Multimap;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class TriDimensionalHammer extends ItemSword implements IMetadata {
	
	public static ToolMaterial HAMMER = EnumHelper.addToolMaterial("HAMMER", 3, 
			300, 8.0f, 24, 5);
	private static String name = "tridimensionalhammer";
	

	public TriDimensionalHammer() {
		super(HAMMER);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if(isSelected){
			EntityPlayer player = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 20, 1));
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		EntityLightningBolt bolt = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ());
		world.spawnEntityInWorld(bolt);
		stack.damageItem(5, player);
		return true;
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack) {
		Multimap map = super.getAttributeModifiers(stack);
		map.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), 
				new AttributeModifier(itemModifierUUID, "Hammer modifier", 20.0d, 0));
		return map;
	}
	
	@Override
	public String getName() { return name; }

}
