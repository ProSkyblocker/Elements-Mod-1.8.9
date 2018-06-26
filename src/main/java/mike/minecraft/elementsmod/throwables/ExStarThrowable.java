package mike.minecraft.elementsmod.throwables;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ExStarThrowable extends EntityThrowable {

	public ExStarThrowable(World world) {
		super(world);
	}
	
	public ExStarThrowable(World world, EntityLivingBase entity){
		super(world, entity);
	}
	
	public ExStarThrowable(World world, double x, double y, double z){
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if(mov.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY){
			if(mov.entityHit instanceof EntityLivingBase){
				EntityLivingBase entity = (EntityLivingBase) mov.entityHit;
				entity.attackEntityFrom(DamageSource.magic, entity.getMaxHealth() / 3);
			}
		} else if(mov.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
				if(!worldObj.isRemote){
					BlockPos pos = mov.getBlockPos();
					worldObj.newExplosion(this.getThrower(), pos.getX(), pos.getY(), pos.getZ(), 2f, true, true);
					this.setDead();
				}
			}
		}
}