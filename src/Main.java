import Grids.Grid;
import Mazes.Maze;

import java.awt.*;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        Grid start = new Grid(true,new Point(0,0));
        Grid a1 = new Grid(true,new Point(0,-1));
        Grid a2 = new Grid(true,new Point(0,1));
        Grid a3 = new Grid(true,new Point(0,2));
        Grid a4 = new Grid(true,new Point(0,3));
        Grid a5 = new Grid(true,new Point(1,-1));
        Grid a6 = new Grid(false,new Point(1,0));
        Grid a7 = new Grid(false,new Point(1,1));
        Grid a8 = new Grid(false,new Point(1,2));
        Grid a9 = new Grid(true,new Point(1,3));
        Grid a10 = new Grid(true,new Point(2,-1));
        Grid a11 = new Grid(true,new Point(2,0));
        Grid a12 = new Grid(true,new Point(2,2));
        Grid a13 = new Grid(true,new Point(2,3));
        Grid end = new Grid(true,new Point(2,1));
        HashMap<Point,Grid> map = new HashMap();
        map.put(start.coords,start);
        map.put(end.coords,end);
        map.put(a1.coords,a1);
        map.put(a2.coords,a2);
        map.put(a3.coords,a3);
        map.put(a4.coords,a4);
        map.put(a5.coords,a5);
        map.put(a6.coords,a6);
        map.put(a7.coords,a7);
        map.put(a8.coords,a8);
        map.put(a9.coords,a9);
        map.put(a10.coords,a10);
        map.put(a11.coords,a11);
        map.put(a12.coords,a12);
        map.put(a13.coords,a13);
        Maze maze = new Maze(map,start,end);
        maze.pathFind();
        System.out.println(maze.explored);
        System.out.println(maze.path);
    }
}
