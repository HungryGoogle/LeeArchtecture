package leeoberver.observation.pattern;

import leeoberver.EventManager.IWatching;
import leeoberver.event.BaseEvent;

/**
 * 被观察者
 *
 * 其实对于event来说，也是一个观察者
 * EventManget 发布event给  ----》 BaseObservation  ----》 IObserver
 *
 * Created by Li on 2017/12/23.
 */

public abstract class BaseObservation<T> implements IObservation {
    IObserver mObserver = null; // 一个被观察者，只有一个观察者
    protected IWatching mWatching = null;

    protected void publishNotify(Object param) {
        if(mObserver != null){
            mObserver.handle(param);
        }
    }

    public void setObserver(IObserver observer) {
        this.mObserver = observer;
        mWatching.setObservation(this);
    }

    // 作为被观察者，收到事件（事件源头）
    public abstract void onEvent(BaseEvent event);

    @Override
    public void publishNotify() {
    }
}
