package rouge.game.main;

import org.lwjgl.util.vector.Vector2f;

import rouge.game.main.instances.Tile;
import rouge.game.main.scenes.World;

public abstract class Entity extends Instance {
	public float dx, dy = 0f;
	public float friction = 0.3f;

	public Entity(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void update(){
		
		Tile tile = getChunk().TILES[(int)((x+(dx))/16)%16][(int)((y+(dy))/16)%16];

		if(!tile.type.solid){
		
			x += dx;
			y += dy;

		}




		if(dx < 0){
			if(dx + friction > 0){
				dx = 0;
			}else{
				dx += friction;
			}
		}

		if(dx > 0){
			if(dx - friction < 0){
				dx = 0;
			}else{
				dx -= friction;
			}
		}


		if(dy < 0){
			if(dy + friction > 0){
				dy = 0;
			}else{
				dy += friction;
			}
		}

		if(dy > 0){
			if(dy - friction < 0){
				dy = 0;
			}else{
				dy -= friction;
			}
		}



		tick();
		draw();
	}

	public void addForce(Vector2f v){







		Tile tile = getChunk().TILES[(int)((x+(v.x* v.length()/(hitbox.width/6)))/16)%16][(int)((y+(v.y * v.length()/(hitbox.height/6)))/16)%16];




		if(!tile.type.solid){
			x += (v.x * (v.length())/hitbox.width);
			y += (v.y * (v.length())/hitbox.height);
		}else{
			/*dx -= (v.x * (v.length())/hitbox.width)+(dx*2);
			dy -= (v.y * (v.length())/hitbox.height)+(dy*2);*/
		}



	}

	public Chunk getChunk(){
		return ((World)Main.getCurrentScene()).CHUNKS[(int) ((x/(16*16))%16)][(int) ((y/(16*16))%16)];
	}

	public float getNiceDy(){
		if(dy < 0){
			return dy*-1;
		}else{
			return dy;
		}
	}

	public float getNiceDx(){
		if(dx < 0){
			return dx*-1;
		}else{
			return dx;
		}
	}


}
