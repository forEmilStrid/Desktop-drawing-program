package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
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

  public static void drawLine(BufferedImage canvas, int startX, int startY, int endX, int endY, float width, Color color) {
    Graphics2D g = canvas.createGraphics();
    Stroke s = new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
    g.setStroke(s);
    g.setColor(color);
    g.drawLine(startX, startY, endX, endY);
    g.dispose();
  }

  public static void drawDashedLine(BufferedImage canvas, int startX, int startY, int endX, int endY, int dashLength, float width, Color color) {
    Graphics2D g = canvas.createGraphics();
    Stroke dashed = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g.setStroke(dashed);
    g.setColor(color);
    g.drawLine(startX, startY, endX, endY);
    g.dispose();
  }

  public static void drawShape(BufferedImage canvas, Path2D shape, Stroke brush, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setStroke(brush);
    g.setColor(color);
    g.draw(shape);
    g.dispose();
  }

  public static void drawShape(BufferedImage canvas, Path2D shape, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setColor(color);
    g.draw(shape);
    g.dispose();
  }

  public static void drawShape(BufferedImage canvas, Shape shape, Color color) {
    Graphics2D g = canvas.createGraphics();
    g.setColor(color);
    g.draw(shape);
    g.dispose();
  }

  public static void drawImage(BufferedImage canvas, BufferedImage imageToDraw, int x, int y) {
    Graphics2D g = canvas.createGraphics();
    g.drawImage(imageToDraw, x, y, null);
    g.dispose();
  }

  public static void rotateAndDrawImage(BufferedImage canvas, BufferedImage imageToDraw, double theta, int x, int y) {
    Graphics2D g = imageToDraw.createGraphics();
    g.rotate(theta);
    drawImage(canvas, imageToDraw, x, y);
    g.dispose();
  }

  public static void scaleAndDrawImage(BufferedImage canvas, BufferedImage imageToDraw, double sx, double sy, int x, int y) {
    Graphics2D g = imageToDraw.createGraphics();
    g.scale(sx, sy);
    drawImage(canvas, imageToDraw, x, y);
    g.dispose();
  }


  public static void drawSelectionBorder(BufferedImage canvas, Rectangle2D selection) {
    Drawing.drawDashedLine(canvas, (int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMinX(), (int) selection.getMinY(), 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, (int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, (int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, (int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMinY(), 5, 0.5f, Color.GRAY);
  }

  public static void drawSelectionBorder(BufferedImage canvas, int startX, int startY, int endX, int endY) {
    Drawing.drawDashedLine(canvas, endX, startY, startX, startY, 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, endX, startY, endX, endY, 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, startX, endY, endX, endY, 5, 0.5f, Color.GRAY);
    Drawing.drawDashedLine(canvas, startX, endY, startX, startY, 5, 0.5f, Color.GRAY);
  }

  public static void drawSelectionDoneBorder(BufferedImage canvas, Rectangle2D selection) {
    Drawing.drawLine(canvas, (int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMinX(), (int) selection.getMinY(), 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, (int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, (int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, (int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMinY(), 1.0f, Color.GRAY);
  }

  public static void drawSelectionDoneBorder(BufferedImage canvas, int startX, int startY, int endX, int endY) {
    Drawing.drawLine(canvas, endX, startY, startX, startY, 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, endX, startY, endX, endY, 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, startX, endY, endX, endY, 1.0f, Color.GRAY);
    Drawing.drawLine(canvas, startX, endY, startX, startY, 1.0f, Color.GRAY);
  }

}
