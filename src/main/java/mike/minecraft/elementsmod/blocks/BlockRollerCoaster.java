package mike.minecraft.elementsmod.blocks;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.gen.RollerCoaster;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockRollerCoaster extends ElementalLuckyBlock {
	private static String name = "blockrollercoaster";

	public BlockRollerCoaster() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote){
			EntityPlayer p = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10);
			p.inventory.addItemStackToInventory(new ItemStack(Items.minecart));
			new RollerCoaster().generate(worldIn, RANDOM, pos);
			worldIn.setBlockToAir(pos);
		}
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1);
	}
	
	public static class RollerItemBlock extends ItemBlock {

		public RollerItemBlock(Block block) {
			super(block);
		}
	
		@Override
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
			stack.setStackDisplayName(EnumChatFormatting.BOLD + "Roller Coaster");
			tooltip.add("Luck: " + EnumChatFormatting.GREEN + "+80");
			tooltip.add(EnumChatFormatting.AQUA + "Roller Coaster!!!");
		}
	}
}