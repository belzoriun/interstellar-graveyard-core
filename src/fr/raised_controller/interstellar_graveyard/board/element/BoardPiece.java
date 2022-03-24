package fr.raised_controller.interstellar_graveyard.board.element;

import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class BoardPiece {

	protected BoardToken defaultToken;
	
	protected BoardPiece(PieceSettings _settings)
	{
		BoardToken.Builder builder = new BoardToken.Builder(this);
		builder.useSettings(_settings);
		setProperties(builder);
		this.defaultToken = builder.build();
	}
	
	public void setProperties(BoardToken.Builder builder)
	{}

	public BoardToken getDefaultToken()
	{
		return this.defaultToken;
	}
	
	public String toString()
	{
		return Registry.PIECE.getId(this).toString();
	}
}
