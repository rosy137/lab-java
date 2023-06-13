package edu.java.contact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.Controller.ContactDaoImpl;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnCancel;
	private JButton btnCreate;
	
	private Component parent; // Frame
	private ContactMain app;  // notifyContactCreated를 갖고 있는 
	
	/**
	 * Launch the application.
	 * @param parent 
	 * @param app 
	 */
	public static void showContactCreateFrame(Component parent, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app);
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
	 */
	public ContactCreateFrame(Component parent, ContactMain app) {
		this.parent = parent; // initialize 앞에서 해줘야 함
		this.app = app;
		initialize(); // GUI 컴포넌트들을 생성하고 초기화.
	} 
	
	public void initialize() {
		setTitle("새 연락처 저장");
		
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
		
		btnCreate = new JButton("저장");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creatNewContact();
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

	private void creatNewContact() {
		// JTextField에서 이름/전화번호/이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// contact 타입 객체 생성.
		Contact contact = new Contact(0, name, phone, email);
		
		// 리스트에 추가. 파일 업데이트. -. DAO
		dao.create(contact);
		
		// ContactMain에게 새 연락처가 저장됐다고 알려줌.
		app.notifyContactCreated();
		
		// TODO 메인 생성된 주소 > 새 연락처 호출 시 전달 > 저장하고 있다가 창 닫기 전에 그 주소값에 전달
		parent.setName(name);
		
		
		// 현재 창 닫기
		dispose();
	}
}
