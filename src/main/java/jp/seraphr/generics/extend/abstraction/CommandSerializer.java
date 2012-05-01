package jp.seraphr.generics.extend.abstraction;

import java.io.InputStream;
import java.io.OutputStream;

public interface CommandSerializer<_Command extends Command<_Command>> {
    public void encode(_Command aCommand, OutputStream aStream);
    public _Command decode(InputStream aStream);
}
