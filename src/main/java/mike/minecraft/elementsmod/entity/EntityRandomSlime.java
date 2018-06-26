package mike.minecraft.elementsmod.entity;

import mike.minecraft.elementsmod.items.ItemManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class EntityRandomSlime extends EntitySlime{

	public EntityRandomSlime(World worldIn) {
		super(worldIn);
		
	}
	
	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(7, Integer.valueOf(0));
        this.dataWatcher.addObject(8, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(9, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(6, Float.valueOf(1.0F));
		this.dataWatcher.addObject(15, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(16, Byte.valueOf((byte)rand.nextInt(20)));
	}
	
	public void setSlimeSize(int size){
		super.setSlimeSize(size);
	}
	
	@Override
	protected Item getDropItem() {
		return this.getSlimeSize() == 1 ? Items.emerald : null;
	}
	
	@Override
	protected void addRandomDrop() {
		if(this.getSlimeSize() == 1){
		switch(this.rand.nextInt(6)){
		case 0:
			this.dropItem(Items.record_cat, 1);
			break;
		case 1:
			this.dropItem(Items.record_11, 1);
			break;
		case 2:
			this.dropItem(Items.saddle, 1);
			break;
		case 3:
			this.dropItem(new ItemStack(Items.golden_apple, 1, 1).getItem(), 1);
			break;
		case 4:
			this.dropItem(Items.slime_ball, 5);
			break;
		case 5:
			this.dropItem(ItemManager.flame, 10);
			break;
		}
	}
	}
	
	@Override
	public void setDead() {
		 int i = this.getSlimeSize();

	        if (!this.worldObj.isRemote && i > 1 && this.getHealth() <= 0.0F)
	        {
	            int j = 2 + this.rand.nextInt(3);

	            for (int k = 0; k < j; ++k)
	            {
	                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
	                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
	                EntityRandomSlime entityslime = this.getInstance();

	                if (this.hasCustomName())
	                {
	                    entityslime.setCustomNameTag(this.getCustomNameTag());
	                }

	                if (this.isNoDespawnRequired())
	                {
	                    entityslime.enablePersistence();
	                }

	                entityslime.setSlimeSize(i / 2);
	                entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
	                this.worldObj.spawnEntityInWorld(entityslime);
	            }
	        }

	        this.isDead = true;
	}
	
	protected EntityRandomSlime getInstance(){
		return new EntityRandomSlime(worldObj);
	}


}
