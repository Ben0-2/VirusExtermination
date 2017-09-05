import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener{
Timer timer;
Panel() {
	timer = new Timer(1000 / 60, this);
}
	  
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	  
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void startGame() {
		timer.start();
		
	}

}
