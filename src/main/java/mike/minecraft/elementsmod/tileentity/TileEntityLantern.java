package mike.minecraft.elementsmod.tileentity;

import net.minecraft.util.ITickable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;

public class TileEntityLantern extends TileEntity implements ITickable {

	@Override
	public void update() {
		BlockPos posW = pos.west();
		BlockPos posE = pos.east();
		worldObj.spawnParticle(EnumParticleTypes.FLAME, posE.getX(), posE.getY() + 1, posE.getZ(), 
				0, 0, 0, new int[0]);
		worldObj.spawnParticle(EnumParticleTypes.FLAME, posW.getX(), posW.getY() + 1, posW.getZ(), 
				0, 0, 0, new int[0]);
		}
}