package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollBar;

public class AppMain03 {

	private JFrame frame;
	private JTextField textField_number1;
	private JTextField textField_number2;
	private JTextArea resultArea;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDiv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(750, 450, 250, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumber1 = new JLabel("num1");
		lblNumber1.setFont(new Font("D2Coding", Font.PLAIN, 17));
		lblNumber1.setBounds(12, 10, 80, 25);
		frame.getContentPane().add(lblNumber1);
		
		JLabel lblNumber2 = new JLabel("num2");
		lblNumber2.setFont(new Font("D2Coding", Font.PLAIN, 17));
		lblNumber2.setBounds(12, 45, 80, 15);
		frame.getContentPane().add(lblNumber2);
		
		textField_number1 = new JTextField();
		textField_number1.setFont(new Font("D2Coding", Font.PLAIN, 17));
		textField_number1.setBounds(104, 12, 120, 21);
		frame.getContentPane().add(textField_number1);
		textField_number1.setColumns(10);
		
		textField_number2 = new JTextField();
		textField_number2.setFont(new Font("D2Coding", Font.PLAIN, 17));
		textField_number2.setBounds(104, 42, 120, 21);
		frame.getContentPane().add(textField_number2);
		textField_number2.setColumns(10);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				plusButtonClick();		
			}
		});
		btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnPlus.setBounds(9, 120, 45, 45);
		frame.getContentPane().add(btnPlus);
				
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnMinus.setBounds(65, 120, 45, 45);
		frame.getContentPane().add(btnMinus);
		
		btnMulti = new JButton("X");
		btnMulti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnMulti.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnMulti.setBounds(122, 120, 45, 45);
		frame.getContentPane().add(btnMulti);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
			}
		});
		btnDiv.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnDiv.setBounds(179, 120, 45, 45);
		frame.getContentPane().add(btnDiv);
		
		resultArea = new JTextArea();
		resultArea.setFont(new Font("D2Coding", Font.PLAIN, 17));
		resultArea.setBounds(9, 175, 213, 176);
		frame.getContentPane().add(resultArea);
	}


	private void handleButtonClick(ActionEvent event) {
//		System.out.println(event.getSource());
		//-> arg로 전달된 ActionEvent 객체에서 이벤트가 발생한 GUI 컴포넌트 정보를 알 수 있다. 
		
		// JTextField에 입력된 문자열을 읽어서 double 타입으로 변환.
		double number1 = 0;
		double number2 = 0;
		try {
			number1 = Double.parseDouble(textField_number1.getText());
			number2 = Double.parseDouble(textField_number2.getText());
		} catch (NumberFormatException ex) {
			resultArea.setText("숫자를 입력하세요");
			return; // 메서드 종료
		}
		double result = 0; // 사칙 연산 결과를 저장할 변수
		String op = ""; // 사칙 연산 연산자 문자열을 저장할 변수
		
		Object Source = event.getSource();
		if (Source == btnPlus) {
			result = number1 + number2;
			op = "+";
		} else if (Source == btnMinus) {
			result = number1 - number2;
			op = "-";
		} else if (Source == btnMulti) {
			result = number1 * number2;
			op = "X";
		} else if (Source == btnDiv) {
			result = number1 / number2;
			op = "/";
		}
		String msg = String.format("%f %s %f = %f", number1, op, number2, result);
		resultArea.setText(result+"");
		resultArea.setText(msg);
	}
}
