package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		JMenu menu;
		JMenuItem addPlayer = new JMenuItem("Add Player");
		JMenuItem removePlayer = new JMenuItem("Remove Player");

		// TODO Auto-generated constructor stub
		menu = new JMenu("Menu");

		menu.add(addPlayer);
		menu.add(removePlayer);

		add(menu);
		
		addPlayer.addActionListener(null);
		removePlayer.addActionListener(null);
	}
}
