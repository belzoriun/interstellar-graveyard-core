package fr.raised_controller.interstellar_graveyard.ihm;

import com.google.common.util.concurrent.AbstractScheduledService.Scheduler;

import fr.raised_controller.interstellar_graveyard.board.Board;
import fr.raised_controller.interstellar_graveyard.board.chunk.Chunk;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.ihm.schedulers.DisplayScheduler;
import fr.raised_controller.interstellar_graveyard.ihm.schedulers.PieceDisplayScheduler;
import fr.raised_controller.interstellar_graveyard.util.Position;
public abstract class Ihm {
	
	private DisplayScheduler<BoardPiece> pieceScheduler;
	
	protected Ihm()
	{
		pieceScheduler = PieceDisplayScheduler.create(this);		
	}
		
	protected abstract void start(); //called on ihm initialisation
	
	public abstract void displayPiece(Position pos, BoardPiece piece);
	
	public void displayChunk(Chunk c)
	{
		for(int x = 0; x < Chunk.CHUNK_SIZE; x++)
		{
			for(int y = 0; y < Chunk.CHUNK_SIZE; y++)
			{
				pieceScheduler.schedule(c.getAbsolutePosition(new Position(x, y)), c.getPiece(new Position(x, y)));
			}
		}
	}
	
	public void displayChunksAround(Board board, Position pos, int renderDistance)
	{
		Position chunkPos = Chunk.toChunkPosition(pos);
		for(int x = chunkPos.getX()-renderDistance; x <= chunkPos.getX()+renderDistance; x++)
		{
			for(int y = chunkPos.getY()-renderDistance; y <= chunkPos.getY()+renderDistance; y++)
			{
				displayChunk(board.getChunk(new Position(x, y)));
			}
		}
	}
	
	protected void close() {
		//called when quit
		pieceScheduler.stopScheduler();
	}
	
	public void init()
	{
		pieceScheduler.init();
		start();
	}
	
	public void schedulePieceDisplay(Position pos, BoardToken token)
	{
		pieceScheduler.schedule(pos, token.getPiece());
	}
}
