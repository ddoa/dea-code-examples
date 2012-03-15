package nl.ica.ddoa.dda.springexample;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

public class Moppenvrager {
	@Autowired
	//@Qualifier("aardbei")
	Moppenverteller verteller;

	public void vraagAanIemandEenMop()
	{
		this.verteller.vertelMop();
	}

}
