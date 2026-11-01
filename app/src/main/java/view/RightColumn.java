package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class RightColumn extends JPanel {
  public RightColumn() {
    super(new BorderLayout());
    JColorChooser colorPicker = new JColorChooser(Color.BLACK);
    colorPicker.setPreviewPanel(new JPanel());
    add(colorPicker, BorderLayout.NORTH);
  }
}
