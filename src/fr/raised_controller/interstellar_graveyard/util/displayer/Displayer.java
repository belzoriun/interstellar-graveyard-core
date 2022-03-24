package fr.raised_controller.interstellar_graveyard.util.displayer;

import fr.raised_controller.interstellar_graveyard.util.Position;

public interface Displayer<T> {
	public void display(Position pos, T value);
}
