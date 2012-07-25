package shulei.july23;

import java.util.ArrayList;

import javax.net.ssl.SSLEngineResult.Status;

public class GeneralStauts {
	public static ArrayList<GeneralRun> list = new ArrayList<GeneralRun>();
	public static ArrayList<String> Status = new ArrayList<String>();

	public static void bind(GeneralRun generalRun) {
		list.add(generalRun);
		Status.add(GeneralManager.getRandomGeneral());

	}

	public static void putAndSysout(GeneralRun generalRun) {
		int index = list.indexOf(generalRun);
		Status.set(index, generalRun.general);
		for (String item : Status) {
			System.out.print(item + "   ");
		}
		System.out.print("\n");

	}
}
