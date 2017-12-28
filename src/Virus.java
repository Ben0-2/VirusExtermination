import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Virus extends SuperObject{
static int speed = 8;
	int gridNum;
	boolean isAlive = true;
public Virus(int x, int y, int width, int height) {
	super(x, y, width, height);
	this.gridNum = gridNum;

	}

void draw(Graphics g) {
super.draw(g);
	g.drawImage(Panel.virusImg, x, y, width, height, null);

}
void update() {
	super.update();

}
void bossStateUpdate() {
	update();
	y+=speed;
}
}
