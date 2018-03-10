package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.Valute.Valuta;
import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	private LinkedList<Valuta> valute = new LinkedList<>();

	@Override
	public boolean dodajKurs(Valuta val) {
		if (val == null)
			throw new RuntimeException("Valuta ne sme biti null!");
		
		if (valute.contains(val)) {
			System.out.println("Valuta vec postoji");
			return false;
		}
		
		valute.add(val);
		return true;
	}

	@Override
	public boolean obrisiKurs(Valuta val) {
		if (!valute.contains(val)) {
			System.out.println("Lista valuta ne sadrzi unetu valutu!");
			return false;
		}
		
		for (int i = 0; i < valute.size(); i++) {
			Valuta v = valute.get(i);
			
			if (v.getNaziv().equals(val.getNaziv()) && v.getDatum().equals(val.getDatum()))
				valute.remove(i);
		}
		
		return true;
	}

	@Override
	public Valuta vratiKurs(String nazivValute, GregorianCalendar datum) {	
		
		for (int i = 0; i < valute.size(); i++) {
			Valuta v = valute.get(i);
			
			if (v.getNaziv().equals(nazivValute) && v.getDatum().equals(datum))
				return v;
		}
		
		throw new RuntimeException("Ne postoji takva valuta u listi!");
	}
	
}
