package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.List;

public class DrawCommand implements Command {
  private List<Point> data;
  Color color;
  Stroke brush;
  float thickness;

  public DrawCommand(List<Point> data, Color color, Stroke brush) {
    this.data = data;
    this.color = color;
    this.brush = brush;
  }

  @Override
  public void execute(BufferedImage canvas) {
    Point prevPoint = data.getFirst();

    Graphics2D graphics = canvas.createGraphics();
    
    graphics.setColor(color);
    graphics.setStroke(brush);

    
    for (int i = 1; i < data.size(); i++) {
      Point currPoint = data.get(i);
      graphics.drawLine(prevPoint.x(), prevPoint.y(), currPoint.x(), currPoint.y());
      prevPoint = currPoint;
    }
    graphics.dispose();
  }

  @Override
  public void undo(BufferedImage canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }

}
