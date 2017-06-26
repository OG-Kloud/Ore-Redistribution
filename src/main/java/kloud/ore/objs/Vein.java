package kloud.ore.objs;

import java.util.Random;

import kloud.ore.Ores;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public final class Vein {
	
	private static int veinID = 0;
	private final String nameVein;
	private final IBlockState block1;
	private final int weight1 = 50;
	private final IBlockState block2;
	private final int weight2 = 85;
	private final IBlockState block3;
	private final int weight3 = 100;
	private int veinSize;
	private int veinWeight;
	
	public final int MAXWEIGHT = 100;
	public final int MAXSIZE = 50;
	
	protected Vein(Block b1, Block b2, Block b3, String name, int size, int weight) {
		veinID += 1;
		this.block1 = b1.getDefaultState();
		this.block2 = b2.getDefaultState();
		this.block3 = b3.getDefaultState();
		this.nameVein = name;
		this.veinSize = size;
		this.veinWeight = weight;
		verifyVeinIntegrity();
	}
	/**Not yet implemented*/
	protected Vein(Block b1, Block b2, String name, int weight) {
		this(b1,  b2, null, name, 100, weight);
	}
	/**Not yet implemented*/
	protected Vein(Block b1, String name, int weight) {
		this(b1, null, name, weight);
	}
	
	public void verifyVeinIntegrity() {
		if(block1 == null) {
			System.out.println("Error with vein creation");
			System.out.println("Your game is about to crash");
			System.out.println("Vein id is = " + veinID);
			System.out.println("Vein Name is " + nameVein);
		}
		System.out.println("Vein id is = " + veinID);
		System.out.println("Vein Name is " + nameVein);
		Ores.kcb.createConfigEntry(this);
	}
	
	public IBlockState oreByWeight() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(100) + 1;
		return randomNumber <= weight1 ? block1 : (randomNumber <= weight2 && randomNumber > weight1 ? block2 : (randomNumber <= weight3 && randomNumber > weight2 ? block3: block1));
	}
	
	public int getVeinSize() {
		return veinSize;
	}
	
	public int getVeinWeight() {
		return veinWeight;
	}
	
	public String getVeinName() {
		return nameVein;
	}

	public IBlockState primary() {
		return this.block1;
	}
	public void setConfigWeight(int veinWeight2) {
		this.veinWeight = veinWeight2;
	}
	public void setSizeWeight(int veinSize2) {
		this.veinSize = veinSize2;
	}
	

}
