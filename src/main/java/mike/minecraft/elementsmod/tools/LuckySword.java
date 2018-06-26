package mike.minecraft.elementsmod.tools;

import java.util.List;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import mike.minecraft.elementsmod.util.LuckySwordItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class LuckySword extends ItemSword implements IMetadata {
	private static String name = "luckysword";
	public static ToolMaterial LUCKY = EnumHelper.addToolMaterial("LUCKY", 3, 1000, 4f, 1, 5);
	
	public LuckySword() {
		super(LUCKY);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.ltab);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase user) {
		LuckySwordItems si = new LuckySwordItems();
		if(!target.getEntityWorld().isRemote){
			EntityPlayer player = user instanceof EntityPlayer ? (EntityPlayer) user : null;
			si.chooseAttack(player, target);
		}
		stack.damageItem(1, user);
		return true;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) { return true; }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("Luck: " + EnumChatFormatting.GOLD + "0");
	}
	
	@Override
	public String getName(){
		return name;
	}

	

}
