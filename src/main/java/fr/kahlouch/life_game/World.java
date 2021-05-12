package fr.kahlouch.life_game;

public class World {
    private boolean[][] life;
    private int generation;

    public World() {
        this.init();
    }

    public void init() {
        this.life = new boolean[Constants.WIDTH_PX / Constants.ENTITY_SIZE_PX][Constants.HEIGHT_PX / Constants.ENTITY_SIZE_PX];
        this.generation = 0;
    }

    public void computeNextTurn() {
        boolean[][] tmpLife = new boolean[Constants.WIDTH_PX / Constants.ENTITY_SIZE_PX][Constants.HEIGHT_PX / Constants.ENTITY_SIZE_PX];
        for (int x = 0; x < life.length; x++) {
            for (int y = 0; y < life[x].length; y++) {
                tmpLife[x][y] = isSurviving(countNeighbours(x, y), this.life[x][y]);
            }
        }
        this.life = tmpLife;
        this.generation++;
    }

    private int countNeighbours(int x, int y) {
        int count = 0;
        count += Boolean.compare(isAlive(x - 1, y - 1), false);
        count += Boolean.compare(isAlive(x - 1, y), false);
        count += Boolean.compare(isAlive(x - 1, y + 1), false);
        count += Boolean.compare(isAlive(x, y - 1), false);
        count += Boolean.compare(isAlive(x, y + 1), false);
        count += Boolean.compare(isAlive(x + 1, y - 1), false);
        count += Boolean.compare(isAlive(x + 1, y), false);
        count += Boolean.compare(isAlive(x + 1, y + 1), false);
        return count;
    }

    private boolean isAlive(int x, int y) {
        try {
            return this.life[x][y];
        } catch (IndexOutOfBoundsException ex) {
            return true;
        }
    }

    private boolean isSurviving(int neighbourNb, boolean alive) {
        return (neighbourNb == 2 && alive) || neighbourNb == 3;
    }

    public boolean[][] getLife() {
        return life;
    }

    public void setLife(boolean[][] life) {
        this.life = life;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}
