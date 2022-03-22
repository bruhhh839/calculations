package calculations;
import java.util.Scanner;

public class calculations{
	private static final boolean True = false;
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		askValue(); //calling askValue method
	}
		
	public static void askValue() { //askValue method
		Scanner scan = new Scanner(System.in);
		char ans =' '; 
		int i=0;
		do {
			System.out.println("Do you want to enter a value? y/n");
			ans = scan.next().charAt(0);
			if  (ans== 'N' ||ans =='n') {
				System.out.println("Good bye!"); //exit from the system
				System.exit(0);
			}
			if (ans == 'y'|| ans == 'Y') {// entering the system
				System.out.println("Enter a value:"); //asking for a value
				double x = scan.nextDouble(); // x is the value the user entered
				System.out.println("Which function? (1:exp 2:sin 3:cos 4:tan 5:cotan"); // asking for function type
				i = scan.nextInt();
				while (i<1 && i>5) { //wrong entry loop
					if (i <1 && i >5)
						System.out.println("Please enter a valid number");
					i = scan.nextInt(); 
				}
				if (i==1) { // outputs shown in the screen
					System.out.println( exp (x));
				}	
				if (i == 2) {
					System.out.println( sin(x));
				}
				if(i==3) {
					System.out.println( cos(x));
				}
				if(i==4) {
					System.out.println( sin(x)/cos(x));
				}
				if(i==5) {
					System.out.println( cos(x)/sin(x));
				}
			}
		}while(true);	
	}
	public static double sin (double a) { //sine method
	    // convert x to an angle between -2 PI and 2 PI
		a = Math.toRadians(a);

	    // 	Taylor series
	    double count = 1.0;      // count = x^i / i!
	    double sum  = 0.0;      
	    
	    for (int i = 1; count != 0.0; i++) { //calculation for sine
	        count *= (a / i);
	        if (i % 4 == 1) 
	        	sum += count;
	        if (i % 4 == 3) 
	        	sum -= count;
	    }
	    return sum;
	}


	public static double cos (double b) {// cosine method
		double c=b;
		c = c % 2*Math.PI;
		b = Math.sqrt(1-(sin(b)*sin(b)));//calculation for cosine for positive outputs
		if (c> (Math.PI)/2 || c< 3*(Math.PI)/2) { //calculation for negative outputs
			b=b*(-1);
		}
			return b;
				}
	public static double exp (double x) { //exponential method
		double sum  = 0.0; //calculation for exponential
        double count = 1.0;
        for (int i = 1; sum != sum + count; i++) {
            sum  = sum + count;
            count = count * x / i;

        }

        return sum;
	}
		
}