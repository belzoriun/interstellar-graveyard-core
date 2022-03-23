package fr.raised_controller.interstellar_graveyard.board.chunk;

import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class Chunk {
	public Map<Position, BoardToken> tokens;
	
	public static final int CHUNK_SIZE = 16;
	
	public Chunk(ChunkBuilder builder)
	{
		
	}
	
	public BoardToken getToken(Position pos)
	{
		return tokens.get(pos);
	}
}
