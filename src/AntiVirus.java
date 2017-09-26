import java.awt.Color;
import java.awt.Graphics;

public class AntiVirus extends SuperObject{
int speed = 15;
public AntiVirus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);
System.out.println("Draw AntiVirus was called");
}
void update() {
	super.update();
}
}
