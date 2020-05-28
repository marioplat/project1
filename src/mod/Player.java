package mod;

import mod.Direction;
import mod.Maze;
import mod.Position;
import mod.Sword;

public class Player {

	//Instance variables
	private Position _curPos;
	
	private boolean _isAlive = true;

	//Getters and setters
	public Position getPlayerPosition() {
		return _curPos;
	}

	public boolean isAlive() {
		return _isAlive;
	}

	public void setPosition(Position p) {
		_curPos = p;
	}

	public void killPlayer() {
		_isAlive = false;
	}
	public boolean inInventory = false;
	/*
	 * This method checks if the player reaches the same position as the sword. If the player does, their inventory is updated.
	 */
    public void pickUpSword(Sword a) {
        if (getPlayerPosition().getRow() == a.getSwordPosition().getRow()
                && getPlayerPosition().getCol() == a.getSwordPosition().getCol()) {
            inInventory = true;
        }
    }
    //Getter for the sword
    
    public boolean hasSword(Sword a) {
        return inInventory;
    }
    
	//Current position of the player
	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}
	/*
	 * This method will make the player move to their desired direction with the use of the JOptionButtons.
	 */
	public boolean playerMove(Direction d, Maze z) {
		if (d == Direction.Up) {
			if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.Down) {
			if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.Right) {
			if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length
					&& !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}
		} else {
			if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}

		return false;
	}
}