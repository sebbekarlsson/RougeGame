package rouge.game.main.scenes;

import java.util.Random;

import rouge.game.main.Chunk;
import rouge.game.main.Scene;
import rouge.game.main.WorldGenerator;

public class World extends Scene {
	public Chunk[][] CHUNKS = new Chunk[WorldGenerator.WORLDSIZE][WorldGenerator.WORLDSIZE];
	

	public void update(){
		
		if(init){
			init();
			init = false;
		}
		
		for(int x = 0; x < CHUNKS.length; x++){
			for(int y = 0; y < CHUNKS[x].length; y++){
				Chunk chunk = CHUNKS[x][y];
				if(!chunk.isOutsideView())
				chunk.update();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		for(int x = 0; x < CHUNKS.length; x++){
			for(int y = 0; y < CHUNKS[x].length; y++){
				CHUNKS[x][y] = new Chunk(x*16*16,y*16*16);
			}
		}
		
	}

}
