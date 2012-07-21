package july21;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import july21.ConstellationInfo.Constellation;

/**
 * just print words that you want to say
 * 
 * @author shulei
 * 
 * 
 */
public class mainByShulei {

	/**
	 * ��һ�⣬����̨����Լ���˵�Ļ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String content = "Do the things that you want to do.Do the things which you will be proud of in all life";
		System.out.println(content);

		startGetConstellationInfo();

	}

	private static void startGetConstellationInfo() {
		ConstellationManager manager = new ConstellationManager();
		String constellation = null;

		for (Constellation element : Constellation.values()) {
			System.out.println(element.INFO + "  :  " + element.toString());
		}
		System.out.println("please input your constellation(���������Ǹ�Ӣ�ģ������Сд��һ��)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			while ((constellation = reader.readLine()) == null) {
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (manager.Contain(constellation)) {
			manager.printConstellationInfo(constellation);
		} else {
			System.out.println("your input is error!");
		}
	}

}
