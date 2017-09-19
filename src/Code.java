import java.awt.Color;
import java.awt.Graphics;

public class Code extends SuperObject{
int speed = 10;
	public Code(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.BLACK);
	g.drawRect(70, 70, 25, 25);
	
}
void update() {
	super.update();
}
}
