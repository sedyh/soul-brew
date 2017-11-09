package com.ampersand.soulbrew.utils;

public class GameMath {
 
 public static int pointDist(int a1, int a2, int b1, int b2) {
  return (int) Math.sqrt( (b1 - a1)*(b1 - a1) + (b2 - a2)*(b2 - a2) );
 }
 
 public static int rnd(int min, int max) {
  max -= min;
  return (int) (Math.random() * ++max) + min;
 }
 
}
