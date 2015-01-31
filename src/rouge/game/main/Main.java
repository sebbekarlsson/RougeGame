package rouge.game.main;

import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import rouge.game.main.scenes.World;


public class Main {
	public static int HEIGHT = 640;
	public static int WIDTH = HEIGHT / 9 * 16;
	public static int SCALE = 1;
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	
	public static ArrayList<Scene> SCENES = new ArrayList<Scene>();
	public static int SCENEINDEX = 0;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		Display.setTitle("Rouge Game");
		try {
			Display.setDisplayMode(new DisplayMode(FRAMESIZE.width, FRAMESIZE.height));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Display.setVSyncEnabled(true);
		initGraphics();
		SCENES.add(new World());
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glColor3f(1, 1, 1);
			
			Camera camera = getCurrentScene().CAMERA;
			camera.update();
			
		
			
			
			GL11.glPushMatrix();
			GL11.glTranslatef(-Display.getWidth()/2, -Display.getHeight()/2, 0);
			GL11.glScalef(3, 3, 0);
			GL11.glTranslatef(Display.getWidth()/2, Display.getHeight()/2, 0);
			GL11.glTranslatef(-camera.x, -camera.y, 0f);
			
			
			getCurrentScene().update();
			
			
			
			GL11.glTranslatef(camera.x, camera.y, 0f);
			GL11.glPopMatrix();
			
			
				
		
			GL11.glColor3f(1, 1, 1);
			Display.sync(60);
			Display.update();
		}
	}
	
	public static Scene getCurrentScene(){
		return SCENES.get(SCENEINDEX);
	}
	
	private void initGraphics(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(),Display.getHeight() , 0, -1f, 100f);
		
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		
		GL11.glEnable(GL11.GL_BLEND); GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		
		
		
	}
}
