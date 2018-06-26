package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.LuckyPotionItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class LuckEPotion extends LuckyPotion {
	private static String name = "luckepotion";
	
	public LuckEPotion(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
		this.setMaxStackSize(20);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		LuckyPotionItems lpi = new LuckyPotionItems();
		
		if(!worldIn.isRemote)
		lpi.chooseLuckyDrink(worldIn, player, player.getPosition());
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Luck: " + EnumChatFormatting.GREEN + "+80");
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) { return true; }
	
	@Override
	public String getName(){
		return name;
	}

}
