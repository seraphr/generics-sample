/**
 *
 */
package jp.seraphr.generics.extend.concretion;

import java.util.LinkedList;
import java.util.Queue;

import jp.seraphr.generics.extend.abstraction.CommandQueue;

/**
 *
 */
public class PrintCommandQueue implements CommandQueue<PrintCommand> {
    private Queue<String> mInnerQueue = new LinkedList<String>();

    public void enqueue(PrintCommand aCommand) {
        mInnerQueue.add(aCommand.getMessage());
    }

    public PrintCommand dequeue() {
        return PrintCommand.fromMessage(mInnerQueue.poll());
    }

    public boolean isEmpty() {
        return mInnerQueue.isEmpty();
    }
}
