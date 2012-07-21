package july21;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.naming.InitialContext;

/**
 * @author shulei
 * 
 */
public class ConstellationManager {
	Map<String, String> map = new HashMap<String, String>();

	public ConstellationManager() {
		init();
	}

	private void init() {
	
		for (int i = 0; i < ConstellationInfo.CONSTELLATION_ARRAY.length; i++) {
			map.put(ConstellationInfo.CONSTELLATION_ARRAY[i], ConstellationInfo.getRandomLuckyInfo());
		} 
		

	}

	public boolean Contain(String constellation) {

		return map.containsKey(constellation);
	}

	public void printConstellationInfo(String constellation) {

		System.out.println("Constellation:" + constellation + "   "
				+ map.get(constellation));

	}

}
