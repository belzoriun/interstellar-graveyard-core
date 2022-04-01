package fr.raised_controller.interstellar_graveyard.ihm.graphical.javafx;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.ihm.Ihm;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class JavafxInterface extends Ihm{

	protected JavafxInterface() {
		super();
	}

	@Override
	protected void start() {
		//define all static layout things and start ui thread
	}

	@Override
	public void displayPiece(Position pos, BoardPiece piece) {
		//alter piece display
	}

}
