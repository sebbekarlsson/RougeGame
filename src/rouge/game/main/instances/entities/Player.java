package rouge.game.main.instances.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import rouge.game.main.Entity;
import rouge.game.main.TextureBank;

public class Player extends Entity {
	float maxspeed = 5f;
	
	public Player(float x, float y) {
		super(x, y);
		sprite.IMAGES.add(TextureBank.BALL);
		setHitbox(32,32);
		friction = 0.1f;
	}

	@Override
	public void tick() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(dx*-1 < maxspeed)
			addForce(new Vector2f(-6f,0));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(dx < maxspeed)
				addForce(new Vector2f(6f,0));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			if(dy*-1 < maxspeed)
			addForce(new Vector2f(0,-6f));
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			if(dy < maxspeed)
			addForce(new Vector2f(0,6f));
		}
		
	}

}
