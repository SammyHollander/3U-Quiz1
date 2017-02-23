
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author holls9719
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating new city
        City lego = new City();
        //creating new walls to form the staircase
        new Wall(lego, 4, 2, Direction.WEST);
        new Wall(lego, 4, 2, Direction.NORTH);
        new Wall(lego, 3, 3, Direction.WEST);
        new Wall(lego, 3, 3, Direction.NORTH);
        new Wall(lego, 2, 4, Direction.WEST);
        new Wall(lego, 2, 4, Direction.NORTH);
        new Wall(lego, 2, 5, Direction.NORTH);
        new Wall(lego, 2, 5, Direction.EAST);
        new Wall(lego, 3, 6, Direction.NORTH);
        new Wall(lego, 3, 6, Direction.EAST);
        new Wall(lego, 4, 7, Direction.NORTH);
        new Wall(lego, 4, 7, Direction.EAST);
        //creating new things on the staircase
        new Thing(lego, 4, 1);
        new Thing(lego, 3, 2);
        new Thing(lego, 2, 3);
        new Thing(lego, 1, 4);
        //creating new robot in lego city starting at 4,0 faceing east
        RobotSE ruby = new RobotSE(lego, 4, 0, Direction.EAST);
        //moveing ruby and haveing it pick up the first thing
        ruby.move();
        ruby.pickThing();
        //get ruby to move up the stairs and pick up things along the way
        while (ruby.getAvenue() < 4) {
            ruby.turnLeft();
            ruby.move();
            ruby.turnRight();
            ruby.move();
            ruby.pickThing();
        }
        //getting ruby move and drop off the first thing at the top
        ruby.move();
        ruby.putThing();
        //getting ruby to move down the stairs and put one thing on each step
        //then stoping ruby at the bottom
        while (ruby.getAvenue() < 8) {
            ruby.move();
            ruby.turnRight();
            ruby.move();
            ruby.putThing();
            ruby.turnLeft();
        }
        //makeing ruby move to the end postion
        ruby.move();
    }
}
