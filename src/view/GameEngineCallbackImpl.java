package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.DicePair;
import interfaces.GameEngine;
import interfaces.GameEngineCallback;
import interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging
 * behaviour
 * 
 * @author Caspar Ryan
 * @see interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {

	private Logger logger = Logger.getLogger("assignment1");
	ConsoleHandler handler = new ConsoleHandler();

	public GameEngineCallbackImpl() {
		// FINE shows rolling output, INFO only shows result
		logger.setUseParentHandlers(false);
		logger.addHandler(handler);
		handler.setLevel(Level.ALL);
		logger.setLevel(Level.FINE);
	}
	
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, player.getPlayerName() + ": ROLLING" + dicePair.toString());
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, player.getPlayerName() + ": *RESULT*" + result.toString());
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, "House: ROLLING" + dicePair.toString());
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, "House: *RESULT*" + result.toString());
		// Loop through playersList and log out player info at Level.INFO
		for (Player player : gameEngine.getAllPlayers()) {
			logger.log(Level.INFO, player.toString());
		}
	}
}
