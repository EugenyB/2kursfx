package sokoban.model.items;

/**
 * Created by eugeny on 05.04.2016.
 */
public interface Direction {
    Direction UP = p-> new Pair(p.getRow()-1,p.getColumn());
    Direction DOWN = p-> new Pair(p.getRow()+1,p.getColumn());
    Direction LEFT = p-> new Pair(p.getRow(),p.getColumn()-1);
    Direction RIGHT = p-> new Pair(p.getRow(),p.getColumn()+1);

    Pair next(Pair position);
}
