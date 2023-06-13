package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
	
//	private int curIndex;
	
	private JFrame frame;
	private JLabel lblKorean;
	private JButton btnInsert;
	private JButton btnDelete;
	private JTable table;
	private JTextField textEnglish;
	private JTextField textMath;
	private JScrollPane scrollPane;
	private JTextField textKorean;
	private JLabel lblEnglish;
	private JLabel lblMath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 400, 350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국어");
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setBounds(25, 25, 100, 30);
		frame.getContentPane().add(lblKorean);
		
		textKorean = new JTextField();
		textKorean.setHorizontalAlignment(SwingConstants.CENTER);
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textKorean.setBounds(153, 25, 140, 30);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				try {
//					handleInsertButtonClick();
//				} catch (NumberFormatException except) {
//					JOptionPane.showMessageDialog(frame, "정수를 입력하세용");
//				}
				/////
				handleInsertButtonClick();
			}
		});
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnInsert.setBounds(148, 162, 80, 20);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				try {
//					handleDeleteButtonClick();
//				} catch (IndexOutOfBoundsException except) {
//					JOptionPane.showMessageDialog(frame, "목록 확인");
//				}
				/////
				handleDeleteButtonClick();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnDelete.setBounds(232, 162, 80, 20);
		frame.getContentPane().add(btnDelete);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblEnglish.setBounds(25, 65, 100, 30);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textEnglish.setColumns(10);
		textEnglish.setBounds(153, 65, 140, 30);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblMath.setBounds(25, 105, 100, 30);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setHorizontalAlignment(SwingConstants.CENTER);
		textMath.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textMath.setColumns(10);
		textMath.setBounds(153, 105, 140, 30);
		frame.getContentPane().add(textMath);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 187, 300, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();	
		/////
		Object[][] data = {}; // 테이블에 사용할 데이터 
		model = new DefaultTableModel(data, COLUMN_NAMES);
		
		///// 입력
//		Object[] row = {10, 20, 30, 60, 20};
//		model.addRow(row);
		
		///// 삭제
//		model.removeRow(0);		
		
		table.setModel(model);
		
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"\uAD6D\uC5B4", "\uC601\uC5B4", "\uC218\uD559", "\uCD1D\uC810", "\uD3C9\uADE0"
//			}
//		));
		
		table.setFont(new Font("D2Coding", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
	}


	private void handleDeleteButtonClick() {
//		model.removeRow(curIndex);
//		System.out.println("삭제 완료");
		
		/////
		// 1. 테이블에서 삭제하기 위해 선택된 행의 인덱스를 찾는다. 
		int index = table.getSelectedRow();
		if (index == -1) { // 테이블에서 아무 행도 선택되지 않은 경우.
			JOptionPane.showMessageDialog(frame, "삭제할 행 선택", "경고", JOptionPane.WARNING_MESSAGE);
			return; // 메서드 종료			
		}

		// 2. 해당 인덱스의 행을 테이블 모델에서 삭제.
		int confirm = JOptionPane.showConfirmDialog(frame, index + "행 삭제할건지?" , "확인", JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			model.removeRow(index);
		}
	}

	private void handleInsertButtonClick() {
		
//		int korean = Integer.parseInt(textKorean.getText());
//		int english = Integer.parseInt(textEnglish.getText());
//		int math = Integer.parseInt(textMath.getText());
//		if (korean < 0 || korean > 100 || english < 0 || english > 100 || math < 0 || math > 100) {
//			JOptionPane.showMessageDialog(frame, "점수 확인 (0 ~ 100)");
//			return;
//		}
//		Score score = new Score(korean, english, math);
//		Object[] row = {korean, english, math, score.getTotal(), score.getMean()};
//		model.addRow(row);
		
		/////
		// 1. JTextField에서 3과목의 점수를 읽음.
		int korean = 0;
		int english = 0;
		int math = 0;
		
		try {
			korean = Integer.parseInt(textKorean.getText());
			english = Integer.parseInt(textEnglish.getText());
			math = Integer.parseInt(textMath.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "정수를 입력: " + e.getMessage() , "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// 2. Score 타입 객체 생성.
		Score score = new Score(korean, english, math);
		
		// 3. JTable에 행을 추가.
		Object[] row = {
				score.getKorean(), 
				score.getEnglish(), 
				score.getMath(), 
				score.getTotal(), 
				score.getMean()
		};
		model.addRow(row);	
		
		// 모든 JTextField의 입력 내용을 지움.
		clearAllTextFields();
	}
	
	private void clearAllTextFields() {
		textKorean.setText("");
		textEnglish.setText("");
		textMath.setText("");
	}
	
	
	
}