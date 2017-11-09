package com.ampersand.soulbrew.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontLoader {
 
 public static Font loadFont(String path, float size) {
  try {
   return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
  } catch (FontFormatException e) {
   System.out.print("1");
   e.printStackTrace();
  } catch (IOException e) {
   System.out.print("2");
   e.printStackTrace();
  }
  return null;
 }
}
