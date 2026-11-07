package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatDarkLaf; // or FlatLightLaf


import model.ChangeManager;
import model.PenTool;
import model.Tool;
import model.ToolController;
import model.ToolFactory;

public class Window {

  public static void main() {
    FlatDarkLaf.setup();

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Window(700, 700);
      }
    });
  }

  public Window(int width, int height) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());


    JMenuBar menuBar = new MenuBar();

    BufferedImage canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    ChangeManager changeManager = new ChangeManager(canvasImage, 10, 10);
    JPanel canvas = new CanvasPanel(canvasImage, changeManager);
    ToolController toolController = new ToolController(new PenTool(canvasImage, changeManager, canvas), canvas);
    ToolFactory toolFactory = new ToolFactory(canvasImage, changeManager, canvas);
    JColorChooser colorPicker = new JColorChooser(Color.BLACK);
    JSlider thicknesSlider = new JSlider(5, 100, 50);

    Tool pen = toolFactory.createTool("pen");
    Tool eraser = toolFactory.createTool("eraser");
    
    var penButton = new ToolButton(() -> {
      pen.setColor(colorPicker.getColor());
      pen.setThickness((float) thicknesSlider.getValue() / 10);
      toolController.setTool(pen);
      toolController.printTool();
    });
    penButton.setText("PEN");
    var eraserButton = new ToolButton(() -> {
      eraser.setThickness((float) thicknesSlider.getValue() / 10);
      toolController.setTool(eraser);
      toolController.printTool();
    });
    eraserButton.setText("ERASER");

    canvas.addMouseListener(toolController);
    canvas.addMouseMotionListener(toolController);
    canvas.addMouseWheelListener(toolController);

    thicknesSlider.addChangeListener(new ChangeListener() {

      @Override
      public void stateChanged(ChangeEvent e) {
        toolController.setThickness((float) thicknesSlider.getValue() / 10);
      }
      
    });

    colorPicker.getSelectionModel().addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        toolController.setColor(colorPicker.getColor());
      }
    });

    colorPicker.setPreviewPanel(new JPanel());


    ToolSettingsPanel rightColumn = new ToolSettingsPanel();
    ToolPanel leftColumn = new ToolPanel();

    rightColumn.add(colorPicker, BorderLayout.NORTH);
    rightColumn.add(thicknesSlider,BorderLayout.CENTER);
    leftColumn.addBtn(penButton);
    leftColumn.addBtn(eraserButton);
    frame.setContentPane(panel);
    frame.setJMenuBar(menuBar);
    panel.add(rightColumn, BorderLayout.EAST);
    panel.add(canvas, BorderLayout.CENTER);
    panel.add(leftColumn, BorderLayout.WEST);

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
