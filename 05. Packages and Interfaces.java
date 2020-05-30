/*

Create two classes called Lion and Snake  that implements all the methods defined in an interface Animal. Declare eat() method 
in Animal interface and display eating habits of that particular animal .Create an interface called Tired Animal. In Tired 
Animal interface add method definition to an existing interface by extending Animal interface to verify Extending Interface 
concept in java.
Note: Lion and Snake implement the required eat( ) method and has some of its own methods and instance variables

 */

interface Animal {
	void eat();
	void sound();
}

interface TiredAnimal extends Animal{
	void tired();
}

class snake implements Animal, TiredAnimal{
	public void eat() {
		System.out.println("Snake:: I am carnivorous!");
	}
	public void tired() {
		System.out.println("Snake:: I am never lazy!");		
	}
	public void sound() {		
		System.out.println("Snake:: I hissss!");
	}
}

class lion implements Animal, TiredAnimal{

	public void tired() {
		System.out.println("Lion:: I am always lazy!");
	}

	public void eat() {
		System.out.println("Lion:: I am carnivorous!");
	}

	public void sound() {	
		System.out.println("Lion:: I roar!");
	}
}

public class Main {
	public static void main(String[] args) {
		snake s = new snake();
		lion l = new lion();
		s.eat();
		s.sound();
		s.tired();
		
		l.eat();
		l.sound();
		l.tired();
		
	}
}
