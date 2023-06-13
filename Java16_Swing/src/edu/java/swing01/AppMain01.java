package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain01 window = new AppMain01();
					window.frame.setVisible(true);// 생성된 JFrame이 보임
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); // JFrame 객체 생성 -> 필드에 할당.
		frame.setBounds(750, 450, 450, 300); // JFrame의 시작 좌표(x, y), 크기(가로, 세로)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//-> JFrame 우상단의 닫기 버튼의 기능 정의 - 프로그램 종료
		
		JLabel lblText = new JLabel("집");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		lblText.setFont(new Font("D2Coding", Font.PLAIN, 32));
		frame.getContentPane().add(lblText, BorderLayout.CENTER);
	}

}
