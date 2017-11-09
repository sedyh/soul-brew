package com.ampersand.soulbrew.entities.statics;

import com.ampersand.soulbrew.Handler;
import com.ampersand.soulbrew.entities.Entity;

public abstract class StaticEntity extends Entity {
 
 public StaticEntity(Handler handler, float x, float y, int width, int height) {
  super(handler, x, y, width, height);
 }
 
}
