package nl.ica.ddoa.dda.springexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Serves as a Repository (see http://en.wikipedia.org/wiki/Domain-driven_design) 
 * for the Person class/datastructure.
 * 
 * @author mdkr
 */
public class PersonRepository {
	public List<Person> list() {
		return lst;
	}

	public void add(Person p) {
		lst.add(p);
		mngr.save(p);
	}

	public void setMngr(DatabaseManager mngr) {
		this.mngr = mngr;
	}

	private List<Person> lst = new ArrayList<Person>();
	private DatabaseManager mngr;
}
