package mike.minecraft.elementsmod.blocks;

import java.util.Random;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCandyOre extends Block implements IMetadata {
	private static String name = "candyore";
	
	public BlockCandyOre(){
		super(Material.rock);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setHardness(2.0f);
		this.setResistance(7.0f);
		this.setLightLevel(0.42f);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeStone);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemManager.cd;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return this.RANDOM.nextInt(5);
	}
	
	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1 + fortune;
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
		return MathHelper.getRandomIntegerInRange(RANDOM, 2, 7);
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1);
	}
	
	@Override
	public String getName(){
		return name;
	}

	

}
