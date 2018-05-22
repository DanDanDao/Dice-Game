package model;

import java.util.*;

import interfaces.GameEngine;
import interfaces.GameEngineCallback;
import interfaces.Player;

public class GameEngineImpl implements GameEngine {

	public GameEngineImpl() {
	}

	private Set<Player> players = new HashSet<Player>();

	private Set<GameEngineCallback> callbacks = new HashSet<GameEngineCallback>();

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}
	
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		for (int i = initialDelay; i <= finalDelay; i += delayIncrement) {
			DicePairImpl dicepair = rollDice();
			for (GameEngineCallback callback : callbacks) {
			callback.intermediateHouseResult(dicepair, this);
		}
			try {
				Thread.sleep(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		DicePairImpl playerResult = rollDice();
		player.setRollResult(playerResult);
		for (GameEngineCallback callback : callbacks) {
		callback.result(player, playerResult, this);
	}

	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		for (int i = initialDelay; i <= finalDelay; i += delayIncrement) {
			DicePairImpl dicepair = rollDice();
			for (GameEngineCallback callback : callbacks) {
				callback.intermediateHouseResult(dicepair, this);
			}
			try {
				Thread.sleep(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		DicePairImpl houseResult = rollDice();
		for (Player player : players) {
		hasWon(player, houseResult);
	}

		for (GameEngineCallback callback : callbacks) {
		callback.houseResult(houseResult, this);
	}

	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		Iterator<Player> iter = players.iterator();
		while (iter.hasNext()) {
			Player p = iter.next();
			if (p.getPlayerId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		callbacks.add(gameEngineCallback);

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return callbacks.remove(gameEngineCallback);
	}

	@Override
	public Set<Player> getAllPlayers() {
		return Collections.unmodifiableSet(players);
	}

	// rollDice generate a pair of random value dices and return a new DicePair
	public DicePairImpl rollDice() {
		int dice1 = 1 + (int) (Math.random() * NUM_FACES);
		int dice2 = 1 + (int) (Math.random() * NUM_FACES);
		return new DicePairImpl(dice1, dice2, NUM_FACES);
	}

	// This method checks if the player has won, lost, or draw.
	public boolean hasWon(Player player, DicePairImpl houseResult) {
		// Player win when their result is greater than house's
		if (player.getRollResult().getDice1() + player.getRollResult().getDice2() > houseResult.getTotal()) {
			player.setPoints(player.getPoints() + player.getBet());
			return true;
		// and lose when their result is smaller than house's
		} else if (player.getRollResult().getDice1() + player.getRollResult().getDice2() < houseResult.getTotal()) {
			player.setPoints(player.getPoints() - player.getBet());
			return false;
		// if there is a tie, the player's points remain the same.
		} else {
			return false;
		}
	}
}
