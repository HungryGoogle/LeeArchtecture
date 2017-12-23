package leeoberver.EventManager;

import java.util.HashMap;
import java.util.Map;

import leeoberver.event.BaseEvent;


/**
 * Created by Li on 2017/12/23.
 */

public class EventManager {

    // todo 这个是一个示例，一个事件只有一个处理者，后续事件处理者需要用一个集合存储，请自行完善
    Map<Class<?>, Watching> eventHandleMap;

    public Watching newWatching(Class<?> event) {
        if (eventHandleMap == null) {
            eventHandleMap = new HashMap<>();
        }

        Watching watch = new Watching();
        eventHandleMap.put(event, watch);
        return watch;
    }

    public void publishEvent(BaseEvent event) {
        // 通过event
        Watching watch = eventHandleMap.get(event.getClass());
        watch.observation.onEvent(event);
    }

    // 单例
    private static final EventManager ourInstance = new EventManager();

    public static EventManager getIns() {
        return ourInstance;
    }

    private EventManager() {

    }
}
