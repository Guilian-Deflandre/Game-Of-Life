# Game Of Life

The game described below is inspired by the Game of Life invented by John Conway in the early seventies. It consists in simulating a simple cellular automaton: cells are placed into a square grid of arbitrary size. At each step, the game determines whether those cells must live or die by applying the following rules:
* If a cell is surrounded by 2 or 3 other cells, it lives.
* If a cell is surrounded by 0 or 1 other cell, it dies of loneliness.
* If a cell is surrounded by 4 cells or more, it dies by asphyxiation.
* If a square of the grid is empty, but surrounded by exactly 3 cells, a new cell is created on this square.
* When a cell dies, it disappears from the grid.

To determine which cells surround a given square of the grid, one takes into account its adjacent squares in the horizontal, vertical and diagonal directions (in other words, its 8 neighboring squares for locations that do not belong to a border). At each step, one first decides for the whole population which cells are going to die, survive, or be created, before modifying this population.
