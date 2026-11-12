package model;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class CanvasTool implements Tool {
  protected Canvas canvas;
  protected ChangeManager changeManager;
  protected JPanel canvasPanel;

  public CanvasTool(Canvas canvas, ChangeManager changeManager, JPanel canvasPanel) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    this.canvasPanel = canvasPanel;
  }

}
