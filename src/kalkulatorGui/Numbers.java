package kalkulatorGui;

public class Numbers {

	
  public static void printNumber(String str){
	  if (!Calculate.dzialanie.equals("")) {
			char result = Calculate.dzialanie.charAt(Calculate.dzialanie.length() - 1);
			System.out.println(result);
			if (result == '+' || result == '-' || result == '*' || result == '/')
				;
			else{
				 if(Calculate.x==0&&!Okno.wybor2||(Calculate.x == 1 && !Okno.wybor2)){
						Calculate.number = "";
						Calculate.dzialanie = "";
						Okno.textField.setText("");
						Okno.textField_1.setText("");
						Calculate.wynik = 0;
						Calculate.x = 0;
						Okno.wybor = true;
					}
					else if (Calculate.x == 1 && !Okno.wybor) {	
						Calculate.number = "";
						Calculate.dzialanie = "";
						Okno.textField.setText("");
						Okno.textField_1.setText("");
						Calculate.wynik = 0;
						Calculate.x = 0;
						Okno.wybor = true;
					}
				
			}
		}
		else{
			
			;
		}
	  if(Calculate.number.equals("0")){
		  Calculate.number="";
		  Calculate.dzialanie = "";
	  }
		 
		Calculate.number += Calculate.number = str;
		Okno.textField.setText(Calculate.number);
		Calculate.dzialanie += str;
		Okno.textField_1.setText(Calculate.dzialanie);
		Okno.wybor2 = true;
	}
	
}
