import java.awt.Color;
import java.awt.Graphics;

public class Code extends SuperObject {
	int speed = 12;
	boolean isAlive = true;

	public Code(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void draw(Graphics g) {
		

<<<<<<< HEAD
		
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

=======
		g.drawImage(Panel.codeImg, x, y, 7, 7, null);
		
>>>>>>> 1478f74d51ceac8894a06bc2831c33382131a9bb
	}

	void update() {
		super.update();
		y -= speed;
		if(y<=0) {
			isAlive=false;
		}
		

	}
}
