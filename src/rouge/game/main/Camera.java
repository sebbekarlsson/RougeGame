package rouge.game.main;

import org.lwjgl.input.Keyboard;

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
		
	}
	
	public void draw(){
		
	}
	

}
