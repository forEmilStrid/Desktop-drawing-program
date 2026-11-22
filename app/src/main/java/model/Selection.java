package model;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class Selection {
  protected Rectangle selBounds;
  protected Shape selection;
  protected Shape orgSelection;
  protected Canvas canvas;
  protected ChangeManager changeManager;

  public Selection(Canvas canvas, ChangeManager changeManager, Shape selection) {
    selBounds = selection.getBounds();
    orgSelection = PathUtils.deepCopyShape(selection);
    this.selection = selection;
    this.canvas = canvas;
    this.changeManager = changeManager;

    canvas.drawSelectionBorder(selection);
    canvas.setClip(selection);
  }

}
