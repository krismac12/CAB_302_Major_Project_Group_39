package Grids;

import java.awt.Point;
public class Grid {
    public boolean walkable;
    public Point coords;
    public int startDistance;
    public int endDistance;
    public int distance;

    public Grid(boolean walk, Point coordinates)
    {
        walkable = walk;
        coords = coordinates;
    }

    public void setDistance(Point start, Point end)
    {
        startDistance = Math.abs(coords.x - start.x) + Math.abs(coords.y - start.y);
        endDistance = Math.abs(coords.x - end.x) + Math.abs(coords.y - end.y);
        distance = startDistance + endDistance;
    }
}
