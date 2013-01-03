package impl.xsandos.game;

import game.IGameState;
import game.IStateGraphBuilder;
import game.StateType;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 28.12.12
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class XsAndOsStateBuilder implements IStateGraphBuilder {
    public static char empty = ' ';
    public static char x = 'x';
    public static char o = 'o';

    private int xId = 1;
    private int oId = 2;
    private Map<String,IGameState> states;
    private XsAndOsState initial;

    public XsAndOsStateBuilder(int xPlayerId, int oPlayerId) {
        this.xId = xPlayerId;
        this.oId = oPlayerId;


    }

    public List<IGameState> buildStateGraph() {

        states = new HashMap<String, IGameState>();

        StringBuilder builder = new StringBuilder("         ");

        initial = new XsAndOsState(builder.toString(), StateType.INITIAL, xId, oId);

        recursivelyСreate(initial, builder, builder.length(), xId);
        return new ArrayList<IGameState>(states.values());
    }

    void recursivelyСreate( XsAndOsState state, StringBuilder builder, int emptyCells, int currId) {
        states.put(state.getField(), state);

        if(state.getType() == StateType.VICTORIOUS || state.getType() == StateType.FINAL) return;
        if(emptyCells == 0) return;

        char mark = currId == xId ? x : o;

        String field;
        XsAndOsState newState;

        for(int i = 0; i < builder.length(); ++i) {
            if(builder.charAt(i) == empty) {

                builder.setCharAt(i, mark);

                field = builder.toString();
                if(!states.containsKey(field)) {
                    newState = new XsAndOsState(field, calculateStateType(field, emptyCells - 1), xId, oId);
                    state.addAction(new XsAndOsAction(state, newState, currId));
                    recursivelyСreate(newState, builder, emptyCells - 1, currId == xId ? oId : xId);
                } else {
                    state.addAction(new XsAndOsAction(state, states.get(builder.toString()), currId));
                }

                builder.setCharAt(i, empty);
            }
        }

    }


    /*
    0 1 2
    3 4 5
    6 7 8

    0 3 6
    2 5 8
    1 4 7

    0 4 8
    2 4 6

    * */

     public StateType calculateStateType(String field, int emptyCells) {
        for(int i =0; i <= 2; ++i) {
            int j = 3 * i;
            if(field.charAt(j) != empty)
                if(field.charAt(j) == field.charAt(j + 1) &&  field.charAt(j) == field.charAt(j + 2))
                    return StateType.VICTORIOUS;

            if(field.charAt(i) != empty)
                if(field.charAt(i) == field.charAt(i + 3) &&  field.charAt(i) == field.charAt(i + 6))
                    return StateType.VICTORIOUS;

        }

        if(field.charAt(4) != empty) {
            if(field.charAt(0) == field.charAt(4) && field.charAt(0) == field.charAt(8))
                return StateType.VICTORIOUS;
            if(field.charAt(2) == field.charAt(4) && field.charAt(4) == field.charAt(6))
                return StateType.VICTORIOUS;
        }

        return emptyCells == 0 ? StateType.FINAL : StateType.INTERMEDIATE;
    }

    public IGameState getInitialState() {
        return initial;
    }

    public int getXPlayerId(){
        return xId;
    }

    public int getOPlayerId() {
        return oId;
    }

}
