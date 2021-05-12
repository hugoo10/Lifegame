package fr.kahlouch.life_game;

public class Rules {
    public static boolean isSurviving(int neighbourNb, boolean alive) {
        return (neighbourNb == 2 && alive) || neighbourNb == 3;
    }
}
