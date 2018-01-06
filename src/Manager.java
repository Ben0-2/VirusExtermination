import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Manager {

	AntiVirus anti;
	AntiVirus regular;
	ArrayList<ScatterShot> scatterShots;
	ArrayList<Code> codes;
	ArrayList<Virus> viruses;
	ArrayList<BossVirus> bossViruses;
	Rectangle collisionBox;
	AntiVirus scatter;
	private int score = 0;
	long virusTimer = 0;
	int virusSpawnTime = 1000;
	Virus virus;

	public Manager() {
		viruses = new ArrayList<Virus>();
		codes = new ArrayList<Code>();
		anti = new AntiVirus(875, 850, 50, 50);
		bossViruses = new ArrayList<BossVirus>();
		scatterShots = new ArrayList<ScatterShot>();

		regular = new AntiVirus(875, 850, 50, 50);

		scatter = new AntiVirus(875, 850, 50, 50);
	}

	void addVirus(Virus o) {
		viruses.add(o);
	}

	void addCode(Code c) {
		codes.add(c);
	}

	void addBossVirus(BossVirus b) {
		bossViruses.add(b);
	}

	void addScatterShot(ScatterShot s) {
		scatterShots.add(s);
	}

	void addAntiVirus(AntiVirus a) {
		anti = a;

	}

	void checkCollision() {
		for (Code c : codes) {
			checkCollision1();
		}
		for (BossVirus b : bossViruses) {
			checkCollision3(b);

		}
		for (ScatterShot s : scatterShots) {
			checkCollision2(s);
		}
	}

	void checkCollision2(ScatterShot s) {
		for (int i = 0; i < viruses.size(); i++) {
			Virus v = viruses.get(i);

			if (v.collisionBox.intersects(s.collisionBox)) {
				Panel.numViruses -= 1;

				v.isAlive = false;

			}

		}
	}

	void checkCollision3(BossVirus b) {
		for (int i = 0; i < scatterShots.size(); i++) {
			ScatterShot s = scatterShots.get(i);
		}
		for (int j = 0; j < codes.size(); j++) {
			Code c = codes.get(j);
		}
		checkCollision1();
	}

	void checkCollision1() {

		for (int i = 0; i < viruses.size(); i++) {
			Virus v = viruses.get(i);
			for (int j = 0; j < codes.size(); j++) {

				Code c = codes.get(j);

				if (v.collisionBox.intersects(c.collisionBox)) {
					Panel.numViruses -= 1;
					v.isAlive = false;
					c.isAlive = false;
				}
			}
			if (v.collisionBox.intersects(anti.collisionBox)) {

				v.isAlive = false;
				anti.isAlive = false;
			}
		
		}
	}

	void manageViruses() {
		Panel.numViruses = 0;
		for (int a = 1; a < 4; a++) {
			int m = 1;

			for (int i = 1; i < 16; i++) {
				for (int j = 0; j < 15; j++) {
					addVirus(new Virus(10 * j + a * 500 - 200, i * 10 + 200, 7, 7));
					Panel.numViruses += 1;
				}

			}
			if (m < 3) {
				m += 1;
			}

		}
	}

	void BossManageViruses() {
		Panel.numViruses2 = 0;
		int m = 1;

		addBossVirus(new BossVirus(800, 300, 250, 250));
	}

	void reset() {
		viruses.clear();
		destroyObjects();
	}

	void draw(Graphics g) {
		// OBJECTS SIZE SHOULD BE 4, NOT 1
		for (Virus v : viruses) {

			v.draw(g);
		}
		for (Code c : codes) {
			c.draw(g);
		}
		for (ScatterShot s : scatterShots) {
			s.draw(g);
		}
		for (BossVirus b : bossViruses) {
			b.draw(g);
		}

		anti.draw(g);
	}

	void update() {
		for (Virus v : viruses) {

			v.update();

		}
		for (Code c : codes) {
			c.update();
		}
		for (ScatterShot s : scatterShots) {
			s.update();
		}

		destroyObjects();
	}

	void updateBoss() {
		for (Virus v : viruses) {
			v.bossStateUpdate();
		}
		for (Code c : codes) {
			c.update();
		}
		for (ScatterShot s : scatterShots) {
			s.speed = 18;
			s.update();
		}

		for (BossVirus b : bossViruses) {
			b.update();
		}

		destroyObjects();
	}

	void destroyObjects() {
		for (int i = 0; i < viruses.size(); i++) {
			Virus v = viruses.get(i);
			if (!v.isAlive) {
				viruses.remove(v);
			}
		}
		for (int i = 0; i < codes.size(); i++) {
			Code c = codes.get(i);
			if (!c.isAlive) {
				codes.remove(c);
			}
		}
		for (int i = 0; i < scatterShots.size(); i++) {
			ScatterShot s = scatterShots.get(i);
			if (!s.isAlive) {
				scatterShots.remove(s);
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
