package mike.minecraft.elementsmod.tileentity;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;

public class TileEntitySpawn extends TileEntity implements ITickable {

	@Override
	public void update() {
		for(int i = 0; i < worldObj.getActualHeight(); i++){
				BlockPos fxPos = pos.up(i).east(2);
				BlockPos fxWest = fxPos.west(4);
				worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, fxPos.getX(), fxPos.getY(), fxPos.getZ(), 
						0, 0, 0, new int[0]);
				worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, fxWest.getX(), fxWest.getY(), fxWest.getZ(), 
						0, 0, 0, new int[0]);
			}
		}
}