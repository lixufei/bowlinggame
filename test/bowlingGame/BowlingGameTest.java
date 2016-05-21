package bowlingGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void testTwoThrowsNoMark () throws Exception {
        Game game = new Game ();
        game.add (4);
        game.add(4);

        assertEquals(8, game.score ());
    }

    @Test
    public void testFourThrowsNoMark () throws Exception {
        Game game = new Game ();
        game.add (4);
        game.add (4);
        game.add (3);
        game.add (6);

        assertEquals(17, game.score ());
    }
}
