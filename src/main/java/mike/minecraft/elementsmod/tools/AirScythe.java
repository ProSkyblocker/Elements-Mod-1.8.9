package mike.minecraft.elementsmod.tools;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class AirScythe extends ItemSword implements IMetadata {
	private static String name = "airscythe";
	private static ToolMaterial AIR = EnumHelper.addToolMaterial("AIR", 3, 1500, 5.0f, 5, 18);
	
	public AirScythe(){
		super(AIR);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		if (!playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
            return false;
        } else {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
            {
                if (block == Blocks.grass)
                {
                    return this.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                }

                if (block == Blocks.dirt)
                {
                    switch ((BlockDirt.DirtType) iblockstate.getValue(BlockDirt.VARIANT))
                    {
                        case DIRT:
                            return this.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                        case COARSE_DIRT:
                            return this.useHoe(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                    }
                }
            }
            return false;
        }
	}

	private boolean useHoe(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target,
			IBlockState newState){
		
		worldIn.playSoundEffect((double)((float)target.getX() + 0.5F), (double)((float)target.getY() + 0.5F), (double)((float)target.getZ() + 0.5F), newState.getBlock().stepSound.getStepSound(), (newState.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, newState.getBlock().stepSound.getFrequency() * 0.8F);

        if (worldIn.isRemote) {
            return true;
        } else {
            for(int x = 0; x < 3; x++){
            	for(int y = 0; y < 3; y++){
            		for(int z = 0; z < 3; z++){
            			worldIn.setBlockState(new BlockPos(target.getX() - x, target.getY() - y, target.getZ() - z), newState);
            		}
            	}
            }
            stack.damageItem(1, player);
            return true;
        }
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.NONE;
	}

	@Override
	public String getName(){
		return name;
	}

	

}
