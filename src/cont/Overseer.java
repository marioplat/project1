package cont;

import javax.swing.JOptionPane;

import mod.*;
import view.*;

public class Overseer {

	//Instance variables
    private Sword _a;
    private Player _p;
    private Minotaur _m;
    private Maze _z;
    private StringMap _s;
    private Window _w;
    private Rat _r;
    private int cnt = 0;
    private int level = 0;
    private int x = 0;
    private static final String[] BUTTONS = { "Up", "Down", "Left", "Right", "Exit" };
    private static final String[] DIALOGUE1 = { "-->" };
    private static final String[] DIALOGUE2 = { "OH SHIT" };
    private static final String[] LEVELS = { "Prison", "Labyrinth", "Spooky", "Minotaur", "Freedom"};

    /*
     * This method checks the players position. It also checks what happens to the player by utilizing the method, gamecheck.
     */
    public void getPlayerMovement() {
        
            while (x<5) {
                int x = _w.option(BUTTONS, _s.updateMap(_p, _m, _r, _z, _a));
                move(x);
                gamecheck();
            }
            _z = new Maze(x);
            _s = new StringMap();
            _p = new Player(_z);
            _m = new Minotaur(_z,0,14);
            _r = new Rat(_z,7,12);        
            _a = new Sword(_z,0,14);

        }

    /*
     * This method opens up a window and asks where the player which level they would like to go to.
     */
    private void warpzone() {
        level = JOptionPane.showOptionDialog(null, "Welcome to the Warp Zone! \r\n (Beat Labyrinth for the event)", "Select a warp zone!", 
                JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null, LEVELS,LEVELS[0]);
        if(level == 0) {
            x = 0;
        }
        else if(level == 1) {
            x = 1;
        
        }
        else if(level == 2) {
            x = 2;
        
        }
        else if(level == 3) {
            x = 3;
        
        }
        else if(level == 4) {
            x = 4;
        
        }
        
    }
    
    //Constructor
    public Overseer() {
    	warpzone();
        _w = new Window();
        _z = new Maze(x);
        _s = new StringMap();
        _p = new Player(_z);
        _m = new Minotaur(_z,0,14);
        _a = new Sword(_z,0,14);
        _r = new Rat(_z,7,12);
        
        getPlayerMovement(); 
        
    }
    

    /*
     * This method runs every time the player moves. If the player moves, the minotaur and rats have their positions updated. 
     * If the player runs into the same position as a wall, it will put them back at their previous position.
     */
    public void move(int x) {
        if (!_p.playerMove(getPlayerDirection(x), _z)) {
            _w.msg("BLESSED WALL GIVE ME STRENGTH! \r\n ... \r\n It does nothing...");
            _m.minotaurMove(_z.getMaze(), _p);
            _r.ratMove(_z);
        } 
        else {
            _m.minotaurMove(_z.getMaze(), _p);
            _r.ratMove(_z);
        
        }
    }

    /*
     * This method checks every thing the player can possibly do. If they get a sword, their inventory gets updated. If the player does not have a sword and runs into the 
     * same position as the minotaur or a rat, it will kill the player and restart the game. If the player reaches the end of the level, it will send them to the next level. 
     * In one of the levels, the player will get asked a riddle and if they get it wrong, the player dies and game is restarted. The method also checks when the player completes
     * all the levels and claims victory.
     */
    public void gamecheck() {
        if (_p.getPlayerPosition().getRow() == _a.getSwordPosition().getRow() // P gets S
                && _p.getPlayerPosition().getCol() == _a.getSwordPosition().getCol()) {
            _w.msg("You got the sword!");
            _p.inInventory = true;
        }
        if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow()//P on M
                && _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && _p.inInventory == false) {
            _w.msg("GAME OVER \r\n The mighty Minotaur violently smashed you to a pulp!");
            _p.killPlayer();
            
        }
        if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow()//P with S on M
                && _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && _p.inInventory == true) {
            _m.killMinotaur();
            _w.msg("GAME COMPLETE \r\n The mighty Minotaur has been slain! "
            		+ "\r\n The prisoner left the dungeon intact. "
            		+ "\r\n Yet the longer he was there, the more insane he had become... "
            		+ "\r\n And so he left... with everything but his humanity.");
                System.exit(0);

        }
        if (_p.getPlayerPosition().getRow() == _r.getRatPos().getRow()//P on R
                && _p.getPlayerPosition().getCol() == _r.getRatPos().getCol() && _r.isAlive()==true) {
        	_w.msg("GAME OVER \r\n The rat gnawed on your entrails...");
           _p.killPlayer(); 
            
        }    
        
        if (_p.getPlayerPosition().getRow() == _z.getEnd().getRow()//P on E
                && _p.getPlayerPosition().getCol() == _z.getEnd().getCol()) {
            
            
            if(x==0) {   
            _w.msg("You climb up to the next room. \r\n You have a massive headache, yet you still press on... \r\n Get ready for level 2");
            x++;
            _w = new Window();
            _z = new Maze(x);
            _s = new StringMap();
            _p = new Player(_z);
            _a = new Sword(_z,0,14);
            _m = new Minotaur(_z,0,14);
            _r = new Rat(_z,2,2);
            
            getPlayerMovement();
            
            }
            else if(x==1) {
            	String answer = "sun";
                String riddle = _w.in( "You climb up to the next room. "
                		+ "\r\n There is a trapdoor leading to the next level. "
                		+ "\r\n Carved on it is a riddle: "
                		+ "\r\n I AM BLAZING, SCORCHING, THE PER CONTRA OF DARKNESS "
                		+ "\r\n WITHOUT ME WATCHING OVER THE EARTH, NO LIFE WOULD THRIVE "
                		+ "\r\n DARKNESS WOULD REIGN "
                		+ "\r\n WHAT AM I? ");
                if(riddle.equalsIgnoreCase(answer)) {
                	_w.msg("Freedom whispered a language not known to you \r\n The trap door opened by itself");
                }
                else {
                	_w.msg("GAME OVER \r\n The trapdoor grew spikes, piercing both of your eyes and killing you.");
                	_p.killPlayer();
                }
                x++;
                _w = new Window();
                _z = new Maze(x);
                _s = new StringMap();
                _p = new Player(_z);
                _a = new Sword(_z,0,14);
                _m = new Minotaur(_z,0,14);
                _r = new Rat(_z,7,2);
                
                getPlayerMovement();
                
                }
                
            
            else if(x==2) {
                _w.msg("You climb up to the next room. \r\n You start hearing horrible, loud noises. \r\n It's the MIGHTY MINOTAUR. \r\n Get ready for level 4");
                _w.option(DIALOGUE1, "SCREW YOU MINOTAUR! \r\n P                                                      M");
                _w.option(DIALOGUE2, "                                                     WHAT THE HELL DID YOU SAY TO ME \r\n  P                                                      M");
                x++;
                _w = new Window();
                _z = new Maze(x); 
                _s = new StringMap();
                _p = new Player(_z);
                _a = new Sword(_z,0,14);
                _m = new Minotaur(_z,12,12);
                _r = new Rat(_z,13,13);
                
                getPlayerMovement();
                
                }
            
            else if(x==3) {
                _w.msg("You climb up to the next room. \r\n A mysterious figure stands in your way. \r\n Is it Freedom..? \r\n Get ready for level 5");
                x++;
                if(cnt == 4) {
                    _a = new Sword(_z,6,7);
                }
                _w = new Window();
                _z = new Maze(x); 
                _s = new StringMap();
                _p = new Player(_z);
                _m = new Minotaur(_z,1,7);
                _r = new Rat(_z,0,14);
                getPlayerMovement();
                
                
            }
            
            else{
                _w.msg("GAME COMPLETE"
                		+ "\r\n The prisoner left the dungeon in one physical piece. "
                		+ "\r\n Yet the longer he was there, the more insane he had become... "
                		+ "\r\n And so he left... with everything but his humanity.");
                System.exit(0);
                }
        }
        
    }
      

    //A getter for the player's movement
    public Direction getPlayerDirection(int x) {
        
        if (x == 0) {
            // Up
            return Direction.Up;
        }
        else if (x == 1) {
            // Down
            return Direction.Down;
        }
        else if (x == 2) {
            // Left
            return Direction.Left;
        }
        else if (x == 3) {
            // Right
            return Direction.Right;
        }
                
        else {
            // EXIT
            System.exit(0);
            return null;
        }
        
    }
}
