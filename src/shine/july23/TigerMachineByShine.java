package shine.july23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TigerMachineByShine extends JApplet implements Runnable,ActionListener {
	/**
	 * @author Shine
	 */
	private static final long serialVersionUID = 1L;
	
	//这个。。。我就不从文本里读了哈。。
	private String[] text = {"赵云","郭嘉","曹操","关羽","诸葛亮"};
	private final static int SIZE = 3;
	private JLabel outputs[];
	private JButton stop;
	private JButton restart;
	
	private Thread threads[];
	
	public void init()
	{
		threads = new Thread[SIZE];
		outputs = new JLabel[SIZE];
		
		stop = new JButton("停止");
		restart = new JButton("滚动"); 
		
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		jp1.setLayout(new GridLayout(1,SIZE,5,5));
		jp2.setLayout(new FlowLayout());
		this.setLayout(new BorderLayout());
		
		for ( int i = 0; i < SIZE; i++ ) {
			outputs[i] = new JLabel();
			outputs[i].setBackground(Color.cyan);
			outputs[i].setOpaque( true );
			jp1.add(outputs[i]);
		}
		
		jp2.add(stop);
		jp2.add(restart);
		add(jp1,BorderLayout.CENTER);
		add(jp2,BorderLayout.SOUTH);
		
		stop.addActionListener(this);
		restart.addActionListener(this);
		
}

	public void run()
	{
		Thread currentThread = Thread.currentThread();
		int index = getIndex(currentThread);
		String display;

		while (threads[index] == currentThread) {
			//睡眠时间0-1秒
			try {
				Thread.sleep((int)(Math.random() * 1000));
			}
			catch ( InterruptedException e ) {
				System.err.println( "sleep interrupted" );
			}
			display = text[(int)(Math.random()* text.length)];
			outputs[index].setText(display);
		}
	}
	//获取当前线程号
	private int getIndex(Thread current)
	{
		for ( int i = 0; i < threads.length; i++ )
			if ( current == threads[i] )
				return i;
		return -1;
	}

	public void start()
	{
		// 启动时及调用时创建线程
		for ( int i = 0; i < threads.length; i++ ) {
			threads[i] =new Thread( this, "Thread " + (i + 1) );
			threads[i].start();
		}
	}
	
	/*
	 * 暂停滚动
	 */
	public synchronized void stop()
	{
		for ( int i = 0; i<threads.length; i++ ){
			threads[i] = null;
			outputs[i].setBackground(Color.pink);
		}	
		notifyAll();
	}
	
	public synchronized void actionPerformed( ActionEvent e )
	{
		if(e.getSource() == stop){
			stop();
		}
		else if(e.getSource() == restart){
			start();
		}
	}
}


