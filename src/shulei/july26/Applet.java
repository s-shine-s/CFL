package shulei.july26;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shulei.UI.util.Console;

public class Applet extends JApplet {
	private JButton b1 = new JButton("²éÑ¯");
	private JLabel label = new JLabel("ÈÕÆÚ(1990-1-3)£º");
	private JTextField textField = new JTextField(10);
	private JTextArea textArea = new JTextArea(20, 40);

	@Override
	public void init() {
		// super.init();
		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		container.add(label);
		container.add(textField);
		container.add(b1);
		container.add(new JScrollPane(textArea));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (DateUtil.MatchYMD(textField)) {
					// String lundarString= ChineseCalendar
					// .sCalendarSolarToLundar(DateUtil.getYMD(textField
					// .getText()));

					int[] inttemp = DateUtil.getYMD(textField.getText());
					SolarDate solarDate = new SolarDate(inttemp[0], inttemp[1],
							inttemp[2]);

					textArea.append(solarDate.toLunarDate().toString() + "  "
							+ solarDate.toWeek().toString());
					textArea.append("\n");
				}
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Console.run(new Applet(), 500, 500);

	}

}
