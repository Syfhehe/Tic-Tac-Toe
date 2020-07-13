package syf;

import java.util.Scanner;

/**
 * @author: Yifan Shen
 * @className: Player
 * @description: Player class
 **/
public class Player {

	Scanner s = new Scanner(System.in);

	int row, column;

	String chessPiece;

	/**
	 * This method choose the position of the pieces.
	 * 
	 * @param chessLocation:  piece location in the board.
	 */
	public void choseLocationinBoard(String chessLocation) {
		do {
			System.out.printf("Enter a row in (1, 2 or 3) for player %s:", chessLocation);
			row = s.nextInt() - 1;
			s.nextLine();
		} while (row < 0 || row > 2);
		do {
			System.out.printf("Enter a column in (1, 2 or 3) for player %s:", chessLocation);
			column = s.nextInt() - 1;
			s.nextLine();
		} while (column < 0 || column > 2);
		this.chessPiece = chessLocation;
	}

}
