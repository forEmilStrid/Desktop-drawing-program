package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RightColumn extends JPanel {
  public RightColumn() {
    setLayout(new BorderLayout());
    ToolPicker toolPicker = new ToolPicker();
    add(toolPicker, SwingConstants.TOP);
  }
}
