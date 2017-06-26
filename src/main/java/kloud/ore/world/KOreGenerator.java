package kloud.ore.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kloud.ore.handler.VeinHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class KOreGenerator implements IWorldGenerator{
	public List<WorldGenerator> generators = new ArrayList<WorldGenerator>();
	
	WorldGenerator coalGenerator;
	WorldGenerator gold1;
	WorldGenerator redstone;
	WorldGenerator lapis;
	WorldGenerator coal1;
	WorldGenerator gold2;
	WorldGenerator coal2;
	WorldGenerator copper1;
	WorldGenerator lead1;
	WorldGenerator silver1;
	WorldGenerator cobalt;
	WorldGenerator iridium1;
	WorldGenerator platinum1;
	WorldGenerator osmium;
	WorldGenerator palladium;
	WorldGenerator titanium;
	WorldGenerator zinc;
	WorldGenerator zinc1;
	WorldGenerator copper;
	WorldGenerator iron1;
	WorldGenerator iron2;
	
	int generatorTotalWeight;
	static WorldGenerator activeGenerator;
	
	static int totalCalls = 0;
	
	public KOreGenerator() {
		
	}
	
	public void init() {
		coalGenerator = new KGenMinable(VeinHandler.coal);
		gold1 = new KGenMinable(VeinHandler.goldSilver);
		redstone = new KGenMinable(VeinHandler.redstone);
		lapis = new KGenMinable(VeinHandler.lapis);
		coal1 = new KGenMinable(VeinHandler.coalTungsten);
		gold2 = new KGenMinable(VeinHandler.goldPlatinum);
		coal1 = new KGenMinable(VeinHandler.coalDiamond);
		copper1 = new KGenMinable(VeinHandler.copperTinAluminium);
		lead1 = new KGenMinable(VeinHandler.leadAluminium);
		silver1 = new KGenMinable(VeinHandler.silverChromiumNickle);
		cobalt = new KGenMinable(VeinHandler.cobaltNickle);
		iridium1 = new KGenMinable(VeinHandler.iridiumTitanium);
		platinum1 = new KGenMinable(VeinHandler.platinumIridium);
		osmium = new KGenMinable(VeinHandler.osmiumTin);
		palladium = new KGenMinable(VeinHandler.palladiumSilver);
		titanium = new KGenMinable(VeinHandler.titaniumSilver);
		zinc = new KGenMinable(VeinHandler.zinc);
		zinc1 = new KGenMinable(VeinHandler.zincAluminiumNickle);
		copper = new KGenMinable(VeinHandler.nativeCopper);
		iron1 = new KGenMinable(VeinHandler.ironCopper);
		iron2 = new KGenMinable(VeinHandler.ironCoal);

		add(coalGenerator);
		add(gold1);
		add(redstone);
		add(lapis);
		add(coal1);
		add(gold2);
		add(coal1);
		add(copper1);
		add(lead1);
		add(silver1);
		add(cobalt);
		add(iridium1);
		add(platinum1);
		add(osmium);
		add(palladium);
		add(titanium);
		add(zinc);
		add(zinc1);
		add(copper);
		add(iron1);
		add(iron2);
	}
	
	public void add(WorldGenerator wg) {
		generatorTotalWeight += ((KGenMinable)wg).getGenWeight();
		generators.add(wg);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		case 0:
			genSurface(world, random, chunkX * 16, chunkZ * 16);
			default:
		}
		
	}
	
	public void genSurface(World world, Random random, int chunkX, int chunkZ) {
		for(int x = 0; x < 1; x++){
			int posX = chunkX + random.nextInt(16);
			int posY = 10 + random.nextInt(99);
			int posZ = chunkZ + random.nextInt(16);
			getGeneratorByWeight().generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public WorldGenerator getGeneratorByWeight() {
		if(totalCalls >= 50 || KOreGenerator.activeGenerator == null) {
			totalCalls = 0;
			Random rand = new Random();
			int index = rand.nextInt(generatorTotalWeight);
			int sum = 0;
			int i = 0;
			while(sum < index) {
				sum = sum + ((KGenMinable)generators.get(i++)).getGenWeight();
			}
//			System.out.println("Chosen vein is: " + veins.get(Math.max(0, i-1)).getVeinName());
			KOreGenerator.activeGenerator = generators.get(Math.max(0, i-1));
			System.out.println(((KGenMinable)KOreGenerator.activeGenerator).getVeinName());
			return KOreGenerator.activeGenerator;
		} else {
			totalCalls += 1;
			return KOreGenerator.activeGenerator;
		}
	}

}
