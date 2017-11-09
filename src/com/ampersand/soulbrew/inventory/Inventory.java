package com.ampersand.soulbrew.inventory;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.gfx.Text;
import com.ampersand.soulbrew.items.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static javafx.scene.text.Font.font;

public class Inventory {
 
 private Handler handler;
 private boolean active = false;
 private ArrayList<Item> inventoryItems;
 
 private int invX = 64, invY = 48,
	     invWidth = 655, invHeight = 498,
	     invListCenterX = invX + 171,
	     invListCenterY = invY + invHeight / 2 + 5;
 
 public Inventory(Handler handler) {
  this.handler = handler;
  inventoryItems = new ArrayList<Item>();
  
  addItem(Item.stoneItem.createNew(5));
  addItem(Item.woodItem.createNew(24));
 }
 
 public void tick() {
  if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
   active = !active;
  if(!active)
   return;
  
  System.out.println("Inventory:");
  for(Item i : inventoryItems) {
   System.out.println(i.getName() + " " + i.getCount());
  }
 }
 
 public void render(Graphics g) {
  if(!active)
   return;
  
  g.drawImage(Assets.inventory, invX, invY, invWidth, invHeight, null);
 
  Text.drawString(g, "> Rock item <", invListCenterX, invListCenterY, false, Color.WHITE, Assets.invFont);
  
 }

 //Инвентарь
 
 public void addItem(Item item) {
  for(Item i : inventoryItems) {
   if(i.getId() == item.getId()) {
    i.setCount(i.getCount() + item.getCount());
    return;
   }
  }
  inventoryItems.add(item);
 }
 
 //Геттеры и Сеттеры
 
 public Handler getHandler() {
  return handler;
 }

 public void setHandler(Handler handler) {
  this.handler = handler;
 }

 public boolean isActive() {
  return active;
 }

 public void setActive(boolean active) {
  this.active = active;
 }
 
}
