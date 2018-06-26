package mike.minecraft.elementsmod.throwables;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityNuke extends EntityThrowable {

	public EntityNuke(World world) {
		super(world);
	}
	
	public EntityNuke(World world, EntityLivingBase entity){
		super(world, entity);
	}
	
	public EntityNuke(World world, double x, double y, double z){
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mov) {
		if(!worldObj.isRemote){
			BlockPos pos = mov.getBlockPos();
			worldObj.newExplosion(this.getThrower(), pos.getX(), pos.getY(), pos.getZ(), 125f, true, true);
			this.setDead();
		}
	}	
}