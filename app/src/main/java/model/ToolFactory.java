package model;

import java.awt.image.BufferedImage;

public class ToolFactory {

  BufferedImage canvas;
  ChangeManager changeManager;


  public ToolFactory(BufferedImage canvas, ChangeManager changeManager) {
    this.canvas = canvas;
    this.changeManager = changeManager;
  }

  public Tool createTool(String tool) {
    switch (tool) {
      case "pen": return new PenTool(canvas, changeManager);
      case "eraser": return new EraserTool(canvas, changeManager);
      default: return new PenTool(canvas, changeManager);
    }
  }
}
