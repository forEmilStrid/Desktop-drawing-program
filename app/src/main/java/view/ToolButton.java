package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ToolButton extends JButton {

  ChooseTool chooseTool;

  public ToolButton(ChooseTool chooseTool) {
    this.chooseTool = chooseTool;
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        chooseTool.chooseTool();
      }
    });
  }
}
