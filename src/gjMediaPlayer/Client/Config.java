package gjMediaPlayer.Client;

import java.util.prefs.*;

public class Config {
	
	private static Preferences config;
	
	private static double volume = 100.0;

	public Config(){
		config = Preferences.userRoot();
		
		if(config.getDouble("VOLUME", -1) != -1){
			volume = config.getDouble("VOLUME", -1);
		}
	}
	
	public Preferences getConfig() {
		return config;
	}

	public static double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		Config.volume = volume;
		config.putDouble("VOLUME", Config.volume);
	}
	
}
