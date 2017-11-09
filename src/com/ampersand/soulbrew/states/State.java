package com.ampersand.soulbrew.states;

import com.ampersand.soulbrew.Game;
import com.ampersand.soulbrew.Handler;
import java.awt.Graphics;

public abstract class State {
 
 private static State currentState = null;
 
 protected Handler handler;
 
 public State(Handler handler) {
  this.handler = handler;
 }
 
 public static void setState(State state) {
  currentState = state;
 }
 
 public static State getState() {
  return currentState;
 }
 
 public abstract void tick();
 
 public abstract void render(Graphics g);
 
}
