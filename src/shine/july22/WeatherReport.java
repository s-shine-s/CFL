package shine.july22;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherReport {
	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws IOException 
	 */
	public static void main(String[] args){
		System.out.print("请输入城市名：");
		Scanner scan = new Scanner(System.in);
		String city = scan.next();
		System.out.println("城市："+ city + "\n");
		String weather=null;
		try {
			weather = getWeather(getCity(city));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(weather);
	}

//	public enum CityCollection{
//		BJ("北京"), NJ("南京"), SH("上海"), TJ("天津"), WX("无锡")
//		, YZ("扬州"), SZ("苏州"), HZ("杭州"), HEB("哈尔滨"), WH("武汉"), CQ("重庆");
//		public final String INFO;
//		CityCollection(String info){
//			INFO = info;
//		}
//	}
	/*
	 * 城市英文名字
	 */
	public static String getCity(String city){
		String[] zCity = {"北京", "南京","上海","天津","无锡","扬州","苏州","杭州"};
		String[] eCity = {"beijing","nanjing","shanghai","tianjin"
				,"wuxi","yangzhou","suzhou","hangzhou"};
		int i=0;
		for(i=0;i<zCity.length;i++){
			if(zCity[i].equals(city)){
				break;
			}
		}
		return eCity[i];
	}
	/*
	 * 获取天气
	 */
	public static String getWeather(String city) throws IOException, SAXException, ParserConfigurationException{
		
		//天气信息
		StringBuilder weatherInfo = new StringBuilder();
		
		//google天气
		String google = "http://www.google.com/ig/api?hl=zh_cn&weather=";
		URL weatherURL = new URL(google + city);
			
		//读取URL成分信息,返回XML
		InputStream in= weatherURL.openStream();		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = in.read()) != -1)
			bos.write(i);

		InputStream readIn = new ByteArrayInputStream(bos.toString().getBytes("utf-8"));
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(readIn);
				
		//获取主要节点
		NodeList forecastInfo = getNodeList(doc,0,"forecast_information");
		NodeList currentCondi = getNodeList(doc,0,"current_conditions");
		NodeList forecastCondi = getNodeList(doc,0,"forecast_conditions");
		
		//当前天气信息
//		String currDate = "现在时间：" + getAttribute(forecastInfo,5,0) + "\n";
		String currCondi = "天气：" + getAttribute(currentCondi,0,0) + "	\t";
		String currHumidity = getAttribute(currentCondi,3,0) + "\t";
		String currWind = getAttribute(currentCondi,5,0) + "\n";
		
		//预报信息
		String foreDate = "日期：" + getAttribute(forecastInfo,4,0) + "\t";
		String dateOfWeek = getAttribute(forecastCondi,0,0) + "\n";
		String foreCondi = "预报：" + getAttribute(forecastCondi,4,0) + "\t";
		String temperature = "温度(℃)：" + getAttribute(forecastCondi,1,0) + "~"
			+ getAttribute(forecastCondi,2,0) + "\n";
		
		weatherInfo.append(foreDate).append(dateOfWeek).append(currCondi).append(currHumidity).append(currWind);
		weatherInfo.append(foreCondi).append(temperature);
		return weatherInfo.toString();
	}
	
	/*
	 * 获取XML节点
	 * doc 为XML文档信息
	 */
	public static NodeList getNodeList(Document doc,int item, String nodeName) {
		NodeList nodeList = null;
		nodeList = doc.getElementsByTagName(nodeName).item(item).getChildNodes();
		return nodeList;
	}
	/*
	 * 获取节点值
	 * index 为节点索引
	 * item 为属性索引
	 */
	public static String getAttribute(NodeList node,int index, int item){
		String attrValue=null;
		attrValue=node.item(index).getAttributes().item(item).getNodeValue();
		return attrValue;
	}

}
