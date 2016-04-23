package sokoban.model.items;

/**
 * Created by eugeny on 23.02.2016.
 */
public class GameObject {
    private Pair position;

    public GameObject(int row, int column) {
        position = new Pair(row,column);
    }

    public int getColumn() {
        return position.getColumn();
    }

    public void setColumn(int column) {
        position.setColumn(column);
    }

    public int getRow() {
        return position.getRow();
    }

    public void setRow(int row) {
        position.setRow(row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameObject)) return false;

        GameObject that = (GameObject) o;

        return position.equals(that.position);

    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }

    public Pair getPosition() {
        return position;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }
}
