package model;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class Selection implements Tool {
  private Rectangle selBounds;
  private Shape selection;
  private Shape orgSelection;
  private Canvas canvas;
  private ChangeManager changeManager;

  public Selection(Canvas canvas, ChangeManager changeManager, Shape selection) {
    selBounds = selection.getBounds();
    orgSelection = PathUtils.deepCopyShape(selection);
    this.selection = selection;
    this.canvas = canvas;
    this.changeManager = changeManager;
  }



}
