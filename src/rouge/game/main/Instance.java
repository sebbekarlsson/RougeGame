package rouge.game.main;

import java.awt.Dimension;

import org.lwjgl.opengl.GL11;

public abstract class Instance {
	public float x,y = 0f;
	public Sprite sprite = new Sprite();
	public Dimension hitbox = new Dimension(16,16);
	
	public Instance(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		tick();
		draw();
	}
	
	public void draw(){
		GL11.glTranslatef(x-hitbox.width/2, y-hitbox.height/2, 0);
			
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			sprite.draw(16, 16);
		
		GL11.glTranslatef(-(x-hitbox.width/2), -(y-hitbox.height/2), 0);
	}
	
	public abstract void tick();
	
	public float getDistanceToCamera(){
		Camera camera = Main.getCurrentScene().CAMERA;
		float distance = (float) Math.sqrt((x-camera.x)*(x-camera.x) + (y-camera.y)*(y-camera.y));
		return distance;
	}
	
	public void setHitbox(int width, int height){
		hitbox.width = width;
		hitbox.height = height;
	}
}
