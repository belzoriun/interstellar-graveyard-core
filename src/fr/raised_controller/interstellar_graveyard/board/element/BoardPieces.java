package fr.raised_controller.interstellar_graveyard.board.element;

import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class BoardPieces {
	public static final BoardPiece VoidPiece = Registry.register(Registry.PIECE, "void", new VoidPiece());
}
