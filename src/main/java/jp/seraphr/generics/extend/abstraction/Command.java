package jp.seraphr.generics.extend.abstraction;

public interface Command<_C extends Command<_C>> {
    /**
     * コマンドを実行する。
     * 次に実行すべきコマンドが生成された場合、そのコマンドを返す。
     *
     * @return nullの場合、次のコマンドなし
     */
    public _C execute();
}
