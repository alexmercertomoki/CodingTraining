package recent.practices;

public class Advisor {
    double findValue(Stock[] p) {
        double value = 0;
        for (int i = 0; i < p.length; i++)
            value += p[i].currentPrice * p[i].sharesHeld;
        return value;
    }
    void advise(Stock[] p) { swindle(p); }
    void swindle(Stock[] p) {
        for (int i = 0; i < p.length; i++)
            p[i].sharesHeld /= 2;
    }
}