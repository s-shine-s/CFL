package shulei.july24;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

public class MainScreen extends JPanel implements Runnable {
	private int width;
	private int height;
	private String time;
	private Random random = new Random();

	public MainScreen(int width, int height) {
		this.width = width;
		this.height = height;
		refreshTime();
	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.gray);
		for (int i = 0; i < 100; i++) {
			Point point = new Point(random.nextInt(width),
					random.nextInt(height));
			Point point2 = new Point(random.nextInt(width),
					random.nextInt(height));
			g.drawLine(point.x, point.y, point2.x, point2.y);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// g.setColor(Color.WHITE);
		g.setFont(new Font("ºÚÌå", Font.BOLD, 150));
		FontMetrics fontMetrics = g.getFontMetrics();
		drawBackground(g);

		// g.setColor(Color.BLACK);
		// g.drawRect(0, 200, width, 400);
		g.setColor(Color.WHITE);
		g.drawString(time, 30, 400);
		g.drawString("enter to exit!", 20, 600);

	}

	private void refreshTime() {
		java.util.Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("h:mm:ss.SSS a");
		time = dateFormat.format(date);
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(10);
				refreshTime();

				repaint();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
