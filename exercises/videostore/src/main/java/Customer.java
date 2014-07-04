import java.util.*;

public class Customer {
	private String _name;
	private Vector _rentals =new Vector();

	public Customer(String name) {
		_name = name;
	}
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName() {
		return _name;
	}
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() +  "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
			    each.getDaysRented() > 1) frequentRenterPoints++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
				String.valueOf(each.getCharge()) + "\n";
			totalAmount += each.getCharge();
		}
		// add footer lines
		result += "Amount owed is "+String.valueOf(totalAmount) + "\n";
		result += "You earned "+String.valueOf(frequentRenterPoints) 
 					+ " frequent renter points\n";
		return result;
	}
	public static void main(String[] args) {
		Customer cust = new Customer("Jan Janssen");
		cust.addRental(new Rental (new Movie("SpongeBob", Movie.NEW_RELEASE), 2));
		cust.addRental(new Rental (new Movie("Ice Age 3", Movie.CHILDRENS), 3));
		System.out.println(cust.statement());
	}
}
