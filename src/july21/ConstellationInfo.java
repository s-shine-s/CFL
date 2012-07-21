package july21;

import java.util.Random;

/**
 * @author shulei
 *
 */
public class ConstellationInfo {
	public enum Constellation {
		Capricorn("Ħ����12.22-1.19"), Aquarius("ˮƿ��1.20-2.18"), Pisces(
				"˫����2.19-3.20"), Aries("������3.21-4.20"), Taurus("��ţ��4.21-5.20"), Gemini(
				"˫����5.21-6.21"), Cancer("��з��6.22-7.22"), Leo("ʨ����7.23-8.22"), Virgo(
				"��Ů��8.23-9.22"), Libra("�����9.23-10.22"), Scorpio(
				"��Ы��10.23-11.21"), Sagittarius("������11.22-12.21");
		public final String INFO;

		Constellation(String info) {
			INFO = info;
		}

	};

	public static final String[] CONSTELLATION_ARRAY = { "Capricorn",
			"Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer",
			"Leo", "Virgo", "Libra", "Scorpio", "Sagittarius" };
	public static final String[] LUCKY_INFO = {" ���ƣ�6��   ���飺�������Ʊ�����ö�˵��ps�����Խ��Խ�ã�",
		" ���ƣ�5�ǰ�   ���飺��Ǯ�����ֳ�����",
		" ���ƣ�5��   ���飺���������˯����",
		" ���ƣ�4�ǰ�   ���飺ÿ�����ǰ룬����������",
		" ���ƣ�4��   ���飺���Ѿ�������ȫ���ٷ�֮��ʮ�����꣬�ﵽ������С��",
		" ���ƣ�3�ǰ�   ���飺����֮��������1���׵ĸ߿չ��������ߵ���˵����������������",
		" ���ƣ�3��   ���飺��಻С�Ĳȵ����ϣ�ûɶ�ر�ģ�",
		" ���ƣ�2�ǰ�   ���飺������ûʲô��˵�ģ���������",
		" ���ƣ�2��   ���飺�������������ζ��ѣ������Ʊ����Ĳ����еģ�",
		" ���ƣ�1�ǰ�   ���飺�͵����͵����Ѿ��ڱ�Ե�ˣ�ʱ��ע�ⰲȫ�ɣ����꣡",
		" ���ƣ�1��   ���飺����Ǹ����磡",
		" ���ƣ�0�ǰ�   ���飺��֪����վ������������𣬴�֮����д�ϲ��һ�ж���õģ����ͣ�",
		" ���ƣ�0��   ���飺ֱ����ɱ���ˣ�",};

	public static String getRandomLuckyInfo() {
		Random random = new Random();
		return ConstellationInfo.LUCKY_INFO[random.nextInt(12)];

	}

}
