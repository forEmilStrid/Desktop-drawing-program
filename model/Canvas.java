package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Canvas {
  private BufferedImage canvas;

  public Canvas(int width, int height) {
    canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
  }

  public void setPixel(int x, int y, Color c) {
    canvas.setRGB(x, y, c.getRGB());
  }
}
