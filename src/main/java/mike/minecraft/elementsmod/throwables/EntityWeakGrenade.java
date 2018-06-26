package mike.minecraft.elementsmod.throwables;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWeakGrenade extends EntityThrowable {

	public EntityWeakGrenade(World worldIn) {
		super(worldIn);
	}

	public EntityWeakGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityWeakGrenade(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if(!worldObj.isRemote){
			BlockPos pos = mov.getBlockPos();
			if(pos != null && this.getThrower() != null){
				worldObj.newExplosion(this.getThrower(), pos.getX(), pos.getY() + 2, pos.getZ(), 2.5f, true, true);
				for(int fx = 0; fx < 3; fx++){
					for(int fy = 0; fy < 3; fy++){
						for(int fz = 0; fz < 3; fz++){
							EntityPotion weak = new EntityPotion(worldObj, this.getThrower(), 16424);
							weak.setPosition(pos.getX() + fx, pos.getY() + fy + 2, pos.getZ() + fz);
							worldObj.spawnEntityInWorld(weak);
						}
					}
				}
				this.setDead();
			}
		}
	}
	
	@Override
	protected float getGravityVelocity() {
	   return 0.07F;
    }

	@Override
	protected float getVelocity()  {
	   return 0.7F;
	}

	@Override
	protected float getInaccuracy() {
	   return -20.0F;
	}
}