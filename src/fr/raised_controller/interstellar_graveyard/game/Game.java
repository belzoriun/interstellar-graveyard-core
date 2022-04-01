package fr.raised_controller.interstellar_graveyard.game;

import java.util.Random;

import fr.raised_controller.interstellar_graveyard.board.Board;
import fr.raised_controller.interstellar_graveyard.board.chunk.ChunkBuilder;
import fr.raised_controller.interstellar_graveyard.board.chunk.OpenSimplexChunkBuilder;
import fr.raised_controller.interstellar_graveyard.ihm.console.ConsoleIhm;
import fr.raised_controller.interstellar_graveyard.util.Position;
import fr.raised_controller.interstellar_graveyard.util.option.Options;

public class Game {

	public static void main(String[] args) {
		BootStrap.init();
		long seed = new Random().nextLong();
		System.out.println("seed : "+seed);
		Board board = new Board();
		
		ChunkBuilder builder = new OpenSimplexChunkBuilder(seed);
		
		Position playerPosition = new Position();

		int renderDistance = Options.instance.RENDER_DISTANCE.get();
		board.generateInitial(builder, playerPosition, renderDistance);
		
		ConsoleIhm ihm = new ConsoleIhm();
		ihm.init();
		
		ihm.displayChunksAround(board, playerPosition, renderDistance);
		
	}

}
