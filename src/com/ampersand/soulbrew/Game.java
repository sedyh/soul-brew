package com.ampersand.soulbrew;
import com.ampersand.soulbrew.display.Display;
import com.ampersand.soulbrew.gfx.Assets;
import com.ampersand.soulbrew.gfx.GameCamera;
import com.ampersand.soulbrew.input.KeyManager;
import com.ampersand.soulbrew.input.MouseManager;
import com.ampersand.soulbrew.states.GameState;
import com.ampersand.soulbrew.states.MenuState;
import com.ampersand.soulbrew.states.State;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable {
 
 private int width, height;
 public String title;
 private boolean fullscreen;
 
 private Display display;
 
 private Thread thread;
 private boolean running = false;
 
 BufferStrategy bs;
 Graphics g;
 
 // Состояния
 public State gameState;
 public State menuState;
 //Ввод
 private KeyManager keyManager;
 private MouseManager mouseManager;
 //Камера
 private GameCamera gameCamera;
 //Обработчик
 private Handler handler;
 
 public Game(String title, int width, int height, boolean fullscreen) {
  
  this.width = width;
  this.height = height;
  this.title = title;
  this.fullscreen = fullscreen;
  
  keyManager = new KeyManager();
  mouseManager = new MouseManager();
  
 }
 
 private void init() {
  
  display = new Display(title, width, height, fullscreen);
  
  if(fullscreen) {
   this.height = display.getFrame().getHeight();
   this.width = display.getFrame().getWidth();
  } 
	  
  display.getFrame().addKeyListener(keyManager);
  
  display.getFrame().addMouseListener(mouseManager);
  display.getFrame().addMouseMotionListener(mouseManager);
  display.getCanvas().addMouseListener(mouseManager);
  display.getCanvas().addMouseMotionListener(mouseManager);
  
  Assets.init();
  
  handler = new Handler(this);
  
  gameCamera = new GameCamera(handler, 0, 0);
  
  gameState = new GameState(handler);
  menuState = new MenuState(handler);
  State.setState(menuState);
 
 }
 
 private void tick() {
  
  keyManager.tick();
  
  if(State.getState() != null) {
   State.getState().tick();
  }
  
 }
 
 public void render() {
  
  bs = display.getCanvas().getBufferStrategy();
  
  if(bs == null) {
   display.getCanvas().createBufferStrategy(3);
   return;
  }
  
  g = bs.getDrawGraphics();
  //Отчистить экран
  g.clearRect(0, 0, width, height);
  //Начать отрисовку
  
  if(State.getState() != null) {
   State.getState().render(g);
  }
 
  //Закончить отрисовку
  bs.show();
  g.dispose();
  
 }
 
 public void run() {
  
  init();
  
  int fps = 60;
  double timePerTick = 1000000000/fps;
  double delta = 0;
  long now;
  long lastTime = System.nanoTime();
  long timer = 0;
  int ticks = 0;
  
  while (running) {
   
   now = System.nanoTime();
   delta += (now - lastTime) / timePerTick;
   timer = now - lastTime;
   lastTime = now;
   
   
   if(delta >= 1) {
    tick();
    render();
    ticks++;
    delta--;
   }
   
   if(timer >= 1000000000) {
    ticks = 0;
    timer = 0;
   }
   
  }
  
  stop();
  
 }
 
 public KeyManager getKeyManager() {
  return keyManager;
 }
 
 public MouseManager getMouseManager() {
  return mouseManager;
 }
 
  public GameCamera getGameCamera() {
  return gameCamera;
 }
  
  public int getWidth() {
   return width;
  }
  
  public int getHeight() {
   return height;
  }
 
 public synchronized void start() {
  
  if(running)
   return;
  
  running = true;
  thread = new Thread(this);
  thread.start();
  
 } 
 
 public synchronized void stop() {
  
  if(!running)
   return;
  
  running = false;
  try {
   thread.join();
  } catch (InterruptedException ex) {
   Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
  }
  
 } 
 
}
