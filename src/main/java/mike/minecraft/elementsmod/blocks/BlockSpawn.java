package mike.minecraft.elementsmod.blocks;

import java.util.Random;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tileentity.TileEntitySpawn;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSpawn extends BlockContainer implements IMetadata {
	private static String name = "blockspawn";
	
	public BlockSpawn() {
		super(Material.rock);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setHardness(0.4f);
		this.setResistance(20.0f);
		this.setLightLevel(0.4f);
		this.setStepSound(soundTypeMetal);
		this.setBlockBounds(0f, 0f, 0f, 1f, 0.7f, 1f);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		ItemStack stack = new ItemStack(Items.clock);
		int dimID = world.provider.getDimensionId();
		
		if(!world.isRemote){
			player.addChatComponentMessage(new ChatComponentText("Your new spawnpoint is now here!"));
		}
		
		stack.addEnchantment(Enchantment.smite, 2);
		stack.setStackDisplayName("Spawnpoint Coords: Dim: " + dimID + "  X: " + pos.getX() + "  Y: " + pos.getY() + "  Z: " + pos.getZ());
		
		player.inventory.addItemStackToInventory(stack);
		return true;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemManager.spawn;
	}
	
	@Override
	public String getName() { 
		return name;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySpawn();
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ItemManager.spawn, 1);
	}
}
