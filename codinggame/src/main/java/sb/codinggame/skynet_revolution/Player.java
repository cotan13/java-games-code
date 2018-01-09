package sb.codinggame.skynet_revolution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cotan on 25/12/2017.
 */
class Player {

    private final int N, L, E;
    private final int[]  gtw, skynet;
    private final String[] links;

    boolean[][] graph ;
    boolean[] gateways ;

    public Player(int N, int L, int E, String[] links, int[] gtw, int[] skynet) throws Exception {
        this.N = N;
        this.L = L;
        this.E = E;
        this.links = links;
        this.gtw = gtw;
        this.skynet = skynet;

        graph = new boolean[N][N];
        gateways = new boolean[N];
        //init the gateways
        for (int g:gtw) gateways[g] = true;

        //draw the graph
        for (String s: links) {
            String[] n = s.split(" ");
            Integer n0 = Integer.parseInt(n[0]);
            Integer n1 = Integer.parseInt(n[1]);
            graph[n1][n0] = graph[n0][n1] = true;
        }
    }


    public String[] severedLinks() {
        List<String> r = new ArrayList<>();
        boolean toClose = false;
        for (Integer agent : skynet) {
            for (int i = 0; i < N; i++) {
                if (gateways[i]) {
                    if (graph[i][agent]) {
                        r.add(agent + " " + i);
                        toClose = true;
                        break;
                    }
                }
            }
            if(!toClose){
                for (int i = 0; i < N; i++) {
                    if (gateways[i])
                        for (int j = 0; j < N; j++)
                            if ((graph[i][j])) {
                                r.add(j + " " + i);
                                break;
                            }
                }
            }

        }
        return r.toArray(new String[0]);
    }



}