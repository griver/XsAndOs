package impl.strategy;

import game.ActionInfo;
import game.IGameAction;
import player.IPlayer;
import strategy.IGlobalStrategy;
import strategy.IStrategy;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 02.01.13
 * Time: 7:23
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStrategy implements IGlobalStrategy {

    private Map<IGameAction, Double> actionCost = new HashMap<IGameAction, Double>();
    public SimpleStrategy() {

    }

    @Override
    public Map<IGameAction, Double> getActionCostMap() {
        return actionCost;
    }

    @Override
    public void analizeGame(List<ActionInfo> log, IPlayer winner, IPlayer player) {
        double  oldVal, profit = winner == player ? 0.1 : (-0.1);

        for(ActionInfo info : log) {
            if(info.player == player) {
                if(actionCost.containsKey(info.action))
                    oldVal = actionCost.get(info.action);
                else
                    oldVal = 0;
                actionCost.put(info.action, oldVal + profit);
            }
        }


    }


}
