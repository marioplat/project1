package view;

import mod.*;

public class StringMap {

        private String _map;
        
        public StringMap() {
            _map = "";
        }
        
        public String updateMap(Player p, Minotaur m, Rat r1, Maze z, Sword a) {
                _map = "";
                for(int r = 0; r < z.getMaze().length; r++) {
                    for(int c = 0; c < z.getMaze()[0].length; c++) {
                        if(z.getMaze()[r][c]) {
                            _map += "W"; //WALL
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                        else if(r == p.getPlayerPosition().getRow() &&
                                c == p.getPlayerPosition().getCol()) {
                            _map += "P"; //PLAYER
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                        else if(r == m.getMinotaurPosition().getRow() &&
                                c == m.getMinotaurPosition().getCol() &&
                                p.isAlive() == true) {
                            _map += "M"; //MINOTAUR
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                        else if(r == z.getEnd().getRow() &&
                                c == z.getEnd().getCol()) {
                            _map += "E"; //EXIT
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                        else if(r == r1.getRatPos().getRow() &&
                                c == r1.getRatPos().getCol() &&
                                r1.isAlive()) {
                            _map += "R"; //RAT1
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                       
                        
                        else if(r == a.getSwordPosition().getRow() &&
                                c == a.getSwordPosition().getCol() &&
                                !p.hasSword(a)) {
                                _map += "S"; //SWORD
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                           
                        }
                        else {
                            _map += ":  :"; //PATH
                            if(c != z.getMaze()[0].length - 1) {
                                _map += " ";
                            }
                        }
                    }
                    _map += "\n";
                }
                return _map;
        }
}
