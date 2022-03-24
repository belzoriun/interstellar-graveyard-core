package fr.raised_controller.interstellar_graveyard.game;

import java.util.Random;

import fr.raised_controller.interstellar_graveyard.board.Board;
import fr.raised_controller.interstellar_graveyard.board.chunk.Chunk;
import fr.raised_controller.interstellar_graveyard.board.chunk.ChunkBuilder;
import fr.raised_controller.interstellar_graveyard.board.chunk.OpenSimplexChunkBuilder;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class Game {

	public static void main(String[] args) {
		BootStrap.init();
		long seed = new Random().nextLong();
		Board board = new Board();
		
		ChunkBuilder builder = new OpenSimplexChunkBuilder(seed);
		Chunk chunk = new Chunk(new Position(0, 0), builder);
		chunk.AddToBoard(board);
		
		int rendreDistance = 1;
		
		
	}

}
