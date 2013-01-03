package impl.xsandos.game;

import game.*;
import player.IPlayer;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 18:10
 * To change this template use File | Settings | File Templates.
 */
public class XsAndOsGame implements IGame {
    private List<ActionInfo> myLog = new LinkedList<ActionInfo>();

    private IPlayer playerX;
    private IPlayer playerO;
    private int xId;
    private int oId;
    private IPlayer lastWinner;
    private IGameState initialState;
    private List<IGameState> states;

    public XsAndOsGame(XsAndOsStateBuilder stateBuilder) {
        states = stateBuilder.buildStateGraph();
        initialState = stateBuilder.getInitialState();
        xId = stateBuilder.getXPlayerId();
        oId = stateBuilder.getOPlayerId();
    }

    @Override
    public void play(IPlayer playerX, IPlayer playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.playerX.setPlayerId(xId);
        this.playerO.setPlayerId(oId);
        myLog.clear();

        IGameState currentState = initialState;
        IPlayer currentPlayer = this.playerX;
        IGameAction currentAction = null;
        boolean isXStep = false;

        while(currentState.getType() != StateType.FINAL && currentState.getType() != StateType.VICTORIOUS) {
            isXStep = !isXStep;
            if(isXStep) currentPlayer = this.playerX;
            else currentPlayer = this.playerO;

            currentAction = currentPlayer.chooseAction(currentState);
            currentState = currentAction.getTargetState();

            myLog.add(new ActionInfo(currentAction, currentPlayer));
           // printStep(currentAction, currentPlayer);

        }
        lastWinner = currentState.getType() == StateType.FINAL ? null : currentPlayer;
    }

    private void printStep(IGameAction action, IPlayer player) {
        System.out.println("----player #" + player.getPlayerId() + "--------");
        System.out.println(action.getSourceState());
        System.out.println( "TO ---> ");
        System.out.println(action.getTargetState());
        System.out.println("----player #" + player.getPlayerId() + "--------");
    }
    @Override
    public IPlayer getLastWinner() {
        return lastWinner;
    }

    @Override
    public List<ActionInfo> getLastGameLog() {
        return myLog;
    }

}
