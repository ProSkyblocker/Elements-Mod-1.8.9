package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElementalApple extends ItemFood implements IMetadata {
	private  String name = "elementsapple";
	public  String[] metaNames = new String[]{"normal", "special"};
	
	
	public ElementalApple() {
		super(6, 4.5f, false);
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
	public boolean hasEffect(ItemStack stack) { 
		return stack.getMetadata() > 0;
	}
	
	@Override
	public String getNameFromDamage(int metadata){
		return name + metaNames[metadata];
	}
	
	public  void registerVariants(){ // registers the versions of the item
		ModelResourceLocation[] variants = new ModelResourceLocation[metaNames.length];
		for(int i = 0; i < metaNames.length; i++){
			variants[i] = new ModelResourceLocation(ElementsMod.MODID + ":" + getNameFromDamage(i), "inventory");
		}
		ModelBakery.registerItemVariants(ItemManager.apple, variants);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return stack.getMetadata() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if(stack.getMetadata() == 0){
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 400, 0));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 400, 1));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 400, 0));
		} else {
			player.addPotionEffect(new PotionEffect(Potion.absorption.id, 400, 1));
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 400, 0));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 2));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 400, 1));
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 400, 1));
		}
	}
	
	@Override
	public String getName(){
		return name;
	}

}
