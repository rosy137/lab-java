package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain06 {

	// 테이블 컬럼 이름
	private static final String[] COLUMN_NAMES = {"이름", "전화번호"};
	
	private JFrame frame;
	private JPanel buttonPanel;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model; // 테이블의 데이터, 컬럼 이름 등을 관리하는 객체.
	
	// 연락처 정보를 관리하는 객체(Controller)
	private ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void notifyContactupdated() {
		// JTable을 새로 그림.
		resetTableModel();
		JOptionPane.showMessageDialog(frame, "연락처 업데이트 성공");
	}
	
	// ContactCreateFrame에서 새 연락처 저장을 성공했을 때 호출할 메서드.
	public void notifyContactCreated() {
		// JTable을 새로 그림.
		resetTableModel();
		JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
	}

	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES); // 데이터가 비워진 모델을 새로 생성
		loadContactData(); // 파일에 저장된 데이터를 다시 읽고 테이블 모델에 추가
		
		table.setModel(model); // 새롭게 만들어진 테이블 모델을 테이블에 세팅
		
	}
	
	
	/**
	 * Create the application.
	 */
	public ContactMain06() {
		initialize(); // 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화
		loadContactData(); // 파일에 저장된 연락처 데이터를 로딩(테이블 초기화).
	}

	private void loadContactData() {
		List<Contact> list = dao.read();
		for (Contact c : list) {
			Object[] row = {c.getName(), c.getPhone()};
			model.addRow(row);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(750, 400, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("연락처 v0.6");
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInsert = new JButton("새 연락처");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreateFrame.showContactCreateFrame(frame, ContactMain06.this);
				// frame -> 새로 뜨는 창의 위치값 전달을 위한
				// this - ActionListener 타입의 익명 객체
				// contactMain06.this - ContactMain06 타입의 객체
			}
		});
		btnInsert.setHorizontalAlignment(SwingConstants.RIGHT);
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 13));
		buttonPanel.add(btnInsert);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		buttonPanel.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 13));
		buttonPanel.add(btnDelete);
		
		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 13));
		buttonPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(); // JTable 타입의 객체 생성
		model = new DefaultTableModel(null, COLUMN_NAMES); // 테이블 모델 객체 생성
		table.setModel(model); // 테이블 모델 객체를 테이블에 세팅.
		// TODO 테이블 컬럼 이름의 폰트 변경
		
//		table.setColumn;
		// TODO 테이블 데이터 행의 폰트 변경.
		table.setFont(new Font("D2Coding", Font.PLAIN, 13)); 
		
		scrollPane.setViewportView(table); // 테이블을 스크롤페인에 부착?
	}

	protected void updateContact() {
		// 테이블에서 선택된 행의 인덱스를 찾고 읽음 / 선택된 행이 없다면 알림창
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "수정하려는 행을 먼저 선택", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// ContactUpdateFrame 생성해서 업데이트 창을 띄움
		// 새 창의 부모 컴포넌트 - 업데이트 창을 띄울 좌표를 계산하기 위해서
		// 선택된 테이블 행 인덱스 - 업데이트 창에서 수정전의 데이터를 출력하기 위해서
		// ContactMain의 주소전달 - 업데이트 성공했을 때 업데이트 창이 메인 창에게 알려주기 위해서
		ContactUpdateFrame.showContactupdateFrame(frame, row, ContactMain06.this);
		
	}

	private void deleteContact() {
		// 테이블에서 선택된 행의 인덱스를 찾음.
		int row = table.getSelectedRow(); 
		if (row == -1) {
			JOptionPane.showMessageDialog(frame, "삭제하려는 행을 먼저 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.delete(row); // 리스트에서 연락처 삭제, 파일 업데이트
			model.removeRow(row); // JTable에서 행 삭제
			JOptionPane.showMessageDialog(frame, "삭제 성공");
		}
		
		
		
	}
}
