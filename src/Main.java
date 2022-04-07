import Grids.Grid;
import Mazes.Maze;

import java.awt.*;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        Grid start = new Grid(true,new Point(0,0));
        Grid end = new Grid(true,new Point(10,100));
        HashMap<Point,Grid> map = new HashMap();
        for(int x = 0; x <=100;x++)
        {
            for(int y = 0 ; y <=100;y++)
            {
                map.put(new Point(x,y),new Grid(true,new Point(x,y)));
            }
        }
        map.put(start.coords,start);
        map.put(end.coords,end);
        Maze maze = new Maze(map,start,end);
        maze.pathFind();
        System.out.println(maze.path);
    }
}
