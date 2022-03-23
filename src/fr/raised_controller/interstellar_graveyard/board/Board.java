package fr.raised_controller.interstellar_graveyard.board;

import java.util.HashMap;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.chunk.Chunk;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class Board {
	private Map<Position, Chunk> chunks;
	private Map<Position, BoardToken> elements;
	
	public Board()
	{
		chunks = new HashMap<>();
		elements = new HashMap<>();
	}
	
	public void addChunk(Position pos, Chunk chunk)
	{
		chunks.put(pos, chunk);
	}

	public void addElement(Position add, BoardPiece piece) {
		elements.put(add, piece.getDefaultToken());
	}
}
