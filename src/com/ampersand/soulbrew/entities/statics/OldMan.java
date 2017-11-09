package com.ampersand.soulbrew.entities.statics;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.gfx.Animation;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.items.Item;
import com.ampersand.soulbrew.tiles.Tile;
import com.ampersand.soulbrew.utils.GameMath;
import java.awt.Color;
import java.awt.Graphics;

public class OldMan extends StaticEntity {
 
 private Animation idle;
	 
 public OldMan(Handler handler, float x, float y) {
  super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);
  bounds.x = 10;
  bounds.y = (int)(height/1.1f);
  bounds.width = width - 20;
  bounds.height = (int)(height - height / 1.1f);
  
  idle = new Animation(100, Assets.oldMan);
 }

 @Override
 public void tick() {
  idle.tick();
 }
 
 
 public void die() {
  handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
 }

 @Override
 public void render(Graphics g) {
  g.setColor(Color.red);
  g.fillRect((int)(x - handler.getGameCamera().getxOffset())-health*3/2+width/2, (int) (y - handler.getGameCamera().getyOffset())+height+5, health*3, 10);
  g.drawImage(idle.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
 }
 
}
