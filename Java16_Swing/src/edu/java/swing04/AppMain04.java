package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class AppMain04 {
	
	///// 이미지 파일의 경로들을 저장하는 배열
	private static final String[] IMAGES = {
			"images/image01.jpg",
			"images/image02.jpg",
			"images/image03.jpg",
			"images/image04.jpg",
			"images/image05.jpg"
	};
	private int curIndex; // 현재 화면에 보여지는 이미지 파일의 인덱스
	
	/////
	
	private JFrame frame;
	private JButton btnPrevious;
	private JLabel lblImage;
	private JButton btnNext;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		///// new ImageIcon("images/images01.jpg")
		lblImage = new JLabel(new ImageIcon(IMAGES[curIndex]));
//		lblImage = new JLabel("IMAGE");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(45, 10, 300, 400);
		frame.getContentPane().add(lblImage);
		// 이미지 초기값
//		lblImage.setIcon(images.get(0));
		
		
	
		btnPrevious = new JButton("<<<");
		btnPrevious.addActionListener(new ActionListener() {
			@Override // 버튼이 클릭됐을 때 호출되는 메서드
			public void actionPerformed(ActionEvent e) {
//				handleButtonClick(e);
				/////
				showPrevImage();
			}
		});
		btnPrevious.setBounds(45, 420, 117, 25);
		frame.getContentPane().add(btnPrevious);
		
		btnNext = new JButton(">>>");
//		btnNext.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				handleButtonClick(e);		
//			}
//		});
		///// Rambda
		btnNext.addActionListener((e) -> showNextImage());
		btnNext.setBounds(228, 420, 117, 25);
		frame.getContentPane().add(btnNext);
	}
	
	/////
	private void showNextImage() {
		if (curIndex < IMAGES.length - 1 ) {
			curIndex ++;		
		} else {
			curIndex = 0;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}

	/////
	private void showPrevImage() {
		if (curIndex > 0) {
			curIndex --;
		} else {
			curIndex = IMAGES.length - 1;
		}
		lblImage.setIcon(new ImageIcon(IMAGES[curIndex]));
	}

//	private void handleButtonClick(ActionEvent event) {
//		int result = 0;
//		Object source = event.getSource();
//		if (source == btnPrevious) {
//			result = -1;
//			lblImage.setIcon(images.get(1 + result));
//		} else if (source == btnNext) {
//			result = +1;
//			lblImage.setIcon(images.get(0 + result));
//		}
//		
//	}

//	List<ImageIcon> images = Arrays.asList(
//			new ImageIcon("images/image01.jpg"), // [0]
//			new ImageIcon("images/image02.jpg"),
//			new ImageIcon("images/image03.jpg"),
//			new ImageIcon("images/image04.jpg"),
//			new ImageIcon("images/image05.jpg") // [4]
//	);
	
	
}
