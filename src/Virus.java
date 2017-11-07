import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Virus extends SuperObject{
int gridNum;
	boolean isAlive = true;
public Virus(int x, int y, int width, int height, int gridNum) {
	super(x, y, width, height);
	this.gridNum = gridNum;

	}
void draw(Graphics g) {
	g.drawImage(Panel.virusImg, x, y, width, height, null);

}
void update() {
	/*if(gridNum ==1) {
		int random = new Random().nextInt(5);
	    x+=random;
	   
	}
	if(gridNum ==2) {
		int random = new Random().nextInt(5);
	    x+= random;
	}
	if(gridNum ==3) {
	int random = new Random().nextInt(5);
		x+= random;	
	}
	
	if(x>1900||x<0) {
		isAlive = false;
	}*/
super.update();
}
}
