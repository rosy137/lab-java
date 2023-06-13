package edu.java.record.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.record.controller.CPostDaoImpl;
import edu.java.record.model.Culture;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppCulture extends JFrame {

	private final CPostDaoImpl dao = CPostDaoImpl.getInstance();
	private Component parent;
	private AppEveryday app;
	private int core;
	
	private JPanel contentPane;
	
	//panelCategory
	private JPanel scrollCate;
	private JLabel lblCate;
	private JComboBox<String> comboCategory;
	private JLabel lblStart;
	private JLabel lblVisit;
	private JLabel lblLoc;
	private JTextField textLoc;
	private JLabel lblGenre;
	private JTextField textGenre;
	private JLabel lblProducer;
	private JTextField textProducer;
	private JLabel lblCast;
	private JTextField textCast;
	private JLabel lblTitle;
	private JTextField textTitle;

	//Main
	private JPanel panelMainContent;
	private JTextField textField;
	private JLabel lblModiTime;
	private JPanel panel;
	private JLabel lblcremodiDate;
	private JButton btnSave;
	private JButton btnEdit;
	private JScrollPane scrollMain;
	private JTextArea textContent;
	private JTextField textSdY;
	private JTextField textVdY;


	/**
	 * Launch the application.
	 */
	public static void showCulture(Component parent, AppEveryday app, int core) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppCulture frame = new AppCulture(parent, app, core);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppCulture(Component parent, AppEveryday app, int core) {
		this.parent = parent;
		this.app = app;
		this.core = core;
		initialize();
		loadData();
	}
	
	private void loadData() {
		Culture cul = dao.read(core);
		if (cul == null) {
			initialize();
		} else {
			//category"Movie", "Drama", "Book", "Exhibition", "Concert", "etc"
			//TODO
			if (cul.getCategory().equals("Movie")) {
				comboCategory.setSelectedIndex(0);
			} else if (cul.getCategory().equals("Drama")) {
				comboCategory.setSelectedIndex(1);
			} else if (cul.getCategory().equals("Book")) {
				comboCategory.setSelectedIndex(2);
			} else if (cul.getCategory().equals("Exhibition")) {
				comboCategory.setSelectedIndex(3);
			} else if (cul.getCategory().equals("Concert")) {
				comboCategory.setSelectedIndex(4);
			} else if (cul.getCategory().equals("etc")) {
				comboCategory.setSelectedIndex(5);
			} 
			textSdY.setText(cul.getStartDate());
			textVdY.setText(cul.getVisitedDate());
			textLoc.setText(cul.getLocation());
			textGenre.setText(cul.getGenre());
			textProducer.setText(cul.getProducerName());
			textCast.setText(cul.getCastName());
			textTitle.setText(cul.getTitle());
			textContent.setText(cul.getContent());
			
			String ct = cul.getCreatedTime();
			String mt = cul.getModifiedTime();
			lblcremodiDate.setText(ct + "/" +mt);
			
		}
	}
	
	public void initialize() {
		setTitle("문화 생활 기록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panelCategory
		scrollCate = new JPanel();
		scrollCate.setBackground(new Color(204, 255, 204));
		scrollCate.setBounds(20, 10, 460, 155);
		contentPane.add(scrollCate);
		scrollCate.setLayout(null);
		
		lblCate = new JLabel("카테고리");
		lblCate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblCate.setBounds(12, 15, 57, 20);
		scrollCate.add(lblCate);
		
		comboCategory = new JComboBox<>();
		String[] categories = {
				"Movie", "Drama", "Book", "Exhibition", "Concert", "etc"
		};
		DefaultComboBoxModel<String> cbmodel = new DefaultComboBoxModel<>(categories);
		comboCategory.setModel(cbmodel);
		comboCategory.setFont(new Font("D2Coding", Font.PLAIN, 13));
		comboCategory.setBounds(81, 14, 149, 23);
		scrollCate.add(comboCategory);

		lblStart = new JLabel("시작날짜");
		lblStart.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStart.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblStart.setBounds(12, 45, 57, 20);
		scrollCate.add(lblStart);
		
		lblVisit = new JLabel("관람날짜");
		lblVisit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisit.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblVisit.setBounds(232, 45, 57, 20);
		scrollCate.add(lblVisit);
		
		lblLoc = new JLabel("위치");
		lblLoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoc.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblLoc.setBounds(12, 75, 57, 20);
		scrollCate.add(lblLoc);
		
		textLoc = new JTextField();
		textLoc.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textLoc.setBounds(81, 75, 149, 20);
		scrollCate.add(textLoc);
		textLoc.setColumns(10);
		
		lblGenre = new JLabel("장르");
		lblGenre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenre.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblGenre.setBounds(232, 75, 57, 20);
		scrollCate.add(lblGenre);
		
		textGenre = new JTextField();
		textGenre.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textGenre.setColumns(10);
		textGenre.setBounds(301, 75, 149, 20);
		scrollCate.add(textGenre);
		
		lblProducer = new JLabel("감독연출");
		lblProducer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProducer.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblProducer.setBounds(12, 103, 57, 20);
		scrollCate.add(lblProducer);
		
		textProducer = new JTextField();
		textProducer.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textProducer.setColumns(10);
		textProducer.setBounds(81, 103, 149, 21);
		scrollCate.add(textProducer);
		
		lblCast = new JLabel("출연자");
		lblCast.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCast.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblCast.setBounds(232, 103, 57, 20);
		scrollCate.add(lblCast);
		
		textCast = new JTextField();
		textCast.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textCast.setColumns(10);
		textCast.setBounds(301, 103, 149, 20);
		scrollCate.add(textCast);
		
		lblTitle = new JLabel("제목");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblTitle.setBounds(12, 130, 57, 25);
		scrollCate.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setBounds(81, 130, 369, 25);
		scrollCate.add(textTitle);
		textTitle.setColumns(10);
		
		textSdY = new JTextField();
		textSdY.setText("YYYY/MM/DD");
		textSdY.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textSdY.setColumns(10);
		textSdY.setBounds(81, 45, 149, 20);
		scrollCate.add(textSdY);
		
		textVdY = new JTextField();
		textVdY.setForeground(new Color(0, 0, 0));
		textVdY.setText("YYYY/MM/DD");
		textVdY.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textVdY.setColumns(10);
		textVdY.setBounds(301, 45, 149, 20);
		scrollCate.add(textVdY);
		//panelCategory
		
		panelMainContent = new JPanel();
		panelMainContent.setBackground(new Color(255, 255, 255));
		panelMainContent.setBounds(20, 180, 460, 321);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panelMainContent.add(panel, BorderLayout.SOUTH);
		
		lblcremodiDate = new JLabel();
		lblcremodiDate.setForeground(new Color(192, 192, 192));
		lblcremodiDate.setBackground(new Color(255, 255, 255));
		lblcremodiDate.setPreferredSize(new Dimension(280, 25));
		lblcremodiDate.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panel.add(lblcremodiDate);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveCulture(e, core);
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 13));
		panel.add(btnSave);
		
		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editCulture();
			}
		});
		btnEdit.setFont(new Font("D2Coding", Font.PLAIN, 13));
		panel.add(btnEdit);
		
		scrollMain = new JScrollPane();
		panelMainContent.add(scrollMain, BorderLayout.CENTER);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textContent.setLineWrap(true);
		scrollMain.setViewportView(textContent);
	}



	private void saveCulture(ActionEvent event, int core) {
		//TODO category
		String category = (String) comboCategory.getSelectedItem();
		String startDate = textSdY.getText();
		String visitedDate  = textVdY.getText();
		String location = textLoc.getText();
		String title = textTitle.getText();
		String genre = textGenre.getText();
		String producerName = textProducer.getText();
		String castName = textCast.getText();
		String content = textContent.getText();
		
		Culture cul = new Culture(0, core, "", "", category, startDate, visitedDate, location, title, genre, producerName, castName, content);
		dao.create(cul);
		JOptionPane.showMessageDialog(contentPane, "저장 완료");
		loadData();
	}

	private void editCulture() {
		String content = textContent.getText();
		Culture cul = new Culture(0, core, "", "", "", "", "", "", "", "", "", "", content);
		dao.update(cul, core);
		loadData();
	}


}