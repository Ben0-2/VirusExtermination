import java.awt.Color;
import java.awt.Graphics;

public class Code extends SuperObject {
	int speed = 12;
	boolean isAlive = true;

	public Code(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void draw(Graphics g) {
		super.draw(g);

		g.drawImage(Panel.codeImg, x, y, 10, 10, null);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

	}

	void update() {

		y -= speed;
		super.update();

	}
}
