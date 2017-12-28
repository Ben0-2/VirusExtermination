import java.awt.Color;
import java.awt.Graphics;

public class AntiVirus extends SuperObject{
int speed = 18;
boolean isAlive = true;
public AntiVirus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	super.draw(g);
	g.drawImage(Panel.antiVirusImg, x, y, width, height, null);

}
void update() {
	super.update();

}
}
