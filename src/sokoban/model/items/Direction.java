package sokoban.model.items;

/**
 * Created by eugeny on 05.04.2016.
 */
public interface Direction {
    Direction UP = p-> new Pair(p.getX(),p.getY()-1);
    Direction DOWN = p-> new Pair(p.getX(),p.getY()+1);
    Direction LEFT = p-> new Pair(p.getX()-1,p.getY());
    Direction RIGHT = p-> new Pair(p.getX()+1,p.getY());

    Pair next(Pair position);
}
