package mike.minecraft.elementsmod.items;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class NetherMeal extends Item implements IMetadata {
	private static String name = "nethermeal";
	
	public NetherMeal(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		
		if(!player.capabilities.isCreativeMode){
			IBlockState state = world.getBlockState(pos);
			if(Block.isEqualTo(state.getBlock(), Blocks.nether_wart)){
				if(state.getValue(BlockNetherWart.AGE) != Integer.valueOf(3)){
					--stack.stackSize;
					world.setBlockState(pos, state.cycleProperty(BlockNetherWart.AGE));
				}
			}
		}
		return true;
	}
	
	@Override
	public String getName() { return name; }

}
