package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import interfaces.DicePair;
import interfaces.GameEngine;
import interfaces.GameEngineCallback;
import interfaces.Player;

public class GameEngineCallbackGUI extends JFrame implements GameEngineCallback {

	public GameEngineCallbackGUI() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setBounds(100,60,600,600);
		setVisible(true);
		
		add(new RollingDicePanel(), BorderLayout.CENTER);
		add(new ToolBar(), BorderLayout.NORTH);
		add(new StatusBar(), BorderLayout.PAGE_END);

	    setJMenuBar(new MenuBar());
	    revalidate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameEngineCallbackGUI frame = new GameEngineCallbackGUI();

	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		
	}

}
