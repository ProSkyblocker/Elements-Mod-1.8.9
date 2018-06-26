package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class InstantNetherPortal extends ItemSimpleFoiled implements IMetadata {
	private static String name = "instantnetherportal";

	public InstantNetherPortal() {
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		this.setMaxDamage(20);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side,
			float hitX, float hitY, float hitZ) {
		stack.damageItem(1, player);
		if(player.isSneaking()){
    		world.setBlockState(pos.up(), Blocks.portal.getDefaultState());
    	} else {
    		world.setBlockState(pos.up(), Blocks.end_portal.getDefaultState());
    	}
        
    
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Right-click for End or shift click to Nether");
	}
	
	@Override
	public String getName(){
		return name;
	}

}
