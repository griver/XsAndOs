package player;

import game.IGameAction;
import game.IGameState;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public interface IPlayer {
    IGameAction chooseAction(IGameState state);
    void setPlayerId(int id);
    int getPlayerId();
}
