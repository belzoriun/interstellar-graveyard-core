package fr.raised_controller.interstellar_graveyard.board.biome;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;

public class BiomeSetting {
	private BoardPiece element;
	private int priority;
	private double elevationMin;
	private double elevationMax;
	
	public BiomeSetting(BoardPiece piece, int priority, double elevationMin, double elevationMax)
	{
		this.element =piece;
		this.priority = priority;
		this.elevationMin = ensureBetween(elevationMin, 0, 1);
		this.elevationMax = ensureBetween(elevationMax, 0, 1);
	}
	
	private double ensureBetween(double value, double min, double max)
	{
		if(value < 0) return 0;
		if(value > 1) return 1;
		return value;
	}

	public BoardPiece getElement() {
		return element;
	}

	public int getPriority() {
		return priority;
	}

	public double getElevationMin() {
		return elevationMin;
	}

	public double getElevationMax() {
		return elevationMax;
	}
}
