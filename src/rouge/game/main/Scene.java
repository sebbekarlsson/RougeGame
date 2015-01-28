package rouge.game.main;

import java.util.ArrayList;

public abstract class Scene {
	public ArrayList<Instance> INSTANCES = new ArrayList<Instance>();
	public Camera CAMERA = new Camera(0,0);
	protected boolean init = true;
	
	public void update(){
		if(init){
			init();
			init = false;
		}
		
		for(int i = 0; i < INSTANCES.size(); i++){
			INSTANCES.get(i).update();
		}
		
		tick();
		draw();
	}
	
	public abstract void tick();
	public abstract void draw();
	public abstract void init();
	
	public void instantiate(Instance instance){
		INSTANCES.add(instance);
	}
	
	public void destroy(Instance instance){
		INSTANCES.remove(instance);
	}
}
