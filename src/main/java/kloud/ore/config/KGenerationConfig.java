package kloud.ore.config;

public class KGenerationConfig implements IKConfig{
	
	public boolean disableVanillaGen = true;
	public int distanceOption;
/*
	@Override
	public void onLoad(Configuration config) {
		config.load();
			disableVanillaGen = config.getBoolean("disableVanillaOreGen", Configuration.CATEGORY_GENERAL, true, "Controls weather vanilla ore generations is disabled.\nVanilla oreGen is disabled by default.\n true disables oreGen false allows vanilla oreGen.");
			distanceOption = config.getInt("distanceVariable", Configuration.CATEGORY_GENERAL, 100, 0, 1000, "determines when the generator will pick a new ore vein type");
		config.save();
	}
*/
	@Override
	public void syncConfig() {
		// TODO Auto-generated method stub
		
	}
}
