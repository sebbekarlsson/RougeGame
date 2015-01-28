package rouge.game.main.instances;

import rouge.game.main.Chunk;
import rouge.game.main.Instance;
import rouge.game.main.TileType;

public class Tile extends Instance {
	public Chunk chunk;
	public TileType type;
	
	public Tile(float x, float y,TileType  type, Chunk chunk) {
		super(x, y);
		this.chunk = chunk;
		this.type = type;
		tileUpdate();
	}
	
	public void tileUpdate(){
		sprite.IMAGES.clear();
		sprite.IMAGES.add(type.texture);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void setType(TileType type){
		this.type = type;
		tileUpdate();
	}


}
