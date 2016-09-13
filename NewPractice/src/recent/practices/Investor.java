package recent.practices;

public class Investor {
    Stock[] portfolio;
    Advisor ohTrustedOne;
    double value;
    Investor() {portfolio = new Stock[0];}
    Investor(Stock[] p, Advisor a) {
        portfolio = p;
        ohTrustedOne = a;
        value = ohTrustedOne.findValue(p);
    }
    String describePortfolio() {
        String s = new String();
        s += "My portfolio is: \n";
        for (int i = 0; i < portfolio.length; i++)
            s += portfolio[i] + "\n";
        s += "The total value is $" + value;
        return s;
    }
    void askAdvice() {
        ohTrustedOne.advise(portfolio);
    }
    
    
    Stock[] copyPortfolio() {  // illustrates returning an array
        Stock[] copy = new Stock[portfolio.length];
        for (int i = 0; i < portfolio.length; i++) {
            Stock s = new Stock();
            s.currentPrice = portfolio[i].currentPrice;
            s.sharesHeld = portfolio[i].sharesHeld;
            s.symbol = new String(portfolio[i].symbol);
            copy[i] = s;
        }
        return copy;
    }

}
