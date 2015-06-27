package sandbox;

import java.util.concurrent.*;
import multiThreadExample.*;


public class TestProgram {

	public String name;
	public String description;
	public long hitpoint;
	public boolean isDead;
	public int x;
	public int y;
	
	
	public TestProgram(){
		
		this.name = "basic";
		this.description = "This is a basic object";
		this.hitpoint = 300;
		this.isDead = false;
		
		
	}
	
	public TestProgram(String name, long hitpoint, int x, int y){
		this.name = name;
		this.hitpoint = hitpoint;
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setHitpoint(long hitpoint){
		this.hitpoint = hitpoint;
	}
	
	public void setHitpoint(double hitpoint){
		this.hitpoint = (long)Math.round(hitpoint);
	}
	
	public void setIsDead(boolean isDead){
		this.isDead = isDead;
	}
	
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public long getHitpoint(){
		return hitpoint;
	}
	public boolean getIsDead(){
		return isDead;
	}
	
	public void subtractHit(long hit){
		this.hitpoint -= hit;
		
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void killObject(){
	
		if(this.hitpoint <= 0){
			isDead = true;
		}
		
		
	}

	
}
