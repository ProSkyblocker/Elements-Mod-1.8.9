package mike.minecraft.elementsmod.armor;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.util.IMetadata;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class CloudCape extends ItemArmor implements IMetadata {
	public static ArmorMaterial CC = EnumHelper.addArmorMaterial("CC", "elements:cc", 
				14, new int[]{0, 4, 0, 0}, 18);
	private static String name = "cloudcape";

	public CloudCape() {
		super(CC, 1, 1);
		this.setUnlocalizedName(ElementsMod.MODID + "_" + name);
		this.setCreativeTab(ElementsMod.tab);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		player.fallDistance = 0.0f;
	}
	
	@Override
	public String getName() {return name; }

}
