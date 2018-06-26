package mike.minecraft.elementsmod.blocks;

import java.util.Iterator;
import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.gen.SkyBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSkyBlock extends ElementalLuckyBlock {
	private static String name= "skyblock";

	public BlockSkyBlock() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote){
			new SkyBlock().generate(worldIn, RANDOM, new BlockPos(pos.getX() + 2, pos.getY() + 35, pos.getZ() - 4));
			teleportPlayers(worldIn);
			worldIn.setBlockToAir(pos);
		}
	}

	public String getName(){
		return name;
	}
	
	public void teleportPlayers(World w){
		Iterator i = w.playerEntities.iterator();
		while(i.hasNext()){
			Object o = i.next();
			if(o instanceof EntityPlayer){
				EntityPlayer all = (EntityPlayer) o;
				all.setPositionAndUpdate(all.posX + 3, all.posY + 42, all.posZ);
			}
		}
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1);
	}
	
	public static class SkyItemBlock extends ItemBlock{

		public SkyItemBlock(Block block) {
			super(block);
		}
		
		@Override
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
			stack.setStackDisplayName(EnumChatFormatting.BOLD + "SkyBlock");
			tooltip.add("Luck: " + EnumChatFormatting.GREEN + "+50");
			tooltip.add("Challenge yourself with playing SkyBlock!!!");
		}
	}
}