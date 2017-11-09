package com.ampersand.soulbrew.worlds;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.entities.EntityManager;
import com.ampersand.soulbrew.entities.creatures.Player;
import com.ampersand.soulbrew.entities.statics.OldMan;
import com.ampersand.soulbrew.entities.statics.Stone;
import com.ampersand.soulbrew.entities.statics.Tree;
import com.ampersand.soulbrew.gfx.Selection;
import com.ampersand.soulbrew.items.ItemManager;
import com.ampersand.soulbrew.tiles.Tile;
import com.ampersand.soulbrew.utils.GameMath;
import com.ampersand.soulbrew.utils.Utils;
import java.awt.Graphics;

public class World {
 
 private Handler handler;
 
 private int width, height;
 private int spawnX, spawnY;
 private int [][] tiles;
 
 //Сущности
 
 private EntityManager entityManager;
 
 //Предметы
 
 private ItemManager itemManager;
 
 //Выделение
 
 private Selection selection;
 
 private int showChunk1 = 0;
 private int showChunk2 = 1;
 
 public World(Handler handler, String path) {
  this.handler = handler;
  entityManager = new EntityManager(handler, new Player(handler, 100, 100));
  itemManager = new ItemManager(handler);
  selection = new Selection(handler);
  
  int f, genX, genY;
  //Загрузка сущностей
  for(int i = 0; i<5; i++){
   for(int j=0; j<5; j++) {
    f = GameMath.rnd(0, 2);
    genX = GameMath.rnd(64, 1216);
    genY = GameMath.rnd(64, 1216);
    if( f == 2){
     entityManager.addEntity(new Tree(handler, genX, genY));
    } else {
     entityManager.addEntity(new Stone(handler, genX, genY));
    }
   }
  }
  
  entityManager.addEntity(new OldMan(handler, 640, 256));
  
  loadWorld(path);
  
  entityManager.getPlayer().setX(spawnX);
  entityManager.getPlayer().setX(spawnY);
 }
 
 public void tick() {
  //Тик для тайлов объявлен ниже!
  selection.tick();
  itemManager.tick();
  entityManager.tick();
  
  // Показывает чанковую прогрузку
  if (handler.getKeyManager().seeChunk) {
   showChunk1 = 1;
   showChunk2 = 0;
  } else {
   showChunk1 = 0;
   showChunk2 = 1;
  }
 }
 
 public void render(Graphics g) {
  
  // Чанковая прогрузка
  int xStart = (int) (Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH) + showChunk1);
  int xEnd = (int) (Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH) + showChunk2);
  int yStart = (int) (Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT) + showChunk1 );
  int yEnd = (int) (Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT) + showChunk2);
  
  for(int x = xStart; x < xEnd; x++) {
   for(int y = yStart; y < yEnd; y++) {
    getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
    //Тик объявлен только для видимых тайлов
    getTile(x, y).tick(x, y);
   }
  }
  
  //Выделение
  selection.render(g);
  //Предметы
  itemManager.render(g);
  //Сущности
  entityManager.render(g);
  
 }
 
 public Tile getTile(int x, int y) {
  if(x < 0 || y < 0 || x >= width || y >= height) {
   return Tile.grassFill;
  }
  Tile t = Tile.tiles[tiles[x][y]];
  if(t == null)
   return Tile.grassFill;
  return t;
 }
 
 private void loadWorld(String path) {
  String file = Utils.loadFileAsString(path);
  String[] tokens = file.split("\\s+");
  width = Utils.parseInt(tokens[0]);
  height = Utils.parseInt(tokens[1]);
  spawnX = Utils.parseInt(tokens[2]);
  spawnY = Utils.parseInt(tokens[3]);
  
  tiles = new int[width][height];
  for(int x = 0; x < width; x++) {
   for(int y = 0; y < height; y++) {
    tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
   }
  }
 }

 public EntityManager getEntityManager() {
  return entityManager;
 }

 public Selection getSelection() {
  return selection;
 }
 
 public int getWidth() {
  return width;
 }
 
 public int getHeight() {
  return height;
 }

 public Handler getHandler() {
  return handler;
 }

 public void setHandler(Handler handler) {
  this.handler = handler;
 }

 public ItemManager getItemManager() {
  return itemManager;
 }

 public void setItemManager(ItemManager itemManager) {
  this.itemManager = itemManager;
 }

 public int toWorldX(int x) {
  return (int)((int) (Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() % Tile.TILE_WIDTH) + (Tile.TILE_WIDTH - (int) (Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() % Tile.TILE_WIDTH) + handler.getMouseManager().getMouseX()) / Tile.TILE_WIDTH * Tile.TILE_WIDTH - Tile.TILE_WIDTH + handler.getGameCamera().getxOffset())/Tile.TILE_WIDTH;
 }
 
 public int toWorldY(int y) {
  return (int)((int) (Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset() % Tile.TILE_HEIGHT) + (Tile.TILE_HEIGHT - (int) (Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset() % Tile.TILE_HEIGHT) + handler.getMouseManager().getMouseY()) / Tile.TILE_HEIGHT * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT + handler.getGameCamera().getyOffset())/Tile.TILE_HEIGHT;
 }
 
 public int toViewX(int x) {
  return 0;
 }
 
 public int toViewY(int y) {
  return 0;
 }
 
 public void setTile(int x, int y, int id) {
  tiles[x][y] = id;
 }
 
 public void breakTile(int x, int y) {
  int id = getTile(x, y).getId();
  if(id == 0) {
   tiles[x][y] = 1;
  } else if(id == 1) {
   tiles[x][y] = 2;
  } else if(id == 2) {
   tiles[x][y] = 3;
  }
 }
 
}
