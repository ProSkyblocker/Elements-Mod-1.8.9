package mike.minecraft.elementsmod.tools;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ExplosivePick extends ItemPickaxe implements IMetadata {
	private String name = "explodepick";
	public static ToolMaterial EXPLODE = EnumHelper.addToolMaterial("EXPLODE", 3, 500, 5.0f, 5, 8);
	
	public ExplosivePick(){
		super(EXPLODE);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Right-Click To Explode!");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 60, 4));
			world.newExplosion(null, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 2f, false, true);
		}
		stack.damageItem(3, player);
		
		
		return stack;
	}
	
	public String getName(){
		return name;
	}

	

}
