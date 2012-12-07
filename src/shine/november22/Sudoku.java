package shine.november22;

import java.util.ArrayList;

public class Sudoku {
	
	public static int UNKNOWN = 81;
	
	private int data;
	private boolean flag;
	private ArrayList<Integer> option;
	private int x;
	private int y;

	public Sudoku(){
		this.data = 0;
		this.flag = false;
		option = new ArrayList<Integer>();
		for(int i = 1; i <= 9;i++){
			option.add(i);
		} 
	}
	public void changeOption(int data){
		if(option.contains(new Integer(data))){
			option.remove(new Integer(data));
		}
	}
	public void changeFlag(){
		if(option.size() == 1){
			setData(option.get(0));
			setFlag(true);
			option.clear();
			Sudoku.UNKNOWN--;
		}
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public ArrayList<Integer> getOption() {
		return option;
	}
	public void setOption(ArrayList<Integer> option) {
		this.option = option;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
