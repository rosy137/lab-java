package edu.java.record.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.record.controller.EPostDaoImpl;
import edu.java.record.model.Everyday;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.BorderLayout;

public class AppEveryday extends JFrame {

	private final EPostDaoImpl dao = EPostDaoImpl.getInstance();
	private Component parent;
	private AppMain app;
	private LocalDateTime now = LocalDateTime.now();
	private int core;
	private String dateOfButton;
	
	private JPanel contentPane;
	// panelRoCulture
	private JPanel panelToCulture;
	private JLabel lblToCulture;
	private JButton btnToCulture;
	
	// panelETC
	private JPanel panelETC;
	private JLabel lblDate;
	
	private JLabel lblWorkout;
	private JCheckBox cbWorkout;

	private JLabel lblMood;
	private final ButtonGroup moodGroup = new ButtonGroup();
	private JRadioButton rdHappy;
	private JRadioButton rdGood;
	private JRadioButton rdNo;
	private JRadioButton rdTired;
	private JRadioButton rdExhausted;

	// Main
	private JPanel panelMainContent;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblcremodiDate;
	private JButton btnSave;
	private JButton btnEdit;
	private JScrollPane scrollMain;
	private JTextArea textContent;
	private JLabel lblCore;
	private JLabel lblMoodPrint;
	private JLabel lblTodayDate;






	/**
	 * Launch the application.
	 */
	public static void showEveryday(Component parent, AppMain app, int core, String dateOfButton) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEveryday frame = new AppEveryday(parent, app, core, dateOfButton);
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
	public AppEveryday(Component parent, AppMain app, int core, String dateOfButton) {
		this.parent = parent;
		this.app = app;
		this.core = core;
		this.dateOfButton = dateOfButton;
		initialize();
		loadData();
	}

	
	private void loadData() {
		Everyday ed = dao.read(core);
		if (ed == null) {
			initialize();
		} else {
			
			lblCore.setText(String.valueOf(ed.getCore()));
			//workout
			if (ed.getWorkout().equals("오늘의 운동 완료!")) {
				cbWorkout.setSelected(true);
			} else {
				cbWorkout.setText(ed.getWorkout());
			}
			//mood
			if (ed.getTodaysMood().equals("Happy")) {
				rdHappy.setSelected(true);
			} else if (ed.getTodaysMood().equals("Good")) {
				rdGood.setSelected(true);
			} else if (ed.getTodaysMood().equals("No")) {
				rdNo.setSelected(true);
			} else if (ed.getTodaysMood().equals("Tired")) {
				rdTired.setSelected(true);
			} else if (ed.getTodaysMood().equals("Exhausted")){
				rdExhausted.setSelected(true);
			}
			//createdmodifiedtime
			String ct = ed.getCreatedTime();
			String mt = ed.getModifiedTime();
			lblcremodiDate.setText(ct + "/" + mt);
			//content
			textContent.setText(ed.getContent());
		}
	}

	public void initialize() {
		setTitle("일상 기록");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// panelETC
		panelETC = new JPanel();
		panelETC.setBackground(new Color(255, 255, 204));
		panelETC.setBounds(20, 10, 460, 100);
		contentPane.add(panelETC);
		panelETC.setLayout(null);
		
		lblDate = new JLabel("오늘");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblDate.setBounds(12, 12, 57, 20);
		panelETC.add(lblDate);
		
		lblCore = new JLabel("core 출력을 위한 라벨");
		lblCore.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblCore.setBounds(430, 12, 0, 20);
		lblCore.setText(String.valueOf(core));
		panelETC.add(lblCore);

		lblTodayDate = new JLabel("해당 버튼의 날짜");
		lblTodayDate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblTodayDate.setBounds(81, 12, 200, 20);
		lblTodayDate.setText(dateOfButton);
		panelETC.add(lblTodayDate);
		
		lblWorkout = new JLabel("오운완?");
		lblWorkout.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWorkout.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblWorkout.setBounds(12, 67, 57, 20);
		panelETC.add(lblWorkout);
		
		cbWorkout = new JCheckBox("오늘의 운동 완료!");
		cbWorkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbWorkout.setFont(new Font("D2Coding", Font.PLAIN, 13));
		cbWorkout.setBounds(81, 67, 169, 20);
		cbWorkout.setSelected(true);
		panelETC.add(cbWorkout);
		
		lblMood = new JLabel("기분");
		lblMood.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMood.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblMood.setBounds(12, 39, 57, 20);
		panelETC.add(lblMood);
		
		rdHappy = new JRadioButton("😆");
		rdHappy.setSelected(true);
		rdHappy.setName("Happy");
		rdHappy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		moodGroup.add(rdHappy);
		rdHappy.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rdHappy.setHorizontalAlignment(SwingConstants.CENTER);
		rdHappy.setBounds(81, 38, 65, 20);
		panelETC.add(rdHappy);
		
		rdGood = new JRadioButton("🙂");
		rdGood.setName("Good");
		rdGood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		moodGroup.add(rdGood);
		rdGood.setHorizontalAlignment(SwingConstants.CENTER);
		rdGood.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rdGood.setBounds(156, 38, 65, 20);
		panelETC.add(rdGood);
		
		rdNo = new JRadioButton("😶");
		rdNo.setName("No");
		rdNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		moodGroup.add(rdNo);
		rdNo.setHorizontalAlignment(SwingConstants.CENTER);
		rdNo.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rdNo.setBounds(231, 38, 65, 20);
		panelETC.add(rdNo);
		
		rdTired = new JRadioButton("🙁");
		rdTired.setName("Tired");
		rdTired.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		moodGroup.add(rdTired);
		rdTired.setHorizontalAlignment(SwingConstants.CENTER);
		rdTired.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rdTired.setBounds(306, 38, 65, 20);
		panelETC.add(rdTired);
		
		rdExhausted = new JRadioButton("😞");
		rdExhausted.setName("Exhausted");
		rdExhausted.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		moodGroup.add(rdExhausted);
		rdExhausted.setHorizontalAlignment(SwingConstants.CENTER);
		rdExhausted.setFont(new Font("D2Coding", Font.PLAIN, 13));
		rdExhausted.setBounds(381, 38, 65, 20);
		panelETC.add(rdExhausted);
		
		lblMoodPrint = new JLabel();
		lblMoodPrint.setEnabled(false);
		lblMoodPrint.setBounds(442, 13, 0, 16);
		panelETC.add(lblMoodPrint);

		// panelETC
		
		// panelRoCulture
		panelToCulture = new JPanel();
		panelToCulture.setBackground(new Color(255, 255, 204));
		panelToCulture.setBounds(20, 120, 460, 50);
		contentPane.add(panelToCulture);
		panelToCulture.setLayout(null);
		
		lblToCulture = new JLabel("오늘의 문화 생활 기록");
		lblToCulture.setBackground(new Color(255, 255, 204));
		lblToCulture.setBounds(12, 10, 218, 30);
		lblToCulture.setHorizontalAlignment(SwingConstants.CENTER);
		lblToCulture.setFont(new Font("D2Coding", Font.PLAIN, 13));
		panelToCulture.add(lblToCulture);
		
		btnToCulture = new JButton("글쓰러가기");
		btnToCulture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppCulture.showCulture(parent, AppEveryday.this, core);
			}
		});
		btnToCulture.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnToCulture.setBounds(242, 10, 206, 30);
		panelToCulture.add(btnToCulture);
		// panelRoCulture
		
		// Main
		panelMainContent = new JPanel();
		panelMainContent.setBackground(new Color(255, 255, 255));
		panelMainContent.setBounds(20, 180, 460, 321);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panelMainContent.add(panel, BorderLayout.SOUTH);
		
		lblcremodiDate = new JLabel("");
		lblcremodiDate.setForeground(new Color(192, 192, 192));
		lblcremodiDate.setBackground(new Color(255, 255, 255));
		lblcremodiDate.setPreferredSize(new Dimension(280, 25));
		lblcremodiDate.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panel.add(lblcremodiDate);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveEveryday(e, core);
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 13));
		panel.add(btnSave);
		
		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editEveryday();
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
		// Main
	}

	protected void editEveryday() {
		String content = textContent.getText();
		Everyday ed = new Everyday(0, 0, "", "", content, "", "");
		dao.update(ed, core);
		loadData();
	}

	private void saveEveryday(ActionEvent event, int core) {
		// mood radio button
		String mood = lblMoodPrint.getText();
		// workout
		String workout = cbWorkout.getText();
		// content
		String content = textContent.getText();
		
		Everyday ed = new Everyday(0, core, "", "", content, mood, workout);
		dao.create(ed);
		JOptionPane.showMessageDialog(contentPane, "저장 완료");
		loadData();
	}

	
	private void handleRadioButtonClick(ActionEvent event) {
		JRadioButton rdbox = (JRadioButton) event.getSource();
		String mood = null;
		if (rdbox.isSelected()) {
			mood = rdbox.getName();
		}
		lblMoodPrint.setText(mood);
		System.out.println(lblMoodPrint.getText());
	}


	private void handleCheckBoxClick(ActionEvent event) {
		JCheckBox cb = (JCheckBox) event.getSource();
		boolean selected = cb.isSelected();
		String result = "오늘의 운동 완료!";
		if (selected == false) {
			result = "오늘은 쉬는 날!";
		}
		cbWorkout.setText(result);
		System.out.println(cbWorkout.getText());
	}
}