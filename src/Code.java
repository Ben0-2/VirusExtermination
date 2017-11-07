import java.awt.Color;
import java.awt.Graphics;

public class Code extends SuperObject{
int speed = 10;
boolean isAlive = true;
	public Code(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	if(Panel.codeImg!=null) {
	g.drawImage(Panel.codeImg, x, y, 10, 10, null);
	}
	
//IDK LEL XD	
}
void update() {
	y-=speed;
	super.update();
	
}
}
