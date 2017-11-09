package com.ampersand.soulbrew;

import com.ampersand.soulbrew.gfx.GameCamera;
import com.ampersand.soulbrew.input.KeyManager;
import com.ampersand.soulbrew.input.MouseManager;
import com.ampersand.soulbrew.worlds.World;

public class Handler {
 
 private Game game;
 private World world;
 
 public Handler (Game game){
  this.game = game;
 }

 public int getWidth() {
  return game.getWidth();
 }
 
  public int getHeight() {
  return game.getHeight();
 }
  
  public KeyManager getKeyManager() {
   return game.getKeyManager();
  }
  
  public MouseManager getMouseManager() {
   return game.getMouseManager();
  }
  
  public GameCamera getGameCamera() {
   return game.getGameCamera();
  }
 
 public Game getGame() {
  return game;
 }

 public void setGame(Game game) {
  this.game = game;
 }

 public World getWorld() {
  return world;
 }

 public void setWorld(World world) {
  this.world = world;
 }
 
}
