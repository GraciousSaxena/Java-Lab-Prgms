/*

Design and develop a Java program for the fruit market problem. The farmer will be able to produce different types of fruits 
(apple, orange, grape, and watermelon), and put them in the market to sell. The market has limited capacity and farmers have to 
stand in a queue if the capacity is exceeded to sell their fruits. Consumers can come to the market any time and purchase their 
desired fruits; and if the fruits they want to buy runs out, they are willing to wait until the supply of that kind is ready. 
Examine and formulate an approach to address this problem and implement the same using Java constructs for programming. 

*/

package prgm7;

import java.util.*;

class Market {
	ArrayList<String> fruits = new ArrayList<> ();
	int number;

	public Market(int no) {
		if (no > 0) {
			this.number = no;
		} else {
			throw new IllegalArgumentException("Invalid Value");
		}
	}

	private synchronized boolean isfull() {
		boolean b = (fruits.size() == this.number);
		return b;
	}

	private synchronized boolean isempty() {
		return fruits.isEmpty();
	}

	public synchronized void farmer() {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < this.number; i++) {
			if (isfull()) {
				System.out.println("Queue currently full!!!\nTry again later....");
				try {
					wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Process Interruption!!!");
				}
			} else {
				System.out.println("Enter the fruit to be added: ");

				String f = in.next();
				
				fruits.add(f);

				System.out.println("Fruit " + f + " is added...\n");
				notify();
			}
		}
		in.close();
	}

	public synchronized void consumer() {
		for (int i = 0; i < this.number; i++) {
			if (isempty()) {
				System.out.println("The stocks are currently empty!!!\nTry again later....");
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Process Interruption!!!");
				}
			} else {
				String removedf = fruits.remove(0);

				System.out.println("Current fruit requested is " + removedf);
				notifyAll();
			}
		}
	}
}

class Farmer extends Thread {
	Market m;

	Farmer(Market m) {
		this.m = m;
	}

	public void run() {
		m.farmer();
	}
}

class Consumer extends Thread {
	Market m;

	Consumer(Market m) {
		this.m = m;
	}

	public void run() {
		m.consumer();
	}
}

public class Main {
	public static void main(String[] args) {
		Market m = new Market(3);

		Farmer f = new Farmer(m);
		Consumer c = new Consumer(m);

		f.start();
		c.start();
	}
}
