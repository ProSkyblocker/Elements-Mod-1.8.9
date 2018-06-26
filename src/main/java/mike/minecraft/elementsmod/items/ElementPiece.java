package mike.minecraft.elementsmod.items;

import java.util.List;
import java.util.Random;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.armor.ArmorRegistry;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElementPiece extends Item implements IMetadata {
	private static String name = "piece";
	public static String[] metaNames = {"diamond", "emerald", "gold", "timebomb", "quickbomb", "regbox"};
	
	public ElementPiece(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHasSubtypes(true);
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
		ModelBakery.registerItemVariants(ItemManager.piece, variants);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(stack.getMetadata() == 3){
			if(!player.capabilities.isCreativeMode){
				--stack.stackSize;
			}
			EntityTNTPrimed tnt = new EntityTNTPrimed(world);
			tnt.setPosition(pos.getX(), pos.getY() - 1, pos.getZ());
			tnt.fuse = 320;
			world.spawnEntityInWorld(tnt);
		}
		if(stack.getMetadata() == 4){
			if(!player.capabilities.isCreativeMode){
				--stack.stackSize;
			}
			EntityTNTPrimed tnt = new EntityTNTPrimed(world);
			tnt.setPosition(pos.getX(), pos.getY() - 1, pos.getZ());
			tnt.fuse = 40;
			world.spawnEntityInWorld(tnt);
		}
		
		
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		// regular treasure box
				if(stack.getMetadata() == 5){
					if(!player.capabilities.isCreativeMode){
						--stack.stackSize;
					}
					
					if(!world.isRemote){
					BoxRefs br = new BoxRefs();
					Random r = player.getRNG();
					ItemStack ri = br.rBox[r.nextInt(br.rBox.length)];
					if(player.inventory.addItemStackToInventory(ri)){
						String format = ri.getRarity().rarityColor + ri.getDisplayName();
						player.addChatComponentMessage(
								new ChatComponentText("You recieved " + format));
						}
					}
				}
		 return stack;
	}
	
	public String getName(){
		return name;
	}
	
	public class BoxRefs {
		public ItemStack[] rBox = {new ItemStack(Items.baked_potato, 4), new ItemStack(Items.golden_apple), 
				new ItemStack(Items.blaze_powder, 3), new ItemStack(ItemManager.flame, 4), new ItemStack(Items.bone, 5),
				new ItemStack(Items.iron_sword), new ItemStack(ArmorRegistry.eh), new ItemStack(Items.gunpowder, 3),
				new ItemStack(Blocks.birch_door), new ItemStack(Blocks.bedrock)};
		
	}

}
