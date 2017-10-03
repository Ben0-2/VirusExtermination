import java.awt.Color;
import java.awt.Graphics;

public class Code extends SuperObject{
int speed = 10;
boolean isAlive = true;
	public Code(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(x, y, width, height);
	
}
void update() {
	super.update();
	y-=speed;
}
}
