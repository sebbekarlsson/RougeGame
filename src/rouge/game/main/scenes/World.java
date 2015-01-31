package rouge.game.main.scenes;



import org.lwjgl.opengl.Display;

import rouge.game.main.Chunk;
import rouge.game.main.Scene;
import rouge.game.main.WorldGenerator;
import rouge.game.main.instances.entities.Player;

public class World extends Scene {
	public Chunk[][] CHUNKS = new Chunk[WorldGenerator.WORLDSIZE][WorldGenerator.WORLDSIZE];
	public WorldGenerator generator = new WorldGenerator();
	public static Player player = new Player(120,120);

	public World(){

	}

	public void update(){

		if(init){
			init();
			init = false;
		}

		for(int x = 0; x < CHUNKS.length; x++){
			for(int y = 0; y < CHUNKS[x].length; y++){
				Chunk chunk = CHUNKS[x][y];
				if(chunk != null){
					if(!chunk.isOutsideView())
						chunk.update();
				}
			}
		}

		for(int i = 0; i < INSTANCES.size(); i++){
			INSTANCES.get(i).update();
		}

		tick();
		draw();
	}

	@Override
	public void tick() {
		CAMERA.x = player.x+Display.getWidth()/6;
		CAMERA.y = player.y+Display.getHeight()/6;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {

		generator.generateWorld(this);
		instantiate(player);
		


	}

}
