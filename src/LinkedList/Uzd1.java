package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Uzd1 {
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i =0;i<saraksts.size();i++) {
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Produkts atrasts saraksta!",
						"Kļūda", JOptionPane.ERROR_MESSAGE);
				return true;
				
			}
		}
		return false;
	}
		
	public static void main(String[] args) {
		String izvele ,koPievienot ,koAtrast,koNonemt,arKoAizstat;
		int kurPievienot,kurNonemt,kkurMainit;
		LinkedList<String> saraksts = new LinkedList<>();
		
		
		do {
			do {
				izvele = JOptionPane.showInputDialog("Izvelies darbibu:"
						+ "\n1 - Pievienot elementu"
						+ "\n2 - Produktu skaits"
						+ "\n3 - Izvadit produktus"
						+ "\n4 - Atrast produktu"
						+ "\n5 - Pievienot elementu noteiktaja vieta"
						+"\n6 - Nonemt elementu"
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
					
					
				}while((jauEksiste(saraksts, koPievienot) == true )|| !koPievienot.matches("^[\\p{L} ]+$"));
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
						break;
					}
				break;
			case "4":
				do {
					koAtrast = JOptionPane.showInputDialog("Ievadi produktu ko atrast:");
					if(saraksts.contains(koAtrast.toLowerCase())) {
						JOptionPane.showMessageDialog(null, "Produkts atrasts saraksta!");
					}else {
						JOptionPane.showMessageDialog(null, "Produkts nav saraksta!");
					}
					
					break;
				}while(!koAtrast.matches("^[\\p{L} ]+$"));
				break;
			case "5" :
				do {
					koPievienot = JOptionPane.showInputDialog("Ievadi produktu ko pievienot:");
					
					kurPievienot = Integer.parseInt(JOptionPane.showInputDialog("Ievadi indeksa vietu kur pievienot produktu (no 0 lidz " + saraksts.size() + "):"));
					if(kurPievienot <0 || kurPievienot > saraksts.size()) {
						JOptionPane.showMessageDialog(null, "Nepareiza indeksa vieta!", "Kļūda", JOptionPane.ERROR_MESSAGE);
						kurPievienot = Integer.parseInt(JOptionPane.showInputDialog("Ievadi indeksa vietu kur pievienot produktu (no 0 lidz " + saraksts.size() + "):"));
					}else {
						break;
					}
					
				}while((jauEksiste(saraksts, koPievienot) == true )|| !koPievienot.matches("^[\\p{L} ]+$")|| kurPievienot>saraksts.size()|| kurPievienot<0);
				saraksts.add(kurPievienot-1, koPievienot.toLowerCase());
				break;
			case "6":
				do {
					koNonemt = JOptionPane.showInputDialog("Ievadi produktu ko nonemt:");
					
				}while(!koNonemt.matches("^[\\p{L} ]+$")|| !jauEksiste(saraksts, koNonemt));
				if(saraksts.remove(koNonemt.toLowerCase())) 
					JOptionPane.showMessageDialog(null, "Produkts veiksmigi noņemts no saraksta!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
				
				break;
				case "7":
					kurNonemt = Integer.parseInt(JOptionPane.showInputDialog("Ievadi indeksa vietu kuru nonemt (no 0 lidz " + (saraksts.size()-1) + "):"));
					if(kurNonemt <0 || kurNonemt > saraksts.size()-1) {
						JOptionPane.showMessageDialog(null, "Nepareiza indeksa vieta!", "Kļūda", JOptionPane.ERROR_MESSAGE);
					}else {
						saraksts.remove(kurNonemt);
						JOptionPane.showMessageDialog(null, "Produkts veiksmigi noņemts no saraksta!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case "8":
					if(!saraksts.isEmpty()) {
						saraksts.removeFirst();
						JOptionPane.showMessageDialog(null, "Pirmais produkts veiksmigi noņemts no saraksta!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Saraksts ir tukss!", "Kļūda", JOptionPane.ERROR_MESSAGE);
					}
					break;
					case "9":
						if(!saraksts.isEmpty()) {
							saraksts.removeLast();
							JOptionPane.showMessageDialog(null, "Pedejais produkts veiksmigi noņemts no saraksta!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Saraksts ir tukss!", "Kļūda", JOptionPane.ERROR_MESSAGE);
						}
						break;
						case "10":
							break;
							case "11":
								saraksts.sort(String.CASE_INSENSITIVE_ORDER);
								JOptionPane.showMessageDialog(null, "Saraksts veiksmigi sakartots aflabetiski!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
								break;
								case "12":
									saraksts.clear();
									JOptionPane.showMessageDialog(null, "Saraksts veiksmigi nodzests!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
									break;
								case "0":
									JOptionPane.showMessageDialog(null, "Iziet no programmas!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
									break;
									default:
										JOptionPane.showMessageDialog(null, "Nepareiza ievade!", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
			
		}while(!izvele.equals("0"));
		
	}
		

}
