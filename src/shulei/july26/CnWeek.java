package shulei.july26;

/**
 * �õ��������ڼ�
 * @author helloWorld
 *
 */
class CnWeek extends Week { 
	private String sCnWeek[] = { "��", "һ", "��", "��", "��", "��", "��" }; 
	public CnWeek() { 
	super(); 
	} 
	public CnWeek(int iWeek) { 
	super(iWeek); 
	}
	public String toString()
	{ 
	return "����" + sCnWeek[this.iWeek]; 
	}
} 
	
