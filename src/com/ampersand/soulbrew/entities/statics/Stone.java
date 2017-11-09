package com.ampersand.soulbrew.entities.statics;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.items.Item;
import com.ampersand.soulbrew.tiles.Tile;
import java.awt.Graphics;

public class Stone extends StaticEntity {
 
 public Stone(Handler handler, float x, float y) {
  super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
  bounds.x = 5;
  bounds.y = (int)(height/1.5f);
  bounds.width = width - 15;
  bounds.height = (int)(height - height / 1.1f);
 }

 @Override
 public void tick() {

 }
 
 public void die() {
  handler.getWorld().getItemManager().addItem(Item.stoneItem.createNew((int)x, (int)y));
 }

 @Override
 public void render(Graphics g) {
  g.drawImage(Assets.stone, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
 }
 
}
