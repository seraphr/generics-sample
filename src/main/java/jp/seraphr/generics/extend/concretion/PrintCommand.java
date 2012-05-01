/**
 *
 */
package jp.seraphr.generics.extend.concretion;

import jp.seraphr.generics.extend.abstraction.Command;

/**
 *
 */
public class PrintCommand implements Command<PrintCommand> {
    public PrintCommand(String aMessage) {
        super();
        mMessage = aMessage;
    }

    private String mMessage;

    public PrintCommand execute() {
        System.out.println(mMessage);

        if(mMessage.contains("1"))
            return new PrintCommand(mMessage.replace('1', '2'));

        return null;
    }

    public String getMessage(){
        return mMessage;
    }

    public static PrintCommand fromMessage(String aMessage){
        return new PrintCommand(aMessage);
    }
}
