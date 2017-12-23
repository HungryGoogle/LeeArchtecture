package leeoberver.observation.pattern;

/**
 * Created by Li on 2017/12/23.
 */

public interface IObserver<T> {
    public void handle(T param);
}
