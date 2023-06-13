package edu.java.swing06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MyFrame myframe = new MyFrame(parent);
					myframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MyFrame(Component parent) {
		this.parent = parent;
		initialize();
	}
	
	public void initialize() {
		setTitle("My Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // <
		
		int x = 100; // 부모 컴포넌트가 null인 경우에 사용할 x좌표 기본값
		int y = 100; // 부모 컴포넌트가 null인 경우에 사용할 y좌표 기본값
		if (parent != null) {
			x = parent.getX(); // 부모 컴포넌트 x좌표
			y = parent.getY(); // 부모 컴포넌트 y좌표
		}
		setBounds(x, y, 450, 300); // 다이얼로그 좌표 (x, y)
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
