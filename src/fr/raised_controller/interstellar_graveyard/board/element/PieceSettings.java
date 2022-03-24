package fr.raised_controller.interstellar_graveyard.board.element;

public class PieceSettings {
	private PieceSetting<Boolean> isInvincible;
	private PieceSetting<Boolean> isMovable;
	private PieceSetting<Boolean> isTraversable;
	private PieceSetting<Integer> lifePoints;
	private PieceSetting<Double> hardness;
	
	public PieceSettings()
	{
		isInvincible = new PieceSetting<Boolean>(false);
		isMovable = new PieceSetting<Boolean>(false);
		isTraversable = new PieceSetting<Boolean>(false);	
		lifePoints = new PieceSetting<Integer>(20);
		hardness = new PieceSetting<Double>(0.1);
	}
	
	public PieceSettings setInvincible()
	{
		this.isInvincible.setValue(true);
		return this;
	}
	
	public PieceSettings setMovable()
	{
		this.isMovable.setValue(true);
		return this;
	}
	
	public PieceSettings setTraversable()
	{
		this.isTraversable.setValue(true);
		return this;
	}
	
	public PieceSettings setLifePoint(int lifepoints)
	{
		this.lifePoints.setValue(lifepoints);
		this.lifePoints.makeImutable();
		return this;
	}
	
	public PieceSettings setHardness(double hardness)
	{
		if(hardness > 1) hardness = 1;
		if(hardness < 0) hardness = 0;
		this.hardness.setValue(hardness);
		return this;
	}
}
