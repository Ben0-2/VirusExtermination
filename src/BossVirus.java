import java.awt.Graphics;

public class BossVirus extends SuperObject{

	public BossVirus(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	
}
void draw(Graphics g) {
	g.drawImage(Panel.bossVirusImg, x, y, width, height, null);
}
}
