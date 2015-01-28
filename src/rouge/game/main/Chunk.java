package rouge.game.main;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import rouge.game.main.instances.Tile;

public class Chunk {
	public int x,y = 0;
	public Tile[][] TILES = new Tile[16][16];
	private boolean init = true;
	Random random = new Random();


	public Chunk(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void init(){
		generateAir();
		for(int x = 0; x < TILES.length; x++){
			for(int y = 0; y < TILES[x].length; y++){
				if(random.nextInt(100) == 0){
				TILES[x][y].setType(TileType.STONE);
				}
				if(random.nextInt(100) == 0){
				TILES[x][y].setType(TileType.STONEBRICKS);
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
		GL11.glTranslatef(x, y, 0);
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
		GL11.glTranslatef(-x, -y, 0);
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
		int margin = (16*16)*2;
		Camera camera = Main.getCurrentScene().CAMERA;
		boolean outside = false;
		if(x < camera.x-margin || x > camera.x+Display.getWidth()+margin || y < camera.y-margin || y > camera.y+Display.getHeight()+margin){
			return true;
		}

		return false;
	}
}
