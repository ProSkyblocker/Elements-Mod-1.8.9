package mike.minecraft.elementsmod.throwables;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityElementsPearl extends EntityThrowable {

	
	public EntityElementsPearl(World worldIn){
		super(worldIn);
	}
	
	public EntityElementsPearl(World worldIn, EntityLivingBase entity) {
		super(worldIn, entity);
	}
	
	public EntityElementsPearl(World world, double x, double y, double z){
		super(world, x, y, z);
	}
	
	protected void onImpact(MovingObjectPosition mov) {
        EntityLivingBase entitylivingbase = this.getThrower();
        Random rand = this.rand;

        if (mov.entityHit != null) {
            mov.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 0.0F);
        }

        for (int i = 0; i < 32; ++i) {
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
        }

        if (!this.worldObj.isRemote) {
            if (entitylivingbase instanceof EntityPlayerMP) {
                EntityPlayerMP entityplayermp = (EntityPlayerMP) entitylivingbase;
                
                if (entityplayermp.playerNetServerHandler.getNetworkManager().isChannelOpen() && entityplayermp.worldObj == this.worldObj && !entityplayermp.isPlayerSleeping()) {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!MinecraftForge.EVENT_BUS.post(event)) { 
                    	if (entitylivingbase.isRiding()){
                        entitylivingbase.mountEntity((Entity) null);
                    }
                    entitylivingbase.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                    entitylivingbase.fallDistance = 0.0F;
                    entitylivingbase.attackEntityFrom(DamageSource.fall, 0.1f);
                    }
                }
            }
            this.setDead();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive()) {
            this.setDead();
        } else {
            super.onUpdate();
        }
    }

}
