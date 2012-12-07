package shine.november22;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assist {
	public static void CreateSudoku(Sudoku [][]sudoku) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("resourse/sudoku.txt")));
		String str = null;
		int line = 0;
		while((str = br.readLine()) != null){
			String str2 = str.replace(" ", "");
			for(int i = 0; i < 9; i++){
				int data = Integer.parseInt(String.valueOf(str2.charAt(i)));
				if(0 != data){
					sudoku[line][i].setData(data);
					sudoku[line][i].setFlag(true);
					sudoku[line][i].setOption(null);
					Sudoku.UNKNOWN--;
				}
			}
			line++;
		}
	}
	
	public static void Print(Sudoku [][]sudoku){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(sudoku[i][j].getData() + " ");
			}
			System.out.println();
		}
	}
}
