package model;

import interfaces.DicePair;
import interfaces.GameEngine;

public class DicePairImpl implements DicePair {

	private int numFaces = GameEngine.NUM_FACES;
	private int dice1;
	private int dice2;
	public static void main(String[] args) {
		
	}

	public DicePairImpl(int dice1, int dice2, int numFaces) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}

	@Override
	public int getDice1() {
		return dice1;
	}

	@Override
	public int getDice2() {
		return dice2;
	}

	@Override
	public int getNumFaces() {
		return numFaces;
	}
	
	// Return total value of dices
	public int getTotal() {
		return dice1+dice2;
	}

	@Override
	public String toString() {
		return " Dice 1: "+dice1+",  Dice 2: "+dice2+" .. Total: "+ getTotal();
	}
	
	

}
