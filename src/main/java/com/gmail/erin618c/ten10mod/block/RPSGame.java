package com.gmail.erin618c.ten10mod.block;

//0=coal, 1=paper, 2=shears
public class RPSGame {

    static public char playGame(int p, int m) {
        if (p == m) { return 'd'; } //draw
        if ((p==0 && m==2) || (p==1 && m==0) || (p==2 && m==1)) { return 'y'; } //yes
        return 'n'; //no
    }
}
