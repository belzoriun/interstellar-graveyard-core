package fr.raised_controller.interstellar_graveyard.event;

import fr.raised_controller.interstellar_graveyard.event.event.PlayCardEvent;
import fr.raised_controller.interstellar_graveyard.event.handler.PlayCardEventListener;

public abstract class Events {
	public static final Event<PlayCardEventListener> PLAY_CARD_EVENT = PlayCardEvent.registerEvent();
}
