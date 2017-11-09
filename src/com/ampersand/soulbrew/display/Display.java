package com.ampersand.soulbrew.display;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

 private JFrame frame;
 private String title;
 private int width, height;
 private Canvas canvas;
 private boolean fullscreen;

 public Display(String title, int width, int height, boolean fullscreen) {
  
  this.title = title;
  this.width = width;
  this.height = height;
  this.fullscreen = fullscreen;
 
  createDisplay();
  
 }

 private void createDisplay() {

 frame = new JFrame(title);
 
 frame.setSize(width, height);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 frame.setResizable(false);
 frame.setLocationRelativeTo(null);
 frame.setVisible(true);
 
 if(fullscreen) {
  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
  this.height = frame.getHeight();
  this.width = frame.getWidth();
 }
 
 canvas = new Canvas();
 canvas.setPreferredSize(new Dimension(width, height));
 canvas.setMaximumSize(new Dimension(width, height));
 canvas.setMinimumSize(new Dimension(width, height));
 canvas.setFocusable(false);
 frame.add(canvas);
 frame.pack();

 }
 
 public Canvas getCanvas() {
  return canvas;
 }

 public JFrame getFrame() {
  return frame;
 }
 
}
