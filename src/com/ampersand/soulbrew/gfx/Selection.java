package com.ampersand.soulbrew.gfx;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.tiles.Tile;
import com.ampersand.soulbrew.utils.GameMath;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Selection {
 
 Handler handler;
 
 private int selectionRad = 250;
 
 int offsX;
 int offsY;
 
 public Selection(Handler handler) {
  this.handler = handler;
 }
 
 public void tick() {
  offsX = (int) (Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() % Tile.TILE_WIDTH);
  offsY = (int) (Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset() % Tile.TILE_HEIGHT);
 }
 
 public void render(Graphics g) {
  
  if(GameMath.pointDist(handler.getWorld().getEntityManager().getPlayer().getWorldX(), handler.getWorld().getEntityManager().getPlayer().getWorldY(), handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY()) < selectionRad) {
   g.setColor(Color.WHITE);
   g.drawLine(handler.getWorld().getEntityManager().getPlayer().getWorldX(), handler.getWorld().getEntityManager().getPlayer().getWorldY(), handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
   g.drawRect(offsX + (Tile.TILE_WIDTH - offsX + handler.getMouseManager().getMouseX()) / Tile.TILE_WIDTH * Tile.TILE_WIDTH - Tile.TILE_WIDTH,
	      offsY + (Tile.TILE_HEIGHT - offsY + handler.getMouseManager().getMouseY()) / Tile.TILE_HEIGHT * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT,
	      Tile.TILE_WIDTH,
	      Tile.TILE_HEIGHT);
   
   String str = String.valueOf(handler.getWorld().getTile(handler.getWorld().toWorldX(handler.getMouseManager().getMouseX()),
	                                                  handler.getWorld().toWorldY(handler.getMouseManager().getMouseY())).getId());
   
   
    
   g.drawString(str, (offsX + (Tile.TILE_WIDTH - offsX + handler.getMouseManager().getMouseX()) / Tile.TILE_WIDTH * Tile.TILE_WIDTH - Tile.TILE_WIDTH + Tile.TILE_WIDTH/2) - str.length(), offsY + (Tile.TILE_HEIGHT - offsY + handler.getMouseManager().getMouseY()) / Tile.TILE_HEIGHT * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT + Tile.TILE_HEIGHT/2);
  }
  
  if(handler.getMouseManager().isLeftPressed()) {
   ArrayList<Integer> arr = new ArrayList<Integer>();
   splitn(handler.getWorld().getEntityManager().getPlayer().getWorldX(), handler.getWorld().getEntityManager().getPlayer().getWorldY(), handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), arr, 5);
   for(int i = 0; i < arr.size()-2; i+=2) {
    g.setColor(new Color(255, 255, 255));
    g.drawLine(arr.get(i), arr.get(i+1), arr.get(i+2), arr.get(i+3));
    g.drawLine(arr.get(i), arr.get(i+1)-1, arr.get(i+2), arr.get(i+3)-1);
    g.drawLine(arr.get(i)-1, arr.get(i+1), arr.get(i+2)-1, arr.get(i+3));
   }
  }
 }
 
 public void splitn(int x1, int y1, int x2, int y2, ArrayList<Integer> arr, int cnt){
  
  --cnt;
  
  int xMiddle = (int) (x1+x2)/2 + rnd(-10, 10);
  int yMiddle = (int) (y1+y2)/2 + rnd(-10, 10);
  
  if (cnt > 0) splitn(x1, y1, xMiddle, yMiddle, arr, cnt);
  arr.add(xMiddle);
  arr.add(yMiddle);
  if (cnt > 0) splitn(xMiddle, yMiddle, x2, y2, arr, cnt);
  
}
 
 public static int rnd(int min, int max) {
  max -= min;
  return (int) (Math.random() * ++max) + min;
 }

 public int getSelectionRad() {
  return selectionRad;
 }
 
}
