package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class DrawCommand implements Command {
  private Path2D data;
  private Color color;
  private Stroke brush;

  public DrawCommand(Path2D data, Color color, Stroke brush) {
    this.data = data;
    this.color = color;
    this.brush = brush;
  }

  @Override
  public void execute(BufferedImage canvas) {
    Drawing.drawShape(canvas, data, brush, color);
  }

}
