package game;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 29.10.12
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public interface IGameAction {
    IGameState getSourceState();
    IGameState getTargetState();

}
