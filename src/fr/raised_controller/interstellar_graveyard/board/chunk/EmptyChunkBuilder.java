package fr.raised_controller.interstellar_graveyard.board.chunk;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class EmptyChunkBuilder implements ChunkBuilder{

	@Override
	public BoardPiece create(Position pos) {
		return Registry.PIECE.getDefaultValue();
	}

}
