package model;

import java.awt.geom.Path2D;

public class PathUtils {
  public static boolean isEmpty(Path2D path) {
    return path.getPathIterator(null).isDone();
  }
}
