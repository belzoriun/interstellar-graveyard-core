package fr.raised_controller.interstellar_graveyard.board.element;

import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;

public abstract class BoardPiece {

	protected PieceSettings settings;
	protected BoardToken defaultToken;
	
	protected BoardPiece(PieceSettings _settings)
	{
		settings = _settings;
	}
	
	public void setProperties(BoardToken.Builder builder)
	{}
}
