package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;

public class ChangeManager {
  private Deque<Command> undoStack = new ArrayDeque<>();
  private Deque<Command> redoStack = new ArrayDeque<>();
  private BufferedImage groundCanvas;
  private BufferedImage canvas;
  private int undoStackSize;
  private int redoStackSize;

  public ChangeManager(BufferedImage canvas, int undoStackSize, int redoStackSize) {
    this.canvas = canvas;
    groundCanvas = Drawing.deepCopyCanvas(canvas);
    this.undoStackSize = undoStackSize;
    this.redoStackSize = redoStackSize;
  }

  public void redraw() {
    Drawing.clearCanvas(canvas);
    Drawing.overWriteCanvas(groundCanvas, canvas);
    for (Command cmd : undoStack.reversed()) {
      cmd.execute(canvas);
    }
  }

  private void addToRedoStack(Command cmd) {
    redoStack.addFirst(cmd);

    if (redoStack.size() > redoStackSize) {
      redoStack.removeLast();
    }
  }

  private void addChange(Command command) {
    if (command.shouldStack()) {
      undoStack.addFirst(command);
    }
    else return;

    if (undoStack.size() > undoStackSize) {
      Command inActiveChange = undoStack.pollLast();
      inActiveChange.execute(groundCanvas);
    }
  }


  public void addNewChange(Command command) {
    addChange(command);
    redoStack = new ArrayDeque<>();
  }

  public void undo() {
    if (!undoStack.isEmpty()) {
      Command unDoneCommand = undoStack.pop();
      addToRedoStack(unDoneCommand);
      redraw();
    }
  }

  public void redo() {
    if (!redoStack.isEmpty()) {
      Command reDoneCommand = redoStack.pop();
      addChange(reDoneCommand);
      redraw();
    }
  }

  @Override
  public String toString() {
    return String.format("Undo Stack: %s Redo Stack: %s", undoStack.toString(), redoStack.toString());
  }
}
