package mike.minecraft.elementsmod.entity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityAttackGiantZombie extends EntityGiantZombie {

	public EntityAttackGiantZombie(World world) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0d, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0d, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0d, false));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0d));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityZombie.class, 8.0f));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityVillager.class, 8.0f));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		addTargetTasks();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0d);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0d);
	}
	
	private void addTargetTasks(){
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
	}
	
	@Override
	protected String getLivingSound()
    {
        return "mob.zombie.say";
    }

	@Override
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    @Override
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }
    
    @Override
    protected void playStepSound(BlockPos pos, Block block)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
    
    @Override
    public Item getDropItem(){
    	return Items.ghast_tear;
    }
    
    @Override
    public void addRandomDrop(){
    	switch(this.rand.nextInt(2)){
    	case 0:
    		this.dropItem(Items.diamond_sword, 1);
    		break;
    	case 1:
    		this.dropItem(Items.golden_apple, 1);
    		break;
    	}
    }
    
   

}
