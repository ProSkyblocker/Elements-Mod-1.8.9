package mike.minecraft.elementsmod.rm;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRespawnPoint extends ModelBase
{
  //fields
    ModelRenderer First_Leg;
    ModelRenderer Second_Leg;
    ModelRenderer Third_Leg;
    ModelRenderer Fourth_Leg;
    ModelRenderer Body;
    ModelRenderer Addition1;
    ModelRenderer Addition2;
    ModelRenderer Addition3;
    ModelRenderer Addition4;
  
  public ModelRespawnPoint()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      First_Leg = new ModelRenderer(this, 0, 0);
      First_Leg.addBox(0F, -4.5F, 0F, 2, 2, 6);
      First_Leg.setRotationPoint(-8F, 24F, -2.533333F);
      First_Leg.setTextureSize(64, 32);
      First_Leg.mirror = true;
      setRotation(First_Leg, 1.570796F, 0F, 0F);
      Second_Leg = new ModelRenderer(this, 0, 0);
      Second_Leg.addBox(0F, 0F, 0F, 2, 2, 6);
      Second_Leg.setRotationPoint(5F, 24F, -7F);
      Second_Leg.setTextureSize(64, 32);
      Second_Leg.mirror = true;
      setRotation(Second_Leg, 1.570796F, 0F, 0F);
      Third_Leg = new ModelRenderer(this, 0, 0);
      Third_Leg.addBox(0F, 0F, 0F, 2, 2, 6);
      Third_Leg.setRotationPoint(5F, 24F, 6F);
      Third_Leg.setTextureSize(64, 32);
      Third_Leg.mirror = true;
      setRotation(Third_Leg, 1.570796F, 0F, 0F);
      Fourth_Leg = new ModelRenderer(this, 0, 0);
      Fourth_Leg.addBox(0F, 0F, 0F, 2, 2, 6);
      Fourth_Leg.setRotationPoint(-7F, 24F, 6F);
      Fourth_Leg.setTextureSize(64, 32);
      Fourth_Leg.mirror = true;
      setRotation(Fourth_Leg, 1.570796F, 0F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-1F, 0F, 0F, 15, 1, 15);
      Body.setRotationPoint(-7F, 17F, -7F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Addition1 = new ModelRenderer(this, 0, 0);
      Addition1.addBox(0F, 0F, 0F, 15, 1, 1);
      Addition1.setRotationPoint(6F, 16F, 8.2F);
      Addition1.setTextureSize(64, 32);
      Addition1.mirror = true;
      setRotation(Addition1, 0F, 1.570796F, 0F);
      Addition2 = new ModelRenderer(this, 0, 0);
      Addition2.addBox(0F, 0F, 0F, 15, 1, 1);
      Addition2.setRotationPoint(-8F, 16F, 8F);
      Addition2.setTextureSize(64, 32);
      Addition2.mirror = true;
      setRotation(Addition2, 0F, 1.570796F, 0F);
      Addition3 = new ModelRenderer(this, 0, 0);
      Addition3.addBox(0F, 0F, 0F, 15, 1, 1);
      Addition3.setRotationPoint(-8F, 16F, 7F);
      Addition3.setTextureSize(64, 32);
      Addition3.mirror = true;
      setRotation(Addition3, 0F, 0F, 0F);
      Addition4 = new ModelRenderer(this, 0, 0);
      Addition4.addBox(0F, 0F, 0F, 15, 1, 1);
      Addition4.setRotationPoint(-8F, 16F, -7F);
      Addition4.setTextureSize(64, 32);
      Addition4.mirror = true;
      setRotation(Addition4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    First_Leg.render(f5);
    Second_Leg.render(f5);
    Third_Leg.render(f5);
    Fourth_Leg.render(f5);
    Body.render(f5);
    Addition1.render(f5);
    Addition2.render(f5);
    Addition3.render(f5);
    Addition4.render(f5);
  }
  
  public void renderSingle(float height){
	  First_Leg.render(height);
	  Second_Leg.render(height);
	  Third_Leg.render(height);
	  Fourth_Leg.render(height);
	  Body.render(height);
	  Addition1.render(height);
	  Addition2.render(height);
	  Addition3.render(height);
	  Addition4.render(height);
	  
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
 

}
