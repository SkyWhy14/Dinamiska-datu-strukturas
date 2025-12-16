package Steks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd2 {
/*Izmantojot JOptionPane klases dialoglodziņus datu ievadei un izvadei,
 *  sastādīt programmu, kura pielietojot steku realizēt loterijas trīs laimīgo skaitļu izlozi.
 *   Trīs piegājienos steks tiek aizpildīts ar 10 nejaušiem skaitļiem (bumbaņām) intervālā [0;9].
 *    Skaitļi pa vienam tiek vilkti ārā no steka un viens no skaitļiem (steka virsējais skaitlis) nejauši tiek iegūts un ielikts laimējošo skaitļu stekā. 
 *    Programma nodrošina izlozes izdarīšanu, piefiksējot izlozes veikšanas datumu un laiku,
 *  kā arī laimīgo skaitļu apskatīšanu. Pēc laimīgo skaitļu noteikšanas, 
 *  izlozi atkārtoti var veikt tikai ja pagājusi vismaz 1 minūte.
 * 
 * 
 */
	public static void main(String[] args) {
		Stack<Integer> bumbas = new Stack<>();
		Stack<Integer> laimigie = new Stack<>();
		 String izvele;
		 Random random  = new Random();//
		 LocalDateTime tagad = LocalDateTime.now();
		 DateTimeFormatter formatets = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 String laiksTagad = "Izloze veikta: " + tagad.format(formatets);
		 
		
		
		long laiksPirmsIzlozes = 0;
		long laiksPecIzlozes = 60000; 
		 String [] darbibas = {"Veikt izlozi","Apskatīt laimīgos skaitļus","Apksatit visus skaitlus ","Apturēt programmu"};
		 do {
			 izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
				if(izvele == null) {
					izvele = "Apturēt programmu";
				}
			 switch(izvele) {
			 case "Veikt izlozi":
				 //parada datumu un laiku kad veikta izloze
				
				 
				 laiksPecIzlozes = System.currentTimeMillis();
				 if(laiksPecIzlozes - laiksPirmsIzlozes >= 60000) {
					 laimigie.clear();
					 for(int i =0;i<3;i++) {
						 bumbas.clear();
						 for(int j =0;j<11;j++) {
							 //skaitli no 1 lidz 10
							int bumba = random.nextInt(10)+1;
							bumbas.push(bumba);
						 }
						 
						 int laimigaBumba = bumbas.pop();
						 laimigie.push(laimigaBumba);
					 }
					 JOptionPane.showMessageDialog(null, "Izloze veikta!");
					 JOptionPane.showMessageDialog(null, laiksTagad);
					 laiksPirmsIzlozes = System.currentTimeMillis();
					 				 }else {
					 					 long atlikusaisLaiks = 60000 - (laiksPecIzlozes - laiksPirmsIzlozes);
					 					 JOptionPane.showMessageDialog(null, "Izloze jau veikta! Lūdzu uzgaidiet vēl " + (atlikusaisLaiks / 1000) + " sekundes.");
					 				 }
				 break;
				 						 case "Apskatīt laimīgos skaitļus":
				 		if(laimigie.isEmpty()) {
				 			JOptionPane.showMessageDialog(null, "Nav veikta izloze!");				 				 				 
				 		 }else {
				 			 String laimigieSkaitli = "Laimīgie skaitļi ir: ";
				 			 for(int i =0;i<laimigie.size();i++) {
				 				 laimigieSkaitli += laimigie.get(i) + " ";
				 			 }
				 			 JOptionPane.showMessageDialog(null, laimigieSkaitli);
				 		 }
				 							 break;
				 							 //parada visus skaitlus
				 				 case "Apksatit visus skaitlus ":
				 			 if(laimigie.isEmpty()) {
				 				 JOptionPane.showMessageDialog(null, "Nav veikta izloze!");
				 				 
									 
				 			 }else {
				 				 String visiLaimigie = "visi skaitli ir: ";
				 				 for(int i =0;i<bumbas.size();i++) {
				 					 visiLaimigie += bumbas.get(i) + " ";
				 				 }
				 				 JOptionPane.showMessageDialog(null, visiLaimigie);
				 			 }
				 			 break;
				 							 
				 			 case "Apturēt programmu":
				 				 JOptionPane.showMessageDialog(null, "Programma apturēta!");
				 				 break;
				 
			 }
			 
		 }while(!izvele.equals("Apturēt programmu"));
		 
		 
		

	}

}
