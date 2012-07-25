package shine.july25;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class CalendarWindow extends JFrame{
	/**
	 * Calendar好丑T.T
	 * 是当前月份，最后发现忘了输出了。。。Orz
	 * 要改的地方还很多、、、、、、、
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jl[];
	JPanel jp=new JPanel();
	public CalendarWindow(String title){
		super(title);
		jl=new JLabel[49];
		jp.setLayout(new GridLayout(7,7,4,4));//为求简单，我就设定值了。。
		String tl[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
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
		//防止出现极端情况，比如今年9月那样。。
		for(int k=48;k>=j;k--){
			jl[k]=new JLabel();
			jl[k].setText(" ");
			jp.add(jl[k]);
		}
		add(jp);
	}
	private String[] getDate(){
		//这个规格化填充，参考以前的demo来着
		DecimalFormat myformat=new DecimalFormat("00");		
		GregorianCalendar gre=new GregorianCalendar();	//当前时间	
		int maxDay=gre.getActualMaximum(gre.DAY_OF_MONTH);//当前月份的最大天数
		int day=1;	
		gre.set(GregorianCalendar.DAY_OF_MONTH,1);//设置日期为月份的第一天
		int weekday=gre.get(gre.DAY_OF_WEEK)-1; //每月1号星期前空格数
		String[] date=new String[weekday+maxDay];			
		//在前面weekday字符串中填充空格
		for(int i=0;i<weekday;i++){
			date[i]=" ";
		}		
		//在后面maxday字符串中填充日期
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
