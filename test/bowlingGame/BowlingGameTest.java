package bowlingGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        game  = new Game();
    }

    @Test
    public void testTwoThrowsNoMark () throws Exception {
        game.add (4);
        game.add(4);

        assertEquals(8, game.score ());
    }

    @Test
    public void testFourThrowsNoMark () throws Exception {
        game.add (4);
        game.add (4);
        game.add (3);
        game.add (6);

        assertEquals(17, game.score());
        assertEquals(8, game.scoreForFrame(1));
        assertEquals(17, game.scoreForFrame(2));
    }

    @Test
    public void testSimpleFrameAfterSpare () throws Exception {
        game.add (4);
        game.add(6);
        game.add (3);
        game.add(2);

        assertEquals(18, game.score());
        assertEquals(13, game.scoreForFrame(1));
        assertEquals(18, game.scoreForFrame(2));
    }

//    @Test
//    public void testOneThrows () throws Exception {
//        game.add (4);
//
//        assertEquals(4, game.score());
//        assertEquals(4, game.scoreForFrame(1));
//        assertEquals(1, game.getCurrentFrame());
//    }

    @Test
    public void testTwoThrows () throws Exception {
        game.add (4);
        game.add (5);

        assertEquals(9, game.scoreForFrame(1));
        assertEquals(2, game.getCurrentFrame());
    }
}
