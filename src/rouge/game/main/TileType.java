package rouge.game.main;

import org.newdawn.slick.opengl.Texture;

public enum TileType {
	
	AIR(null,false),
	STONEBRICKS(TextureBank.STONEBRICKS,true),
	STONE(TextureBank.STONE,false);
	
	public Texture texture;
	public boolean solid;
	TileType(Texture texture, boolean solid){
		this.texture = texture;
		this.solid = solid;
	}
}
