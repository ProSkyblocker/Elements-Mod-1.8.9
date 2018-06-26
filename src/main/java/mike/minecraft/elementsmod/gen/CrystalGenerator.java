package mike.minecraft.elementsmod.gen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CrystalGenerator extends WorldGenerator{
	public IBlockState block; // the block to generate
	public Predicate<IBlockState> target; // where to generate
	
	
	public CrystalGenerator(IBlockState block, Predicate<IBlockState> target){
		this.block = block;
		this.target = target;
	}
	
	public CrystalGenerator(IBlockState block){
		this(block, BlockHelper.forBlock(Blocks.stone)); 
		// replace stone blocks for the block to generate
	}
	
	
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		if(world.getBlockState(pos).getBlock().isReplaceableOreGen(world, pos, target) && new Random().nextInt(2) == 0){
			world.setBlockState(pos, block);
		}
		return true;
	}

}
