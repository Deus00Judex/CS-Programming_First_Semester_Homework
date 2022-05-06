package hausaufgaben;


public class Zinsrechnung 
{

	public static void main (String[] args) 
	{
	double startbetrag = 0.0;
	double zinssatz = 0.0;
	String berechnungszweck = "";
	String promt = "Berechnung Erfolgt";

	
	startbetrag = SimpleIO.getDouble("Bitte gebe einen Startbetrag ein !");
	if (startbetrag <= 0)
	{	
		SimpleIO.output("Fehler Flasche Eingabe");
		return;
	}
	
	zinssatz = SimpleIO.getDouble("Bitte gebe einen Zinssatz mit Punktschreibweise ein !");
	if ((zinssatz == 0.0) || (String.valueOf(zinssatz).contains(",")))
	{	
		SimpleIO.output("Fehler Flasche Eingabe");
		return;
	}
	
	berechnungszweck = SimpleIO.getString("Bitte gebe einen Berechnungszweck ein ! (Ziel oder Zeit)");
	while (!(berechnungszweck.equals("Ziel")) && !(berechnungszweck.equals("Zeit")))
	{	
		SimpleIO.output("Fehler Flasche Eingabe");
		return;
	}
	
	switch (berechnungszweck)
	{	
	case "Ziel":
		
		double zielbetrag = 0;
		double startbetragtemp = startbetrag;
		int jahrebiszielbetrag = 0;
		while (zielbetrag <= 0)
		{	
			zielbetrag = SimpleIO.getDouble("Bitte gebe einen Zielbetrag ein !");
		}
		while (startbetragtemp < zielbetrag)
		{
			jahrebiszielbetrag++;
			startbetragtemp = startbetragtemp * (1+(zinssatz/100));
		}

		SimpleIO.output("Bei einem Zinssatz von " + zinssatz + " und einem Startbetrag von " + startbetrag + "€ braucht es " + jahrebiszielbetrag + " Jahren bis " + zielbetrag + "€ gespart sind !",promt);
		return;
		
	case "Zeit":
		
		int sparjahre = 0;
		double sparbetrag = startbetrag;
		while (sparjahre <= 0)
		{	
			sparjahre = SimpleIO.getInt("Wieveiel Jahre möchten sie sparen ?");
		}
		int sparjahretemp = sparjahre;
			while (sparjahretemp>0)
			{
				sparbetrag = sparbetrag * (1+(zinssatz/100));
				sparjahretemp--;
			}
			SimpleIO.output("Bei einem Zinssatz von " + zinssatz + " und einem Startbetrag von " + startbetrag + "€ hat man nach " + sparjahre + " Jahren " + (float) sparbetrag  + "€ gespart !",promt);
			return;
			
			
			
	}
		
	}	
	
	
	

}

	
