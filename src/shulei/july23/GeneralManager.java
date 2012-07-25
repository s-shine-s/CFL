package shulei.july23;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GeneralManager {
	static Boolean flag = true;
	private static Random random = new Random();
	public static ArrayList<String> Generals = new ArrayList<String>();
	static {
		String path = System.getProperty("user.dir");// 获取当前项目路径
		// System.out.println(path);
		File file = new File(path + "\\general.txt");
		try {
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				if (temp != null) {
					Generals.add(temp.trim());
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for (String item : Generals) {
		// System.out.println(item.trim());
		// }

	}

	public static String getRandomGeneral() {
		int ran = random.nextInt(GeneralManager.Generals.size());
		return Generals.get(ran);
	}

	public void startAdvanceGame() {
		final GeneralRun run1 = new GeneralRun(30);
		final GeneralRun run2 = new GeneralRun(50);
		final GeneralRun run3 = new GeneralRun(100);
		GeneralStauts.bind(run1);
		GeneralStauts.bind(run2);
		GeneralStauts.bind(run3);
		
		new Thread(run1).start();
		new Thread(run2).start();
		new Thread(run3).start();
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					System.in.read();
					run1.end();
					run2.end();
					run3.end();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}).start();
	}

	public void StartGame() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				GeneralManager manager = new GeneralManager();
				while (flag) {

					manager.getRandomGeneral();
					// Runtime.getRuntime().exec("cmd /c cls");
					System.out.println(manager.getRandomGeneral());
					try {
						Thread.sleep(random.nextInt(30) + 20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					System.in.read();
					flag = false;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}).start();

	}

}
