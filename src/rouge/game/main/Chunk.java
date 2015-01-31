package rouge.game.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.lwjgl.opengl.Display;


import rouge.game.main.instances.Tile;

public class Chunk {
	public int x,y = 0;
	public Tile[][] TILES = new Tile[16][16];
	private boolean init = true;
	Random random = new Random();
	public BufferedImage map;


	public Chunk(int x, int y, BufferedImage map){
		this.x = x;
		this.y = y;
		this.map = map;
	}

	public void init(){
		generateAir();
		for(int x = 0; x < map.getWidth(); x++){
			for(int y = 0; y < map.getHeight(); y++){
				Color color = new Color(map.getRGB(x, y));
				
				if(color.getRed() == 255){
					TILES[x][y].setType(TileType.STONEBRICKS);
				}
				if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0){
					TILES[x][y].setType(TileType.STONE);
				}
				
			}
		}
	}

	public void update(){
		if(init){
			init();
			init = false;
		}
		
		if(init == false){
			for(int x = 0; x < TILES.length; x++){
				for(int y = 0; y < TILES[x].length; y++){
					TILES[x][y].update();
				}
			}
		}
	
		draw();
	}
	
	public void draw(){
		/*GL11.glTranslatef(x, y, 0);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1, 0, 0);
		
		
		GL11.glBegin(GL11.GL_LINES);
		
		GL11.glVertex2f(16*16, 0);
		GL11.glVertex2f(16*16, 16*16);
		
		GL11.glEnd();
		
		GL11.glBegin(GL11.GL_LINES);
		
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(16*16,0);
		
		GL11.glEnd();
		
		GL11.glColor3f(1, 1, 1);
		GL11.glTranslatef(-x, -y, 0);*/
	}

	public void generateAir(){
		for(int x = 0; x < TILES.length; x++){
			for(int y = 0; y < TILES[x].length; y++){
				TILES[x][y] = new Tile(this.x+x*16,this.y+y*16,TileType.AIR,this);
			}
		}
	}

	public float getDistanceToCamera(){
		Camera camera = Main.getCurrentScene().CAMERA;
		float distance = (float) Math.sqrt((x-camera.x)*(x-camera.x) + (y-camera.y)*(y-camera.y));
		return distance;
	}

	public boolean isOutsideView(){
		Camera camera = Main.getCurrentScene().CAMERA;
		if(x+16*16 < camera.x-Display.getWidth()/3 || x > camera.x+Display.getHeight()/3 || y+16*16 < camera.y-Display.getHeight()/3 || y > camera.y+Display.getHeight()/3){
			return true;
		}

		return false;
	}
}
