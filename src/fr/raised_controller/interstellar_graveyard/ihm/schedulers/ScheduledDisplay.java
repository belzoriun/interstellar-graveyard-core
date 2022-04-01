package fr.raised_controller.interstellar_graveyard.ihm.schedulers;

import fr.raised_controller.interstellar_graveyard.util.Position;

public class ScheduledDisplay<T> {
	private Position pos;
	private T data;
	
	public ScheduledDisplay(Position pos, T data) {
		this.pos = pos;
		this.data = data;
	}
	
	public Position getPos() {
		return pos;
	}
	public T getData() {
		return data;
	}
	
	
}
