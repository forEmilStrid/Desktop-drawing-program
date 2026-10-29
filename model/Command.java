package model;

public interface Command {
  void execute(Canvas canvas);
  void undo(Canvas canvas);

  public default boolean shouldStack() {
    return true;
  }
}
