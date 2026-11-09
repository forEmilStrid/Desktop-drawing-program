package view;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ViewUtils {
  public static Icon iconFromPath(String path) {
    URL url = ViewUtils.class.getClassLoader().getResource(path);
    return new ImageIcon(url);
  }
}
