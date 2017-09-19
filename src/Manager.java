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
void checkCollision() {
	
}
void manageViruses() {
	
}
void reset() {
	
}
void draw(Graphics g) {
for(int i=0; i<objects.size();i++) {
	SuperObject o = objects.get(i);
	o.draw();
}
}
void update() {
	for(int i = 0; i<objects.size(); i++) {
		SuperObject o = objects.get(i);
		o.update();
	}
destroyObjects();
}
void destroyObjects() {
	for(int i = 0; i<objects.size(); i ++) {
		if(!objects.get(i).isAlive) {
			objects.remove(i);
		}
	}
}
void setScore() {
	
}
void getScore() {
	
}
}
