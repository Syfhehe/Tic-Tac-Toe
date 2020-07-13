package syf;

/**
 * @author: Yifan Shen
 * @className: Board
 * @description: Chess board class
 **/
public class Board {

	private int totalNumber;

	Player player = new Player();

	String[][] boardArray = new String[3][3];

	/**
	 * This method print the chess board in console.
	 */
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println("-------------");
			for (int j = 0; j < 3; j++) {
				if (boardArray[i][j] == null)
					System.out.printf("|   ");
				else
					System.out.printf("| %s ", boardArray[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("-------------");
	}

	/**
	 * This method put the piece on board. If the position of the pieces is legal,
	 * it will be stored in the array
	 * 
	 * @param chess: put the chess in board.
	 */
	public boolean putChess(String chessLocation) {
		player.choseLocationinBoard(chessLocation);
		if (judgement(player.row, player.column)) {
			boardArray[player.row][player.column] = player.chessPiece;
			return true;
		} else {
			System.out.println("This site has been taken up, please choose another!");
			return false;
		}
	}

	/**
	 * Determine if the location is legal
	 * 
	 * @param row: row number in the board.
	 * @param column: column number in the board.
	 */
	public boolean judgement(int row, int column) {
		if (boardArray[row][column] == null)
			return true;
		else if (row > 2 || row < 0 || column > 2 || column < 0)
			return false;
		else
			return false;
	}

	/**
	 * Determine if the anyone match the win condition
	 */
	public boolean winCondition() {
		int i, j;
		// Same row
		for (i = 0; i < 3; i++) {
			if (boardArray[i][0] == boardArray[i][1] && boardArray[i][1] == boardArray[i][2] && boardArray[i][0] != null) {
				System.out.printf("%s player won!\n", boardArray[i][0]);
				return true;
			}
		}
		// Same column
		for (j = 0; j < 3; j++) {
			if (boardArray[0][j] == boardArray[1][j] && boardArray[1][j] == boardArray[2][j] && boardArray[0][j] != null) {
				System.out.printf("%s player won!\n", boardArray[0][j]);
				return true;
			}
		}
		// diagonal
		if (boardArray[0][0] == boardArray[1][1] && boardArray[1][1] == boardArray[2][2] && boardArray[1][1] != null) {
			System.out.printf("%s player won!\n", boardArray[0][0]);
			return true;
		}
		// Anti-diagonal
		if (boardArray[0][2] == boardArray[1][1] && boardArray[1][1] == boardArray[2][0] && boardArray[1][1] != null) {
			System.out.printf("%s player won!\n", boardArray[0][2]);
			return true;
		}
		return false;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
}
