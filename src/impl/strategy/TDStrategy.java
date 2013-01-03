package impl.strategy;

import game.ActionInfo;
import game.IGameAction;
import player.IPlayer;
import strategy.IGlobalStrategy;
import sun.org.mozilla.javascript.tools.shell.Global;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 03.01.13
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 */
public class TDStrategy implements IGlobalStrategy {
    private Map<IGameAction, Double> actionCost = new HashMap<IGameAction, Double>();
    private double tdFactor = 0.5;

    public TDStrategy() { }

    public TDStrategy(double tdFactor) {
        if(tdFactor > 0 && tdFactor < 1)
        this.tdFactor = tdFactor;
    }

    @Override
    public Map<IGameAction, Double> getActionCostMap() {
        return actionCost;
    }

    @Override
    public void analizeGame(List<ActionInfo> gameLog, IPlayer winner, IPlayer player) {
        boolean hasNext = false;
        double currCost, nextCost = 0;
        double prise = winner == player ? 1.0 : 0.0;
        ActionInfo info;

        for(int i = gameLog.size() - 1; i >= 0; --i) {
            info = gameLog.get(i);
            if(info.player == player){
                if(hasNext == false){
                    nextCost = prise;
                    hasNext = true;

                } else {
                    currCost = safeGetCost(info.action);
                    nextCost = currCost + tdFactor * (nextCost - currCost);
                }

                actionCost.put(info.action, nextCost);

            }
        }
    }

    private double safeGetCost( IGameAction action) {
        if(actionCost.containsKey(action))
            return actionCost.get(action);
        return 0.0;
    }
}
