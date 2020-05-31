package prgm1;

/*

Create a Java class called Complex with the following details as member variables within it. 
(i) Real  (ii) Imaginary
Develop a Java program to perform addition and subtraction of two complex numbers by using the method add() and subtract( ) 
respectively, by passing object as parameter and display result using method display(). Initialize the real and imaginary values 
of the complex number using parameterized constructor. Also demonstrate overloading constructors and methods.

*/

class complex{
	int real;
	int img;
	complex() {}
	complex(int r, int i) {
		this.real = r;
		this.img = i;
	}
	
	void add(complex a) {
		this.img  += a.img;
		this.real += a.real;
	}
	
	void sub(complex a) {
		this.img  -= a.img;
		this.real -= a.real;
	}
	
	complex add(complex a, complex b) {
		complex x = new complex();
		x.real = a.real + b.real;
		x.img = a.img + b.img;
		return x;
	}

	complex sub(complex a, complex b) {
		complex x = new complex();
		x.real = a.real - b.real;
		x.img = a.img - b.img;
		return x;
	}
	void display() {
		System.out.print("The imaginary number is "+this.real);
		if(this.img < 0) {
			System.out.println("" + this.img+"i.");
		} else {
			System.out.println("+" + this.img + "i.");
		}
	}
}

public class prgm1 {
	public static void main(String[] args) {
		complex a = new complex(3, 4);
		complex b = new complex(1, 2);
//		b.add(a);
		b.display();
		b.sub(a);
		b.display();
	}
}
