package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ToolFactory {

  BufferedImage canvas;
  ChangeManager changeManager;
  JPanel canvasPanel;
  ToolController toolController;


  public ToolFactory(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel, ToolController toolController) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
    this.toolController = toolController;
  }

  public Tool createTool(String tool, float thickness, Color color) {
    switch (tool) {
      case "pen": {
        var pen = new PenTool(canvas, changeManager, canvasPanel); 
        pen.setThickness(thickness);
        pen.setColor(color);
        return pen;
      }
      case "eraser": {
        var eraser = new EraserTool(canvas, changeManager, canvasPanel);
        eraser.setThickness(thickness);
        return eraser;
      }
      default: return new PenTool(canvas, changeManager, canvasPanel);
    }
  }

  public Tool createTool(String tool, float thickness) {
    switch (tool) {
      case "pen": {
        var pen = new PenTool(canvas, changeManager, canvasPanel); 
        pen.setThickness(thickness);
        return pen;
      }
      case "eraser": {
        var eraser = new EraserTool(canvas, changeManager, canvasPanel);
        eraser.setThickness(thickness);
        return eraser;
      }
      default: return new PenTool(canvas, changeManager, canvasPanel);
    }
  }

  public Tool createTool(String tool) {
    switch (tool) {
      case "pen": {
        return new PenTool(canvas, changeManager, canvasPanel);
      }
      case "eraser": {
        return new EraserTool(canvas, changeManager, canvasPanel);
      }
      case "recSelector": {
        return new RectangleSelectionTool(canvas, changeManager, canvasPanel, toolController);
      }
      default: return new PenTool(canvas, changeManager, canvasPanel);
    }
  }
}
