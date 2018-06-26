package mike.minecraft.elementsmod.rm;

import mike.minecraft.elementsmod.ElementsMod;
import mike.minecraft.elementsmod.entity.EntityElementMaster;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderElementMaster extends RenderLiving<EntityElementMaster> {
	
	public RenderElementMaster(ModelElementMaster model, float scale){
		super(Minecraft.getMinecraft().getRenderManager(), model, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityElementMaster entity) {
		return new ResourceLocation(ElementsMod.MODID, "textures/entity/modelelementmaster.png");
	}

}
