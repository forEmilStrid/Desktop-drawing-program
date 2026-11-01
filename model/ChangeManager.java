package model;

import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;

public class ChangeManager {
  private Deque<Command> undoStack = new ArrayDeque<>();
  private Deque<Command> redoStack = new ArrayDeque<>();
  private BufferedImage canvas;
  private int undoStackSize;
  private int redoStackSize;

  public ChangeManager(BufferedImage canvas, int undoStackSize, int redoStackSize) {
    this.canvas = canvas;
    this.undoStackSize = undoStackSize;
    this.redoStackSize = redoStackSize;
  }
  
  private void redraw() {
    for (Command cmd : undoStack.reversed()) {
      cmd.execute(canvas);
    }
  }

  private void addToRedoStack(Command cmd) {
    redoStack.add(cmd);

    if (undoStack.size() > redoStackSize) {
      undoStack.removeLast();
    }
  }

  public void addChange(Command command) {
    undoStack.add(command);

    if (undoStack.size() > undoStackSize) {
      undoStack.removeLast();
    }

    redoStack = new ArrayDeque<>();
  }

  public void undo() {
    Command unDoneCommand = undoStack.pop();
    addToRedoStack(unDoneCommand);
    redraw();
  }

  public void redo() {
    Command reDoneCommand = redoStack.pop();
    addChange(reDoneCommand);
    redraw();
  }
}
