package game;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 28.12.12
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public interface IStateGraphBuilder {
    List<IGameState> buildStateGraph();
    IGameState getInitialState();
}
