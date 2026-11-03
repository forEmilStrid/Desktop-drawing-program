package model;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ToolFactory {

  BufferedImage canvas;
  ChangeManager changeManager;
  JPanel canvasPanel;


  public ToolFactory(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }

  public Tool createTool(String tool) {
    switch (tool) {
      case "pen": return new PenTool(canvas, changeManager, canvasPanel);
      case "eraser": return new EraserTool(canvas, changeManager, canvasPanel);
      default: return new PenTool(canvas, changeManager, canvasPanel);
    }
  }
}
