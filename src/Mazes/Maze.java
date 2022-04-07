package Mazes;

import Grids.Grid;

import java.awt.*;
import java.util.HashMap;

public class Maze
{
    public HashMap<Point, Grid> grids;

    public Maze(HashMap<Point, Grid> nodes)
    {
        grids = nodes;
    }
}
