package july21;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConstellationByShine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] consteList={"������","��ţ��","˫����","��з��","ʨ����","��Ů��",
				"�����","��Ы��","������","Ħ����","ˮƿ��","˫����"};
		String[] adviceList={"������ȥ�Է���","Լ����ɣ�","˯��˯����Ȼ�ѣ�",
				"��Ҫ���ŵ��Է�����","ȥ���ɿ�����","�ͼ������죡",
				"�¸�ȥ��װɣ�","ѧϰ��Ŭ������","���ˮ��",
				"��˯����","׼ʱ�Է���","������Ϸ�ɣ�"};
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String datestr=format.format(date);
		System.out.println("ʱ�䣺"+ datestr);
		System.out.println("-----------------�� �� �� ��------------------");
		for(int i=0;i<consteList.length;i++){
			System.out.println(consteList[i] + "	" 
					+ "����: " + starOut()+  " \t"
					+ "����: " + adviceList[(int)(Math.random()*adviceList.length)] );
		}
	}
	private static String starOut(){
		int num=(int)(Math.random()*5+1);
		String star="";
		for(int i=0;i<num;i++){
			star+="��";
		}
		return star;
	}

}
