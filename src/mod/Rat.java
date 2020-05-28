package mod;

public class Rat {
        //instance variables
        private Position _curPos;
        private boolean _facingLeft = true;
        
        private static final int RAT_START_ROW = 0;
        private static final int RAT_START_COL = 0;
        
        //Getters and setters
        public Position getRatPos() { return _curPos;    }
        
        private boolean _isAlive = true;
        
        public boolean isAlive() {return _isAlive;}
        
        public void killRat() {_isAlive = false; _curPos = new Position(0,14);}
        
        //current position of the rat
        public Rat(Maze z, int row, int col) {
            
            _curPos = new Position(row, col);
        }
        /*
         * This method sets up the AI for the rats. If they hit a wall, they will move the opposite direction.
         */
        public void ratMove(Maze z) {
            
            
            if( _curPos.getRow() == 0 && _curPos.getCol() == 14) {
                _curPos = new Position(0,14);
            }
            else {
                if (_facingLeft && _curPos.getCol() - 1 >= 0) {
                    if (!z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
                        _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
                    } 
                    else {
                        _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
                        _facingLeft = false;
                    }
                } 
                else if(_curPos.getCol() + 1 <= 14) {
                    if (!z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
                        _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
                        _facingLeft = false;
                    } 
                    else {
                        _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
                        _facingLeft = true;
                        }
                    }
                }
            }

        
        
}
