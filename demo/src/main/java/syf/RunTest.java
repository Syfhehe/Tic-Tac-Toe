package syf;

public class RunTest {

	public static void main(String[] args) {
		while (true) {
			int i = 0;
			Board board = new Board();
			board.printBoard();
			while (!board.winCondition()) {
				if (board.getTotalNumber() % 2 == 0) {
					boolean judge = board.putChess("X");
					if (!judge)
						continue;
				} else {
					boolean judge = board.putChess("O");
					if (!judge)
						continue;
				}
				i++;
				board.setTotalNumber(i);
				board.printBoard();
				if (board.getTotalNumber() == 9) {
					System.out.println("This is a draw!");
					break;
				}
			}
			break;
		}
	}

}
