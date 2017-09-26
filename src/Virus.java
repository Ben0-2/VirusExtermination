import java.awt.Color;
import java.awt.Graphics;

public class Virus extends SuperObject{
public Virus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	g.setColor(Color.GREEN);
	g.fillRect(x, y, width, height);
System.out.println("Draw Virus was called");
}
void update() {
	y+=2;
	if(y>800) {
		isAlive = false;
	}
}
}
