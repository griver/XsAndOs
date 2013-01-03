import game.IGame;
import game.IGameState;
import impl.strategy.EpsilonGreedyStrategy;
import impl.strategy.SimpleStrategy;
import impl.strategy.TDStrategy;
import impl.xsandos.game.XsAndOsGame;
import impl.xsandos.game.XsAndOsStateBuilder;
import impl.xsandos.player.CleverXsAndOsPlayer;
import impl.xsandos.player.RandomXsAndOsPlayer;
import player.IPlayer;
import strategy.IGlobalStrategy;
import strategy.ISelectionStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 17:18
 * To change this template use File | Settings | File Templates.
 */


public class Main {
    static public void main(String[] args) {
        IGame game = new XsAndOsGame(new XsAndOsStateBuilder(1, 2));

        IGlobalStrategy globalStrategy = new SimpleStrategy(); //new TDStrategy();

        boolean isTemperature = false;
        EpsilonGreedyStrategy selectionStrategy = new EpsilonGreedyStrategy(0.40, isTemperature);
        selectionStrategy.setTemperatureFactor(0.95);

        IPlayer first = new CleverXsAndOsPlayer(globalStrategy, selectionStrategy); // new RandomXsAndOsPlayer();
        IPlayer second = new RandomXsAndOsPlayer();
        int standoff, firstWins;

        for(int i = 0; i < 101; ++i)    {
            standoff = firstWins = 0;
            for (int j = 0; j < 1000; ++j){
                game.play(first, second);

                if(i > 0) {
                    globalStrategy.analizeGame(game.getLastGameLog(), game.getLastWinner(), first);
                    selectionStrategy.analizeGame(game.getLastGameLog(), game.getLastWinner(), first);
                }


                if(game.getLastWinner() == null)
                    ++standoff;
                if(game.getLastWinner() == first)
                    ++firstWins;

            }
            System.out.println( (i + 1) + ".  first " + firstWins + " : " + (1000 -firstWins) + " second");
        }

    }

    static public void printStates() {
        XsAndOsStateBuilder builder = new XsAndOsStateBuilder(1, 2);
        int i = 0;
        List<IGameState> stateList = builder.buildStateGraph();
        Collections.sort(stateList);
        for(IGameState state : stateList) {
            System.out.println("State #" + i++ + "  Type: " + state.getType());
            System.out.println(state.toString());

        }
    }


}
