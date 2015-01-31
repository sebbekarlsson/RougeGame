package rouge.game.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import rouge.game.main.scenes.World;

public class WorldGenerator {
	public static int WORLDSIZE = 16*40;
	public static int ROOMSIZE = 7;
	Random random = new Random();

	public void generateWorld(World world){
		BufferedImage map = new BufferedImage(WORLDSIZE, WORLDSIZE, BufferedImage.TYPE_INT_RGB);


		for(int xx = 0; xx < map.getWidth(); xx++){
			for(int yy = 0; yy < map.getHeight(); yy++){
				map.setRGB(xx, yy, Color.black.getRGB());
			}
		}

		for(int xx = 0; xx < map.getWidth()/ROOMSIZE; xx++){
			for(int yy = 0; yy < map.getHeight()/ROOMSIZE; yy++){
				new Slice(xx*ROOMSIZE,yy*ROOMSIZE,ROOMSIZE,ROOMSIZE,map).build();
			}
		}
		
		for(int x = 0; x < world.CHUNKS.length/16; x++){
			for(int y = 0; y < world.CHUNKS[x].length/16; y++){
				BufferedImage mapPart = map.getSubimage(x*16, y*16, 16, 16);
				world.CHUNKS[x][y] = new Chunk(x*16*16,y*16*16,mapPart);
			}
		}

		File outputfile = new File("image.png");
		try {
			ImageIO.write(map, "PNG", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class Slice{
		int x,y = 0;
		int width, height = 0;
		BufferedImage map;

		public Slice(int x, int y, int width, int height, BufferedImage map){
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.map = map;
		}

		public void build(){
			for(int xx = x; xx < x+width; xx++){
				for(int yy = y; yy < y+height; yy++){
					if(xx >= x+width-1 || yy >= y+height-1)
					map.setRGB(Math.min(map.getWidth()-1, xx), Math.min(map.getHeight()-1, yy), Color.red.getRGB());
				}
			}
			
			if(random.nextInt(3) == 0){
				for(int xx = x; xx < x+width-1; xx++){
					map.setRGB(xx, y+height-1, Color.black.getRGB());
				}
			}
			
			if(random.nextInt(3) == 0){
				for(int yy = y; yy < y+height-1; yy++){
					map.setRGB(x+width-1, yy, Color.black.getRGB());
				}
			}
			
			boolean side = random.nextBoolean();
			
			if(side == false){
				map.setRGB(x+width/2, y+height-1, Color.black.getRGB());
				map.setRGB(x-1+width/2, y+height-1, Color.black.getRGB());
			}
			else if(side == true){
				map.setRGB(x+width-1, y+height/2, Color.black.getRGB());
				map.setRGB(x+width-1, y-1+height/2, Color.black.getRGB());
			}
		
		}

	}
}
