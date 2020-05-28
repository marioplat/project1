package mod;

public class Maze {
    //Instance variables
    private boolean[][] _maze;
    private Position _start;
    private Position _end;
    //Getters
    public Position getStart() { return _start; }
    public Position getEnd() { return _end; }
    public boolean[][] getMaze() { return _maze; }
    
    /*
     * This method sets up all mazes, which is an array of boolean values. True values represent a
     * wall that the player cannot pass. It also contains variables that establishes the player's starting position
     */
    public Maze(int x) {
        // true is a wall.
        if(x==0) {
        boolean[][] maze = {
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},

                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, true, true, false, true, true, true, true, true, true, true, true, true, true, true},

                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                
                {true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                
            };
            Position[] _rPpos = {
                new Position(1,1),
                
            };
            Position[] _rEpos = {
                new Position(7,14),
                
            };
        //Instance variables that establishes the player's starting position
        int PLAYER_START_ROW = _rPpos[0].getRow();
        int PLAYER_START_COL = _rPpos[0].getCol();
        int PLAYER_END_ROW = _rEpos[0].getRow();
        int PLAYER_END_COL = _rEpos[0].getCol();    
        
        _maze = maze;
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        }
        else if(x==1) {
            boolean[][] maze2 = {
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},

                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                    {true, true, false, false, true, false, false, false, false, true, true, true, true, true, true},
                    
                    {true, true, true, false, false, false, true, false, false, true, true, true, true, true, true},
                    
                    {true, true, false, false, true, true, true, true, false, true, true, true, true, true, true},

                    {true, true, false, true, true, true, true, true, false, true, true, true, true, true, true},
                    
                    {true, true, false, false, true, true, false, false, false, true, true, true, true, true, true},
                    
                    {true, true, true, false, true, true, false, true, true, true, true, true, false, false, false},
                    
                    {true, true, false, false, true, true, false, true, true, true, true, true, false, true, true},
                    
                    {true, true, false, true, true, true, false, true, true, true, true, true, false, true, true},
                    
                    {true, true, false, false, true, true, false, true, true, true, true, true, false, true, true},
                    
                    {true, true, true, false, true, true, false, true, true, true, true, true, false, true, true},
                    
                    {true, true, false, false, true, true, false, false, false, false, false, false, false, true, true},
                    
                    {true, true, false, false, true, true, true, true, true, true, true, true, true, true, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                };
                Position[] _rPpos = {
                    new Position(7,14),
                    
                };
                Position[] _rEpos = {
                    new Position(13,2),
                    
                };
            
            int PLAYER_START_ROW = _rPpos[0].getRow();
            int PLAYER_START_COL = _rPpos[0].getCol();
            int PLAYER_END_ROW = _rEpos[0].getRow();
            int PLAYER_END_COL = _rEpos[0].getCol();    
            _maze = maze2;
            _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
            _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
            }
        else if(x==2) {
            boolean[][] maze3 = {
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},

                    {true, true, false, false, true, true, true, true, true, true, true, false, false, true, true},
                    
                    {true, true, true, false, false, true, true, true, true, true, false, false, true, true, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                    {true, true, true, false, true, true, true, true, true, true, true, false, true, true, true},

                    {true, true, true, false, true, false, true, true, true, false, true, false, true, true, true},
                    
                    {true, true, true, false, true, false, true, false, true, false, true, false, true, true, true},
                    
                    {true, true, true, false, false, false, false, false, false, false, false, false, true, true, true},
                    
                    {true, true, true, false, true, false, true, false, true, false, true, false, true, true, true},
                    
                    {true, true, true, false, true, false, true, false, true, false, true, false, true, true, true},
                    
                    {true, true, true, false, true, false, true, false, true, false, true, false, true, true, true},
                    
                    {true, true, true, false, true, false, true, false, true, false, true, false, true, true, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                };
                Position[] _rPpos = {
                    new Position(11,3),
                    
                };
                Position[] _rEpos = {
                    new Position(11,11),
                    
                };
            
            int PLAYER_START_ROW = _rPpos[0].getRow();
            int PLAYER_START_COL = _rPpos[0].getCol();
            int PLAYER_END_ROW = _rEpos[0].getRow();
            int PLAYER_END_COL = _rEpos[0].getCol();    
                
            _maze = maze3;
            _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
            _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
            }
        else if(x==3) {
            boolean[][] maze4 = {
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},

                    {true, true, true, true, false, false, false, false, false, false, false, false, false, false, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                    
                    {true, true, true, true, false, false, false, false, false, false, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, true, true, false, false, true, true, true, false, true},

                    {true, false, false, true, false, true, false, false, false, false, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, false, false, true, true, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, false, false, false, false, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, true, true, false, false, true, true, true, false, true},
                    
                    {true, true, false, true, false, true, false, false, false, false, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, false, false, true, true, true, true, true, false, true},
                    
                    {true, false, true, true, false, true, false, false, false, false, true, true, true, false, true},
                    
                    {true, false, false, true, false, true, true, true, false, false, true, true, true, false, true},
                    
                    {true, true, false, false, false, true, false, false, false, false, false, false, false, false, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                };
            Position[] _rPpos = {
                    new Position(13,4),
                    
                };
                Position[] _rEpos = {
                    new Position(1,4),
                    
                };
            
            int PLAYER_START_ROW = _rPpos[0].getRow();
            int PLAYER_START_COL = _rPpos[0].getCol();
            int PLAYER_END_ROW = _rEpos[0].getRow();
            int PLAYER_END_COL = _rEpos[0].getCol();    
            _maze = maze4;
            _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
            _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
            }
        else {
            boolean[][] maze5 = {
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},

                    {true, true, true, true, false, false, false, false, false, false, false, false, false, false, true},
                    
                    {true, true, false, false, true, true, true, true, true, true, false, true, true, true, true},
                    
                    {true, true, true, false, true, false, false, true, true, true, false, true, true, true, true},
                    
                    {true, true, false, false, true, false, false, true, false, false, false, true, false, false, true},

                    {true, true, false, false, true, false, false, true, true, true, false, true, true, true, true},
                    
                    {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                    
                    {true, true, true, true, true, true, true, true, true, false, false, false, true, true, true},
                    
                    {false, false, false, false, true, false, true, false, true, false, false, true, false, false, true},
                    
                    {false, false, false, true, false, false, false, false, false, false, false, true, false, false, true},
                    
                    {false, false, false, false, false, false, true, false, false, false, false, true, false, false, true},
                    
                    {false, false, true, false, false, true, false, false, false, false, false, false, false, false, true},
                    
                    {false, false, false, false, false, false, false, true, false, false, true, false, false, false, true},
                    
                    {true, false, false, true, false, false, false, false, false, false, true, false, false, false, true},
                    
                    {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                    
                };
                
            Position[] _rPpos = {
                    new Position(1,13),
                    
                };
                Position[] _rEpos = {
                    new Position(10,0),
                    
                };
            
            int PLAYER_START_ROW = _rPpos[0].getRow();
            int PLAYER_START_COL = _rPpos[0].getCol();
            int PLAYER_END_ROW = _rEpos[0].getRow();
            int PLAYER_END_COL = _rEpos[0].getCol();    
            _maze = maze5;
            _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
            _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
            }
    }
}

