package kalkulatorGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.math.*;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class Okno {

	private JFrame frmCalculator;
	static JTextField textField;
	static JTextField textField_1;
	public static boolean wybor = true;
	public static boolean wybor2 = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno window = new Okno();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Okno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setBackground(Color.WHITE);
		frmCalculator.setFont(new Font("Dialog", Font.PLAIN, 26));
		frmCalculator.setForeground(Color.WHITE);
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 466, 587);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 460, 182);
		frmCalculator.getContentPane().add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Yu Gothic UI", Font.BOLD, 39));
		textField.setBounds(0, 52, 460, 130);
		panel.add(textField);
		textField.setColumns(10);
		textField.setBorder(null);
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(0, 29, 460, 30);
		textField_1.setBorder(null);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 190, 460, 368);
		frmCalculator.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(6, 4));

		// procenty
		JButton btnNewButton_23 = new JButton("%");
		Calculate.createButton(btnNewButton_23);
	
		btnNewButton_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double c = Double.parseDouble(Calculate.number);
				c = (c * Calculate.wynik) / 100;

				wybor2 = false;

				if (Calculate.x == 0) {
					;
				} else if (Calculate.x == 1 && !wybor) {
					;
				} else {
					Calculate.number = String.valueOf(c);
					textField.setText(Calculate.number);
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);
				}

			}
		});
		panel_1.add(btnNewButton_23);

		// pierwiastkowanie

		JButton btnNewButton_22 = new JButton("\u221A");
		Calculate.createButton(btnNewButton_22);
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				wybor2 = false;
				int wynikInt;

				Calculate.number = String.valueOf(Math.sqrt(Double.parseDouble(Calculate.number)));

				if (Calculate.x == 0) {
					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				} else if (Calculate.x == 1 && !wybor) {

					Calculate.number = String.valueOf(Math.sqrt(Calculate.wynik));
					Calculate.wynik = Double.parseDouble(Calculate.number);
					Calculate.dzialanie = Calculate.number;
				} else {
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}
				if (Double.parseDouble(Calculate.number) % 1 == 0) {
					wynikInt = (int) Double.parseDouble(Calculate.number);
					textField.setText(Integer.toString(wynikInt));
				} else
					textField.setText(Calculate.number);

			}

		});
		btnNewButton_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_22);

		JButton btnNewButton_21 = new JButton("x^2");
		Calculate.createButton(btnNewButton_21);
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wybor2 = false;
				double x = Double.parseDouble(Calculate.number);
				x = x * x;
				Calculate.number = Double.toString(x);

				int wynikInt;

				if (Calculate.x == 0) {

					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);
				} else if (Calculate.x == 1 && !wybor) {
					Calculate.wynik *= Calculate.wynik;
					Calculate.number = Double.toString(Calculate.wynik);
					Calculate.dzialanie = Calculate.number;
					Calculate.wynik = Double.parseDouble(Calculate.number);
				} else {

					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}
				if (Double.parseDouble(Calculate.number) % 1 == 0) {
					wynikInt = (int) Double.parseDouble(Calculate.number);
					textField.setText(Integer.toString(wynikInt));
				} else
					textField.setText(Calculate.number);

			}

		});
		btnNewButton_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_21);

		JButton btnNewButton_20 = new JButton("1/X");
		Calculate.createButton(btnNewButton_20);
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char result = Calculate.dzialanie.charAt(Calculate.dzialanie.length() - 1);

				if (result == '+' || result == '-' || result == '*' || result == '/' || result == '.')
					;
				else {
					wybor2 = false;
					double x = Double.parseDouble(Calculate.number);
					x = 1 / x;
					Calculate.number = Double.toString(x);

					if (Calculate.x == 0) {

						Calculate.dzialanie = Calculate.number;
						textField_1.setText(Calculate.dzialanie);
					} else if (Calculate.x == 1 && !wybor) {
						Calculate.wynik = 1 / Calculate.wynik;
						Calculate.number = Double.toString(Calculate.wynik);
						Calculate.dzialanie = Calculate.number;
						Calculate.wynik = Double.parseDouble(Calculate.number);
					} else {

						Calculate.subDzialanie();
						Calculate.dzialanie += Calculate.number;
						textField_1.setText(Calculate.dzialanie);

					}
					textField.setText(Calculate.number);
				}

			}
		});
		btnNewButton_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(btnNewButton_20);

		JButton btnNewButton_12 = new JButton("CE");
		Calculate.createButton(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Calculate.x == 0) {
					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					wybor = true;
					Calculate.wynik = 0;
					Calculate.x = 0;

				}

				String str = textField_1.getText();
				if (str.equals("")) {

					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					wybor = true;
					Calculate.wynik = 0;
					Calculate.x = 0;
				} else {

					if (wybor) {

						Calculate.subDzialanie();

					} else {
						Calculate.dzialanie = "";
					}
					Calculate.number = Double.toString(Calculate.wynik);
					// Calculate.dzialanie=Double.toString(Calculate.wynik);
					textField_1.setText(Calculate.dzialanie);
					textField.setText(Double.toString(Calculate.wynik));
					Calculate.x = 0;
				}

			}
		});
		btnNewButton_12.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		panel_1.add(btnNewButton_12);

		JButton btnNewButton_2 = new JButton("C");
		Calculate.createButton(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calculate.number = "";
				Calculate.dzialanie = "";
				textField.setText("");
				textField_1.setText("");
				Calculate.wynik = 0;
				Calculate.x = 0;
				wybor = true;
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("BACK");
		Calculate.createButton(btnNewButton_5);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Calculate.x == 1 && !wybor) {
					;
				} else {
					char result = Calculate.dzialanie.charAt(Calculate.dzialanie.length() - 1);
					System.out.println(result);
					if (result == '+' || result == '-' || result == '*' || result == '/')
						;
					else {
						Calculate.number = Calculate.number.substring(0, Calculate.number.length() - 1);
						Calculate.dzialanie = Calculate.dzialanie.substring(0, Calculate.dzialanie.length() - 1);
						textField_1.setText(Calculate.dzialanie);
						textField.setText(Calculate.number);

					}
				}

			}
		});
		

		//DZIELENIE
		
		JButton btnNewButton_15 = new JButton("/");
		Calculate.createButton(btnNewButton_15);
		btnNewButton_15.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculate.dzialanie(4,"/");

			}
		});
		panel_1.add(btnNewButton_15);

		JButton btnNewButton_19 = new JButton("7");
		Calculate.createButton(btnNewButton_19);
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Numbers.printNumber("7");
			}
		});

		btnNewButton_19.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnNewButton_19.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.add(btnNewButton_19);

		JButton btnNewButton_18 = new JButton("8");
		Calculate.createButton(btnNewButton_18);
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("8");
			}
		});
		btnNewButton_18.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_18);

		JButton btnNewButton_17 = new JButton("9");
		Calculate.createButton(btnNewButton_17);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("9");
			}
		});
		btnNewButton_17.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_17);

		
		//MNOZENIE
		
		JButton btnNewButton_16 = new JButton("*");
		Calculate.createButton(btnNewButton_16);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculate.dzialanie(3,"*");
			}
		});
		btnNewButton_16.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_16);

		
		
		JButton btnNewButton_14 = new JButton("4");
		Calculate.createButton(btnNewButton_14);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("4");
			}
		});
		btnNewButton_14.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_13 = new JButton("5");
		Calculate.createButton(btnNewButton_13);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("5");
			}
		});
		btnNewButton_13.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_13);

		JButton btnNewButton_10 = new JButton("6");
		Calculate.createButton(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("6");
			}
		});
		btnNewButton_10.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_10);

		
		//ODEJMOWANIE
		
		JButton btnNewButton_11 = new JButton("-");
		Calculate.createButton(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Calculate.dzialanie(2,"-");
			}
		});
		btnNewButton_11.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_11);

		
		
		
		JButton btnNewButton_9 = new JButton("1");
		Calculate.createButton(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("1");
			}
		});
		btnNewButton_9.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_9);

		JButton btnNewButton_8 = new JButton("2");
		Calculate.createButton(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("2");
			}
		});
		btnNewButton_8.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_8);

		JButton btnNewButton_7 = new JButton("3");
		Calculate.createButton(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Numbers.printNumber("3");
			}
		});
		btnNewButton_7.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_7);

		
		//DODAWANIE
		
		JButton btnNewButton_6 = new JButton("+");
		Calculate.createButton(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculate.dzialanie(1,"+");

			}
		});
		btnNewButton_6.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_6);

		
		
		JButton btnNewButton_4 = new JButton("+/-");
		Calculate.createButton(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double d = Double.parseDouble(Calculate.number);
				d = d - (2 * d);
				Calculate.number = Double.toString(d);

				if (Calculate.x == 0) {
					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				} else if (Calculate.x == 1 && !wybor) {
					Calculate.number = Double.toString(Calculate.wynik - (2 * Calculate.wynik));
					Calculate.wynik = Double.parseDouble(Calculate.number);
					Calculate.dzialanie = Calculate.number;
				} else {
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}
				textField.setText(Calculate.number);

			}
		});
		btnNewButton_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("0");
		Calculate.createButton(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				if (Calculate.x == 0 && !wybor2 || (Calculate.x == 1 && !wybor2)) {
					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					Calculate.wynik = 0;
					Calculate.x = 0;
					wybor = true;
				}
				else if (Calculate.x == 1 && !wybor) {
					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					Calculate.wynik = 0;
					Calculate.x = 0;
					wybor = true;
				}else{
					if(Calculate.number.equals("0")){
						  Calculate.number="";
						  Calculate.dzialanie = "";
					  }
					Calculate.number += Calculate.number = "0";
					Calculate.dzialanie += "0";
					textField.setText(Calculate.number);
					textField_1.setText(Calculate.dzialanie);
					wybor2 = true;
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_1 = new JButton(".");
		Calculate.createButton(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Calculate.x == 1 && !wybor) {
					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					Calculate.wynik = 0;
					Calculate.x = 0;
					wybor = true;
				} else {
					Calculate.number += Calculate.number = ".";
					textField.setText(Calculate.number);
					Calculate.dzialanie += ".";
					textField_1.setText(Calculate.dzialanie);
				}

			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("=");
		Calculate.createButton(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int wynikInt;

				if (Calculate.x == 0) {
					Calculate.number = "";
					Calculate.dzialanie = "";
					textField.setText("");
					textField_1.setText("");
					Calculate.wynik = 0;
					Calculate.x = 0;

				}
				Calculate.equals();
				Calculate.dzialanie = (Double.toString(Calculate.wynik));
				if (Calculate.wynik % 1 == 0) {
					wynikInt = (int) Calculate.wynik;
					textField.setText(Integer.toString(wynikInt));
				} else
					textField.setText(Double.toString(Calculate.wynik));
				textField_1.setText("");
				wybor = false;
				Calculate.x = 1;

			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 23));
		panel_1.add(btnNewButton);

		JButton btnNewButton_24 = new JButton("sin");
		Calculate.createButton(btnNewButton_24);
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calculate.number = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(Calculate.number))));
				wybor2 = false;

				if (Calculate.x == 0) {
					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				} else if (Calculate.x == 1 && !wybor) {
					Calculate.number = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(Calculate.number))));
					Calculate.wynik = Double.parseDouble(Calculate.number);
					Calculate.dzialanie = Calculate.number;
				} else {
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}
				textField.setText(Calculate.number);

			}

		});
		btnNewButton_24.setBounds(0, 127, 115, 55);
		panel.add(btnNewButton_24);
		btnNewButton_24.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton_25 = new JButton("cos");
		Calculate.createButton(btnNewButton_25);
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double angleInRadian = Math.toRadians(Double.parseDouble(Calculate.number));
				Calculate.number = String.valueOf(Math.cos(angleInRadian));
				wybor2 = false;

				if (Calculate.x == 0) {
					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				} else if (Calculate.x == 1 && !wybor) {
					angleInRadian = Math.toRadians(Calculate.wynik);
					Calculate.number = String.valueOf(Math.cos(angleInRadian));
					Calculate.wynik = Double.parseDouble(Calculate.number);
					Calculate.dzialanie = Calculate.number;
				} else {
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}
				textField.setText(Calculate.number);
			}
		});
		btnNewButton_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_25.setBounds(113, 127, 115, 55);
		panel.add(btnNewButton_25);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String) comboBox.getSelectedItem();
				if (str.equals("Zaawansowany")) {
					textField.setBounds(0, 52, 460, 75);
					btnNewButton_24.setVisible(true);

				}

				if (str.equals("Podstawowy")) {
					textField.setBounds(0, 52, 460, 130);

				}

			}
		});

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Podstawowy", "Zaawansowany" }));
		comboBox.setBounds(0, 0, 122, 20);
		panel.add(comboBox);

		JButton btnNewButton_26 = new JButton("!");
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wybor2 = false;
				int wynikInt;
				double n = Double.parseDouble(Calculate.number);
				double silnia = 1;
				for (int i = 2; i < n + 1; i++) {
					silnia = silnia * i;
				}

				Calculate.number = Double.toString(silnia);

				if (Calculate.x == 0) {
					Calculate.dzialanie = Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				} else if (Calculate.x == 1 && !wybor) {
					n = Calculate.wynik;
					silnia = 1;
					for (int i = 2; i < n + 1; i++) {
						silnia = silnia * i;
					}

					Calculate.wynik = Double.parseDouble(Calculate.number);
					Calculate.dzialanie = Calculate.number;
				} else {
					Calculate.subDzialanie();
					Calculate.dzialanie += Calculate.number;
					textField_1.setText(Calculate.dzialanie);

				}

				if (Double.parseDouble(Calculate.number) % 1 == 0) {
					wynikInt = (int) Double.parseDouble(Calculate.number);
					textField.setText(Integer.toString(wynikInt));
				} else
					textField.setText(Calculate.number);

			}
		});
		Calculate.createButton(btnNewButton_26);
		btnNewButton_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_26.setBounds(223, 127, 122, 55);
		panel.add(btnNewButton_26);

		JButton btnNewButton_27 = new JButton("x^y");
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// wybor2=false;

				if (Calculate.wynik != 0) {

					Calculate.powNumbers();

					textField.setText(Double.toString(Calculate.wynik));
					Calculate.number = "";
					Calculate.dzialanie += "^";
					textField_1.setText(Calculate.dzialanie);
				} else {
					if (Calculate.dzialanie != "") {
						char result = Calculate.dzialanie.charAt(Calculate.dzialanie.length() - 1);
						System.out.println(result);
						if (result == '+' || result == '-' || result == '*' || result == '/')
							;
						else {

							if (wybor) {
								Calculate.powNumbers();
							}

							wybor = true;
							Calculate.pom = 5;
							Calculate.dzialanie += "^";
							textField.setText(Double.toString(Calculate.wynik));
							textField_1.setText(Calculate.dzialanie);
							Calculate.number = "";
						}
					} else {
						Calculate.powNumbers();
						textField.setText(Double.toString(Calculate.wynik));
						Calculate.number = "";
						Calculate.dzialanie += "^";
						textField_1.setText(Calculate.dzialanie);
					}
				}

			}
		});
		Calculate.createButton(btnNewButton_27);
		btnNewButton_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_27.setBounds(339, 127, 121, 55);
		panel.add(btnNewButton_27);

		frmCalculator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				frmCalculator.getContentPane(), panel, textField, textField_1, panel_1, btnNewButton_23,
				btnNewButton_22, btnNewButton_21, btnNewButton_20, btnNewButton_12, btnNewButton_2, btnNewButton_5,
				btnNewButton_15, btnNewButton_19, btnNewButton_18, btnNewButton_17, btnNewButton_16, btnNewButton_14,
				btnNewButton_13, btnNewButton_10, btnNewButton_11, btnNewButton_9, btnNewButton_8, btnNewButton_7,
				btnNewButton_6, btnNewButton_4, btnNewButton_3, btnNewButton_1, btnNewButton }));
	}
}
