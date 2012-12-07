package shine.november22;
public class Validation {

	
	public void ColVali(Sudoku[][] sudoku, Sudoku s) {
		int col = s.getY();
		for(int i = 0; i < 9; i++){
			if(sudoku[i][col].isFlag()){
				int data = sudoku[i][col].getData();
				s.changeOption(data);
			}
		}
		s.changeFlag();
	}

	public void GridVali(Sudoku[][] sudoku, Sudoku s) {
		int x = s.getX()/3;
		int y = s.getY()/3;
		for(int i = 3 * x; i < 3; i++){
			for(int j = 3 * y; j < 3; j++){
				if(sudoku[i][j].isFlag()){
					int data = sudoku[i][j].getData();
					s.changeOption(data);
				}
			}
		}
		s.changeFlag();
	}

	public void RowVali(Sudoku[][] sudoku, Sudoku s) {
		int row = s.getX();
		for(int j = 0; j < 9; j++){
			if(sudoku[row][j].isFlag()){
				int data = sudoku[row][j].getData();
				s.changeOption(data);
			}
		}
		s.changeFlag();
	}

	
	
}
