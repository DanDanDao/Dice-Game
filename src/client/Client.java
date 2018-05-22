package client;

import interfaces.GameEngine;
import interfaces.Player;
import model.GameEngineImpl;
import model.SimplePlayer;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]) {
		
		final GameEngine gameEngine = new GameEngineImpl();
		
		Player[] players = new Player[]
		{ new SimplePlayer("1", "The Roller", 1000), new SimplePlayer("2", "The Loser", 500) };

		// register the callback for notifications (all logging output is done by GameEngineCallbackImpl)
		// see provided skeleton class GameEngineCallbackImpl.java
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());

		// main loop to add players place a bet and roll
		for (Player player : players)
		{
			gameEngine.placeBet(player, 100);
			gameEngine.addPlayer(player);
			gameEngine.rollPlayer(player, 1, 100, 20);
		}
		

		// all players have rolled so now house rolls (GameEngineCallBack is
		// called) and results are calculated
		gameEngine.rollHouse(1, 100, 20);
	}


}
