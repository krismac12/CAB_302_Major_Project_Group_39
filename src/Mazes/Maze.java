package Mazes;

import Grids.Grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Maze
{
    public HashMap<Point, Grid> grids;
    public HashMap<Point, Grid> explored = new HashMap<>();
    public HashMap<Point, Grid> walkable = new HashMap<>();
    public HashMap<Point, Grid> path = new HashMap<>();
    public Grid current;
    public Grid start;
    public Grid end;
    public boolean solvable = true;

    public Maze(HashMap<Point, Grid> nodes, Grid Start, Grid End)
    {
        grids = nodes;
        start = Start;
        end = End;
    }

    public void pathFind()
    {
        explored.put(start.coords,grids.get(start.coords));
        current = start;
        findWalkable(current);
        int i = 0;
        while(true)
        {

            i++;
            int shortestDistance = 200;
            Grid shortestGrid = null;
            int x = 0;
            for(Map.Entry<Point,Grid> entry : walkable.entrySet())
            {

                Point coordinates = entry.getKey();
                Grid grid = entry.getValue();
                grid.setDistance(start.coords,end.coords);
                if(grid.distance <= shortestDistance)
                {
                    shortestDistance = grid.distance;
                    shortestGrid = grid;
                }
            }
            if(shortestGrid != null)
            {
                current = shortestGrid;
                walkable.remove(shortestGrid.coords);
                explored.put(shortestGrid.coords,shortestGrid);
            }
            if(current.coords == end.coords)
            {
                break;
            }
            findWalkable(current);
            if(walkable.isEmpty())
            {
                solvable = false;
                break;
            }
        }
        int d = 0;
        while(current != start && solvable)
        {
            d++;
            System.out.println(d);
            findpath();
        }
    }

    public void findWalkable(Grid current)
    {
        Point east = new Point(current.coords.x+1,current.coords.y);
        Point west = new Point(current.coords.x-1,current.coords.y);
        Point north = new Point(current.coords.x,current.coords.y+1);
        Point south = new Point(current.coords.x,current.coords.y-1);
        Point[] points = {north,south,east,west};
        for (Point point: points)
        {
            if(grids.containsKey(point))
            {
                Grid grid = grids.get(point);
                if(grid.walkable && !explored.containsKey(grid.coords))
                {
                    walkable.put(point,grid);
                }
            }
        }
    }
    // not working
    public void findpath()
    {
        Point east = new Point(current.coords.x+1,current.coords.y);
        Point west = new Point(current.coords.x-1,current.coords.y);
        Point north = new Point(current.coords.x,current.coords.y+1);
        Point south = new Point(current.coords.x,current.coords.y-1);
        Point[] points = {north,south,east,west};
        Grid shortestGrid = null;
        ArrayList<Grid> exploredGrids = new ArrayList<>();
        for (Point point: points)
        {
            if(explored.containsKey(point))
            {
                exploredGrids.add(grids.get(point));
            }
        }
        int shortestDistance = 200;
        for(Grid grid : exploredGrids)
        {
            if(grid.startDistance < shortestDistance && !path.containsValue(grid))
            {
                shortestDistance = grid.startDistance;
                shortestGrid = grid;
            }
        }
        current = shortestGrid;
        path.put(current.coords,current);
    }
}
