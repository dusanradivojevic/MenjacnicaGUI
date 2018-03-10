package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.Valute.Valuta;
import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	private LinkedList<Valuta> valute = new LinkedList<>();

	@Override
	public boolean dodajKurs(Valuta val) {
		valute.add(val);
		return true;
	}

	@Override
	public boolean obrisiKurs(Valuta val) {
		if (!valute.contains(val))
			throw new RuntimeException("Valuta ne postoji u listi!");
		
		int i = valute.indexOf(val);
		valute.remove(i);
		return true;
	}

	@Override
	public Valuta vratiKurs(String nazivValute, GregorianCalendar datum) {
		Valuta val = new Valuta(nazivValute, datum);
			
		if (valute.contains(val)) {
			int i = valute.indexOf(val);
			return valute.get(i);
		}
		
		throw new RuntimeException("Valuta ne postoji u listi!");
	}
	
}
