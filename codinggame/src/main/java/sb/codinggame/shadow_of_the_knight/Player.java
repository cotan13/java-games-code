package sb.codinggame.shadow_of_the_knight;

/**
 * Created by cotan on 24/12/2017.
 */
public class Player {

    public static final String SPACE = " ";
    private final int W; // width of the building.
    private final int H; // height of the building.
    private final int N; // maximum number of turns before game over.
    private final int X0;
    private final int Y0;

    public Player(int w, int h, int n, int x0, int y0) {
        this.W = w;
        this.H = h;
        this.N = n;
        this.X0 = x0;
        this.Y0 = y0;
    }

    public String whereIsBatman(String... directions) {
        int x0 = 0, xn = W - 1, x = X0;
        int y0 = 0, yn = H - 1, y = Y0;

        String lastPosition = "";
        for (String dir : directions) {

            if (dir.contains("U")) yn = y - 1;
            if (dir.contains("D")) y0 = y + 1;
            if (dir.contains("R")) x0 = x + 1;
            if (dir.contains("L")) xn = x - 1;

            x = (xn + x0) / 2;
            y = (yn + y0) / 2;

            lastPosition = x + SPACE + y;
        }
        return lastPosition;
    }


}
