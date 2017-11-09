package com.ampersand.soulbrew.states;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.gfx.Animation;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.ui.ClickListener;
import com.ampersand.soulbrew.ui.UIImageButton;
import com.ampersand.soulbrew.ui.UIManager;
import com.ampersand.soulbrew.utils.GameMath;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuState extends State {

 private UIManager uiManager;
 private Color frgYellow = new Color(255, 216, 133);
 private Color bckYellow = new Color(226, 174, 118);
 int x, y;
 int counter;
 private Animation oulRift;
 
 public MenuState(Handler handler) {
  super(handler);
  uiManager = new UIManager(handler);
  handler.getMouseManager().setUIManager(uiManager);
  

  uiManager.addObject(new UIImageButton(20, handler.getHeight()/2, 200, 50, Assets.btn_start, new ClickListener(){
      @Override
      public void onClick() {
       handler.getMouseManager().setUIManager(null);
       State.setState(handler.getGame().gameState);
      }
  }));
  uiManager.addObject(new UIImageButton(20, handler.getHeight()/2 + 51, 200, 50, Assets.btn_start, new ClickListener(){
      @Override
      public void onClick() {
       handler.getMouseManager().setUIManager(null);
       State.setState(handler.getGame().gameState);
      }
  }));
  uiManager.addObject(new UIImageButton(20, handler.getHeight()/2 + 102, 200, 50, Assets.btn_start, new ClickListener(){
      @Override
      public void onClick() {
       handler.getMouseManager().setUIManager(null);
       State.setState(handler.getGame().gameState);
      }
  }));
  
  oulRift = new Animation(60, Assets.oulRift);
  
  }
 
 public void tick() {
  uiManager.tick();
  oulRift.tick();
  
  counter++;
  
  x = (int)(Math.cos(Math.toRadians(counter))*10+handler.getWidth()/2-1024/2);
  y = (int)(Math.sin(Math.toRadians(counter))*10+handler.getHeight()/2-641/2);
  
  if(counter > 360)
   counter = 0;
  
  /*
  handler.getMouseManager().setUIManager(null);
  State.setState(handler.getGame().gameState);
  */
 }

 public void render(Graphics g) {

  g.drawImage(Assets.backgroundMenu, x, y, null);
  uiManager.render(g);
  
  g.setColor(frgYellow);
  g.fillRect(0, 0, handler.getWidth(), 10);
  
  g.setColor(bckYellow);
  g.fillRect(0, 10, handler.getWidth(), 10);
  
  g.setColor(frgYellow);
  g.fillRect(0, handler.getHeight()-20, handler.getWidth(), 10);
  
  g.setColor(bckYellow);
  g.fillRect(0, handler.getHeight()-10, handler.getWidth(), 10);
  
  g.setColor(frgYellow);
  g.fillRect(0, 0, 10, handler.getHeight()-10);
  
  g.setColor(frgYellow);
  g.fillRect(handler.getWidth()-10, 0, 10, handler.getHeight()-10);
  g.drawImage(oulRift.getCurrentFrame(), -30, handler.getHeight()/2-250, 300, 300, null);
  
  g.setColor(Color.black);
  
  /* 
  g.setColor(Color.red);
  g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
  */
 }
 
 
 
}
