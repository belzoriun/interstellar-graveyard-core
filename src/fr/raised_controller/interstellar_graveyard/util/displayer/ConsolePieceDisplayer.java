package fr.raised_controller.interstellar_graveyard.util.displayer;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.Position;
import fr.raised_controller.interstellar_graveyard.util.texture.TextTextureMapper;

public class ConsolePieceDisplayer extends PieceDisplayer<String>{

	public ConsolePieceDisplayer() {
		super(TextTextureMapper.instance);
	}

	@Override
	public void display(Position pos, BoardPiece value) {
		System.out.print(mapper.getTexture(Registry.PIECE.getId(value)));
	}
	
}
