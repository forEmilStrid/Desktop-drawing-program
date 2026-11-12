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

public class Canvas {

  private BufferedImage canvas;
  private Graphics2D g;

  public Canvas(int width, int height) {
    canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    g = canvas.createGraphics();
  }

  public Canvas(BufferedImage image) {
    canvas = image;
    g = canvas.createGraphics();
  }

  public BufferedImage getImage() {
    return canvas;
  }

  public void fill(Color color) {
    g.setColor(color);
    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
  }

  public void clear() {
    fill(Color.WHITE);
  }


  public void overWriteCanvas(Canvas otherCanvas){
    g.drawImage(otherCanvas.getImage(), 0, 0, null);
  }

  public Canvas deepCopyCanvas() {
    BufferedImage b = new BufferedImage(canvas.getWidth(), canvas.getHeight(), canvas.getType());
    Graphics2D g = b.createGraphics();
    g.drawImage(canvas, 0, 0, null);
    g.dispose();
    return new Canvas(b);
  }

  public void drawLine(int startX, int startY, int endX, 
    int endY, Color color, Stroke brush) {
    g.setColor(color);
    g.setStroke(brush);
    g.drawLine(startX, startY, endX, endY);
  }

  public void drawLine(int startX, int startY, int endX, int endY, float width, Color color) {
    Stroke s = new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
    g.setStroke(s);
    g.setColor(color);
    g.drawLine(startX, startY, endX, endY);
  }

  public void drawDashedLine(int startX, int startY, int endX, int endY, int dashLength, float width, Color color) {
    Stroke dashed = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
    g.setStroke(dashed);
    g.setColor(color);
    g.drawLine(startX, startY, endX, endY);
  }

  public void drawShape(Path2D shape, Stroke brush, Color color) {
    g.setStroke(brush);
    g.setColor(color);
    g.draw(shape);
  }

  public void drawShape(Path2D shape, Color color) {
    g.setColor(color);
    g.draw(shape);
  }

  public void drawShape(Shape shape, Color color) {
    g.setColor(color);
    g.draw(shape);
  }

  public void drawImage(BufferedImage imageToDraw, int x, int y) {
    g.drawImage(imageToDraw, x, y, null);
  }

  //NOT DONE
  public void rotateAndDrawImage(BufferedImage imageToDraw, double theta, int x, int y) {
    Graphics2D g = imageToDraw.createGraphics();
    g.rotate(theta);
    drawImage(imageToDraw, x, y);
    g.dispose();
  }

  //NOT DONE
  public void scaleAndDrawImage(BufferedImage imageToDraw, double sx, double sy, int x, int y) {
    Graphics2D g = imageToDraw.createGraphics();
    g.scale(sx, sy);
    drawImage(imageToDraw, x, y);
    g.dispose();
  }


  public void drawSelectionBorder(Rectangle2D selection) {
    drawDashedLine((int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMinX(), (int) selection.getMinY(), 5, 0.5f, Color.GRAY);
    drawDashedLine((int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 5, 0.5f, Color.GRAY);
    drawDashedLine((int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 5, 0.5f, Color.GRAY);
    drawDashedLine((int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMinY(), 5, 0.5f, Color.GRAY);
  }

  public void drawSelectionBorder(int startX, int startY, int endX, int endY) {
    drawDashedLine(endX, startY, startX, startY, 5, 0.5f, Color.GRAY);
    drawDashedLine(endX, startY, endX, endY, 5, 0.5f, Color.GRAY);
    drawDashedLine(startX, endY, endX, endY, 5, 0.5f, Color.GRAY);
    drawDashedLine(startX, endY, startX, startY, 5, 0.5f, Color.GRAY);
  }

  public void drawSelectionDoneBorder(Rectangle2D selection) {
    drawLine((int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMinX(), (int) selection.getMinY(), 1.0f, Color.GRAY);
    drawLine((int) selection.getMaxX(), (int) selection.getMinY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 1.0f, Color.GRAY);
    drawLine((int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMaxX(), (int) selection.getMaxY(), 1.0f, Color.GRAY);
    drawLine((int) selection.getMinX(), (int) selection.getMaxY(), (int) selection.getMinX(), (int) selection.getMinY(), 1.0f, Color.GRAY);
  }

  public void drawSelectionDoneBorder(int startX, int startY, int endX, int endY) {
    drawLine(endX, startY, startX, startY, 1.0f, Color.GRAY);
    drawLine(endX, startY, endX, endY, 1.0f, Color.GRAY);
    drawLine(startX, endY, endX, endY, 1.0f, Color.GRAY);
    drawLine(startX, endY, startX, startY, 1.0f, Color.GRAY);
  }

}
