package model;

public class EmptyCommand implements Command {

  @Override
  public void execute(Canvas canvas) {

  }

  @Override
  public void undo(Canvas canvas) {

  }

  @Override
  public boolean shouldStack() {
    return false;
  }
}
