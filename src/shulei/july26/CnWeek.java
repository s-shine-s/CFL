package shulei.july26;

/**
 * 得到中文星期几
 * @author helloWorld
 *
 */
class CnWeek extends Week { 
	private String sCnWeek[] = { "日", "一", "二", "三", "四", "五", "六" }; 
	public CnWeek() { 
	super(); 
	} 
	public CnWeek(int iWeek) { 
	super(iWeek); 
	}
	public String toString()
	{ 
	return "星期" + sCnWeek[this.iWeek]; 
	}
} 
	
