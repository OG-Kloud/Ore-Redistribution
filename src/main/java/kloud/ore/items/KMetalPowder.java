package kloud.ore.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kloud.ore.materials.MetalType;
import net.minecraft.item.Item;

public class KMetalPowder {
	
	public List<Item> listOfMaterials;
	public Map<Item, Integer> toQuantity = new HashMap<Item, Integer>();
	public boolean isSingleMaterial = false;
	public int numberOfMaterials = 0;
	
	public KMetalPowder() {
		listOfMaterials = new ArrayList<Item>(9);
	}
	
	public void addMaterial(MetalType type, int quantity) {
		
	}
	
	public boolean getIsSingleMaterial() {
		return isSingleMaterial;
	}
	
	public void setSingleMaterial() {
		this.isSingleMaterial = true;
	}
	
	public List<Item> truncate() {
		List<Item> active = new ArrayList<Item>(this.numberOfMaterials);
		for(int i = 0; i < this.numberOfMaterials; i++) {
			active.add(this.listOfMaterials.get(i));
		}
		return active;
	}

}
