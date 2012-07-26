package shulei.UI.util;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import shulei.july25.Applet1;

public class Console {
	public static String title(Object o) {
		String tString = o.getClass().toString();
		System.out.println(tString);
		if (tString.indexOf("class") != -1) {
			tString = tString.substring(6);
		}
		return tString;

	}

	public static void run(JFrame jFrame, int width, int height) {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(width, height);
		jFrame.setVisible(true);
	}

	public static void run(JApplet jApplet, int width, int height) {
		JFrame jFrame = new JFrame(title(jApplet));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(width, height);

		jFrame.getContentPane().add(jApplet);
		jApplet.init();
		jApplet.start();
		jFrame.setVisible(true);
	}

	public void run(JPanel jPanel, int width, int height) {
		JFrame jFrame = new JFrame(title(jPanel));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(width, height);

		jFrame.getContentPane().add(jPanel);
		jFrame.setVisible(true);
	}
	// public static void main(String[] args) {
	// System.out.println(title(new JApplet()));
	// }
}
