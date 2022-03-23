package fr.raised_controller.interstellar_graveyard.board.chunk;

import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.util.Position;

public interface ChunkBuilder {
	
	BoardToken create(Position pos);
	
}
