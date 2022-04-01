package fr.raised_controller.interstellar_graveyard.util;

import java.util.Objects;

public class Position {
	private int x;
	private int y;
	
	public Position()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void translateX(int value)
	{
		this.x = value;
	}
	
	public void translateY(int value)
	{
		this.y = value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
	
	public Position add(Position pos)
	{
		return new Position(x+pos.getX(), y+pos.getY());
	}
	
	public String toString()
	{
		return "("+x+";"+y+")";
	}
}
