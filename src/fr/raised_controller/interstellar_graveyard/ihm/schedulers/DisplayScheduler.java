package fr.raised_controller.interstellar_graveyard.ihm.schedulers;

import fr.raised_controller.interstellar_graveyard.util.Position;

public interface DisplayScheduler<T> {
	public void schedule(Position pos, T data);
	public void init();
	public void stopScheduler();
}
