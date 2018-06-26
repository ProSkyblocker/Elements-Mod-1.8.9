package mike.minecraft.elementsmod.entity;

import mike.minecraft.elementsmod.items.ItemManager;
import mike.minecraft.elementsmod.rm.ModelElementMaster;
import mike.minecraft.elementsmod.rm.RenderElementMaster;
import mike.minecraft.elementsmod.tools.ToolManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityElementMaster extends EntityMob {

	public EntityElementMaster(World world) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0d, false));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0d));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8f));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		
	}
	
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0d);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0d);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3d);
		
	}
	
	@Override
	protected Item getDropItem(){
		return ItemManager.mana;
	}
	
	@Override
	protected void addRandomDrop(){
		this.dropItem(ToolManager.ws, 1);
	}

	
	@Override
	protected String getDeathSound(){
		return "mob.skeleton.death";
	}

}
