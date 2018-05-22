package model;

import interfaces.DicePair;
import interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int currentPoints;
	private int currentBet;
	private DicePair rollResult;

	public SimplePlayer(String playerId, String playerName, int currentPoints) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.currentPoints = currentPoints;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return currentPoints;
	}

	@Override
	public void setPoints(int points) {
		this.currentPoints = points;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		final boolean betPlaced;
		if (this.currentPoints >= bet && bet > 0) {
			this.currentBet = bet;
			betPlaced = true;
		} else {
			betPlaced = false;
		}
		return betPlaced;
	}

	@Override
	public int getBet() {
		return currentBet;
	}

	@Override
	public DicePair getRollResult() {
		return rollResult;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		this.rollResult = rollResult;
	}

	@Override
	public String toString() {
		return "Player: id=" + this.playerId + ", name=" + this.playerName + ", points=" + this.currentPoints;
	}
}
