package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {

	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnCancel;
	private JButton btnCreate;
	
	private Component parent; // 부모 컴포넌트를 저장하기 위한 필드
	
	private int index; // 업데이트할 연락처의 인덱스를 저장하기 위한 필드
	private ContactMain06 app; // 업데이트 성공한 후 알림 메서드를 호출하기 위한 객체

	/**
	 * Launch the application.
	 * @param parent 
	 */
	public static void showContactupdateFrame(Component parent, int index, ContactMain06 app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param parent 
	 * @param app 
	 * @param index 
	 */
	public ContactUpdateFrame(Component parent, int index, ContactMain06 app) {
		this.parent = parent; // initialize 앞에서 해줘야 함
		this.index = index;
		this.app = app;
		initialize(); // GUI 컴포넌트들을 생성하고 초기화.
		readContact();
	}
	
	private void readContact() {
		Contact contact = dao.read(index);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
		
	}
	
	public void initialize() {
		setTitle("연락처 업데이트");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 프로그램 전체가 아닌 현재 창만 닫기
		
		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 350, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblName.setBounds(20, 20, 80, 20);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textName.setBounds(125, 20, 150, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblPhone.setBounds(20, 60, 80, 20);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textPhone.setColumns(10);
		textPhone.setBounds(125, 60, 150, 20);
		panel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(125, 100, 150, 20);
		panel.add(textEmail);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblEmail.setBounds(20, 100, 80, 20);
		panel.add(lblEmail);
		
		JPanel bottonPanel = new JPanel();
		contentPane.add(bottonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("수정");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		bottonPanel.add(btnCreate);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 13));
		bottonPanel.add(btnCancel);
	}

	protected void updateContact() {
		// JTextField에서 업데이트 정보들을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(0, name, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(this, "수정 하시겠습니까?", "재확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.update(index, contact); // 리스트 수정하고 파일에 업데이트
			app.notifyContactupdated();// ContactMain 프레임에 있는 테이블을 갱신하기 위해서
			dispose(); // 현재 창 닫기
		} 
		
	}

}
