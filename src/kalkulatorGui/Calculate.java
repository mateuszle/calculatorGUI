package kalkulatorGui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Calculate {

	static String number = "";
	static String number1 = "";
	static String dzialanie="";
	static int changeNumber = 0;
	static double wynik = 0;
	static double a = 0;
	static double b = 0;
	static int pom;
    static double pom2=0;
    static double pom3=0;
	static int x = 0;
	static int[] operators = new int[2];

	public static void addNumbers() {
		x++;
		if (x == 1) {
			wynik =  Double.parseDouble(number);
		}
		
		if (x > 1)
			equals();
		pom = 1;
		pom3=pom;
	}

	public static void powNumbers(){
		

		pom2=Calculate.wynik;
		if (x == 1||x==0) {
			wynik =  Double.parseDouble(number);
		x++;
		}
		
		
		pom = 5;
		
	}
	
	public static void substractNumbers() {
		x++;

		if (x == 1) {
			wynik =  Double.parseDouble(number);
		
		}

		else {
			if (x > 1)
				equals();
		}
		pom = 2;
		pom3=pom;
	}

	public static void multiplyNumbers() {

		x++;
		if (x == 1) {
			wynik =  Double.parseDouble(number);
			
					
		} else {
			if (x > 1){
				System.out.println("dadda");
				equals();
			}
				
		}
		pom = 3;
		pom3=pom;

	}

	public static void divideNumbers() {

		x++;
		if (x == 1) {
			wynik = Double.parseDouble(number);

		} else {
			if (x > 1)
				equals();
		}
		pom = 4;
		pom3=pom;
	}

	public static void equals() {
		if (pom == 1) {
			wynik +=  Double.parseDouble(number);
		} else if (pom == 2) {
			wynik -=  Double.parseDouble(number);
		} else if (pom == 3) {

			wynik = wynik *  Double.parseDouble(number);

		} else if (pom==4) {
			wynik /= Double.parseDouble(number);
		}
		else{
			System.out.println("to jest pom3"+pom3);
			wynik=Math.pow(wynik, Double.parseDouble(number));
			
			if(pom3==1)
				wynik+=pom2;
			if(pom3==2)
				wynik=pom2-wynik;
			if(pom3==3)
				wynik*=pom2;
			if(pom3==4)
				wynik/=pom2;
				
		}
		System.out.println(number);
		
		
	}

	public static void subDzialanie() {
		int result = Calculate.dzialanie.length() - 1;
		for (int i = result; i > 0; i--) {
			if (Calculate.dzialanie.charAt(i) == '+' || Calculate.dzialanie.charAt(i) == '-'
					|| Calculate.dzialanie.charAt(i) == '*' || Calculate.dzialanie.charAt(i) == '/') {
				  Calculate.dzialanie = Calculate.dzialanie.substring(0, i + 1);
				break;
			}

		}
		
		
	}
	
	public static void changeBackground(JButton button){
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(SystemColor.controlHighlight);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
	}
	
	public static void createButton(JButton button){
		button.setBorderPainted(false);
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		changeBackground(button);
		//Okno.panel_1.add(button);
	}
	
	public static void dzialanie(int pom,String str){
		int wynikInt;
		if (Calculate.dzialanie != "") {
			char result = Calculate.dzialanie.charAt(Calculate.dzialanie.length() - 1);
			System.out.println(result);
			if (result == '+' || result == '-' || result == '*' || result == '/' || result == '.')
				;
			else {
				if (Okno.wybor){
					if (pom == 1) {
						Calculate.addNumbers();
					} else if (pom == 2) {
						Calculate.substractNumbers();
					} else if (pom == 3) {
						Calculate.multiplyNumbers();
					} else if (pom==4) {
						Calculate.divideNumbers();
					}
			
				}
					
				Okno.wybor = true;
				Calculate.pom = pom;
				Calculate.dzialanie += str;
				Okno.textField_1.setText(Calculate.dzialanie);
				if (Calculate.wynik % 1 == 0) {
					wynikInt = (int) Calculate.wynik;
					Okno.textField.setText(Integer.toString(wynikInt));
				} else
					Okno.textField.setText(Double.toString(Calculate.wynik));
				Calculate.number = "";
			}
		} else {
			if (Calculate.wynik == 0)
				;

		}
	}
}







