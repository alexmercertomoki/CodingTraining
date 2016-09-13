package recent.practices;

public class Stock {
    Stock() {}
    Stock(int s, double p, String name) {
        sharesHeld = s;
        currentPrice = p;
        symbol = name;
    }
    int sharesHeld = 0;
    double currentPrice = 100.00;
    String symbol;
    public String toString() {
        String s = new String();
        s += sharesHeld + " shares of " + symbol + " at $" + currentPrice;
        return s;
    }
    
   
    
    
}
