import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Manager {
	ArrayList<SuperObject> objects;
	Rectangle collisionBox;
	private int score = 0;
	long virusTimer = 0;
	int virusSpawnTime = 1000;

	public Manager() {
		objects = new ArrayList<SuperObject>();
	}

	void addObject(SuperObject o) {
		objects.add(o);
	}
//GET RID OF INSTANCEOF IN IF STATEMENT
	void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = 0; j < objects.size(); j++) {
				SuperObject o1 = objects.get(i);
				SuperObject o2 = objects.get(i);
				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof Virus && o2 instanceof Code) || (o2 instanceof Virus && o1 instanceof Code)) {
	               o1.isAlive = false;
	               o2.isAlive = false;
					}
					else if(o1.collisionBox.intersects(o2.collisionBox)) {
					if((o1 instanceof AntiVirus && o2 instanceof Virus)||(o1 instanceof Virus && o2 instanceof AntiVirus)) {
						o1.isAlive = false;
						o2.isAlive = false;
					}
				}
				}
			}
			
		}
	}
//THIS IS JUST SO I CAN SEE THAT DRAW GAME STATE WORKS, WILL CHANGE WHEN I SEE THAT DRAW GAME STATE WORKS
	void manageViruses() {
for (int i = 1; i < 16; i++) {
	for (int j = 0; j < 15; j++) {
		addObject(new Virus(5*j+500, i*5 + 200, 5, 5));
	}

    
}
	}

	void reset() {
		objects.clear();
	}

	void draw(Graphics g) {
		//OBJECTS SIZE SHOULD BE 4, NOT 1
		for (int i = 0; i < objects.size(); i++) {
			SuperObject o = objects.get(i);
			o.draw(g);
		}
	
	}

	void update() {
		for (int i = 0; i < objects.size(); i++) {
			SuperObject o = objects.get(i);
			o.update();
		}
		destroyObjects();
	}

	void destroyObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	int getScore() {
		return score;
	}

	void setScore(int s) {
		score = s;
	}

}
