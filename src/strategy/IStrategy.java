package strategy;

import game.ActionInfo;
import game.IGameAction;
import player.IPlayer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 02.01.13
 * Time: 7:04
 * To change this template use File | Settings | File Templates.
 */
public interface IStrategy {
    void analizeGame(List<ActionInfo> gameLog, IPlayer winner, IPlayer player);
}
