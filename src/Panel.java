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

public class Panel extends JPanel implements ActionListener, KeyListener {
	boolean virusesDrawn = false;
	Timer timer;
Manager manager;
	Font font;
	Font font2;
	final int menuState = 0;
	final int selectModeState = 1;
	final int selectAntiVirusState = 2;
	final int gameState = 3;
	final int deadState = 4;
	final int victoryState = 5;
	int currentState = menuState;

	Panel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Bangla MN", Font.PLAIN, 72);
		font2 = new Font("Bangla MN", Font.PLAIN, 36);
	manager = new Manager();
	
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == menuState) {
				currentState = selectModeState;
			} else if (currentState == deadState) {
				currentState = menuState;
			} else if (currentState == victoryState) {
				currentState = menuState;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			if (currentState == selectModeState) {
				currentState = selectAntiVirusState;
			} else if (currentState == selectAntiVirusState) {
				currentState = gameState;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_H) {
			if (currentState == selectModeState) {
				currentState = selectAntiVirusState;
			} else if (currentState == selectAntiVirusState) {
				currentState = gameState;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_E) {
			if (currentState == selectModeState) {
				currentState = selectAntiVirusState;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			if (currentState == selectAntiVirusState) {
				currentState = gameState;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			manager.anti.x +=10;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			manager.anti.x -=10;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addCode(new Code(manager.anti.x+25, manager.anti.y, 5, 5));
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == menuState) {
			updateMenuState();
		}
		if (currentState == selectModeState) {
			updateSelectModeState();
		}
		if (currentState == selectAntiVirusState) {
			updateSelectAntiVirusState();
		}
		if (currentState == gameState) {
			updateGameState();
		}
		if (currentState == deadState) {
			updateDeadState();
		}
		if (currentState == victoryState) {
			updateVictoryState();
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
		} else if (currentState == selectModeState) {
			drawSelectModeState(g);
		} else if (currentState == selectAntiVirusState) {
			drawSelectAntiVirusState(g);
		} else if (currentState == gameState) {
			drawGameState(g);
		} else if (currentState == deadState) {
			drawDeadState(g);
		}
	}

	void updateMenuState() {

	}

	void updateSelectModeState() {

	}

	void updateSelectAntiVirusState() {

	}

	void updateGameState() {

	manager.update();
	manager.checkCollision();
	}

	void updateDeadState() {

	}

	void updateVictoryState() {

	}

	void drawMenuState(Graphics g) {

		g.setFont(font);
		g.drawString("Virus Extermination!", 565, 450);
	}

	void drawSelectModeState(Graphics g) {
		g.setFont(font);
		g.drawString("Choose a Mode!", 565, 250);
		g.setFont(font2);
		g.drawString("Press E for Easy Mode", 125, 450);
		g.drawString("Press R for Regular Mode", 725, 450);
		g.drawString("Press H for Hard Mode", 1325, 450);
	}

	void drawSelectAntiVirusState(Graphics g) {
		g.setFont(font);
		g.drawString("Choose an Anti-virus Software!", 300, 250);
		g.setFont(font2);
		
		g.drawString("Press R for Regular Software", 400, 450);
		g.drawString("Press S for Scatter Software", 1100, 450);
	}

	void drawGameState(Graphics g) {
manager.draw(g);
if(virusesDrawn == false) {
	manager.manageViruses();
	virusesDrawn = true;
}
}

	void drawDeadState(Graphics g) {
		g.setFont(font);
		g.drawString("Game Over!", 565, 500);
	}

	void drawVictoryState(Graphics g) {

	}

	public void startGame() {
		timer.start();

	}

}