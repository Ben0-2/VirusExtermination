import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Manager {
	int numViruses = 0;
	ArrayList<SuperObject> objects;
	Rectangle collisionBox;
	private int score = 0;
	long virusTimer = 0;
	int virusSpawnTime = 1000;
Virus virus;
	public Manager() {
		objects = new ArrayList<SuperObject>();

	}

	void addObject(SuperObject o) {
		objects.add(o);
	}

	void checkCollision() {
		
		for (int i = 0; i < objects.size(); i++) {
		
			for (int j = 0; j < objects.size(); j++) {
				SuperObject o1 = objects.get(i);
				SuperObject o2 = objects.get(i);
				if (o1.collisionBox.intersects(o2.collisionBox)) {
					System.out.println("Two objects hit each other");
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

	void manageViruses() {
for(int a = 1; a<5; a++) {
		int m = 1;
		
	for (int i = 1; i < 16; i++) {
	for (int j = 0; j < 15; j++) {
		addObject(new Virus(10*j+a*500, i*10 + 200, 7, 7, m));
		numViruses+=1;
	}

}
	if(m<3) {
		m+=1;
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
