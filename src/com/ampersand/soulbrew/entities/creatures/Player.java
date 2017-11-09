package com.ampersand.soulbrew.entities.creatures;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.entities.Entity;
import com.ampersand.soulbrew.gfx.Animation;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.inventory.Inventory;
import com.ampersand.soulbrew.tiles.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Creature {
 
 private int lastDirection = 0;
 private boolean isStay = true;
 private boolean selection;
 //Анимации
 private Animation animUp, animDown, animLeft, animRight;
 // Таймер атаки
 private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
 //Инвентарь
 private Inventory inventory;
 
 public Player(Handler handler, float x, float y) {
  super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
  
  bounds.x = 16;
  bounds.y = 32;
  bounds.width = 32;
  bounds.height = 32;
  
  //Анимации
  
  animUp = new Animation(300, Assets.player_up);
  animDown = new Animation(300, Assets.player_down);
  animLeft = new Animation(300, Assets.player_left);
  animRight = new Animation(300, Assets.player_right);
  
  inventory = new Inventory(handler);
 }

 public void tick() {
  //Анимация
  animUp.tick();
  animDown.tick();
  animLeft.tick();
  animRight.tick();
  //Движение
  getInput();
  move();
  handler.getGameCamera().centerOnEntity(this);
  //Проверять атаку
  checkAttacks();
  //Инвентарь
  inventory.tick();
 }
 
 private void checkAttacks() {
  attackTimer += System.currentTimeMillis() - lastAttackTimer;
  lastAttackTimer = System.currentTimeMillis();
  if(attackTimer < attackCooldown)
   return;
  
  Rectangle cb = getCollisionBounds(0, 0);
  Rectangle ar = new Rectangle();
  int arSize = 64;
  ar.width = arSize;
  ar.height = arSize;
  
  //Убрать потом ...
  int offsXX = (int) (Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() % Tile.TILE_WIDTH);
  int offsYY = (int) (Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset() % Tile.TILE_HEIGHT);
  
   ar.x = (int) (offsXX + (Tile.TILE_WIDTH - offsXX + handler.getMouseManager().getMouseX()) / Tile.TILE_WIDTH * Tile.TILE_WIDTH - Tile.TILE_WIDTH + handler.getGameCamera().getxOffset());
   ar.y = (int) (offsYY + (Tile.TILE_HEIGHT - offsYY + handler.getMouseManager().getMouseY()) / Tile.TILE_HEIGHT * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT + handler.getGameCamera().getyOffset());	   
 
  for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
   if(e.equals(this))
    continue;
   if(e.getCollisionBounds(0, 0).intersects(ar)) {
    selection = false;
    e.setSelected(true);
   } else {
    e.setSelected(false);
   }
  }
  ar.x = 0;
  ar.y = 0;
  
  //...
  
  if(handler.getMouseManager().isLeftPressed()) {
   
   int offsX = (int) (Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() % Tile.TILE_WIDTH);
   int offsY = (int) (Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset() % Tile.TILE_HEIGHT);
  
   ar.x = (int) (offsX + (Tile.TILE_WIDTH - offsX + handler.getMouseManager().getMouseX()) / Tile.TILE_WIDTH * Tile.TILE_WIDTH - Tile.TILE_WIDTH + handler.getGameCamera().getxOffset());
   ar.y = (int) (offsY + (Tile.TILE_HEIGHT - offsY + handler.getMouseManager().getMouseY()) / Tile.TILE_HEIGHT * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT + handler.getGameCamera().getyOffset());	   
 
   //Здесь можно реализовать остальное пробитие
   
  }
  attackTimer = 0;
  
  for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
   if(e.equals(this))
    continue;
   if(e.getCollisionBounds(0, 0).intersects(ar)) {
    e.hurt(1);
    System.out.println(getHealth());
    return;
   }
  }
  
 }
 
 @Override
 public void die() {
  System.out.println("You lose");
 }
 
 public void getInput() {
  xMove = 0;
  yMove = 0;
  
  if(handler.getKeyManager().up & ! handler.getKeyManager().down) {
   yMove = -speed;
  }
  if(handler.getKeyManager().down & ! handler.getKeyManager().up) {
   yMove = speed;
  }
  if(handler.getKeyManager().left & ! handler.getKeyManager().right) {
   xMove = -speed;
  }
  if(handler.getKeyManager().right & ! handler.getKeyManager().left) {
   xMove = speed;
  }
   
 }

 public void render(Graphics g) {
  
  g.setColor(Color.white);
  //Рендер бокса
  if(selection)
   g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), (int)(y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
  
  g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
  
  //Рендер области действия
  g.drawOval(getWorldX() - handler.getWorld().getSelection().getSelectionRad(), 
	     getWorldY() - handler.getWorld().getSelection().getSelectionRad(), 
	     handler.getWorld().getSelection().getSelectionRad()*2, 
	     handler.getWorld().getSelection().getSelectionRad()*2);
  
}
 
 public void postRender(Graphics g) {
  inventory.render(g);
 }
 
 public BufferedImage getCurrentAnimationFrame() {
  if(xMove < 0) {
   return animLeft.getCurrentFrame();
  } else if(xMove > 0) {
   return animRight.getCurrentFrame();
  } else if(yMove < 0) {
   return animUp.getCurrentFrame();
  } 
  else
    return animDown.getCurrentFrame();
 }
 
 public Inventory getInventory() {
  return inventory;
 }

 public void setInventory(Inventory inventory) {
  this.inventory = inventory;
 }
 
 public int getWorldX() {
  return (int) (handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset() + handler.getWorld().getEntityManager().getPlayer().getHeight()/2);
 }
 
 public int getWorldY() {
  return (int) (handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset() + handler.getWorld().getEntityManager().getPlayer().getWidth()/2);
 }
 
}
