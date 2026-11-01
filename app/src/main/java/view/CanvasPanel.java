package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.*;


public class CanvasPanel extends JPanel {

  BufferedImage canvas;
  ChangeManager changeManager;
  ToolController toolController;


  public CanvasPanel(BufferedImage canvas, ChangeManager changeManager) {
    this.canvas = canvas;
    this.changeManager = changeManager;
    toolController = new ToolController(new PenTool(canvas, changeManager), Color.BLACK, this);
    addMouseListener(toolController);
    addMouseMotionListener(toolController);
    addMouseWheelListener(toolController);

    setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
    var g = canvas.createGraphics();
    g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    g.dispose();

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(canvas, 0, 0, this);
  }

}
