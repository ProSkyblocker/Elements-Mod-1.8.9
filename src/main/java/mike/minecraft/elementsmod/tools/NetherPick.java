package mike.minecraft.elementsmod.tools;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class NetherPick extends ItemPickaxe implements IMetadata {
	public static ToolMaterial NPICK = EnumHelper.addToolMaterial("NPICK", 3, 1000, 6f, 4.0f, 7);
	public static String name = "firepickaxe";
	
	
	protected NetherPick() {
		super(NPICK);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		target.setFire(1200);
		stack.damageItem(1, attacker);
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		stack.setStackDisplayName(EnumChatFormatting.RED + "Nether Pickaxe");
	}

	@Override
	public String getName(){
		return name;
	}

}
