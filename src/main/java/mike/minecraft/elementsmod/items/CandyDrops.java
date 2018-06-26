package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CandyDrops extends ItemFood implements IMetadata {
	private static String name = "candy";
	public static String[] metaNames = {"candycane", "choco", "jawbreak", "lolly", "bgum"};
			
	
	public CandyDrops(){
		super(2, 0.8f, false);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		/*
		 * returns the normal prefix for getUnlocalizedName() in Item
		 * plus it adds the metadata name at the ending
		 */
		return super.getUnlocalizedName() + "." + metaNames[stack.getItemDamage()];
		
	}
	
	@Override // puts the versions of the item into the creative menu
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List items) {
		for(int meta = 0; meta < metaNames.length; meta++){
			items.add(new ItemStack(this, 1, meta)); 
		}
	};
	
	@Override
	public String getNameFromDamage(int metadata){
		return name + metaNames[metadata];
	}
	
	public void registerVariants(){ // registers the versions of the item
		ModelResourceLocation[] variants = new ModelResourceLocation[metaNames.length];
		for(int i = 0; i < metaNames.length; i++){
			variants[i] = new ModelResourceLocation(ElementsMod.MODID + ":" + getNameFromDamage(i), "inventory");
		}
		ModelBakery.registerItemVariants(ItemManager.cd, variants);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		switch(stack.getItemDamage()){
		case 0:
			tooltip.add(EnumChatFormatting.ITALIC + "Ho ho ho!!!");
			break;
		case 1:
			stack.setStackDisplayName("Chocolate");
			tooltip.add(EnumChatFormatting.GOLD + "Scrumptious Goodness!");
			break;
		case 2:
			stack.setStackDisplayName("Jawbreaker");
			tooltip.add(EnumChatFormatting.BOLD + "A ball of strength!");
			break;
		case 3:
			stack.setStackDisplayName("Lollipop");
			tooltip.add(EnumChatFormatting.BLUE + "Candy on a stick!");
			break;
		case 4:
			stack.setStackDisplayName("Bubble Gum");
			tooltip.add(EnumChatFormatting.LIGHT_PURPLE + "Can you sing the Bubble Gum song?");
			break;
			
		}
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		switch(stack.getItemDamage()){
		case 0:
			player.addPotionEffect(new PotionEffect(Potion.healthBoost.id, 300, 0));
			player.addPotionEffect(new PotionEffect(Potion.absorption.id, 300, 0));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 0));
			break;
		case 1:
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300, 0));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 300, 0));
			break;
		case 2:
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 300, 1));
			break;
		case 3:
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 300, 1));
			break;
		case 4:
			player.addPotionEffect(new PotionEffect(Potion.saturation.id, 300, 1));
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 300, 0));
			break;
		}
	}
	
	@Override
	public String getName(){
		return name;
	}

	

}
