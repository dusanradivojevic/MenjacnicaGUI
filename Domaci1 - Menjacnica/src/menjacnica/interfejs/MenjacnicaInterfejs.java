package menjacnica.interfejs;

import java.util.GregorianCalendar;

import menjacnica.Valute.Valuta;

public interface MenjacnicaInterfejs {
	
	public boolean dodajKurs(Valuta val);
	public boolean obrisiKurs(Valuta val);
	public Valuta vratiKurs(String nazivValute, GregorianCalendar datum);
	
}
