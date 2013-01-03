package impl.xsandos.game;

import game.IGameAction;
import game.IGameState;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 28.12.12
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class XsAndOsAction implements IGameAction {
    private IGameState sourceState;
    private IGameState targetState;
    private int playerId;

    public XsAndOsAction(IGameState sourceState, IGameState targetState, int playerId) {
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.playerId = playerId;
    }

    @Override
    public IGameState getSourceState() {
        return sourceState;
    }

    @Override
    public IGameState getTargetState() {
        return targetState;
    }

    public int getPlayerId() {
        return playerId;
    }
}
