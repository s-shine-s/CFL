package july21;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConstellationByShine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] consteList={"白羊座","金牛座","双子座","巨蟹座","狮子座","处女座",
				"天秤座","天蝎座","射手座","摩羯座","水瓶座","双鱼座"};
		String[] adviceList={"和朋友去吃饭！","约个会吧！","睡觉睡到自然醒！",
				"不要对着电脑发呆！","去吃巧克力！","和家人聊天！",
				"勇敢去表白吧！","学习该努力啦！","多喝水！",
				"多睡觉！","准时吃饭！","玩会儿游戏吧！"};
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String datestr=format.format(date);
		System.out.println("时间："+ datestr);
		System.out.println("-----------------星 座 运 势------------------");
		for(int i=0;i<consteList.length;i++){
			System.out.println(consteList[i] + "	" 
					+ "运势: " + starOut()+  " \t"
					+ "建议: " + adviceList[(int)(Math.random()*adviceList.length)] );
		}
	}
	private static String starOut(){
		int num=(int)(Math.random()*5+1);
		String star="";
		for(int i=0;i<num;i++){
			star+="★";
		}
		return star;
	}

}
