package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Drawing {

  public static void fillCanvas(BufferedImage canvas, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setColor(color);
    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    g.dispose();
  }


  public static void overWriteCanvas(BufferedImage source, BufferedImage dest){
    Graphics2D g = dest.createGraphics();
    g.drawImage(source, 0, 0, null);
    g.dispose();
  }

  public static BufferedImage deepCopyCanvas(BufferedImage source){
    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
    Graphics2D g = b.createGraphics();
    g.drawImage(source, 0, 0, null);
    g.dispose();
    return b;
  }


}
