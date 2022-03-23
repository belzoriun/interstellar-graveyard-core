package fr.raised_controller.interstellar_graveyard.board.element;

import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;

public abstract class BoardPiece {

	protected PieceSettings settings;
	protected BoardToken defaultToken;
	
	protected BoardPiece(PieceSettings _settings)
	{
		settings = _settings;
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
}
