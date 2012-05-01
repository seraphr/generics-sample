package jp.seraphr.generics.extend.abstraction;

public interface CommandQueue<_Command extends Command<_Command>> {
    public void enqueue(_Command aCommand);
    public _Command dequeue();
    public boolean isEmpty();
}
