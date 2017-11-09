package com.ampersand.soulbrew.tiles;

import com.ampersand.soulbrew.Handler;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
 
 // Переменные
 
 public static Tile[] tiles = new Tile[256];
 public static Tile air = new GrassFill(0);
 public static Tile grassFill = new GrassFill(1);
 public static Tile grassUpperLeftOuter = new GrassUpperLeftOuter(2);
 public static Tile grassUpOuter = new GrassUpOuter(3);
 public static Tile grassUpperRightOuter = new GrassUpperRightOuter(4);
 public static Tile grassDownerLeftOuter = new GrassDownerLeftOuter(5);
 public static Tile grassDownOuter = new GrassDownOuter(6);
 public static Tile grassDownerRightOuter = new GrassDownerRightOuter(7);
 public static Tile grassRightOuter = new GrassRightOuter(8);
 public static Tile grassLeftOuter = new GrassLeftOuter(9);
 public static Tile grassDownerLeftInner = new GrassDownerLeftInner(10);
 public static Tile grassDownerRightInner = new GrassDownerRightInner(11);
 public static Tile grassUpperRightInner = new GrassUpperRightInner(12);
 public static Tile grassUpperLeftInner = new GrassUpperLeftInner(13);
 
 // Класс
 
 public static final int TILE_WIDTH = 64,
	                 TILE_HEIGHT = 64;
 
 protected BufferedImage texture;
 protected final int id;
 
 public Tile(BufferedImage texture, int id) {
  this.texture = texture;
  this.id = id;
  tiles[id] = this;
 }

 public void tick(int x, int y) {
  
 }
 
 public void render(Graphics g, int x, int y) {
  g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
 }
 
 public boolean isSolid() {
  return false;
 }
 
 public int getId() {
  return id;
 }
 
}
