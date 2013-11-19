public class Rational {
    private int numerator;
    private int denominator;

    public Rational(){
	numerator = 0;
	denominator = 1;
    }
    public Rational (int a, int b) {
	numerator = a;
	denominator = b;
    }
    public String toString() {
	String x = numerator + "/" + denominator;
	return x;
    }
    public float floatValue() {
	return (numerator / denominator);
    }
    public int getNumerator() {
	return numerator;
    }
    public int getDenominator() {
	return denominator;
    }
    public Rational multiply(Rational r) {
	int num = numerator * r.getNumerator();
	int den = denominator * r.getDenominator();
	return new Rational (num, den);
    }
    public Rational divide(Rational r) {
        int num = numerator * r.getDenominator();
        int den = denominator * r.getNumerator();
        return new Rational (num, den);
    }
    public Rational add (Rational r) {
	int common = denominator * r.getDenominator();
	int numerator1 = numerator * r.getDenominator();
	int numerator2 = r.getNumerator() * denominator;
	int sum = numerator1 + numerator2;
	return new Rational (sum, common);
    }
    public Rational subtract (Rational r) {
        int common = denominator * r.getDenominator();
        int numerator1 = numerator * r.getDenominator();
        int numerator2 = r.getNumerator() * denominator;
        int sum = numerator1 - numerator2;
        return new Rational (sum, common);
    }
    public int gcd( int a, int b) {
	if (a == 0) {
	    return b;
	}
	else {
	    return gcd (a, b % a);
	}
    }
    private void reduce( Rational r) {
	if (numerator != 0) {
	    int common = gcd (numerator, denominator);
	    numerator /= common;
	    denominator /= common;
	}
    }
    public int compareTo(Rational r) {
	Rational difference = this.subtract((Rational)r);
	if (difference.numerator == 0) return 0;
	else if (difference.numerator < 0) return -1;
	else return 1;
    }
    public static void main(String[] args) {
	Rational x = new Rational(2,4);
	Rational r = new Rational(5,8);
	System.out.println(reduce(x.add(r)));
    }
}
