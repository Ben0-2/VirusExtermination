import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
	public static BufferedImage bossVirusImg;
	public static BufferedImage backgroundImg;
	String PLeft = Double.toString(100.0 * (numViruses / 675));
	boolean songPlayed = false;
	boolean songPlayed2 = false;
	boolean timeReset = false;
	boolean virusesDrawn = false;
	boolean bossVirusesDrawn = false;
	Random random0 = new Random();
	static int numViruses = 675;
<<<<<<< HEAD
	static int secondsLeft = 76;
	static int secondsLeft2 = 201;
=======
	static int secondsLeft = 160;
	static int secondsLeft2 = 111;
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
	Timer timer;
	Timer gameTimer;

	boolean songPlayed3 = false;
	boolean songPlayed4 = false;
	Manager manager;
	Font font;
	Font font2;
	Font font3;
	Font font4;
	Font font5;
	final int menuState = 0;
<<<<<<< HEAD
	final int instructionState = 1;
	final int selectAntiVirusState = 2;
	final int gameState = 3;
	final int deadState = 4;
	final int victoryState = 5;
	final int BossState = 6;
	final int BossVictoryState = 7;
	final int endState = 8;
=======

	final int selectAntiVirusState = 1;
	final int gameState = 2;
	final int deadState = 3;
	final int victoryState = 4;
	final int BossState = 5;
	final int BossVictoryState = 6;
	final int endState = 7;
	final int instructionState = 8;
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
	int currentState = menuState;
	int virusSpawnerTimer = 1;
	int virusSpawnerTimer2 = 1;
	int messageTimer = 0;
	int shotTimer = 0;
	
	Graphics g;
	public static BufferedImage Bees;

	Panel() {
		try {
			virusImg = ImageIO.read(this.getClass().getResourceAsStream("Bees.png"));
			codeImg = ImageIO.read(this.getClass().getResourceAsStream("Code.png"));
			antiVirusImg = ImageIO.read(this.getClass().getResourceAsStream("GalagaShip.png"));
			bossVirusImg = ImageIO.read(this.getClass().getResourceAsStream("BossBrain.png"));
			backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("BackgroundForGame.jpg"));
			if (codeImg != null) {
				System.out.println("Code Image loaded");
			} else {
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
		font3 = new Font("Bangla MN", Font.PLAIN, 16);
		font4 = new Font("Bangla MN", Font.PLAIN, 54);
		font5 = new Font("Bangla MN", Font.PLAIN, 24);
		manager = new Manager();

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == menuState) {
				currentState = instructionState;
<<<<<<< HEAD
			} else if (currentState == instructionState) {
=======
			} else if(currentState == instructionState) {
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
				currentState = selectAntiVirusState;
				}else if (currentState == deadState) {
			
				currentState = menuState;
			} else if (currentState == victoryState) {
				currentState = BossState;
				manager.removeViruses();
			} else if (currentState == BossVictoryState) {
				currentState = endState;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_R) {

			if (currentState == selectAntiVirusState) {
				currentState = gameState;
				manager.anti = manager.regular;
				manager.anti.scatter = false;

			}
		}

		else if (e.getKeyCode() == KeyEvent.VK_S) {
			if (currentState == menuState) {
				currentState = selectAntiVirusState;
			} else if (currentState == selectAntiVirusState) {
				currentState = gameState;
				manager.anti = manager.scatter;
				manager.scatter.scatter = true;

			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//MAKE SOMETHING INTERESTING HAPPEN AT HOME!
			manager.anti.x += 10;
<<<<<<< HEAD
			if (manager.anti.x >= 1300) {
				manager.anti.x = 650;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			manager.anti.x += 10;
			if (manager.anti.x >= 1300) {
				manager.anti.x = 650;
=======
			if(numViruses<550) {
				
			}
			if(manager.anti.x>=1900) {
				manager.anti.x=875;
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			manager.anti.x -= 10;
			if (manager.anti.x <= 0) {
				manager.anti.x = 650;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			manager.anti.x -= 10;
			if (manager.anti.x <= 0) {
				manager.anti.x = 650;
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (manager.anti == manager.regular) {

				manager.addCode(new Code(manager.regular.x + 25, manager.regular.y, 5, 5));

<<<<<<< HEAD
			} else if (manager.anti == manager.scatter) {
=======
			}
			else if(manager.anti == manager.scatter) {
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb

				manager.addScatterShot(new ScatterShot(manager.scatter.x + 25, manager.scatter.y, 5, 5));

			}
<<<<<<< HEAD
		}
	}
=======
			
		}}
	
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == gameState) {
			updateGameState();
<<<<<<< HEAD
=======
			
			shotTimer += 1;
			
			
			
		
		}
	
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb

			shotTimer += 1;

		}

		else if (currentState == BossState) {

			updateBossState();
			if (!manager.anti.isAlive) {
				currentState = deadState;
			}

			if (messageTimer > 1080) {
				if (virusSpawnerTimer == 60) {

					for (int i = 0; i < 52; i++) {
						int random = new Random().nextInt(25);
						manager.addVirus(new Virus(i * 25 + random, 0, 10, 10));
					}

					virusSpawnerTimer = 1;
				}
				virusSpawnerTimer += 1;
			}
			messageTimer += 1;
		}

		repaint();
	}

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
		}else if(currentState== instructionState) {
			drawInstructionState(g);
		}
		else if (currentState == selectAntiVirusState) {
			drawSelectAntiVirusState(g);
		} else if (currentState == instructionState) {
			drawInstructionState(g);
		} else if (currentState == gameState) {
			if (numViruses == 0) {
				currentState = victoryState;
			}

			else if (secondsLeft == 0) {
				currentState = deadState;
			}
			drawGameState(g);
		} else if (currentState == victoryState) {
			drawVictoryState(g);
		} else if (currentState == deadState) {
			drawDeadState(g);
		} else if (currentState == BossState) {
			drawBossState(g);
			if (manager.anti.isAlive == false) {
				currentState = deadState;
			} else if (secondsLeft2 == 0) {
				currentState = BossVictoryState;
			}
		} else if (currentState == BossVictoryState) {
			drawBossVictoryState(g);
		} else if (currentState == endState) {
			drawEndState(g);
		}
	}

	

	void updateGameState() {

		manager.update();

		manager.checkCollision();
	
	}

	void updateBossState() {
		manager.updateBoss();
		manager.checkCollision();
		int rand = new Random().nextInt(100);

	}

	void drawMenuState(Graphics g) {
		manager.reset();
		messageTimer = 0;
		virusSpawnerTimer = 0;
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font);
<<<<<<< HEAD
		g.drawString("Virus Extermination!", 300, 300);

		g.setFont(font5);
		g.drawString("Press ENTER to look at the instructions, or press S to skip them", 300, 500);
=======
		g.drawString("Virus Extermination!", 565, 450);
		g.drawString("Press Enter to go to the instructions!", 265, 700);
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
		if (songPlayed3 == false) {
			playStartUpTheme();
			songPlayed3 = true;
		}
	}
<<<<<<< HEAD

	void drawInstructionState(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font4);
		g.drawString("Press SPACE to destroy Viruses!", 200, 55);
		g.drawString("Press LEFT KEY or A to move left!", 200, 270);
		g.drawString("Press RIGHT KEY or D to move Right!", 200, 485);
		g.setFont(font2);
		g.drawString("Press ENTER to confront the first line of defense!", 200, 700);

	}

=======
	void drawInstructionState(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Press Space to destroy viruses!", 265, 200);
		g.drawString("Press A or Left Arrow to move AntiVirus left!", 65, 450);
		g.drawString("Press D or Right Arrow to move AntiVirus right!", 65, 700);
		g.drawString("Press Enter to select your AntiVirus!", 265, 950);
		
	}
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
	void drawSelectAntiVirusState(Graphics g) {
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Choose an Anti-virus Software!", 75, 250);
		g.setFont(font2);

		g.drawString("Press R for Regular Software", 100, 450);
		g.drawString("Press S for Scatter Software", 700, 450);
	}

	void drawGameState(Graphics g) {
<<<<<<< HEAD
		if (secondsLeft < 221 && secondsLeft > 210) {
			drawStringScroll(g, "We Are The First Line Of Defense.");
		} else if (secondsLeft < 210 && secondsLeft > 205) {
			drawStringScroll(g, "There Is No Way You Can Get Through Us!");
		} else if (secondsLeft < 205 && secondsLeft > 200) {
			drawStringScroll(g, "We Are The Strongest Defense in Virus History!");
		} else if (secondsLeft < 200 && secondsLeft > 195) {
			drawStringScroll(g, "If You Defeat Us, You Are Granted A Meeting With The Boss");
		} else if (secondsLeft < 195 && secondsLeft > 190) {
			drawStringScroll(g, "I Shouldn't Have Said That.");
		}
=======
g.setFont(font2);

>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
		if (manager.anti == manager.regular) {
			manager.regular.draw(g);
		} else if (manager.anti == manager.scatter) {
			manager.scatter.draw(g);
		}
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		manager.draw(g);
		if (!virusesDrawn) {
			manager.manageViruses();
			virusesDrawn = true;
		}
		if(numViruses<400);
		int min = secondsLeft / 60;
		int seconds = secondsLeft % 60;

		g.setFont(font2);

		if (seconds == 0) {
			g.drawString("Time Left: " + min + ":" + seconds + "0", 600, 150);
		} else if (seconds < 10) {
<<<<<<< HEAD
			g.drawString("Time Left: " + min + ":" + "0" + seconds, 600, 150);
=======
			g.drawString("Time Left: " + min + ":" + "0" + seconds, 600, 140);
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
		} else {
			g.drawString("Time Left: " + min + ":" + seconds, 600, 150);
		}

	}

	void drawDeadState(Graphics g) {

		if (songPlayed3 == false) {
			playDeathTheme();
			songPlayed3 = true;
		}
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Game Over!", 565, 500);
		manager.anti.isAlive = true;
		secondsLeft = 160;
		secondsLeft2 = 201;

	}

	void drawVictoryState(Graphics g) {
		if (songPlayed == false) {
			playMarioBrosTheme();
			songPlayed = true;
		}

		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font2);
<<<<<<< HEAD
		g.drawString("You Won! Congratulations! On To The Boss Fight!", 125, 325);
=======
		g.drawString("You Won! Congratulations! On To The Boss Fight!", 450, 500);
		g.drawString("Press Enter to Confront the Boss Brain!", 450, 750);
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
	}

	void drawBossState(Graphics g) {
		if (!timeReset) {
			secondsLeft2 = 111;
			timeReset = true;
		}
		manager.regular.draw(g);
		g.setFont(font2);

		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		manager.draw(g);
		if (!bossVirusesDrawn) {
			secondsLeft=201;
			manager.BossManageViruses();
			bossVirusesDrawn = true;

		}
		int min2 = secondsLeft2 / 60;
		int seconds2 = secondsLeft2 % 60;

		g.setFont(font2);

		if (seconds2 == 0) {
			g.drawString("Time Left: " + min2 + ":" + seconds2 + "0", 600, 150);
		} else if (seconds2 < 10 && seconds2 > 0) {
			g.drawString("Time Left:" + min2 + ":" + "0" + seconds2, 600, 150);
		} else {
			g.drawString("Time Left: " + min2 + ":" + seconds2, 600, 150);
		}
		if (messageTimer >= 180 && messageTimer < 360) {
			drawStringScroll(g, "I am the boss virus");
		} else if (messageTimer >= 360 && messageTimer < 540) {
			drawStringScroll(g, "I see you have made it past my first wave, impressive");
		} else if (messageTimer >= 540 && messageTimer < 720) {
			drawStringScroll(g, "But, you cannot defeat me!");
		} else if (messageTimer >= 720 && messageTimer < 900) {
			drawStringScroll(g, "If you can live through this death for 1.5 minutes, I will leave");
		} else if (messageTimer >= 900 && messageTimer < 1080) {
			drawStringScroll(g, "PREPARE TO DIE");
		}
	}

	void drawBossVictoryState(Graphics g) {
		
		if (songPlayed2 == false) {
			
			playMarioBrosTheme();
			songPlayed2 = true;
		}
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font2);
		g.drawString("You Won! Congratulations!",450, 500);
		g.drawString("Press Enter To Finish Your Game!", 450, 750);
	}

	void drawEndState(Graphics g) {
		if (songPlayed4 == false) {
			playCompleteFinishTheme();
			songPlayed4 = true;
		}
		g.drawImage(backgroundImg, 0, 0, 1900, 1000, null);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Thank You For Playing!", 450, 500);

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
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("Microsoft-Windows-XP-Startup-Sound.wav"));
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

	public void playCompleteFinishTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("GameComplete.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void drawStringScroll(Graphics g, String s) {
		g.drawString(s, 100, 250);
	}
}