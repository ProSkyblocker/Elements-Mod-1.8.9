package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WorldStaff extends Item implements IMetadata {
	private static String name = "worldstaff";
	
	public WorldStaff(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxStackSize(1);
		this.setMaxDamage(200);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if(player.inventory.hasItemStack(new ItemStack(ItemManager.mana, 1, 0)) || player.capabilities.isCreativeMode){
			for(int fx = 0; fx < 5; fx++){
				for(int fy = 0; fy < 5; fy++){
					BlockPos structure = new BlockPos(pos.getX() + fx, pos.getY() + fy + 1, pos.getZ());
					world.setBlockState(structure, Blocks.cobblestone.getDefaultState());
				}
			}
			player.inventory.consumeInventoryItem(new ItemStack(ItemManager.mana, 1, 0).getItem());
			stack.damageItem(5, player);
			return true;
		}
		return true;
	}
	
	@Override
	public String getName(){
		return name;
	}

}
