package com.ampersand.soulbrew.states;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.entities.creatures.Player;
import com.ampersand.soulbrew.entities.statics.Tree;
import com.ampersand.soulbrew.worlds.World;
import java.awt.Graphics;

public class GameState extends State {

 private World world;
 
 
 public GameState(Handler handler) {
  super(handler);
  
  world = new World(handler, "/res/worlds/world1.txt");
  handler.setWorld(world);

 }
 
 public void tick() {
  world.tick();
 }

 public void render(Graphics g) {
  world.render(g);
 }
 
 
 
}
