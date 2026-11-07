package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.ToolController;
import model.ToolFactory;

public class ToolPanel extends JPanel {

  private JPanel toolPicker = new ToolPicker();

  public ToolPanel() {
    super(new BorderLayout());
    add(toolPicker, BorderLayout.NORTH);
  }

  public void addBtn(JButton btn) {
    toolPicker.add(btn);
  }
}
