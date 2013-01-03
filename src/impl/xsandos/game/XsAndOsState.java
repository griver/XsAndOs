package impl.xsandos.game;

import game.IGameAction;
import game.IGameState;
import game.StateType;
import player.IPlayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 28.12.12
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
class XsAndOsState implements IGameState {
    private String field;

    private StateType type;

    private List<IGameAction> xActions = new ArrayList<IGameAction>();

    private List<IGameAction> oActions = new ArrayList<IGameAction>();

    private int xId;

    private int oId;

    public XsAndOsState(String field, StateType type, int xId, int oId) {
        this.field = field;
        this.type = type;
        this.xId = xId;
        this.oId = oId;
    }

    @Override
    public List<IGameAction> getAvailableActions(IPlayer player) {
        if(player.getPlayerId() == xId)
            return xActions;
        if (player.getPlayerId() == oId)
            return oActions;
        return null;
    }

    @Override
    public StateType getType() {
        return type;
    }

    void addAction(XsAndOsAction action) {
        if(action.getPlayerId() == xId)
            xActions.add(action);
        else if(action.getPlayerId() == oId)
            oActions.add(action);
    }

    String getField() {
        return field;
    }


    public int compareTo(XsAndOsState xsAndOsState) {
        return field.compareTo(xsAndOsState.field);
    }

    @Override
    public String getStateId() {
        return getField();
    }

    @Override
    public int compareTo(IGameState state) {
       return getStateId().compareTo(state.getStateId());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < field.length(); ++i) {
            builder.append(field.charAt(i));
            if((i + 1) % 3 == 0) {
                builder.append('\n');
                if(i + 1 != field.length())
                    builder.append("-----\n");
            }

            else builder.append('|');
        }
        return builder.toString();
    }


}
