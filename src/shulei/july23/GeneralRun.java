package shulei.july23;

public class GeneralRun implements Runnable {

	private static boolean flag = true;
	private long time;
	public static String general = "";

	public GeneralRun(long time) {
		this.time = time;
	}

	public void end() {
		flag = false;
	}

	@Override
	public void run() {
		GeneralManager manager = new GeneralManager();
		while (flag) {

			manager.getRandomGeneral();

			general = manager.getRandomGeneral();
			GeneralStauts.putAndSysout(this);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
