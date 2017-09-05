import javax.swing.JFrame;

public class VirusExtermination {
JFrame frame;
Panel panel;
final int width = 2000;
final int height= 2000;
public VirusExtermination() {
	frame = new JFrame();
	panel = new Panel();
	setup();
}
public static void main(String[] args) {
	VirusExtermination virus = new VirusExtermination();
}
void setup() {
	frame.setSize(width, height);
	frame.addKeyListener(panel);
	frame.add(panel);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.startGame();
}
}
