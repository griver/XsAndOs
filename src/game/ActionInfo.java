package game;

import player.IPlayer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class ActionInfo {

    public ActionInfo(final IGameAction action, IPlayer player) {
        this.action = action;
        this.player = player;
    }

    public final IGameAction action;

    public final IPlayer player;


}
