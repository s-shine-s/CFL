package july21;

import java.util.Random;

/**
 * @author shulei
 *
 */
public class ConstellationInfo {
	public enum Constellation {
		Capricorn("摩羯座12.22-1.19"), Aquarius("水瓶座1.20-2.18"), Pisces(
				"双鱼座2.19-3.20"), Aries("白羊座3.21-4.20"), Taurus("金牛座4.21-5.20"), Gemini(
				"双子座5.21-6.21"), Cancer("巨蟹座6.22-7.22"), Leo("狮子座7.23-8.22"), Virgo(
				"处女座8.23-9.22"), Libra("天秤座9.23-10.22"), Scorpio(
				"天蝎座10.23-11.21"), Sagittarius("射手座11.22-12.21");
		public final String INFO;

		Constellation(String info) {
			INFO = info;
		}

	};

	public static final String[] CONSTELLATION_ARRAY = { "Capricorn",
			"Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer",
			"Leo", "Virgo", "Libra", "Scorpio", "Sagittarius" };
	public static final String[] LUCKY_INFO = {" 运势：6星   建议：立刻买彩票，还用多说。ps：买的越多越好！",
		" 运势：5星半   建议：数钱数到手抽筋，，！",
		" 运势：5星   建议：随便玩儿随便睡觉！",
		" 运势：4星半   建议：每天四星半，快乐似神仙",
		" 运势：4星   建议：你已经击败了全国百分之六十的少年，达到了幸运小康",
		" 运势：3星半   建议：幸运之神在离你1万米的高空哈，如果你高调点说不定能吸引到她！",
		" 运势：3星   建议：最多不小心踩到蚂蚁，没啥特别的！",
		" 运势：2星半   建议：呼呼，没什么好说的，就那样呗",
		" 运势：2星   建议：马马虎虎，中下游而已，别买彩票，真的不会中的！",
		" 运势：1星半   建议：低调，低调，已经在边缘了，时刻注意安全吧，少年！",
		" 运势：1星   建议：你就是个悲剧！",
		" 运势：0星半   建议：我知道你刚经历了生离死别，大悲之后必有大喜，一切都会好的，加油！",
		" 运势：0星   建议：直接自杀好了！",};

	public static String getRandomLuckyInfo() {
		Random random = new Random();
		return ConstellationInfo.LUCKY_INFO[random.nextInt(12)];

	}

}
