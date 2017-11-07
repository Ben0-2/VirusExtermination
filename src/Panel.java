import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage virusImg;
	public static BufferedImage codeImg;
	public static BufferedImage antiVirusImg;	
	String  PLeft = Double.toString(100.0 * 675 / 675);
	boolean songPlayed = false;
boolean virusesDrawn = false;
	static int numViruses = 675;
	static int secondsLeft = 3;
	Timer timer;
	Timer gameTimer;
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
public static BufferedImage Bees;
	Panel() {
		try {
			virusImg = ImageIO.read(this.getClass().getResourceAsStream("Bees.jpg"));
			codeImg=ImageIO.read(this.getClass().getResourceAsStream("Code.jpg"));
	       antiVirusImg=ImageIO.read(this.getClass().getResourceAsStream("GalagaShip.jpg"));
			if(codeImg!=null) {
	        	System.out.println("Code Image loaded");
	        }else {
	        	System.out.println("Code Image not loaded");
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		timer = new Timer(1000 / 60, this);
		 gameTimer = new Timer(1000, new GameTimer());
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
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			manager.anti.x += 10;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			manager.anti.x -= 10;

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addCode(new Code(manager.anti.x + 25, manager.anti.y, 5, 5));
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
			 if(PLeft.equals("0.0")) {
				currentState = victoryState;
			}
			 
			 else if(secondsLeft == 0) {
				 currentState = deadState;
			 }
			 drawGameState(g);
		} 
		else if(currentState == victoryState) {
			drawVictoryState(g);
		}
		else if (currentState == deadState) {
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
g.setColor(Color.WHITE);
g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
g.setFont(font);
		g.drawString("Virus Extermination!", 565, 450);
	}

	void drawSelectModeState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("Choose a Mode!", 565, 250);
		g.setFont(font2);
		g.drawString("Press E for Easy Mode", 125, 450);
		g.drawString("Press R for Regular Mode", 725, 450);
		g.drawString("Press H for Hard Mode", 1325, 450);
        
	}

	void drawSelectAntiVirusState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("Choose an Anti-virus Software!", 300, 250);
		g.setFont(font2);

		g.drawString("Press R for Regular Software", 400, 450);
		g.drawString("Press S for Scatter Software", 1100, 450);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
		manager.draw(g);
		if (virusesDrawn == false) {
			manager.manageViruses();
			virusesDrawn = true;

		}
	int min= secondsLeft/60;
	int seconds = secondsLeft%60;
 PLeft = Double.toString(100.0 * numViruses / 675);
		String roundDown = PLeft.substring(0, 4);
		
		g.setFont(font2);
		g.drawString("Percent Left: " + roundDown + " %", 1300, 150);
        if(seconds == 0) {
        	g.drawString("Time Left: "+min+":" + seconds+ "0",600,160);
        }
		else{
			g.drawString("Time Left: "+min+":"+seconds, 600, 150);
		}
	}

	void drawDeadState(Graphics g) {
	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString("Game Over!", 565, 500);
	}

	void drawVictoryState(Graphics g) {
		if(songPlayed==false) {
			playMarioBrosTheme();
			songPlayed=true;
		}
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
		g.setFont(font);		
		g.drawString("You Won! Congratulations!", 450, 500);
	}

	public void startGame() {
		timer.start();
gameTimer.start();
	
	}
	public void playMarioBrosTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Wiin.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}