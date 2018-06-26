

package mike.minecraft.elementsmod.gen;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TrapA extends WorldGenerator
{
	private World w;
	
	public TrapA(World w){
		this.w = w;
	}
	

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		setBlock(pos.getX() + 0, pos.getY() + 0, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 0, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 0, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 0, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 0, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 1, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 1, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 1, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 1, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 1, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 0, pos.getY() + 2, pos.getZ() + 0, Blocks.grass);
		setBlock(pos.getX() + 0, pos.getY() + 2, pos.getZ() + 1, Blocks.grass);
		setBlock(pos.getX() + 0, pos.getY() + 2, pos.getZ() + 2, Blocks.grass);
		setBlock(pos.getX() + 0, pos.getY() + 2, pos.getZ() + 3, Blocks.grass);
		setBlock(pos.getX() + 0, pos.getY() + 2, pos.getZ() + 4, Blocks.grass);
		setBlock(pos.getX() + 0, pos.getY() + 3, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 3, pos.getZ() + 1, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 3, pos.getZ() + 2, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 3, pos.getZ() + 3, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 3, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 4, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 4, pos.getZ() + 1, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 4, pos.getZ() + 2, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 4, pos.getZ() + 3, Blocks.iron_bars);
		setBlock(pos.getX() + 0, pos.getY() + 4, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 1, pos.getY() + 0, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 0, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 0, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 0, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 0, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 1, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 0, Blocks.grass);
		setBlock(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 1, Blocks.monster_egg);
		setBlock(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 2, Blocks.monster_egg);
		setBlock(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 3, Blocks.monster_egg);
		setBlock(pos.getX() + 1, pos.getY() + 2, pos.getZ() + 4, Blocks.grass);
		setBlock(pos.getX() + 1, pos.getY() + 3, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 1, pos.getY() + 3, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 1, pos.getY() + 4, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 1, pos.getY() + 4, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 2, pos.getY() + 0, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 0, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 0, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 0, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 0, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 1, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 0, Blocks.grass);
		setBlock(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 1, Blocks.monster_egg);
		setBlock(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 2, Blocks.monster_egg);
		setBlock(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 3, Blocks.monster_egg);
		setBlock(pos.getX() + 2, pos.getY() + 2, pos.getZ() + 4, Blocks.grass);
		setBlock(pos.getX() + 2, pos.getY() + 3, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 2, pos.getY() + 3, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 2, pos.getY() + 4, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 2, pos.getY() + 4, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 3, pos.getY() + 0, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 0, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 0, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 0, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 0, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 1, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 3, pos.getY() + 2, pos.getZ() + 0, Blocks.grass);
		setBlock(pos.getX() + 3, pos.getY() + 2, pos.getZ() + 1, Blocks.monster_egg);
		setBlock(pos.getX() + 3, pos.getY() + 2, pos.getZ() + 2, Blocks.monster_egg);
		setBlock(pos.getX() + 3, pos.getY() + 2, pos.getZ() + 3, Blocks.monster_egg);
		setBlock(pos.getX() + 3, pos.getY() + 2, pos.getZ() + 4, Blocks.grass);
		setBlock(pos.getX() + 3, pos.getY() + 3, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 3, pos.getY() + 3, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 3, pos.getY() + 4, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 3, pos.getY() + 4, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 0, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 0, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 0, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 0, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 0, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 0, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 1, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 2, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 3, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4, Blocks.dirt);
		setBlock(pos.getX() + 4, pos.getY() + 2, pos.getZ() + 0, Blocks.grass);
		setBlock(pos.getX() + 4, pos.getY() + 2, pos.getZ() + 1, Blocks.grass);
		setBlock(pos.getX() + 4, pos.getY() + 2, pos.getZ() + 2, Blocks.grass);
		setBlock(pos.getX() + 4, pos.getY() + 2, pos.getZ() + 3, Blocks.grass);
		setBlock(pos.getX() + 4, pos.getY() + 2, pos.getZ() + 4, Blocks.grass);
		setBlock(pos.getX() + 4, pos.getY() + 3, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 3, pos.getZ() + 1, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 3, pos.getZ() + 2, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 3, pos.getZ() + 3, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 3, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 4, pos.getZ() + 0, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 4, pos.getZ() + 1, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 4, pos.getZ() + 2, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 4, pos.getZ() + 3, Blocks.iron_bars);
		setBlock(pos.getX() + 4, pos.getY() + 4, pos.getZ() + 4, Blocks.iron_bars);
		setBlock(pos.getX() + 2, pos.getY() + 21, pos.getZ() + 2, Blocks.anvil);
		setBlock(pos.getX() + 2, pos.getY() + 22, pos.getZ() + 2, Blocks.anvil);

		return true;
	}
	
	public void setBlock(int i, int j, int k, Block b){
		w.setBlockState(new BlockPos(i, j, k), b.getDefaultState());
	}
	
	public void setBlock(int i, int j, int k, Block b, int meta){
		w.setBlockState(new BlockPos(i, j, k), b.getStateFromMeta(meta));
	}
}