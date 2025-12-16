package Steks;

import java.util.Stack;

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
		long laiksPirmsIzlozes = 0;
		long laiksPecIzlozes = 60000; //1 minute in milliseconds
		 String [] darbibas = {"Veikt izlozi","Apskatīt laimīgos skaitļus","Apturēt programmu"};
		 
		

	}

}
