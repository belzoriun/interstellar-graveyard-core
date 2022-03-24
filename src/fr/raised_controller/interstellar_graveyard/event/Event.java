package fr.raised_controller.interstellar_graveyard.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Event<T> {
	private Function<List<T>, T> invokerFactory;
	private T invoker;
	private List<T> handlers;
	private Object lock = new Object();
	
	public Event(Class<T> type, Function<List<T>, T> invokerFactory)
	{
		this.invokerFactory = invokerFactory;
		this.handlers = new ArrayList<T>();
		update();
	}
	
	private void update()
	{
		this.invoker = this.invokerFactory.apply(handlers);
	}
	
	public void Register(T handler)
	{
		synchronized (lock) {
			 this.handlers.add(handler);
		}
		update();
	}
	
	public T invoker()
	{
		return invoker;
	}
}
