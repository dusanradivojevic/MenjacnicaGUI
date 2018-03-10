package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.Valute.Valuta;
import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs{
	
	private LinkedList<Valuta> valute = new LinkedList<>();

	@Override
	public boolean dodajKurs(Valuta val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiKurs(Valuta val) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Valuta vratiKurs(String nazivValute, GregorianCalendar datum) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
