import java.awt.Graphics;
import java.awt.Rectangle;

public class ScatterShot extends SuperObject{
int speed=2;
Rectangle collisionBox2;
Rectangle collisionBox3;
	public ScatterShot(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.collisionBox2 = new Rectangle(x, y, width, height);
		this.collisionBox3 = new Rectangle(x, y, width, height);
		}
void draw(Graphics g) {
	g.drawImage(Panel.codeImg, 30, 30, null);
}
void update() {
	super.update();
	collisionBox2.setBounds(x, y+7, width, height);
	collisionBox3.setBounds(x, y+14, width, height);
	y-=speed;
}
}
