package fr.raised_controller.interstellar_graveyard.board.element;

public class AsteroidPiece extends BoardPiece{
	
	public static enum AsteroidType{
		TINY(3, 0.1),
		MEDIUM(5, 0.4)
		,LARGE(15, 0.6);
		
		private int life;
		private double hardness;
		
		private AsteroidType(int life, double hardness)
		{
			this.life = life;
			this.hardness = hardness;
		}
	}

	protected AsteroidPiece(AsteroidType type) {
		super(new PieceSettings().setHardness(type.hardness).setLifePoint(type.life));
		// TODO Auto-generated constructor stub
	}

}
