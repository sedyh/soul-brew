package com.ampersand.soulbrew.entities.statics;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.items.Item;
import com.ampersand.soulbrew.tiles.Tile;
import java.awt.Graphics;

public class Tree extends StaticEntity {
 
 public Tree(Handler handler, float x, float y) {
  super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);
  bounds.x = 10;
  bounds.y = (int)(height/1.0f);
  bounds.width = width - 42;
  bounds.height = (int)(height - height / 1.01f);
 }

 @Override
 public void tick() {

 }
 
 
 public void die() {
  handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
 }

 @Override
 public void render(Graphics g) {
   g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
 }
 
}
