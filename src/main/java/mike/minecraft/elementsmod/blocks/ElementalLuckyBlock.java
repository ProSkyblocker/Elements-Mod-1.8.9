package mike.minecraft.elementsmod.blocks;

import java.util.List;
import java.util.Random;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import mike.minecraft.elementsmod.util.LuckyBlockItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ElementalLuckyBlock extends Block implements IMetadata {
	private static String name = "elementalluckyblock";

	public ElementalLuckyBlock(){
		super(Material.iron);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
		this.setHardness(0.2f);
		this.setResistance(45.0f);
		this.setLightLevel(0.2f);
		this.setStepSound(soundTypeStone);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote){
			new LuckyBlockItems().chooseSituation(worldIn, pos);
			worldIn.setBlockToAir(pos);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public String getName() { return name; }
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1);
	}
	
	public static class ElementalItemBlock extends ItemBlock{

	public ElementalItemBlock(Block block) {
		super(block);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Luck: " + EnumChatFormatting.GOLD + "0");
	}
}}