import java.awt.Graphics;
import java.awt.Rectangle;

public class ScatterShot extends SuperObject{
int speed=1;

	public ScatterShot(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
	
		
		}
void draw(Graphics g) {
	g.drawImage(Panel.codeImg, x, y, 10, 10, null);
	
}
void update() {
	super.update();
y-=speed;
}
}
