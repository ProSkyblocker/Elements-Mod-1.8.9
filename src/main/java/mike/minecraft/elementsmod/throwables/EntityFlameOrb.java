package mike.minecraft.elementsmod.throwables;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityFlameOrb extends EntityThrowable {

	public EntityFlameOrb(World world) {
		super(world);
	}

	public EntityFlameOrb(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityFlameOrb(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if(mov.typeOfHit == MovingObjectType.BLOCK){
			BlockPos pos = mov.getBlockPos();
			
			for(int x = 0; x < 5; x++){
				for(int z = 0; z < 5; z++){
					BlockPos increased = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
					if(!worldObj.isAirBlock(increased.west())){
						this.worldObj.setBlockState(increased, Blocks.fire.getDefaultState());
					}
				}
			}	
		} else if(mov.typeOfHit == MovingObjectType.ENTITY){
			EntityLivingBase base = mov.entityHit instanceof EntityLivingBase ? 
					(EntityLivingBase) mov.entityHit : null;
			base.attackEntityFrom(DamageSource.inFire, 4f);	
			base.setFire(500);
		}
			this.setDead();
	}
}
