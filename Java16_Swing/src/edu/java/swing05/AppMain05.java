package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtected;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbstatic;
	private JCheckBox cbAbstract;
	private JCheckBox cbfinal;
	private JComboBox<String> comboBox;
	private JButton btnInfo;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(550, 350, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPrivate = new JRadioButton("private");
		rbPrivate.setSelected(true);
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JRadioButton btn = (JRadioButton) e.getSource(); // 라디오 버튼이 가지고 있는 기능을 사용하기 위한 casting
//				String btnText = btn.getText();
//				boolean selected = btn.isSelected();
//				textArea.setText(btnText + " : " + selected);
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPrivate); 
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rbPrivate.setBounds(30, 40, 120, 25);
		frame.getContentPane().add(rbPrivate);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rbPackage.setBounds(155, 40, 120, 25);
		frame.getContentPane().add(rbPackage);
		
		rbProtected = new JRadioButton("protected");
		rbProtected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbProtected);
		rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rbProtected.setBounds(280, 40, 120, 25);
		frame.getContentPane().add(rbProtected);
		
		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPublic);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rbPublic.setBounds(405, 40, 120, 25);
		frame.getContentPane().add(rbPublic);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbAbstract.setBounds(30, 80, 120, 25);
		frame.getContentPane().add(cbAbstract);
		
		cbfinal = new JCheckBox("final");
		cbfinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbfinal.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbfinal.setBounds(155, 80, 120, 25);
		frame.getContentPane().add(cbfinal);
		
		cbstatic = new JCheckBox("static");
		cbstatic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbstatic.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbstatic.setBounds(280, 80, 120, 25);
		frame.getContentPane().add(cbstatic);
		
		comboBox = new JComboBox<>();
		
		String[] items = {"naver.com", "gamil.com", "kakao.com"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<> (items);
		comboBox.setModel(model);
		// 같은 의미 
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gamil.com", "kakao.com"}));
		
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 13));
		comboBox.setBounds(34, 130, 366, 25);
		frame.getContentPane().add(comboBox);
		
		btnInfo = new JButton("확인");
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printInfo();
			}
		});
		btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnInfo.setBounds(428, 130, 97, 25);
		frame.getContentPane().add(btnInfo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 190, 491, 120);
		frame.getContentPane().add(scrollPane); // 스크롤바
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea); // TEXTPOT
	}

	private void printInfo() {
		// 라디오 버튼, 체크박스, 콤보 박스의 상태를 JtextArea에 출력
		
		StringBuffer buffer = new StringBuffer(); // textArea에 출력할 문자열을 저장하기 위해서 비어있는 문자열을 생성.
		
		// 어떤 라디오 버튼이 선택됐는 지를 체크
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText()); // append: 문자열 뒤에 새로운 문자열 붙여줌
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtected.isSelected()) {
			buffer.append(rbProtected.getText());
		} else {
			buffer.append(rbPublic.getText());
		}
		buffer.append(" 라디오 버튼 선택됨.\n");
		
		// 체크박스들의 선택 여부를 확인.
		if(cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if(cbfinal.isSelected()) {
			buffer.append(cbfinal.getText()).append(" ");
		}
		if(cbstatic.isSelected()) {
			buffer.append(cbstatic.getText()).append(" ");
		}
		buffer.append(" 체크 박스 선택됨.\n");
		
		// 콤보 박스에서 선택된 아이템 찾기
		String item = (String) comboBox.getSelectedItem();
		buffer.append(item).append(" 콤보박스 선택됨.\n");
		
		// 버퍼의 내용을 textArea에 출력
		textArea.setText(buffer.toString()); // String으로 만들기 
	}

	private void handleCheckBoxClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(체크박스)를 찾음.
		JCheckBox chbox = (JCheckBox) event.getSource();
		// 체크박스의 텍스트를 찾음.
		String text = chbox.getText();
		// 체크박스의 체크(선택) 여부 확인.
		boolean selected = chbox.isSelected();
		// 정보 출력
		textArea.setText(text+ " : " + selected);
		
	}

	private void handleRadioButtonClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(라디오 버튼)를 찾음.
		JRadioButton btn = (JRadioButton) event.getSource(); // 라디오 버튼이 가지고 있는 기능을 사용하기 위한 casting
		// 라디오 버튼의 텍스트를 찾음.
		String btnText = btn.getText();
		// 라디오 버튼의 선택(체크) 여부를 확인.
		boolean selected = btn.isSelected();
		// 결과를 JTextArea에 출력.
		textArea.setText(btnText + " : " + selected);
	}
}
