package fr.raised_controller.interstellar_graveyard.event.event;

import fr.raised_controller.interstellar_graveyard.event.ActionResult;
import fr.raised_controller.interstellar_graveyard.event.Event;
import fr.raised_controller.interstellar_graveyard.event.handler.PlayCardEventListener;

public class PlayCardEvent {
	public static Event<PlayCardEventListener> EVENT = new Event<PlayCardEventListener>(PlayCardEventListener.class, 
			(listeners)->()->{
				for(PlayCardEventListener listener : listeners)
				{
					if(listener.invoke() == ActionResult.ERROR)
					{
						return ActionResult.ERROR;
					}
				}
				
				return ActionResult.SUCCESS;
			});
	
	public static Event<PlayCardEventListener> registerEvent()
	{
		EVENT.Register(()->{
			return ActionResult.IGNORE;
		});
		return EVENT;
	}
}
