package game;

import com.sun.java.swing.plaf.gtk.GTKConstants;
import player.IPlayer;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public interface IGameState extends Comparable<IGameState> {
    List<IGameAction> getAvailableActions(IPlayer player);
    StateType getType();
    String getStateId();

}
