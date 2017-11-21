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
	int x;
	int y;
	int width;
	int height;
	public static BufferedImage virusImg;
	public static BufferedImage codeImg;
	public static BufferedImage antiVirusImg;	
	String  PLeft = Double.toString(100.0 * 675 / 675);
	boolean songPlayed = false;
    boolean songPlayed2 = false;
	boolean virusesDrawn = false;
	
	static int numViruses = 675;
	static int numViruses2 = 180;
	static int secondsLeft = 225;
	static int secondsLeft2 = 400 ;
	Timer timer;
	Timer gameTimer;
	boolean songPlayed3 = false;
	Manager manager;
	Font font;
	Font font2;
	final int menuState = 0;

	final int selectAntiVirusState = 1;
	final int gameState = 2;
	final int deadState = 3;
	final int victoryState = 4;
	final int stage2State = 5;
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
				currentState = selectAntiVirusState;
			} else if (currentState == deadState) {
				currentState = menuState;
			} else if (currentState == victoryState) {
				currentState = stage2State;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_R) {
			
			if (currentState == selectAntiVirusState) {
				currentState = gameState;
				manager.anti=manager.regular;
			
		} }

		 else if (e.getKeyCode() == KeyEvent.VK_S) {

			if (currentState == selectAntiVirusState) {
				currentState = gameState;
				manager.anti = manager.scatter;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			manager.anti.x += 10;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			manager.anti.x -= 10;

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(manager.anti ==manager.regular) {
				manager.addCode(new Code(manager.anti.x + 25, manager.anti.y, 5, 5));
			}
			if(manager.anti == manager.scatter) {
				manager.addScatterShot(new ScatterShot(manager.anti.x+25, manager.anti.y,5,5));
			}
		}
		}
	

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (currentState == gameState) {
			updateGameState();
		}
	
		else if(currentState == stage2State) {
			updateStage2State();
		}
		
		repaint();
	}

	
	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
		}  else if (currentState == selectAntiVirusState) {
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
		else if(currentState == stage2State) {
			drawStage2State(g);
		}
	}

	

	void updateGameState() {

		manager.update();
		manager.checkCollision();
	}

	
    void updateStage2State() {
    	manager.update();
    	manager.checkCollision();
    }
	void drawMenuState(Graphics g) {
g.setColor(Color.WHITE);
g.fillRect(0, 0, 1900, 1000);
		g.setColor(Color.black);
g.setFont(font);
		g.drawString("Virus Extermination!", 565, 450);
	if(songPlayed3==false) {
		playStartUpTheme();
		songPlayed3=true;
	}
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
	    if(songPlayed == false) {
	    	playDeathTheme();
	    	songPlayed = true;
	    }
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
void drawStage2State(Graphics g) {
	System.out.println("Draw Stage Two Called");
	g.setColor(Color.WHITE);
	g.fillRect(0, 0, 1900, 1000);
	g.setColor(Color.black);
	manager.draw(g);
	if (virusesDrawn == false) {
		manager.stage2ManageViruses();
		virusesDrawn = true;

	}
int min2= secondsLeft2/60;
int seconds2 = secondsLeft2%60;
String PLeft2 = Double.toString(100.0 * numViruses2 / 1200);
	String roundDown2 = PLeft2.substring(0, 4);
	
	g.setFont(font2);
	g.drawString("Percent Left: " + roundDown2 + " %", 1300, 150);
    if(seconds2 == 0) {
    	g.drawString("Time Left: "+min2+":" + seconds2+ "0",600,150);
    }
	else{
		g.drawString("Time Left: "+min2+":"+seconds2, 600, 150);
	}
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
	public void playStartUpTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Microsoft-Windows-XP-Startup-Sound.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void playDeathTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Death.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}