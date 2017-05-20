package net.kloudspace.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.kloudspace.init.handlers.VeinHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KOreGenerator implements IWorldGenerator{
	private List<WorldGenerator> generators = new ArrayList<WorldGenerator>();
	
	WorldGenerator ironGenerator;
	WorldGenerator goldGenerator;
	int generatorTotalWeight;
	
	public KOreGenerator() {
		ironGenerator = new KGenMinable(VeinHandler.ironVein, 50);
		goldGenerator = new KGenMinable(VeinHandler.goldVein, 50);
		
		generators.add(ironGenerator);
		generatorTotalWeight += ((KGenMinable)ironGenerator).getGenWeight();
		generators.add(goldGenerator);
		generatorTotalWeight += ((KGenMinable)goldGenerator).getGenWeight();
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		case 0:
			genSurface(ironGenerator, world, random, chunkX * 16, chunkZ * 16);
			default:
		}
		
	}
	
	public void genSurface(WorldGenerator gener, World world, Random random, int chunkX, int chunkZ) {
		for(int x = 0; x < 1; x++){
			int posX = chunkX + random.nextInt(16);
			int posY = 10 + random.nextInt(99);
			int posZ = chunkZ + random.nextInt(16);
			getGeneratorByWeight().generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public WorldGenerator getGeneratorByWeight() {
		Random rand = new Random();
		int index = rand.nextInt(generatorTotalWeight);
		int sum = 0;
		int i = 0;
		while(sum < index) {
			sum = sum + ((KGenMinable)generators.get(i++)).getGenWeight();
		}
//		System.out.println("Chosen vein is: " + veins.get(Math.max(0, i-1)).getVeinName());
		return generators.get(Math.max(0, i-1));
	}

}
