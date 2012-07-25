package shulei.july24;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphicsDevice device = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		DisplayMode dMode = device.getDisplayMode();
		int width = dMode.getWidth();
		int height = dMode.getHeight();
		System.out.println("with:" + width + " " + "height:" + height);
		MainScreen mainScreen=new MainScreen(width,height);
		final JFrame frame=new JFrame();
		frame.getContentPane().add(mainScreen,BorderLayout.CENTER);
		frame.setUndecorated(true);
		device.setFullScreenWindow(frame);
		new Thread(mainScreen).start();
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
	}

}
