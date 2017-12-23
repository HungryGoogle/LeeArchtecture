package leeoberver.EventManager;


import leeoberver.observation.pattern.BaseObservation;

/**
 * Created by Li on 2017/12/23.
 */

public class Watching implements IWatching {
    BaseObservation observation;

    @Override
    public void setObservation(BaseObservation baseObservation) {
        observation = baseObservation;
    }
}
