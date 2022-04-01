package fr.raised_controller.interstellar_graveyard.ihm.schedulers;

import java.util.ArrayList;
import java.util.List;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.board.token.BoardToken;
import fr.raised_controller.interstellar_graveyard.ihm.Ihm;
import fr.raised_controller.interstellar_graveyard.util.Position;

public class PieceDisplayScheduler extends Thread implements DisplayScheduler<BoardPiece>{
	
	private static PieceDisplayScheduler instance = null;
	private Ihm displayer;
	
	private List<ScheduledDisplay<BoardPiece>> scheduled;
	
	private PieceDisplayScheduler(Ihm displayer)
	{
		this.displayer = displayer;
		this.scheduled = new ArrayList<>();
	}
	
	public void run()
	{
		super.run();
		while(isAlive())
		{
			if(!scheduled.isEmpty())
			{
				ScheduledDisplay<BoardPiece> toDisplay = scheduled.remove(0);
				if(toDisplay != null)
					displayer.displayPiece(toDisplay.getPos(), toDisplay.getData());
			}
		}
	}
	
	public static PieceDisplayScheduler create(Ihm display)
	{
		if(instance == null)
		{
			instance = new PieceDisplayScheduler(display);
		}
		return instance;
	}

	@Override
	public void schedule(Position pos, BoardPiece data) {
		this.scheduled.add(new ScheduledDisplay<BoardPiece>(pos, data));
	}

	@Override
	public void init() {
		this.start();
	}

	@Override
	public void stopScheduler() {
		try {
			this.join();
		} catch (InterruptedException e) {
		}
	}

}
