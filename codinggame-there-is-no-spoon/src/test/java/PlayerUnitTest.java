import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cotan on 23/12/2017.
 */
@RunWith(JUnit4.class)
public class PlayerUnitTest {

    private Player player2 = new Player();

    /**
     * Simple case
     *  O O
     *  O X
     */
    @Test
    public void testSimpleInputLines() {
        String[] expected = {"0 0 1 0 0 1", "1 0 -1 -1 -1 -1" , "0 1 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(2, 2, "00", "0.");
        assertThat(actaul, is(expected));
    }

    /**
     * Horizontal case
     *  O X O X O X
     */
    @Test
    public void testHorizontalInputLines() {
        String[] expected = {"0 0 2 0 -1 -1","2 0 4 0 -1 -1","4 0 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(5, 1, "0.0.0.");
        assertThat(actaul, is(expected));
    }

    /**
     * Vertical case
     *  O
     *  O
     *  O
     *  O
     */
    @Test
    public void testVerticalInputLines() {
        String[] expected = {"0 0 -1 -1 0 1","0 1 -1 -1 0 2","0 2 -1 -1 0 3", "0 3 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(1, 4, "0", "0", "0", "0");
        assertThat(actaul, is(expected));
    }

    /**
     * Square case 1
     *  O O
     *  O O
     */
    @Test
    public void testCarre1InputLines() {
        String[] expected = {"0 0 1 0 0 1", "1 0 -1 -1 1 1" , "0 1 1 1 -1 -1", "1 1 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(2, 2, "00", "00");
        assertThat(actaul, is(expected));
    }

    /**
     * Square case 2
     *  O X O
     *  X X X
     *  O X O
     */
    @Test
    public void testCarre2InputLines() {
        String[] expected = {"0 0 2 0 0 2", "2 0 -1 -1 2 2" , "0 2 2 2 -1 -1", "2 2 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(3, 3, "0.0", "...", "0.0");
        assertThat(actaul, is(expected));
    }

    /**
     * T case
     *  O O O
     *  X O X
     *  X O X
     */
    @Test
    public void testTInputLines() {
        String[] expected = {"0 0 1 0 -1 -1", "1 0 2 0 1 1" , "2 0 -1 -1 -1 -1", "1 1 -1 -1 1 2", "1 2 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(3, 3, "000", ".0.", ".0.");
        assertThat(actaul, is(expected));
    }

    /**
     * Diagonal case
     *  O X X X
     *  X O X X
     *  X X O X
     *  X X X O
     */
    @Test
    public void testDiagonalInputLines() {
        String[] expected = {"0 0 -1 -1 -1 -1", "1 1 -1 -1 -1 -1", "2 2 -1 -1 -1 -1", "3 3 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(4, 4, "0...", ".0..", "..0.", "...0");
        assertThat(actaul, is(expected));
    }

    /**
     * Complex case
     *  O O X O
     *  O X O O
     *  X O X O
     *  O O O X
     */
    @Test
    public void testComplexInputLines() {
        String[] expected = {"0 0 1 0 0 1", "1 0 3 0 1 2", "3 0 -1 -1 3 1", "0 1 2 1 0 3",
                "2 1 3 1 2 3", "3 1 -1 -1 3 2", "1 2 3 2 1 3", "3 2 -1 -1 -1 -1",
                "0 3 1 3 -1 -1", "1 3 2 3 -1 -1", "2 3 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(4, 4, "00.0", "0.00", ".0.0", "000.");
        assertThat(actaul, is(expected));
    }

    /**
     * Shurikan case
     X X O X X X X
     X X X X X X X
     X X O X O X O
     X X X X X X X
     O X O X O X X
     X X X X X X X
     X X X X O X X
     */

    @Test
    public void testShurikanInputLines() {
        String[] expected = {"2 0 -1 -1 2 2", "2 2 4 2 2 4", "4 2 6 2 4 4", "6 2 -1 -1 -1 -1", "0 4 2 4 -1 -1", "2 4 4 4 -1 -1", "4 4 -1 -1 4 6", "4 6 -1 -1 -1 -1"};
        String[] actaul = player2.thereIsNoSpoon(7, 7, "..0....",".......","..0.0.0",".......","0.0.0..",".......","....0..");
        assertThat(actaul, is(expected));
    }


}
