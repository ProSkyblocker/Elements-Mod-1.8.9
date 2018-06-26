package mike.minecraft.elementsmod.throwables;

import mike.minecraft.elementsmod.util.LuckyPotionItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityUnluckyPotion extends EntityThrowable {

	public EntityUnluckyPotion(World world) {
		super(world);
	}
	
	public EntityUnluckyPotion(World world, EntityLivingBase entity){
		super(world, entity);
	}
	
	public EntityUnluckyPotion(World world, double x, double y, double z){
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mov) {
		LuckyPotionItems lpi = new LuckyPotionItems();
		EntityPlayer player = this.getThrower() instanceof EntityPlayer ? (EntityPlayer) this.getThrower() : null;
		if(mov.getBlockPos() != null && player != null){
			if(!worldObj.isRemote){
				lpi.chooseUnluckyDrink(worldObj, player, mov.getBlockPos());
				this.setDead();
			}
		}
	}
	
	@Override
	protected float getGravityVelocity() {
	   return 0.05F;
    }

	@Override
	protected float getVelocity()  {
	   return 0.5F;
	}

	@Override
	protected float getInaccuracy() {
	   return -20.0F;
	}
}