package impl.xsandos.player;

import game.IGameAction;
import game.IGameState;
import game.StateType;
import player.IPlayer;

import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.12.12
 * Time: 4:56
 * To change this template use File | Settings | File Templates.
 */
public class RandomXsAndOsPlayer extends XsAndOsPlayer{
    private static Random random = new Random();
    @Override
    public IGameAction chooseAction(IGameState state) {
        List<IGameAction> actions = state.getAvailableActions(this);

        for(IGameAction action : actions)
            if(action.getTargetState().getType() == StateType.FINAL)
                return action;
        if(actions.size() == 0) {
            System.out.println("State:");
            System.out.println(state.toString());
            System.out.println(" Player : " + this.getPlayerId());
        }

        int next = random.nextInt(actions.size());
        return actions.get(next);
    }
}
