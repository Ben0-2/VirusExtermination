import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Panel.secondsLeft -=1;
	}

}
