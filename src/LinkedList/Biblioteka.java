package LinkedList;

import java.util.LinkedList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Biblioteka {

    static String virknesParbaude(String zinojums, String nokl) {
        String ievade;
        do {
            ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
            if (ievade == null)
                return null;
            ievade = ievade.trim();
        } while (!Pattern.matches("^[\\p{L} .]+$", ievade));
        return ievade;
    }

    static int skaitlaParbaude(String zinojums, int tips) {
        String ievade;
        int skaitlis;
        while (true) {
            ievade = JOptionPane.showInputDialog(null, zinojums, "Skaitļa ievade", JOptionPane.INFORMATION_MESSAGE);
            if (ievade == null)
                return -1;
            try {
                skaitlis = Integer.parseInt(ievade);
                if (tips == 1 && skaitlis <= 0) {
                    JOptionPane.showMessageDialog(null, "Lūdzu, ievadi pozitīvu skaitli!", "Kļūda",
                            JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                return skaitlis;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ievadītā vērtība nav derīgs skaitlis!", "Kļūda",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static double skaitlaParbaude(String zinojums, double tips) {
        String ievade;
        double skaitlis;
        while (true) {
            ievade = JOptionPane.showInputDialog(null, zinojums, tips);
            if (ievade == null)
                return -1;
            try {
                skaitlis = Double.parseDouble(ievade);
                if (skaitlis < 0.1) {
                    JOptionPane.showMessageDialog(null, "Ievadīts nepareizs skaitlis!", "Nekorekti dati",
                            JOptionPane.WARNING_MESSAGE);
                }
                return skaitlis;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nepareizs skaitlis ir ievadīts", "Kļūda",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static int meklet(LinkedList<Gramata> plaukts, String nosaukums) {
        for (int i = 0; i < plaukts.size(); i++) {
            if (plaukts.get(i).getNosaukums().equalsIgnoreCase(nosaukums)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String nosaukums, autors, izdevnieciba, izvelne;
        int id = 1, skaits, lppSk, indekss;
        double cena;

        LinkedList<Gramata> plaukts = new LinkedList<>();
        String[] darbibas = {
                "Pievienot grāmatu",
                "Noņemt grāmatu",
                "Apskatīt grāmatu",
                "Iznomāt grāmatu",
                "Atdot grāmatu",
                "Iziet no programmas"
        };

        do {
            izvelne = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību:", "Darbību saraksts",
                    JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);

            if (izvelne == null) {
                izvelne = "Iziet no programmas";
            }

            switch (izvelne) {
                case "Pievienot grāmatu":
                    nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "nigga boy");
                    if (nosaukums == null) break;
                    //pabaudi vai tada grammata jau nav ielikta plaukta
                    
                    
                    autors = virknesParbaude("Ieraksti autora vārdu", "J.K. Rowling");
                    if (autors == null) break;

                    izdevnieciba = virknesParbaude("Ieraksti izdevniecību", "Bloomsbury");
                    if (izdevnieciba == null) break;

                    skaits = skaitlaParbaude("Norādi eksemplāru skaitu", 1);
                    if (skaits == -1) break;

                    lppSk = skaitlaParbaude("Norādi lappušu skaitu", 10);
                    if (lppSk == -1) break;

                    cena = skaitlaParbaude("Norādi grāmatas cenu", 0.1);
                    if (cena == -1.0) break;

                    plaukts.add(new Gramata(id++, skaits, lppSk, nosaukums, autors, izdevnieciba, cena));
                    JOptionPane.showMessageDialog(null, "Grāmata pievienota!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Noņemt grāmatu":
                    if (plaukts.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Plaukts ir tukšs!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu ko vēlies noņemt", "Harry Potter un filozofu akmens");
                    if (nosaukums == null) break;

                    indekss = meklet(plaukts, nosaukums);
                    if (indekss == -1) {
                        JOptionPane.showMessageDialog(null, "Grāmata nav plauktā!", "Kļūda", JOptionPane.ERROR_MESSAGE);
                    } else {
                        plaukts.remove(indekss);
                        JOptionPane.showMessageDialog(null, "Grāmata noņemta no plaukta!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "Apskatīt grāmatu":
                						if (plaukts.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Plaukts ir tukšs!", "Kļūda", JOptionPane.ERROR_MESSAGE);
						break;
					}else {
						nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu ko vēlies apskatīt", "nigga boy");
						if (nosaukums == null) break;
						indekss = meklet(plaukts, nosaukums);
						if(indekss == -1) {
							JOptionPane.showMessageDialog(null, "Grāmata nav plauktā!", "Kļūda", JOptionPane.ERROR_MESSAGE);
							}else {
								
								plaukts.get(indekss).info();
							}
					}
                	break;
                case "Iznomāt grāmatu":
    				
    				if(plaukts.isEmpty())
    					JOptionPane.showMessageDialog(null, "Nav plauktā nevienas grāmatas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
    				else {
    					nosaukums = virknesParbaude("Kādu grāmatu meklējat", "nigga boy");
    					
    					if(nosaukums == null)
    						break;
    					
    					indekss = meklet(plaukts, nosaukums);
    					
    					if(indekss == -1)
    						JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neotrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
    					else {
    						plaukts.get(indekss).panemtGramatu();
    					}
    						
    				}
    				
    				break;
    				
                case "Atdot grāmatu":
                if(plaukts.isEmpty())
                JOptionPane.showMessageDialog(null, "Nav plauktā nevienas grāmatas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
                else {
                	nosaukums = virknesParbaude("Kādu grāmatu vēlaties atdot", "nigga boy");
					
					if(nosaukums == null)
						break;
					
					indekss = meklet(plaukts, nosaukums);
					
					if(indekss == -1)
						JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neotrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					else {
						plaukts.get(indekss).panemtGramatu();
						
					}
                }
                break;
                	
                case "Iziet no programmas":
                	JOptionPane.showMessageDialog(null, "Programma tika apturēta","Paziņojums",JOptionPane.INFORMATION_MESSAGE);
                    
            }

        } while (!izvelne.equals("Iziet no programmas"));

         	
    }
}
