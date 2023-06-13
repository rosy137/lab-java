package edu.java.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnOptionDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain06 window = new AppMain06();
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
	public AppMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 400, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(frame, "안뇽"); // (부모 컴포넌트(null이면 화면 중앙),)
				JOptionPane.showMessageDialog(frame // 메시지 다이얼로그가 실행될 부모 컴포넌트
						, "안녕하세용?" // 다이얼로그에 표시ㅏ될 메시지
						, "오늘" // 다이얼 로그 타이틀(제목)
						, JOptionPane.PLAIN_MESSAGE); //메시지 타입
				//messageType the type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE,or PLAIN_MESSAGEThrows:
			}
		});
		btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnMsgDlg.setBounds(18, 20, 400, 60);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(
						frame, // 부모 컴포넌트
						"찐으로 삭제?", // 메시지
						"졸려쥭겠네", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, /// 확인 옵션(yes-no, yes-no-cancel)
						JOptionPane.QUESTION_MESSAGE // 메시지 타입
						);
				btnConfirmDlg.setText("Confirm = " + result);
			}
		});
		btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnConfirmDlg.setBounds(18, 100, 400, 60);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnOptionDlg = new JButton("Option Dialog");
		btnOptionDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] Options = {"아니뇨", "어려버요", "재ㅁ밌", "쉬워"};
				int result = JOptionPane.showOptionDialog(
						frame, // 부모 컴포넌트
						"Java Swing 재미있나요?", // 메시지
						"질문", // 타이틀
						JOptionPane.YES_NO_CANCEL_OPTION, // 옵션 타입 DEFAULT_OPTION, YES_NO_OPTION, YES_NO_CANCEL_OPTION,or OK_CANCEL_OPTION 
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입 ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE,or PLAIN_MESSAGE
						null, // 아이콘
						Options, // 옵션들의 배열
						Options[2] // 옵션 초기값
						);
				btnOptionDlg.setText("Confirm = " + result);
			}
		});
		btnOptionDlg.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnOptionDlg.setBounds(18, 180, 400, 60);
		frame.getContentPane().add(btnOptionDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] selectionValues = {"10대", "20대", "30대", "40대"};
//				String input = JOptionPane.showInputDialog(frame,"이름?");
				Object input = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트 
						"나이?", // 메시지
						"질문", // 타이틀
						JOptionPane.QUESTION_MESSAGE, // 메시지 타입 
						null, // 아이콘
						selectionValues, // 선택값selectionValues
						selectionValues[0]
						);
				btnInputDlg.setText("select = " + input);
			}
		});
		btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnInputDlg.setBounds(18, 260, 400, 60);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog.showMyDialog(frame);
			}
		});
		btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnCustomDlg.setBounds(18, 340, 400, 60);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame);
			}
		});
		btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 17));
		btnCustomFrame.setBounds(18, 420, 400, 60);
		frame.getContentPane().add(btnCustomFrame);
	}
}
