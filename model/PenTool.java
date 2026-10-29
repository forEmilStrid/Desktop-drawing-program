package model;

import java.awt.Color;

public class PenTool extends Tool {
  public PenTool(Canvas canvas) {
    super(
      (c, x, y) -> c.setPixel(x, y, Color.BLACK), 
      (c, x, y) -> c.setPixel(x, y, Color.BLACK), 
      m -> new DrawCommand(m));
  }
}
