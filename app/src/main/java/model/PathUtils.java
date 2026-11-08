package model;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class PathUtils {
  public static boolean isEmpty(Path2D path) {
    return path.getPathIterator(null).isDone();
  }

  public static Shape deepCopyShape(Shape shape) {
    if (shape == null) return null;

    Path2D pathCopy = new Path2D.Double();
    pathCopy.append(shape.getPathIterator(null), false);
    return pathCopy;
  }
}
