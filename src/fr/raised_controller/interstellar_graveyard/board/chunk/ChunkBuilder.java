package fr.raised_controller.interstellar_graveyard.board.chunk;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.util.Position;

public interface ChunkBuilder {
	
	BoardPiece create(Position pos);
	
}
