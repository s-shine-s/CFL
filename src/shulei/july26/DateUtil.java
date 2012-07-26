package shulei.july26;

import javax.swing.JTextField;

/**
 * 放些通用的东西
 * @author helloWorld
 *
 */
public class DateUtil {
	/**
	 * @param paser  形如1990-1-2格式的数据
	 * @return 返回1990-1-2经过 Split（“-”）之后的内容并转化为int
	 */
	public static int[] getYMD(String paser) {
		//TODO 用正则表达式解析是否符合格式
		String[] result =paser.split("-");
		int[] nIntResult=new int[3];
		for (int i = 0; i < 3; i++) {
			nIntResult[i]=Integer.parseInt(result[i].trim());
		}
		return nIntResult;
	}

	public static boolean MatchYMD(JTextField textField) {
		// TODO Auto-generated method stub
		return true;
	}
}
