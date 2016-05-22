package bowlingGame;

public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int currentThrows = 0;
    private int itsCurrentFrame = 1;
    private Boolean fistThrow = true;

    public void add(int pins) {
        itsThrows[currentThrows++] = pins;
        itsScore += pins;
        adjustCurrentFrame(pins);
    }

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];

            if (firstThrow == 10) {
                score += 10 + itsThrows[ball] + itsThrows[ball+1];
            } else {
                int secondThrow = itsThrows[ball++];
                int frameScore = firstThrow + secondThrow;

                if (frameScore == 10) {
                    score = frameScore + itsThrows[ball]; //思考为什么不是score = frameScore + itsThrows[ball++];
                } else {
                    score += frameScore;
                }
            }
        }
        return score;
    }

    public int adjustCurrentFrame(int pins) {
        if (fistThrow) {
            if (pins == 10) {
                itsCurrentFrame ++;
            } else {
                fistThrow = false;
            }
        } else {
            fistThrow = true;
            itsCurrentFrame ++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
        return itsCurrentFrame;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
