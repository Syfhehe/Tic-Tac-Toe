package syf;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import syf.model.Step;

public class BoardTest {
	
	@Test
	public void winConditionNoWinner() {
		Board board = new Board();
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step(0, 0));
		steps.add(new Step(2, 0));

		RunGemeTest(board, steps);
		
		assertFalse(board.winCondition());
	}

	@Test
	public void winConditionXplayerWin() {
		Board board = new Board();
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step(0, 0));
		steps.add(new Step(2, 0));
		steps.add(new Step(1, 1));
		steps.add(new Step(2, 1));
		steps.add(new Step(2, 2));

		RunGemeTest(board, steps);
		
		assertTrue(board.winCondition());
	}
	
	@Test
	public void winConditionOplayerWin() {
		Board board = new Board();
		
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step(0, 0));
		steps.add(new Step(1, 1));
		steps.add(new Step(0, 1));
		steps.add(new Step(0, 2));
		steps.add(new Step(1, 0));
		steps.add(new Step(2, 0));

		RunGemeTest(board, steps);
		
		assertTrue(board.winCondition());
	}

	private void RunGemeTest(Board board, List<Step> steps) {
		for (int i = 0; i < steps.size(); i++) {
			Step s = steps.get(i);
			if (i % 2 == 0)
				board.boardArray[s.getRow()][s.getColumn()] = "X";
			else
				board.boardArray[s.getRow()][s.getColumn()] = "O";
		}
	}

}
