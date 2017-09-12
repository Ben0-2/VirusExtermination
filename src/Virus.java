import java.awt.Graphics;

public class Virus extends SuperObject{
public Virus(int x, int y, int width, int height) {
	super(x, y, width, height);
}
void draw(Graphics g) {
	
}
void update() {
	y+=2;
	if(y>800) {
		isAlive = false;
	}
}
}
