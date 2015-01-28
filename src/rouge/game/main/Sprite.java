package rouge.game.main;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	public ArrayList<Texture> IMAGES = new ArrayList<Texture>();
	public int IMAGEINDEX = 0;

	public void tick(){}
	public void draw(float width, float height){
		Texture t = getCurrentImage();
		if(t != null)
		t.bind();
		GL11.glBegin(GL11.GL_QUADS);
		if(IMAGES.size() > 0){

			

			if(t != null){
				
				
				
				
				GL11.glTexCoord2f(0, 0);
				GL11.glVertex2f(0, 0);
				
				GL11.glTexCoord2f(t.getWidth(), 0);
				GL11.glVertex2f(width, 0);
				
				GL11.glTexCoord2f(t.getWidth(), t.getHeight());
				GL11.glVertex2f(width, height);
				
				GL11.glTexCoord2f(0, t.getHeight());
				GL11.glVertex2f(0, height);

			}

		}

		GL11.glEnd();
	}

	public Texture getCurrentImage(){
		return IMAGES.get(IMAGEINDEX);
	}
}
