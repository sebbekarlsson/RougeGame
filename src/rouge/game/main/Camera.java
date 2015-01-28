package rouge.game.main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Camera {
	public float x,y = 0f;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		tick();
		draw();
	}
	
	public void tick(){
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			x -= 3f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			x += 3f;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			y -= 3f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			y += 3f;
		}
	}
	
	public void draw(){
		
	}
	

}
