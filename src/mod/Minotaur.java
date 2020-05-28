package mod;

public class Minotaur {
    //Instance variables
    private Position _curPos;
    
    
    private static final int MINOTAUR_START_ROW = 0;
    private static final int MINOTAUR_START_COL = 0;
    //Getters
    public Position getMinotaurPosition() { return _curPos;    }
    public Minotaur(Maze z, int row, int col) {
        _curPos = new Position(row, col);
    }
    public int getMinotaurRow() {
        return _curPos.getRow();
    }
    public int getMinotaurCol() {
        return _curPos.getCol();
    }
    private boolean _isAlive = true;
    public boolean isMinoAlive() {return _isAlive;}
    public void killMinotaur() {_isAlive = false;}
    
        /*
         * This method sets up the minotaur's AI. It will not only attempt to follow the player, but if it runs into a wall, it will simply move the opposite direction
         */
    	public void minotaurMove(boolean[][] maze, Player p){
            int distRow = _curPos.getRow() - p.getPlayerPosition().getRow();
            int distCol = _curPos.getCol() - p.getPlayerPosition().getCol();
            if(_curPos.getRow()== 0 && _curPos.getCol()==14) {
                _curPos = new Position(0,14);
            }
            else {
            if(distRow > 0){
                if(!maze[_curPos.getRow() - 1][_curPos.getCol()]){
                    _curPos.setRow(_curPos.getRow() - 1);
                }
                else{
                    if(distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]){
                        _curPos.setCol(_curPos.getCol() - 1);
                    }
                    else if(!maze[_curPos.getRow()][_curPos.getCol() + 1]){
                        _curPos.setCol(_curPos.getCol() + 1);
                    }
                    else if(!maze[_curPos.getRow()][_curPos.getCol() - 1]){
                        _curPos.setCol(_curPos.getCol() - 1);
                    }
                    else{
                        _curPos.setRow(_curPos.getRow() + 1);
                    }
                }
            }
            else if(distRow == 0){
                if(distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]){
                    _curPos.setCol(_curPos.getCol() - 1);
                }
                else if(!maze[_curPos.getRow()][_curPos.getCol() + 1]){
                    _curPos.setCol(_curPos.getCol() + 1);
                }
                else if(!maze[_curPos.getRow() + 1][_curPos.getCol()]){
                    _curPos.setRow(_curPos.getRow() + 1);
                }
                else if(!maze[_curPos.getRow() - 1][_curPos.getCol()]){
                    _curPos.setRow(_curPos.getRow() - 1);
                }
                else{
                    _curPos.setCol(_curPos.getCol() - 1);
                }
            }
            else{
                if(!maze[_curPos.getRow() + 1][_curPos.getCol()]){
                    _curPos.setRow(_curPos.getRow() + 1);
                }
                else{
                    if(distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]){
                        _curPos.setCol(_curPos.getCol() - 1);
                    }
                    else if(!maze[_curPos.getRow()][_curPos.getCol() + 1]){
                        _curPos.setCol(_curPos.getCol() + 1);
                    }
                    else if(!maze[_curPos.getRow()][_curPos.getCol() - 1]){
                        _curPos.setCol(_curPos.getCol() - 1);
                    }
                    else{
                        _curPos.setRow(_curPos.getRow() - 1);
                    }
                }
            }
        }
        }
    }
