package mike.minecraft.elementsmod.rm;

import org.lwjgl.opengl.GL11;

import mike.minecraft.elementsmod.ElementsMod;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TESpawnRenderer extends TileEntitySpecialRenderer {
	public ModelRespawnPoint model;
	
	private static final ResourceLocation texture = 
			new ResourceLocation(ElementsMod.MODID, "extras/ModelSpawnBlock.png");

	public TESpawnRenderer() {
		model = new ModelRespawnPoint();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z,
			float render, int number) {
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
		GL11.glRotated(180, 0, 0, 1);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		model.renderSingle(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	

}
