package strategy;

import game.IGameAction;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 03.01.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public interface IGlobalStrategy extends IStrategy {
    Map<IGameAction, Double> getActionCostMap();
}
