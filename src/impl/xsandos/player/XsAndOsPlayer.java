package impl.xsandos.player;

import player.IPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.12.12
 * Time: 4:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class XsAndOsPlayer implements IPlayer {
    private int id;
    @Override
    public void setPlayerId(int id) {
        this.id = id;
    }

    @Override
    public int getPlayerId() {
        return id;
    }
}
