import java.awt.Color;
import java.awt.Graphics;

public class AntiVirus extends SuperObject{
int speed = 18;
boolean scatter=false;
boolean isAlive = true;
public AntiVirus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	update();
	if(!scatter) {
	g.setColor(Color.RED);
	}
	else {
		g.setColor(Color.CYAN);
	}
	
	
	g.drawImage(Panel.antiVirusImg, x, y, width, height, null);

}
void update() {
	collisionBox.setBounds(x,y,50,50);

}
}
