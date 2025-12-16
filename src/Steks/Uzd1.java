package Steks;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd1 {
	public static void main(String[] args) {
	String izvele,vards = "";
	Stack<String> mansSteks = new Stack<>();
	String [] darbibas = {"Ievadi vārdu","Noteikt vārda garumu","Apskatīt pedējo burtu","Apgriezt vārdu","Apturēt programmu"};
	
	
	
	do {
		izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību izvēlne", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
		if(izvele == null) {
			izvele = "Apturēt programmu";
		}
		switch(izvele) {
			case "Ievadi vārdu":
				if(mansSteks.isEmpty()) {
					do {
						vards = JOptionPane.showInputDialog("Ievadi vārdu:");
					}while(vards.contains(" "));
					for(int i =0;i<vards.length();i++) {
						mansSteks.push(Character.toString(vards.charAt(i)));
					}
					
					
				}else
					JOptionPane.showMessageDialog(null, "Steks nav tukšs!","Brīdinājums",JOptionPane.WARNING_MESSAGE);
				break;
				case "Noteikt vārda garumu":
					if(!mansSteks.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vārda garums ir: " + mansSteks.size() + " burti");
					break;
					}else {
						JOptionPane.showMessageDialog(null, "Steks ir tukšs!","Kļūda",JOptionPane.ERROR_MESSAGE);
					}
					case "Apskatīt pedējo burtu":
						if(!mansSteks.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Pēdējais burts ir: " + mansSteks.peek());
							}else {
								JOptionPane.showMessageDialog(null, "Steks ir tukšs!","Kļūda",JOptionPane.ERROR_MESSAGE);
							}
						break;
						case "Apgriezt vārdu":
							if(!mansSteks.isEmpty()) {
								vards = "";
								int garums = mansSteks.size();
								for(int i =0;i<garums;i++) {
									vards += mansSteks.pop();
									}
								JOptionPane.showMessageDialog(null, "Apgrieztais vārds ir: " + vards);
								}else {
									JOptionPane.showMessageDialog(null, "Steks ir tukšs!","Kļūda",JOptionPane.ERROR_MESSAGE);
								}
							break;
						case "Apturēt programmu":
							JOptionPane.showMessageDialog(null, "Programma apturēta!");
							break;
				
		}
		
	}while(!izvele.equals("Apturēt programmu"));
}

}
