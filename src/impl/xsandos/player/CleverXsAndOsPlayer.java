package impl.xsandos.player;

import game.IGameAction;
import game.IGameState;
import strategy.IGlobalStrategy;
import strategy.IStrategy;
import strategy.ISelectionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.12.12
 * Time: 5:41
 * To change this template use File | Settings | File Templates.
 */
public class CleverXsAndOsPlayer extends XsAndOsPlayer {
    static private Random random = new Random();
    private Map<IGameAction, Double> actionCost = new HashMap<IGameAction, Double>();

    private IGlobalStrategy strategy;
    private ISelectionStrategy selectionStrategy;


    public CleverXsAndOsPlayer(IGlobalStrategy strategy, ISelectionStrategy selectionStrategy) {
        this.strategy = strategy;
        this.selectionStrategy = selectionStrategy;
    }

    @Override
    public IGameAction chooseAction(IGameState state) {
        return selectionStrategy.selectAction(state.getAvailableActions(this), strategy.getActionCostMap());
    }

    public void setStrategy(IGlobalStrategy strategy) {
        this.strategy = strategy;
    }

    public void setSelectionStrategy(ISelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }
}
