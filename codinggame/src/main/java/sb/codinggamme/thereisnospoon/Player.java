package sb.codinggamme.thereisnospoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cotan on 23/12/2017.
 */
public class Player {

    private static final char ZERO = '0';
    private static final char SPACE = ' ';
    private static final String END = "-1 -1";

    public String[] thereIsNoSpoon(int width, int height, String... lines) {
        List<String> r = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (lines[y].charAt(x) != ZERO) continue;
                String currentPosition = x + " " + y;
                currentPosition += SPACE + nextPointOnTheRight(lines, x, y, width);
                currentPosition += SPACE + nextPointOnTheBelow(lines, x, y, height);
                r.add(currentPosition);
            }
        }
        return r.toArray(new String[0]);
    }


    private String nextPointOnTheRight(String[] lines, int x, int y, int width) {
        if(x +1 >= width){
            return END;
        }
        for (int x1 = x +1; x1 < width; x1++) {
            boolean f = lines[y].charAt(x1) == ZERO;
            if(f) return x1 + " " + y;
        }
        return END;
    }

    private String nextPointOnTheBelow(String[] lines, int x, int y, int height) {
        if( y +1 >= height){
            return END;
        }
        for (int y1 = y +1; y1 < height; y1++) {
            boolean f = lines[y1].charAt(x) == ZERO;
            if(f) return x + " " + y1;
        }
        return END;
    }

}
