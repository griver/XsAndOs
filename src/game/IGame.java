package game;

import player.IPlayer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public interface IGame {
    public void play(IPlayer player1, IPlayer player2);

    public IPlayer getLastWinner();

    public List<ActionInfo> getLastGameLog();
}
