package mike.minecraft.elementsmod.gen;
import java.util.Random;

import mike.minecraft.elementsmod.blocks.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SkyBlock extends WorldGenerator
{
	
	public SkyBlock() { }

	public boolean generate(World world, Random rand, BlockPos pos) {

		setBlock(world, pos.getX() + 0, pos.getY() + 0, pos.getZ() + 0, Blocks.grass);
		setBlock(world, pos.getX() + 0, pos.getY() + 0, pos.getZ() + 3, Blocks.grass);
		setBlock(world, pos.getX() + 0, pos.getY() + 0, pos.getZ() + 4, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 0, pos.getZ() + 0, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 0, pos.getZ() + 1, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 0, pos.getZ() + 2, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 0, pos.getZ() + 3, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 0, pos.getZ() + 4, Blocks.grass);
		setBlock(world, pos.getX() + 1, pos.getY() + 3, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 1, pos.getY() + 3, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 1, pos.getY() + 4, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 0, Blocks.grass);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 1, Blocks.grass);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 2, Blocks.grass);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 3, Blocks.grass);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 4, Blocks.grass);
		setBlock(world, pos.getX() + 2, pos.getY() + 3, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 2, pos.getY() + 0, pos.getZ() + 0, BlockManager.elb);
		setBlock(world, pos.getX() + 2, pos.getY() + 1, pos.getZ() + 0, BlockManager.elb);
		setBlock(world, pos.getX() + 2, pos.getY() + 2, pos.getZ() + 0, BlockManager.elb);
		setBlock(world, pos.getX() + 2, pos.getY() + 3, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 2, pos.getY() + 4, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 2, pos.getY() + 4, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 3, pos.getY() + 0, pos.getZ() + 0, Blocks.grass);
		setBlock(world, pos.getX() + 3, pos.getY() + 0, pos.getZ() + 1, Blocks.grass);
		setBlock(world, pos.getX() + 3, pos.getY() + 0, pos.getZ() + 2, Blocks.grass);
		setBlock(world, pos.getX() + 3, pos.getY() + 0, pos.getZ() + 3, Blocks.grass);
		setBlock(world, pos.getX() + 3, pos.getY() + 0, pos.getZ() + 4, Blocks.grass);
		setBlock(world, pos.getX() + 3, pos.getY() + 1, pos.getZ() + 4, Blocks.chest);
		setBlock(world, pos.getX() + 3, pos.getY() + 3, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 3, pos.getY() + 3, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 3, pos.getY() + 4, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 3, pos.getY() + 4, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 3, pos.getY() + 5, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 4, pos.getY() + 3, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 4, pos.getY() + 3, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 4, pos.getY() + 4, pos.getZ() + 0, Blocks.leaves);
		setBlock(world, pos.getX() + 4, pos.getY() + 4, pos.getZ() + 1, Blocks.leaves);
		setBlock(world, pos.getX() + 4, pos.getY() + 5, pos.getZ() + 0, Blocks.leaves);
		
		TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 4));
		addInventory(chest, Items.string, 1, 12);
		addInventory(chest, Items.lava_bucket, 2, 1);
		addInventory(chest, Items.reeds, 3, 1);
		addInventory(chest, Items.bone, 4, 1);
		addInventory(chest, Item.getItemFromBlock(Blocks.brown_mushroom), 10, 1);
		addInventory(chest, Item.getItemFromBlock(Blocks.red_mushroom), 11, 1);
		addInventory(chest, Item.getItemFromBlock(Blocks.ice), 12, 2);
		addInventory(chest, Items.melon, 19, 1);
		addInventory(chest, Item.getItemFromBlock(Blocks.cactus), 20, 1);
		addInventory(chest, Items.pumpkin_seeds, 21, 1);
		addInventory(chest, Item.getItemFromBlock(Blocks.log), 24, 4);
		return true;
	}
	
	public void setBlock(World w, double x, double y, double z, Block b){
		w.setBlockState(new BlockPos(x, y, z), b.getDefaultState(), 2);
	}
	
	public void addInventory(TileEntityChest chest, Item item, int place, int size){
		chest.setInventorySlotContents(place, new ItemStack(item, size));
	}
}