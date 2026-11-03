package model;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class EraserTool implements Tool {
  private BufferedImage canvas;
  private ChangeManager changeManager;
  private JPanel canvasPanel;

  public EraserTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }


  @Override
  public String toString() {
    return "ERASER";
  }
}
