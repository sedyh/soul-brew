package com.ampersand.soulbrew.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
 
 private static final int width=64, height=64;
 
 public static Font invFont;
 //tiles
 public static BufferedImage grassFill, grassUpperLeftOuter, grassUpOuter, grassUpperRightOuter,
	                                grassDownerLeftOuter, grassDownOuter, grassDownerRightOuter,
			                grassLeftOuter, grassRightOuter, grassUpperRightInner, grassUpperLeftInner,
					grassDownerLeftInner, grassDownerRightInner;
 //entities
 public static BufferedImage tree, stone;
 public static BufferedImage[] oldMan;
//selectedEntities
 public static BufferedImage selectedTree, selectedStone, selectedOldMan;
 //items
 public static BufferedImage planks;
 //inventory
 public static BufferedImage inventory;
 
 public static BufferedImage[] player_up, player_right, player_down, player_left,
	                       player_upStay, player_downStay, player_leftStay, player_rightStay;
 
 public static BufferedImage[] btn_start;
 //Other
 public static BufferedImage[] oulRift;
 public static BufferedImage backgroundMenu;
 
 public static void init() {
  
  //fonts
  
  
  //textures
  SpriteSheet uiSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/ui.png"));
  
  inventory = ImageLoader.loadImage("/res/textures/inv.png");
  
  btn_start = new BufferedImage[2];
  
  btn_start[0] = uiSheet.crop(0, 0, width*4, height);
  btn_start[1] = uiSheet.crop(0, height, width*4, height);
  
  //Тайлы
  
  SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/tiles.png"));
  
  grassFill = tileSheet.crop(0, 0, width, height);
  grassUpperLeftOuter = tileSheet.crop(width, 0, width, height);
  grassUpOuter = tileSheet.crop(width*2, 0, width, height);
  grassUpperRightOuter = tileSheet.crop(width*3, 0, width, height);
  grassDownerLeftOuter = tileSheet.crop(width*4, 0, width, height);
  grassDownOuter = tileSheet.crop(width*5, 0, width, height);
  grassDownerRightOuter = tileSheet.crop(width*6, 0, width, height);
  grassRightOuter = tileSheet.crop(width*7, 0, width, height);
  grassLeftOuter = tileSheet.crop(width*8, 0, width, height);
  
  grassDownerRightInner = tileSheet.crop(width*9, 0, width, height);
  grassDownerLeftInner = tileSheet.crop(width*10, 0, width, height);
  grassUpperRightInner = tileSheet.crop(width*11, 0, width, height);
  grassUpperLeftInner = tileSheet.crop(0, height, width, height);
  
  //Предметы
  
  planks = tileSheet.crop(width, height, width, height);
  
  //Сущности
  
  tree = tileSheet.crop(width*8, height*10, width, height*2);
  stone = tileSheet.crop(width*6, height*11, width, height);
  oldMan = new BufferedImage[3];
  oldMan[0] = tileSheet.crop(width*9, height*10, width, height*2);
  oldMan[1] = tileSheet.crop(width*10, height*10, width, height*2);
  oldMan[2] = tileSheet.crop(width*11, height*10, width, height*2);
  
  //Выделенные сущности
  
  selectedTree = tileSheet.crop(width*7, height*10, width, height*2);
  selectedStone = tileSheet.crop(width*8, height*10, width, height*2);
  
  // Игроки
  
  SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/player.png"));
 
  player_up = new BufferedImage[4];
  player_right = new BufferedImage[4];
  player_down = new BufferedImage[4];
  player_left = new BufferedImage[4];
  
  player_up[0] = playerSheet.crop(0, 0, width, height);
  player_up[1] = playerSheet.crop(width, 0, width, height);
  player_up[2] = playerSheet.crop(0, 0, width, height);
  player_up[3] = playerSheet.crop(width*2, 0, width, height);
  player_right[0] = playerSheet.crop(width*3, 0, width, height);
  player_right[1] = playerSheet.crop(width*4, 0, width, height);
  player_right[2] = playerSheet.crop(width*3, 0, width, height);
  player_right[3] = playerSheet.crop(width*5, 0, width, height);
  player_down[0] = playerSheet.crop(width*6, 0, width, height);
  player_down[1] = playerSheet.crop(width*7, 0, width, height);
  player_down[2] = playerSheet.crop(width*6, 0, width, height);
  player_down[3] = playerSheet.crop(width*8, 0, width, height);
  player_left[0] = playerSheet.crop(width*9, 0, width, height);
  player_left[1] = playerSheet.crop(width*10, 0, width, height);
  player_left[2] = playerSheet.crop(width*9, 0, width, height);
  player_left[3] = playerSheet.crop(width*11, 0, width, height);
  
  
  backgroundMenu = ImageLoader.loadImage("/res/textures/backgroundMenu.png");
  
  SpriteSheet oulRiftSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/oulRift.png"));
  
  oulRift = new BufferedImage[121];
  
  int h = 0;
  for(int i = 0; i<900; i+= 300) {
   for(int j = 0; j<12000; j+= 300) {
    h ++;
    oulRift[h] = oulRiftSheet.crop(i, j, 300, 300);
   }
  }
    
 }
 
}
