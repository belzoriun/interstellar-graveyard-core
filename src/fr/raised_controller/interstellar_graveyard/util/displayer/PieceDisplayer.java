package fr.raised_controller.interstellar_graveyard.util.displayer;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.util.texture.TextureMapper;

public abstract class PieceDisplayer<T> implements Displayer<BoardPiece>{

	protected TextureMapper<T> mapper;
	
	public PieceDisplayer(TextureMapper<T> mapper)
	{
		this.mapper = mapper;
		this.mapper.init();
	}

}
