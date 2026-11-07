package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Path2D;
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

  public static void drawLine(BufferedImage canvas, int startX, int startY, int endX, 
    int endY, Color color, Stroke brush) {
    Graphics2D graphics = canvas.createGraphics();
    graphics.setColor(color);
    graphics.setStroke(brush);
    graphics.drawLine(startX, startY, endX, endY);
    graphics.dispose();
  }

  public static void drawShape(BufferedImage canvas, Path2D shape, Stroke brush, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setStroke(brush);
    g.setColor(color);
    g.draw(shape);
    g.dispose();
  }

}
