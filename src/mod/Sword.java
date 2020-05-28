package mod;
//CHECK
public class Sword {

	//instance variables
    private Position _curPos;
    private static final int SWORD_START_ROW = 0;
    private static final int SWORD_START_COL = 14;
    //Getter
    public Position getSwordPosition() { return _curPos;}
    //Setter
    public Sword(Maze z, int row, int col) {
        _curPos = new Position(row, col);
    }

}
