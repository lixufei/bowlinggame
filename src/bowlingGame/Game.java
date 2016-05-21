package bowlingGame;

public class Game {
    private int ball = 0;

    public void add(int i) {
        ball += i;
    }

    public int score() {
        return ball;
    }
}
