package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Drawing {

  public static void fillCanvas(BufferedImage canvas, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setColor(color);
    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    g.dispose();
  }

  public static void clearCanvas(BufferedImage canvas) {
    fillCanvas(canvas, Color.WHITE);
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

  public static void drawSelectionBorder(BufferedImage canvas, Rectangle2D selection) {
    Drawing.drawDashedLine(canvas, (int) selection.getMinX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMinY(), 5);
    Drawing.drawDashedLine(canvas, (int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 5);
    Drawing.drawDashedLine(canvas, (int) selection.getMaxX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMaxY(), 5);
    Drawing.drawDashedLine(canvas, (int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMinY(), 5);
  }

public static void drawSelectionBorder(BufferedImage canvas, int startX, int startY, int endX, int endY) {
    Drawing.drawDashedLine(canvas, startX, startY, endX, startY, 5);
    Drawing.drawDashedLine(canvas, endX, startY, endX, endY, 5);
    Drawing.drawDashedLine(canvas, endX, endY, startX, endY, 5);
    Drawing.drawDashedLine(canvas, startX, endY, startX, startY, 5);
  }

  public static void drawDashedLine(BufferedImage canvas, int startX, int startY, int endX, int endY, int dashLength) {
    Graphics2D g = canvas.createGraphics();
    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g.setStroke(dashed);
    g.setColor(Color.GRAY);
    g.drawLine(startX, startY, endX, endY);
    g.dispose();
  }

}
