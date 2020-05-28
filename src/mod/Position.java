package mod;

public class Position {

	//Instance variables
    private int _row;
    private int _col;
    public static final int rP = (int)(Math.random() * 2 );
    public int getRow() { return _row; }
    public int getCol() { return _col; }
    
    //Setters for the players position
    public Position(int r, int c) {
        _row = r;
        _col = c;
    }
    
    public void setRow(int r) {
        _row = r;
        
    }
    public void setCol(int c) {
        _col = c;
        
    }

}
