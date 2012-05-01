package jp.seraphr.generics.extend.abstraction;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AbstractCommandRunner<_Command extends Command<_Command>> {
    public AbstractCommandRunner(CommandQueue<_Command> aQueue, CommandSerializer<_Command> aSerializer) {
        super();
        mQueue = aQueue;
        mSerializer = aSerializer;
    }

    private CommandQueue<_Command> mQueue;
    private CommandSerializer<_Command> mSerializer;

    public void runOnce() {
        if (!mQueue.isEmpty())
            return;

        OutputStream tStream = null;
        try {
            tStream = new FileOutputStream(new File("aa.obj"));
            _Command tCommand = mQueue.dequeue();
            mSerializer.encode(tCommand, tStream);

            _Command tNewCommand = tCommand.execute();
            if (tNewCommand != null) {
                mQueue.enqueue(tNewCommand);
            }
        } catch (Exception tE) {
            throw new RuntimeException(tE);
        } finally {
            if (tStream != null) {
                try {
                    tStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
