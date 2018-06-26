package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityUnluckyPotion;
import mike.minecraft.elementsmod.util.IMetadata;
import mike.minecraft.elementsmod.util.LuckyPotionItems;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LuckyPotion extends ItemFood implements IMetadata {
	private static String name = "luckypotion";
	
	public LuckyPotion() {
		super(0, 0.5f, false);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
		this.setAlwaysEdible();
		this.setMaxStackSize(20);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		LuckyPotionItems lpi = new LuckyPotionItems();
		
		if(!worldIn.isRemote)
		lpi.chooseDrink(worldIn, player, player.getPosition());
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) { return true; }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Luck: " + EnumChatFormatting.GOLD + "0");
	}
	
	@Override
	public String getName(){
		return name;
	}

	

}
