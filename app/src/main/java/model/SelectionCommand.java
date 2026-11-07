package model;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

public class SelectionCommand implements Command {

  private Shape data;

  public SelectionCommand(Shape data) {
    this.data = data;
  }

  @Override
  public void execute(BufferedImage canvas) {
    
  }



}
