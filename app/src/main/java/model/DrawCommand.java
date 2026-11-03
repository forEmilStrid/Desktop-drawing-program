package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawCommand implements Command {
  private List<Point> data;
  Color color;
  Tool tool;
  float thickness;

  public DrawCommand(List<Point> data, Color color, Tool tool, float thickness) {
    this.data = data;
    this.color = color;
    this.tool = tool;
    this.thickness = thickness;
  }

  @Override
  public void execute(BufferedImage canvas) {
    Graphics2D graphics = canvas.createGraphics();
    graphics.setStroke(new BasicStroke(thickness));

    Point prevPoint = data.getFirst();
    for (int i = 1; i < data.size(); i++) {
      Point currPoint = data.get(i);
      graphics.drawLine(prevPoint.x(), prevPoint.y(), currPoint.x(), currPoint.y());
    }
    graphics.dispose();
  }

  @Override
  public void undo(BufferedImage canvas) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }

}
