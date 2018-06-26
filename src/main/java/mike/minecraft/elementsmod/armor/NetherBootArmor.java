package mike.minecraft.elementsmod.armor;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class NetherBootArmor extends ItemArmor implements IMetadata {
	public static ArmorMaterial NETHERBOOT = EnumHelper.addArmorMaterial("NETHERBOOT", "elements:nether", 
			9, new int[]{0, 0, 0, 6}, 8);
	private static String name = "netherboot";

	public NetherBootArmor() {
		super(NETHERBOOT, 1, 3);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		super.addInformation(stack, player, tooltip, advanced);
		stack.setStackDisplayName(EnumChatFormatting.RED + "Nether Boots");
		tooltip.add("Walk on fire and lava without taking damage!");
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		super.onArmorTick(world, player, stack);
		
		if(stack.getItem() == ArmorRegistry.nb) {
			BlockPos playerPos = new BlockPos(player.posX, player.posY - 1, player.posZ);
			Block block = world.getBlockState(playerPos).getBlock();
			Block bDown = world.getBlockState(playerPos.down()).getBlock();
			
			if(Block.isEqualTo(block, Blocks.lava) || Block.isEqualTo(block, Blocks.flowing_lava)){
				world.setBlockState(playerPos, Blocks.ice.getDefaultState());
			}
			
			if(Block.isEqualTo(bDown, Blocks.lava) || Block.isEqualTo(bDown, Blocks.flowing_lava)){
				world.setBlockState(playerPos.down(), Blocks.ice.getDefaultState());
			}
		}
	}
	
	@Override
	public String getName(){
		return name;
	}

}
