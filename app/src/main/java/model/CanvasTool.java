package model;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CanvasTool implements Tool {
  protected BufferedImage canvas;
  protected ChangeManager changeManager;
  protected JPanel canvasPanel;

  public CanvasTool(BufferedImage canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }

}
