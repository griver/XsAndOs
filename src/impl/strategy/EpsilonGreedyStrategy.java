package impl.strategy;

import game.ActionInfo;
import game.IGameAction;
import game.IGameState;
import player.IPlayer;
import strategy.ISelectionStrategy;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 02.01.13
 * Time: 6:34
 * To change this template use File | Settings | File Templates.
 */
public class EpsilonGreedyStrategy implements ISelectionStrategy {
    private static Random random = new Random();
    private int gamesPlayed = 0;
    private boolean isTemperature = false;
    private double tempFactor = 0.95;
    private double epsilon = 0.4;

    public EpsilonGreedyStrategy(double epsilon, boolean isTemperature) {
        if(epsilon >= 0 && epsilon <= 1)
            this.epsilon = epsilon;
    }

    @Override
    public IGameAction selectAction(List<IGameAction> actions, Map<IGameAction, Double> actionCost) {
        if(actions.size() == 0) return null;
        List<IGameAction> tmpActions  = new LinkedList<IGameAction>();
        double currCost, maxCost = safeGetCost(actions.get(0), actionCost);


        for(IGameAction action : actions){
            currCost = safeGetCost(action, actionCost);

            if(currCost > maxCost) maxCost = currCost;
        }

        double  val = random.nextDouble();
        boolean chooseFromMax = val > epsilon;

        for(IGameAction action : actions){
            currCost = safeGetCost(action, actionCost);

            if(chooseFromMax) {
                if(currCost >= maxCost)
                    tmpActions.add(action);
            } else {
                if(currCost <= maxCost)
                    tmpActions.add(action);
            }
        }
        if(tmpActions.size() == 0)  {
            System.out.println("Alert!");
        }

        return tmpActions.get(random.nextInt(tmpActions.size()));
    }

    private double safeGetCost( IGameAction action, Map<IGameAction, Double> actionCostMap) {
        if(actionCostMap.containsKey(action))
            return actionCostMap.get(action);
        return 0.0;
    }

    public void setTemperatureFactor(double value) {
        if(value > 1 || value <= 0 ) return;

    }

    @Override
    public void analizeGame(List<ActionInfo> gameLog, IPlayer winner, IPlayer player) {
        if(!isTemperature) return;

        ++gamesPlayed;
        gamesPlayed = gamesPlayed % 1000;

        if(gamesPlayed == 0)
            epsilon = Math.max(epsilon * tempFactor, 0.0);

    }
}
