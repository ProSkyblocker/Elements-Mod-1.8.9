package mike.minecraft.elementsmod.tools;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.blocks.BlockManager;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class WorldMultiTool extends ItemPickaxe implements IMetadata {
	private static String name = "worldmultitool";
	public static ToolMaterial MULTI = EnumHelper.addToolMaterial("MULTI", 3, 1600, 8, 4, 5);
	
	private static Set<Block> effective = Sets.newHashSet(Blocks.grass, Blocks.farmland, Blocks.dark_oak_door, Blocks.dark_oak_stairs,
			Blocks.bed, Blocks.acacia_door, Blocks.chest, Blocks.dirt, Blocks.mycelium,
			Blocks.snow, Blocks.snow_layer, Blocks.gravel, Blocks.hardened_clay, 
			Blocks.clay, Blocks.hay_block, Blocks.pumpkin, Blocks.jukebox, 
			Blocks.standing_sign, Blocks.reeds, Blocks.redstone_lamp,
			Blocks.wall_banner, Blocks.trapped_chest, Blocks.trapdoor,
			BlockManager.wore, BlockManager.noce, Blocks.sand, Blocks.sponge);
	

	public WorldMultiTool(){
		super(MULTI);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
		
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack){ // gets the tool classes of the item
		return ImmutableSet.of("pickaxe", "axe", "spade");
	}
	
	@Override
	public boolean canHarvestBlock(Block block){ // what blocks can it harvest?
		return effective.contains(block) ? true: super.canHarvestBlock(block);
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, Block block){ // what's the speed vs the block?
		if(block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants){
			return this.efficiencyOnProperMaterial;
		}
		return effective.contains(block) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(stack, block);
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	
	

	
	
	
	
	
	

}
