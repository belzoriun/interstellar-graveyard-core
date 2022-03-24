package fr.raised_controller.interstellar_graveyard.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	public List<Chunk> getChunksInBounds(Position topLeft, Position bottomRight)
	{
		List<Chunk> result = new ArrayList<>();
		for(int x = topLeft.getX(); x <= bottomRight.getX(); x++)
		{
			for(int y = topLeft.getY(); y <= bottomRight.getY(); y++)
			{
				Position pos = new Position(x, y);
				if(chunks.containsKey(pos))
				{
					result.add(chunks.get(pos));
				}
				else
				{
					result.add(Chunk.emptyChunk(pos));
				}
			}
		}
		return result;
	}
	
	public void addChunk(Position pos, Chunk chunk)
	{
		chunks.put(pos, chunk);
	}

	public void addElement(Position add, BoardPiece piece) {
		elements.put(add, piece.getDefaultToken());
	}
}
