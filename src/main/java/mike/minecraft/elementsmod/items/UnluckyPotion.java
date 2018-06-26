package mike.minecraft.elementsmod.items;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.throwables.EntityUnluckyPotion;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class UnluckyPotion extends ItemSimpleFoiled implements IMetadata {
	private static String name = "unluckypotion";
	
	public UnluckyPotion(){
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
		this.setMaxStackSize(20);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		BlockPos pos = player.getPosition();
		
		if(!player.capabilities.isCreativeMode){
			--stack.stackSize;
		}
		
		if(!world.isRemote){
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.spawnEntityInWorld(new EntityUnluckyPotion(world, player));
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add("Luck: " + EnumChatFormatting.RED + "-80");
	}
		
	@Override
	public String getName(){
		return name;
	}

}
