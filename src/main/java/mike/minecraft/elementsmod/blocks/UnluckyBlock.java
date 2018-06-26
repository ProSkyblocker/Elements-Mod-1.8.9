package mike.minecraft.elementsmod.blocks;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.LuckyBlockItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class UnluckyBlock extends ElementalLuckyBlock {
	private static String name = "unluckyblock";

	public UnluckyBlock() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote){
			new LuckyBlockItems().createUnluckySituation(worldIn, pos);
			worldIn.setBlockToAir(pos);
		}
	}
	
	public static class UnluckyItemBlock extends ItemBlock{

		public UnluckyItemBlock(Block block) {
			super(block);
		}
		
		@Override
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
			tooltip.add("Luck: " + EnumChatFormatting.RED + "-80");
		}
	}
}