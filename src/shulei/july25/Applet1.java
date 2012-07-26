package shulei.july25;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import shulei.UI.util.Console;

public class Applet1 extends JApplet {
	private JButton b1 = new JButton("click1");
	private JTextField textField = new JTextField(10);
	private JTextArea textArea = new JTextArea(20, 40);

	@Override
	public void init() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new JLabel("ÔÂ·Ý£º"));

		container.add(textField);
		container.add(b1);
		container.add(new JScrollPane(textArea));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append(CalendarUtil.showMonthCalender(2012,
						Integer.parseInt(textField.getText())));
			}
		});

	}

	public static void main(String[] args) {
		Console.run(new Applet1(), 500, 500);

	}
}
