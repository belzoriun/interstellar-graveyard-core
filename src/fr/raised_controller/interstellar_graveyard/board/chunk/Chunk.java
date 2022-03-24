package fr.raised_controller.interstellar_graveyard.board.chunk;

import java.util.HashMap;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.Board;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class Chunk {
	private Map<Position, BoardPiece> tokens;
	private Position pos;
	
	public static final int CHUNK_SIZE = 16;
	
	public Chunk(Position pos, ChunkBuilder builder)
	{
		this.pos=pos;
		tokens = new HashMap<>();
		for(int x =0; x < CHUNK_SIZE; x++)
		{
			for(int y = 0; y<CHUNK_SIZE; y++)
			{
				tokens.put(new Position(x, y), builder.create(new Position(x, y)));
			}
		}
	}
	
	public void AddToBoard(Board board)
	{
		board.addChunk(this.pos, this);
		for(int x =0; x < CHUNK_SIZE; x++)
		{
			for(int y = 0; y<CHUNK_SIZE; y++)
			{
				board.addElement(new Position(x, y).add(pos), this.tokens.get(new Position(x, y)));
			}
		}
	}
	
	public BoardPiece getPiece(Position pos)
	{
		return tokens.get(pos);
	}

	public static Chunk emptyChunk(Position pos) {
		return new Chunk(pos, new EmptyChunkBuilder());
	}
}
