package Grids;

import java.awt.Point;
public class Grid
{
    public boolean walkable;
    public Point coords;

    public Grid(boolean walk, Point coordinates)
    {
        walkable = walk;
        coords = coordinates;
    }
}
