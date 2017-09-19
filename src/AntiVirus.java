import java.awt.Color;
import java.awt.Graphics;

public class AntiVirus extends SuperObject{
int speed = 15;
public AntiVirus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.WHITE);
	g.drawRect(700, 700, 50, 50);
}
void update() {
	super.update();
}
}
