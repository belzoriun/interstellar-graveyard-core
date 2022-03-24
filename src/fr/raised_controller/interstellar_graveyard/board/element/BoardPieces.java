package fr.raised_controller.interstellar_graveyard.board.element;

import fr.raised_controller.interstellar_graveyard.board.element.AsteroidPiece.AsteroidType;
import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class BoardPieces {
	public static final BoardPiece VOID_PIECE = register("void", new VoidPiece());
	public static final BoardPiece TINY_ASTEROID = register("tiny_asteroid", new AsteroidPiece(AsteroidType.TINY));
	public static final BoardPiece MEDIUM_ASTEROID = register("medium_asteroid", new AsteroidPiece(AsteroidType.MEDIUM));
	public static final BoardPiece LARGE_ASTEROID = register("large_asteroid", new AsteroidPiece(AsteroidType.LARGE));
	
	private static BoardPiece register(String id, BoardPiece piece)
	{
		return Registry.register(Registry.PIECE, id, piece);
	}
}
