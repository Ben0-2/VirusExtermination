import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Manager {
AntiVirus anti;
	int numViruses = 0;
	ArrayList<Code> codes;
	ArrayList<Virus> viruses;
	Rectangle collisionBox;
	private int score = 0;
	long virusTimer = 0;
	int virusSpawnTime = 1000;
	Virus virus;

	public Manager() {
		viruses = new ArrayList<Virus>();
        codes = new ArrayList<Code>();
	    anti = new AntiVirus(875,850,50,50);
	}

	void addVirus(Virus o) {
		viruses.add(o);
	}
    void addCode(Code c) {
    	codes.add(c);
    }
    void addAntiVirus(AntiVirus a) {
    	anti = a;
    	
    }
    void checkCollision() {
    	for(Code c: codes ) {
    		checkCollision(c);
    	}
    }
	void checkCollision(Code c) {

		for (int i = 0; i < viruses.size(); i++) {

			Virus v = viruses.get(i);

			if (v.collisionBox.intersects(c.collisionBox)) {

				v.isAlive = false;
				c.isAlive = false;
			}

		}
	}

	void manageViruses() {
		for (int a = 1; a < 4; a++) {
			int m = 1;

			for (int i = 1; i < 16; i++) {
				for (int j = 0; j < 15; j++) {
					addVirus(new Virus(10 * j + a * 500 - 200, i * 10 + 200, 7, 7, m));
					numViruses += 1;
				}

			}
			if (m < 3) {
				m += 1;
			}
		
		}
	}

	void reset() {
		viruses.clear();
	}

	void draw(Graphics g) {
		// OBJECTS SIZE SHOULD BE 4, NOT 1
		for (Virus v: viruses) {
		
			v.draw(g);
		}
		for(Code c: codes) {
		 c.draw(g);
		}
		anti.draw(g);
	}

	void update() {
		for (Virus v: viruses) {
			
			v.update();

		}
	for(Code c: codes) {
		c.update();
	}
		destroyObjects();
	}

	void destroyObjects() {
		for (int i = 0; i<viruses.size(); i++) {
		Virus v = viruses.get(i);
			if (!v.isAlive) {
				viruses.remove(v);
			}
		}
	for(int i = 0; i<codes.size(); i++) {
		Code c = codes.get(i);
		if(!c.isAlive) {
			codes.remove(c);
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
