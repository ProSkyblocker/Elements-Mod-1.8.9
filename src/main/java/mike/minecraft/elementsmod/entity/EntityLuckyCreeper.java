package mike.minecraft.elementsmod.entity;

import java.util.Random;

import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLuckyCreeper extends EntityCreeper {
	private int lastActiveTime;
    /** The amount of time since the creeper was close enough to the player to ignite */
    private int timeSinceIgnited;
    private int fuseTime = getRNG().nextInt(40);
    /** Explosion radius for this creeper. */
    private int explosionRadius = getRNG().nextInt(21);
    private int field_175494_bm = 0;

	public EntityLuckyCreeper(World worldIn) {
		super(worldIn);
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntitySkeleton.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, true));
	}
	

	@Override
	protected Item getDropItem() {
		return Items.gold_ingot;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public float getCreeperFlashIntensity(float p_70831_1_)
    {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
    }
	
	@Override
	 public void fall(float distance, float damageMultiplier)
    {
        super.fall(distance, damageMultiplier);
        this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);

        if (this.timeSinceIgnited > this.fuseTime - 5)
        {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }
	
	
	@Override
	public void onUpdate() {
		
		if (this.isEntityAlive())
        {
            this.lastActiveTime = this.timeSinceIgnited;

            if (this.hasIgnited())
            {
                this.setCreeperState(1);
            }

            int i = this.getCreeperState();

            if (i > 0 && this.timeSinceIgnited == 0)
            {
                this.playSound("creeper.primed", 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;

            if (this.timeSinceIgnited < 0)
            {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime)
            {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }

        super.onUpdate();
	}
	
	private void explode(){
		if (!this.worldObj.isRemote)
        {
            boolean flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
            float f = this.getPowered() ? 2.0F : 1.0F;
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)explosionRadius * f, flag);
            this.setDead();
        }
	}
	
	@Override
	protected void addRandomDrop() {
		switch(getRNG().nextInt(2)){
		case 0:
			this.dropItem(ToolManager.ls, 1);
			break;
		case 1:
			this.dropItem(ItemManager.lp, 2);
			break;
		case 2:
			ItemStack le = new ItemStack(ItemManager.crystals, 1, 4);
			this.dropItem(le.getItem(), 5);
			break;
		default:
			this.dropItem(ToolManager.ls, 1);
			break;
		}
	}
	
	 @Override
	 public boolean isAIEnabled()
	    {
	        return this.field_175494_bm < 1 && this.worldObj.getGameRules().getBoolean("doMobLoot");
	    }
	 	
	 	@Override
	    public void func_175493_co()
	    {
	        ++this.field_175494_bm;
	    }
	
	
	
	

	

}
