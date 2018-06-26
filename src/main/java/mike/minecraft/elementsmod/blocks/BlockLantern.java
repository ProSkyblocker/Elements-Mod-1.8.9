package mike.minecraft.elementsmod.blocks;

import java.util.Random;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tileentity.TileEntityLantern;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockLantern extends BlockContainer implements IMetadata {
	private static String name = "lantern";

	public BlockLantern() {
		super(Material.rock);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setHardness(0.85f);
		this.setResistance(30.5f);
		this.setStepSound(soundTypeMetal);
		this.setBlockBounds(0, 0, 0, 1.0f, 1.1f, 1.0f);
		this.setLightLevel(0.7f);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemManager.spawn;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return 1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLantern();
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ItemManager.spawn, 1, 1);
	}
	
	@Override
	public String getName() { return name; }

}
