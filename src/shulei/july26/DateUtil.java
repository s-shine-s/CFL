package shulei.july26;

import javax.swing.JTextField;

/**
 * ��Щͨ�õĶ���
 * @author helloWorld
 *
 */
public class DateUtil {
	/**
	 * @param paser  ����1990-1-2��ʽ������
	 * @return ����1990-1-2���� Split����-����֮������ݲ�ת��Ϊint
	 */
	public static int[] getYMD(String paser) {
		//TODO ��������ʽ�����Ƿ���ϸ�ʽ
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
