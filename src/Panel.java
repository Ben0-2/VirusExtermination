import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener{
Timer timer;
/*JButton hardMode;
JButton easyMode;*/
JButton regularMode;
/*JButton healthShip;
JButton powerShip;*/
JButton regularShip;
Font font;
Font font2;
final int menuState = 0;
final int selectModeState = 1;
final int selectShipState = 2;
final int gameState = 3;
final int deadState = 4;
int currentState = selectModeState;
Panel() {
	timer = new Timer(1000 / 60, this);
    font = new Font("Bangla MN", Font.PLAIN,72);
    font2 = new Font("Bangla MN",Font.PLAIN,36);
}
	  
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == menuState) {
				currentState = selectModeState;
			}
		}
	}

	  
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public void paintComponent(Graphics g) {
    	if(currentState==menuState) {
    		drawMenuState(g);
    	}
    	else if(currentState==selectModeState) {
    		drawSelectModeState(g);
    	}
    }
	void drawMenuState(Graphics g) {

		g.setFont(font);
    	g.drawString("Virus Extermination!",565, 450);
    }
	void drawSelectModeState(Graphics g) {
		g.setFont(font);
		g.drawString("Choose a Mode!", 565, 250);
		g.setFont(font2);
		g.drawString("Press E for Easy Mode", 125, 450);
		g.drawString("Press R for Regular Mode", 725, 450);
		g.drawString("Press H for Hard Mode",1325, 450);
	}
    void drawSelectShipState(Graphics g) {
    	
    }
	void drawGameState(Graphics g) {
    	
    }
	void drawDeadState(Graphics g) {
		
	}
	public void startGame() {
		timer.start();
		
	}

}
