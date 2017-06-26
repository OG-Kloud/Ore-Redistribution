package kloud.ore.config;
import kloud.ore.handler.VeinHandler;
import kloud.ore.objs.Vein;

public class KConfigEntry {
	
	public String weight;
	public String size;
	public String catName;
	
	public int veinWeight;
	public int veinSize;
	
	public int defaultWeight;
	public int defaultSize;
	
	public int maxWeight;
	public int maxSize;
	
	public KConfigEntry(String weight, String size, String name, int dw, int ds, int w, int s){
		this.weight = weight;
		this.size = size;
		this.catName = name;
		
		this.maxSize = s;
		this.maxWeight = w;
		
		this.defaultSize = ds;
		this.defaultWeight = dw;
	}

	public void updateVein() {
		Vein vein = VeinHandler.getVeinFromName(catName);
		vein.setConfigWeight(veinWeight);
		vein.setSizeWeight(veinSize);
	}

}
