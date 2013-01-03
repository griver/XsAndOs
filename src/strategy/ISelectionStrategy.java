package strategy;

import game.IGameAction;
import game.IGameState;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 02.01.13
 * Time: 6:28
 * To change this template use File | Settings | File Templates.
 */
public interface ISelectionStrategy extends IStrategy {
    IGameAction selectAction(List<IGameAction> actions, Map<IGameAction, Double> actionCost);
}
