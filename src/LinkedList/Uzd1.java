package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Uzd1 {
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i =0;i<saraksts.size();i++) {
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Produkts jau eksiste saraksta!",
						"Kļūda", JOptionPane.ERROR_MESSAGE);
				return true;
				
			}
		}
		return false;
	}
		
	public static void main(String[] args) {
		String izvele ,koPievienot,koAtrast,koNonemt,arKoAizstat;
		int kurPievienot,kurNonemt,kkurMainit;
		LinkedList<String> saraksts = new LinkedList<>();
		
		
		do {
			do {
				izvele = JOptionPane.showInputDialog("Izvelies darbibu:"
						+ "\n1 - Pievienot elementu"
						+ "\n2 - Produktu skaits"
						+ "\n3 - Izvadit produktus"
						+ "\n4 - Atrast produktu"
						+ "\n5 - Pievienot elementu noteiktaja vieta"+
						"\n6 - Nonemt elementu"
						+ "\n7 - Nonemt pec indeksa"
						+"\n8 - Nonemt pirmo"
						+"\n9 - Nonemt pedejo"
						+"\n10 - Mainit produktu"
						+"\n11 - Sakartot aflabetiski"
						+"\n12 - Nodzest sarakstu"
						+ "\n0 - Iziet no programmas");
				if(izvele == null)
					izvele = "0";
			}while(!izvele.matches("\\d+"));
			switch(izvele) {
			case  "1":
				do {
					koPievienot = JOptionPane.showInputDialog("Ievadi produktu ko pievienot:");
					
					
				}while((jauEksiste(saraksts, koPievienot)) == true || !koPievienot.matches("[\\p{L}&&\\p{IsLatin}]+"));
				saraksts.add(koPievienot.toLowerCase());
				JOptionPane.showMessageDialog(null, "Produkts veiksmigi pievienots sarakstam!");
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "Saraksta produktu skaits ir: " + saraksts.size());
				break;
			case "3":
				if(saraksts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Saraksts ir tukss!","Informacija",JOptionPane.INFORMATION_MESSAGE);
					}else {
						Iterator<String> izvade = saraksts.iterator();
						String str = "";
						while(izvade.hasNext()) {
							str += izvade.next() + "\n";
						}
						JOptionPane.showMessageDialog(null, "Saraksta produkti ir:\n" + str,"Produktu Saraksts",JOptionPane.INFORMATION_MESSAGE);
						
					}
				
			}
			
		}while(!izvele.equals("0"));
		
	}
		

}
