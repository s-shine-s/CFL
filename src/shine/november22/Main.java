package shine.november22;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sudoku [][]sudoku = new Sudoku[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				sudoku[i][j] = new Sudoku();
				sudoku[i][j].setX(i);
				sudoku[i][j].setY(j);
			}
		}
		try {
			Assist.CreateSudoku(sudoku);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assist.Print(sudoku);
		System.out.println();
		Validation vali = new Validation();
		while(Sudoku.UNKNOWN > 0){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					if(!sudoku[i][j].isFlag()){
						vali.RowVali(sudoku, sudoku[i][j]);
						vali.ColVali(sudoku, sudoku[i][j]);
						vali.GridVali(sudoku, sudoku[i][j]);
					}			
				}
			}
		}
		Assist.Print(sudoku);
	}
}
