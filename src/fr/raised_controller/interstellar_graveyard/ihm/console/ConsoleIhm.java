package fr.raised_controller.interstellar_graveyard.ihm.console;

import java.util.HashMap;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.ihm.Ihm;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.Position;
import fr.raised_controller.interstellar_graveyard.util.texture.TextTextureMapper;
import fr.raised_controller.interstellar_graveyard.util.texture.TextureMapper;

public class ConsoleIhm extends Ihm{
	
	private Map<Position, String> displayParts;
	private Position topLeft;
	private Position bottomRight;
	private TextureMapper<String> mapper;
	
	private Thread displayThread = new Thread() {
		public void run()
		{
			while(isAlive())
			{
				ClearConsole();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					return;
				}
				displayAll();
			}
		}
	};

	public ConsoleIhm() {
		super();
		displayParts = new HashMap<>();
		topLeft = new Position();
		bottomRight = new Position();
	}

	private void setDisplayPart(Position pos, String texture) {
		displayParts.put(pos, texture);
		if(pos.getX() < topLeft.getX())
		{
			topLeft.translateX(pos.getX());
		}
		if(pos.getY() > topLeft.getY())
		{
			topLeft.translateY(pos.getY());
		}
		if(pos.getX() > bottomRight.getX())
		{
			bottomRight.translateX(pos.getX());
		}
		if(pos.getY() < bottomRight.getY())
		{
			bottomRight.translateY(pos.getY());
		}
	}
	
	public void displayAll()
	{
        System.out.println();
		for(int y = topLeft.getY(); y >= bottomRight.getY(); y--)
		{
			for(int x = topLeft.getX(); x <= bottomRight.getX(); x++)
			{
				String part = displayParts.get(new Position(x, y));
				if(part == null)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print(part);
				}
			}
			System.out.println();
		}
	}

	@Override
	protected void start() {
		this.mapper = TextTextureMapper.instance;
		mapper.init();
		displayThread.start();
	}

	@Override
	protected void close() {
		super.close();
		try {
			displayThread.join();
		} catch (InterruptedException e) {
		}
	}
	
	 private static void ClearConsole(){
	        try{
	            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
	              
	            if(operatingSystem.contains("Windows")){        
	                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
	                Process startProcess = pb.inheritIO().start();
	                startProcess.waitFor();
	            } else {
	                ProcessBuilder pb = new ProcessBuilder("clear");
	                Process startProcess = pb.inheritIO().start();

	                startProcess.waitFor();
	            } 
	        }catch(Exception e){
	            System.out.println(e);
	        }
	    }

	@Override
	public void displayPiece(Position pos, BoardPiece piece) {
		setDisplayPart(pos, this.mapper.getTexture(Registry.PIECE.getId(piece)));
	}
	
}
