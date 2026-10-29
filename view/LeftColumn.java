package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LeftColumn extends JPanel {
  public LeftColumn() {
    setLayout(new BorderLayout());
    ToolPicker toolPicker = new ToolPicker();
    add(toolPicker, SwingConstants.TOP);
  }
}
