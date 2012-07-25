package shine.july25;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CalendarWindow extends JFrame{
	/**
	 * Calendar�ó�T.T
	 * �ǵ�ǰ�·ݣ��������������ˡ�����Orz
	 * Ҫ�ĵĵط����ܶࡢ������������
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl[];
	JPanel jp=new JPanel();
	public CalendarWindow(String title){
		super(title);
		jl=new JLabel[49];
		jp.setLayout(new GridLayout(7,7,4,4));//Ϊ��򵥣��Ҿ��趨ֵ�ˡ���
		String tl[]={"������","����һ","���ڶ�","������","������","������","������"};
		String date[]= getDate();
		int i,j;
		for(i=0;i<7;i++){
			jl[i]= new JLabel();
			jl[i].setText(tl[i]);
			jp.add(jl[i]);
		}
		for(j=i;j<i+date.length;j++){
			jl[j]= new JLabel();
			jl[j].setText(date[j-i]);
			jp.add(jl[j]);
		}
		//��ֹ���ּ���������������9����������
		for(int k=48;k>=j;k--){
			jl[k]=new JLabel();
			jl[k].setText(" ");
			jp.add(jl[k]);
		}
		add(jp);
	}
	private String[] getDate(){
		//��������䣬�ο���ǰ��demo����
		DecimalFormat myformat=new DecimalFormat("00");		
		GregorianCalendar gre=new GregorianCalendar();	//��ǰʱ��	
		int maxDay=gre.getActualMaximum(gre.DAY_OF_MONTH);//��ǰ�·ݵ��������
		int day=1;	
		gre.set(GregorianCalendar.DAY_OF_MONTH,1);//��������Ϊ�·ݵĵ�һ��
		int weekday=gre.get(gre.DAY_OF_WEEK)-1; //ÿ��1������ǰ�ո���
		String[] date=new String[weekday+maxDay];			
		//��ǰ��weekday�ַ��������ո�
		for(int i=0;i<weekday;i++){
			date[i]=" ";
		}		
		//�ں���maxday�ַ������������
		for(int i=weekday;i<weekday+maxDay;i++){
			date[i]=myformat.format(day);
			day++;
		}
		return date;
	}
}
public class CalendarByShine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalendarWindow wd = new CalendarWindow("Calendar");
		wd.setBounds(0,0,400,400);
		wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wd.setVisible(true);
	}
}
