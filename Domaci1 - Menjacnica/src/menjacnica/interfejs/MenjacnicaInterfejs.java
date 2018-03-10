package menjacnica.interfejs;

import java.util.GregorianCalendar;

public interface MenjacnicaInterfejs {
	
	public boolean dodajKurs(String nazivValute, GregorianCalendar datum);
	public boolean obrisiKurs(String nazivValute, GregorianCalendar datum);
	public double vratiKurs(String nazivValute, GregorianCalendar datum);
	
}
