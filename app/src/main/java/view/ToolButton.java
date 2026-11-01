package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ToolButton extends JButton implements MouseListener {

  ChooseTool chooseTool;

  public ToolButton(ChooseTool chooseTool) {
    this.chooseTool = chooseTool;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    chooseTool.chooseTool();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    chooseTool.chooseTool();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    chooseTool.chooseTool();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
  }
}
