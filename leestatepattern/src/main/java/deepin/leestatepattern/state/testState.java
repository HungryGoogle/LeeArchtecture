package deepin.leestatepattern.state;

/**
 * Created by li on 2017/9/28.
 */

public class testState {
    public static void main(String agrs[]){
        StateContext stateContext = new StateContext();
        stateContext.handle("1");
        stateContext.handle("2");
        stateContext.handle("3");
        stateContext.handle("4");
    }
}
