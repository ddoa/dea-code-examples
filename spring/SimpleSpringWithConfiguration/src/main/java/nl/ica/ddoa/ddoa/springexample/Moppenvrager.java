package nl.ica.ddoa.ddoa.springexample;

public class Moppenvrager {
	private Moppenverteller verteller;

	public Moppenverteller getVerteller() {
		return verteller;
	}

	public void setVerteller(Moppenverteller verteller) {
		this.verteller = verteller;
	}
	
	public void vraagAanIemandEenMop()
	{
		verteller.vertelMop();
	}
}
