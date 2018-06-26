package mike.minecraft.elementsmod.gen;

import java.util.Random;

import mike.minecraft.elementsmod.blocks.BlockManager;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ElementsWorldGen implements IWorldGenerator {
	public CrystalGenerator gen;
	public CrystalGenerator nether;
	public CrystalGenerator end;
	public CrystalGenerator netherS;
	public CrystalGenerator endS;
	public CrystalGenerator light;
	public CrystalGenerator random;
	public CrystalGenerator candy;
	public CrystalGenerator lbs;
	public CrystalGenerator air;
	
	public ElementsWorldGen(){
		gen = new CrystalGenerator(BlockManager.wore.getDefaultState());
		nether = new CrystalGenerator(BlockManager.noce.getDefaultState(), BlockHelper.forBlock(Blocks.netherrack));
		end = new CrystalGenerator(BlockManager.eco.getDefaultState(), BlockHelper.forBlock(Blocks.end_stone));
		light = new CrystalGenerator(BlockManager.lco.getDefaultState());
		random = new CrystalGenerator(BlockManager.leo.getDefaultState());
		netherS = new CrystalGenerator(BlockManager.noce.getDefaultState());
		endS = new CrystalGenerator(BlockManager.eco.getDefaultState());
		candy = new CrystalGenerator(BlockManager.bco.getDefaultState());
		lbs = new CrystalGenerator(BlockManager.elb.getDefaultState());
		air = new CrystalGenerator(BlockManager.ao.getDefaultState());
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
		case -1: // Nether
			this.runGenerator(nether, world, random, chunkX, chunkZ, 30, 60, 90);
			
			break;
		case 0: // Overworld
			this.runGenerator(gen, world, random, chunkX, chunkZ, 15, 10, 50);
			this.runGenerator(netherS, world,  random, chunkX, chunkZ, 5, 10, 50);
			this.runGenerator(endS, world, random, chunkX, chunkZ, 5, 10, 50);
			this.runGenerator(light, world, random, chunkX, chunkZ, 30, 10, 60);
			this.runGenerator(this.random, world, random, chunkX, chunkZ, 30, 10, 60);
			this.runGenerator(candy, world, random, chunkX, chunkZ, 26, 10, 96);
			this.runGenerator(lbs, world, random, chunkX, chunkZ, 12, 10, 60);
			this.runGenerator(air, world, random, chunkX, chunkZ, 17, 55, 96);
			break;
		case 1: // End
			this.runGenerator(end, world, random, chunkX, chunkZ, 25, 40, 60);
			break;
		
		}
		
	}
	
	public void runGenerator(WorldGenerator generator, World world, Random rand,  int chunkX, int chunkZ, int spawn, int minY, int maxY){
		if(minY < 0 || maxY > 256 || minY > maxY){
			throw new IllegalArgumentException("Illegal Height Args for WorldGenerator");
		}
		int diff = maxY - minY + 1;
		for(int i = 0; i < spawn; i++){
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minY + rand.nextInt(diff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
			
		}
		
	}
	
	
	

}
