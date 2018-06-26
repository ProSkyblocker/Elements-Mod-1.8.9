package mike.minecraft.elementsmod.rm;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.entity.EntityLuckyCreeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLuckyCreeper extends RenderLiving<EntityLuckyCreeper> {

	public RenderLuckyCreeper(ModelCreeper c, float scale) {
		super(Minecraft.getMinecraft().getRenderManager(), c, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLuckyCreeper entity) {
		return new ResourceLocation(ElementsMod.MODID, "textures/entity/modelluckycreeper.png");
	}

}
