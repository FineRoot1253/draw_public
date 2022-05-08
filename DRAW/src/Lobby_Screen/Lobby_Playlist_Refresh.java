package Lobby_Screen;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;

public class Lobby_Playlist_Refresh extends Default_Button_Event{

	private Default_Frame DF;
	
	public Lobby_Playlist_Refresh(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,900, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
}
