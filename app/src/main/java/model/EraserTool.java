package model;

import java.awt.image.BufferedImage;

public class EraserTool implements Tool {
  private BufferedImage canvas;
  private ChangeManager changeManager;

  public EraserTool(BufferedImage canvas, ChangeManager changeManager) {
    this.canvas = canvas;
    this.changeManager = changeManager;
  }


  @Override
  public String toString() {
    return "ERASER";
  }
}
