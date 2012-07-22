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
		System.out.print("�������������");
		Scanner scan = new Scanner(System.in);
		String city = scan.next();
		System.out.println("���У�"+ city + "\n");
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
//		BJ("����"), NJ("�Ͼ�"), SH("�Ϻ�"), TJ("���"), WX("����")
//		, YZ("����"), SZ("����"), HZ("����"), HEB("������"), WH("�人"), CQ("����");
//		public final String INFO;
//		CityCollection(String info){
//			INFO = info;
//		}
//	}
	/*
	 * ����Ӣ������
	 */
	public static String getCity(String city){
		String[] zCity = {"����", "�Ͼ�","�Ϻ�","���","����","����","����","����"};
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
	 * ��ȡ����
	 */
	public static String getWeather(String city) throws IOException, SAXException, ParserConfigurationException{
		
		//������Ϣ
		StringBuilder weatherInfo = new StringBuilder();
		
		//google����
		String google = "http://www.google.com/ig/api?hl=zh_cn&weather=";
		URL weatherURL = new URL(google + city);
			
		//��ȡURL�ɷ���Ϣ,����XML
		InputStream in= weatherURL.openStream();		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = in.read()) != -1)
			bos.write(i);

		InputStream readIn = new ByteArrayInputStream(bos.toString().getBytes("utf-8"));
		Document doc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder().parse(readIn);
				
		//��ȡ��Ҫ�ڵ�
		NodeList forecastInfo = getNodeList(doc,0,"forecast_information");
		NodeList currentCondi = getNodeList(doc,0,"current_conditions");
		NodeList forecastCondi = getNodeList(doc,0,"forecast_conditions");
		
		//��ǰ������Ϣ
//		String currDate = "����ʱ�䣺" + getAttribute(forecastInfo,5,0) + "\n";
		String currCondi = "������" + getAttribute(currentCondi,0,0) + "	\t";
		String currHumidity = getAttribute(currentCondi,3,0) + "\t";
		String currWind = getAttribute(currentCondi,5,0) + "\n";
		
		//Ԥ����Ϣ
		String foreDate = "���ڣ�" + getAttribute(forecastInfo,4,0) + "\t";
		String dateOfWeek = getAttribute(forecastCondi,0,0) + "\n";
		String foreCondi = "Ԥ����" + getAttribute(forecastCondi,4,0) + "\t";
		String temperature = "�¶�(��)��" + getAttribute(forecastCondi,1,0) + "~"
			+ getAttribute(forecastCondi,2,0) + "\n";
		
		weatherInfo.append(foreDate).append(dateOfWeek).append(currCondi).append(currHumidity).append(currWind);
		weatherInfo.append(foreCondi).append(temperature);
		return weatherInfo.toString();
	}
	
	/*
	 * ��ȡXML�ڵ�
	 * doc ΪXML�ĵ���Ϣ
	 */
	public static NodeList getNodeList(Document doc,int item, String nodeName) {
		NodeList nodeList = null;
		nodeList = doc.getElementsByTagName(nodeName).item(item).getChildNodes();
		return nodeList;
	}
	/*
	 * ��ȡ�ڵ�ֵ
	 * index Ϊ�ڵ�����
	 * item Ϊ��������
	 */
	public static String getAttribute(NodeList node,int index, int item){
		String attrValue=null;
		attrValue=node.item(index).getAttributes().item(item).getNodeValue();
		return attrValue;
	}

}
