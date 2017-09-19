import java.awt.Color;
import java.awt.Graphics;

public class Virus extends SuperObject{
public Virus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.GREEN);
	g.drawRect(250, 250, 50, 50);
}
void update() {
	y+=2;
	if(y>800) {
		isAlive = false;
	}
}
}
