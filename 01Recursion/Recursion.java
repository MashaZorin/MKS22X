public class Recursion{
    public static String name(){
	return "Zorin,Maria";
    }

    public static double sqrt(double n){
	if (n == 0){
	    return 0;
	}
	else if (n < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    return guessSqrt(n, n / 2);
	}
    }

    public static double guessSqrt(double n, double guess){
	if ((n - guess * guess) / n * 100 < 0.001 && (n - guess * guess) / n * 100 > -0.001){
	    return guess;
	}
	else{
	    double better_guess = (n / guess + guess) / 2;
	    return guessSqrt(n, better_guess);
	}
    }

    /* public static void main(String[]args){
	System.out.println(sqrt(100));
	System.out.println(sqrt(4));
	System.out.println(sqrt(1000));
	System.out.println(sqrt(10000));
	}*/
}
