package edu.java.record.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.w3c.dom.html.HTMLTableCaptionElement;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

import edu.java.record.controller.DPostDaoImpl;
import edu.java.record.controller.EPostDaoImpl;
import edu.java.record.controller.MPostDaoImpl;
import edu.java.record.model.Dday;
import edu.java.record.model.Everyday;
import edu.java.record.model.MonthlyGoal;
import oracle.jdbc.OracleDriver;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import static edu.java.record.ojdbc.OracleConnect.*;
import static edu.java.record.model.MonthlyGoal.Entity.*;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class AppMain {

	private JFrame frame;
	private Calendar cal = new GregorianCalendar();
	private Calendar calendar = Calendar.getInstance();
	private final LocalDateTime NOW = LocalDateTime.now();
	
	// panelthisYM (상단 왼쪽 제목)
	private JPanel panelthisYM;
	private JLabel lblMm;
	private JLabel lblYear;
	
	// panelMonthlyGoal
	private List<MonthlyGoal> goalList;
	private static final String[] COLUMN_GOAL = {"<MONTHLY GOAL>"};
	private MPostDaoImpl gdao = MPostDaoImpl.getInstance();
	private DefaultTableModel gmodel;
	private JPanel panelMonthlyGoal;
	private JScrollPane scrollGoal;
	private JTable tablemonGoal;
	private JPanel panelGBot;
	private JPanel panelGTB;
	private JButton btnGadd;
	private JButton btnGdel;
	private JTextField textMG;
	
	//panelDday
	private List<Dday> dayList;
	private static final String[] COLUMN_DAY = {"<DDAY>","COUNT"};
	private DPostDaoImpl ddao = DPostDaoImpl.getInstance();
	private DefaultTableModel dmodel;
	private JPanel panelDday;
	private JScrollPane scrollDday;
	private JTable tableDday;
	private JPanel panelDTop;
	private JPanel panelDTB;
	private JButton btnDadd;
	private JButton btnDdel;
	
	//panelcategory
	private JPanel panelcategory;
	private JButton btnAddPost;
	
	//panelSearch
	private JPanel panelSearch;
	private JButton btnSearch;
	private JTextField textSearch;
	private String keyword;
	
	//panelMiniCal
	private DefaultTableModel mimodel;
	private JPanel Mini;
	private JPanel panelMini;
	private JScrollPane paneMini;
	private JTable tableMini;
	private JLabel labelMini;
	private JButton preMini;
	private JButton nextMini;
		
	//panelMainCal
	private JPanel panelMainCal;
	private JPanel panelMainCB;
	private JButton btnMPre;
	private JButton btnMNext;
	private JLabel lblMYM;
	private JButton dayButs[] = new JButton[42];
	private JPanel panelWeekday;
	private JLabel weekday[] = new JLabel[7];

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain window = new AppMain();
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
	public AppMain() {
		initialize();
		loadMGData();
		loadDddata();
	}
	
	//monthlygoal
	private void loadMGData() {
		goalList = gdao.read();
		for (MonthlyGoal mg : goalList) {
			Object[] row = {mg.getGoal()};
			gmodel.addRow(row);
		}
	}
	//dday
	private void loadDddata() {
		dayList = ddao.read();
		for (Dday d : dayList) {
			Object[] row = {d.getDtitle(), d.getDcount()};
			dmodel.addRow(row);
		}
	}
	
	private void loadData() {
		resetBut();
		setMianCal();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBackground(new Color(204, 204, 255));
		frame.setBounds(750, 350, 600, 650);
		frame.setLocationRelativeTo(null);
		frame.setTitle("How was your day?");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// panelthisYM (상단 왼쪽 제목)
		panelthisYM = new JPanel();
		panelthisYM.setBackground(new Color(204, 204, 255));
		panelthisYM.setBounds(12, 10, 160, 120);
		frame.getContentPane().add(panelthisYM);
		panelthisYM.setLayout(null);
		
		lblYear = new JLabel("YYYY");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		String year = NOW.format(DateTimeFormatter.ofPattern("yyyy"));
		lblYear.setText(year + "년");
		lblYear.setFont(new Font("D2Coding", Font.PLAIN, 40));
		lblYear.setBounds(12, 22, 136, 42);
		panelthisYM.add(lblYear);
		
		lblMm = new JLabel("MM");
		lblMm.setBackground(Color.WHITE);
		lblMm.setHorizontalAlignment(SwingConstants.CENTER);
		String month = NOW.format(DateTimeFormatter.ofPattern("MM"));
		String day = NOW.format(DateTimeFormatter.ofPattern("dd"));
		lblMm.setText(month + "월 " + day + "일");
		lblMm.setFont(new Font("D2Coding", Font.PLAIN, 27));
		lblMm.setBounds(12, 68, 136, 36);
		panelthisYM.add(lblMm);
		// panelthisYM (상단 왼쪽 제목)
		
		// panelMonthlyGoal
		panelMonthlyGoal = new JPanel();
		panelMonthlyGoal.setBackground(new Color(204, 204, 255));
		panelMonthlyGoal.setBounds(184, 10, 216, 120);
		frame.getContentPane().add(panelMonthlyGoal);
		panelMonthlyGoal.setLayout(new BorderLayout(0, 0));
				
		scrollGoal = new JScrollPane();
		scrollGoal.setBackground(new Color(204, 204, 255));
		panelMonthlyGoal.add(scrollGoal, BorderLayout.CENTER);
				
		tablemonGoal = new JTable();
		tablemonGoal.setBackground(new Color(255, 255, 255));
		tablemonGoal.setColumnSelectionAllowed(true);
		gmodel = new DefaultTableModel(null,COLUMN_GOAL);
		tablemonGoal.setModel(gmodel);
		tablemonGoal.getTableHeader().setFont(new Font("D2Coding", Font.BOLD,13));
		tablemonGoal.getTableHeader().setBackground(Color.WHITE);
		scrollGoal.setViewportView(tablemonGoal);
				
		panelGBot = new JPanel();
		panelGBot.setBackground(new Color(204, 204, 255));
		panelMonthlyGoal.add(panelGBot, BorderLayout.SOUTH);
		panelGBot.setLayout(new BorderLayout(0, 0));
		panelGBot.setPreferredSize(new DimensionUIResource(216, 20));
				
		panelGTB = new JPanel();
		panelGTB.setBackground(new Color(204, 204, 255));
		panelGBot.add(panelGTB, BorderLayout.EAST);
				
		btnGadd = new JButton("+");
		btnGadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creatNewMG();
			}
		});
		btnGadd.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panelGTB.add(btnGadd);
		btnGadd.setPreferredSize(new Dimension(12,12));
		
		textMG = new JTextField();
		textMG.setBackground(new Color(255, 255, 255));
		textMG.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panelGBot.add(textMG, BorderLayout.CENTER);
		textMG.setColumns(10);
				
		btnGdel = new JButton("-");
		btnGdel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteMG();
			}
		});
		btnGdel.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panelGTB.add(btnGdel);
		btnGdel.setPreferredSize(new Dimension(12,12));
		// panelMonthlyGoal
		
		//panelDday
		panelDday = new JPanel();
		panelDday.setBackground(new Color(204, 204, 255));
		panelDday.setBounds(412, 10, 173, 120);
		frame.getContentPane().add(panelDday);
		panelDday.setLayout(new BorderLayout(0, 0));
		
		scrollDday = new JScrollPane();
		scrollDday.setBackground(new Color(204, 204, 255));
		panelDday.add(scrollDday, BorderLayout.CENTER);
		
		tableDday = new JTable();
		tableDday.setColumnSelectionAllowed(true);
		dmodel = new DefaultTableModel(null, COLUMN_DAY);
		tableDday.setModel(dmodel);
		tableDday.getTableHeader().setFont(new Font("D2Coding", Font.BOLD,13));
		tableDday.getTableHeader().setBackground(Color.WHITE);
		scrollDday.setViewportView(tableDday);
		
		panelDTop = new JPanel();
		panelDTop.setBackground(new Color(204, 204, 255));
		panelDday.add(panelDTop, BorderLayout.SOUTH);
		panelDTop.setLayout(new BorderLayout(0, 0));
		panelDTop.setPreferredSize(new Dimension(173,20));
		
		panelDTB = new JPanel();
		panelDTB.setBackground(new Color(204, 204, 255));
		panelDTop.add(panelDTB, BorderLayout.EAST);
		
		btnDadd = new JButton("+");
		btnDadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppDday.showDday(frame, AppMain.this);
				loadData();
			}
		});
		btnDadd.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panelDTB.add(btnDadd);
		btnDadd.setPreferredSize(new Dimension(12,12));
		
		btnDdel = new JButton("-");
		btnDdel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteDd();
			}
		});
		btnDdel.setFont(new Font("D2Coding", Font.PLAIN, 11));
		panelDTB.add(btnDdel);
		btnDdel.setPreferredSize(new Dimension(12,12));
		//panelDday
		
		
		// 미니 캘린더
		Mini = new JPanel();
		Mini.setBackground(new Color(204, 204, 255));
		Mini.setBounds(12, 432, 160, 169);
		frame.getContentPane().add(Mini);
		Mini.setLayout(new BorderLayout());
		Mini.setVisible(true);
		
		labelMini = new JLabel();
		labelMini.setHorizontalAlignment(SwingConstants.CENTER);
		labelMini.setPreferredSize(new Dimension(130,25));
		labelMini.setFont(new Font("D2Coding", Font.PLAIN, 11));
		
		preMini = new JButton("<");
		preMini.setFont(new Font("D2Coding", Font.PLAIN, 11));
		preMini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cal.add(Calendar.MONTH, -1);
		        updateMonth();
			}
		});
		preMini.setPreferredSize(new Dimension(20,25));
		
		nextMini = new JButton(">");
		nextMini.setFont(new Font("D2Coding", Font.PLAIN, 11));
		nextMini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cal.add(Calendar.MONTH, +1);
		        updateMonth();
			}
		});
		nextMini.setPreferredSize(new Dimension(20, 25));
		
		panelMini = new JPanel();
		panelMini.setLayout(new BorderLayout());
//		panleMini.setBackground(new Color(204, 204, 255));
		panelMini.add(preMini,BorderLayout.WEST);
		panelMini.add(labelMini,BorderLayout.CENTER);
		panelMini.add(nextMini,BorderLayout.EAST);
		
		String [] columns = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		mimodel = new DefaultTableModel(null,columns);
		tableMini = new JTable(mimodel);
		paneMini = new JScrollPane(tableMini);
		paneMini.setEnabled(false);
		 
		Mini.add(panelMini, BorderLayout.NORTH);
		Mini.add(paneMini, BorderLayout.CENTER);
		
		tableMini.getTableHeader().setFont(new Font("D2Coding", Font.PLAIN, 9));
		tableMini.setFont(new Font("D2Coding", Font.PLAIN, 10));
		tableMini.setRowHeight(20);
		
		this.updateMonth();
		// 미니캘린더 끝

		
		//panelcategory
		panelcategory = new JPanel();
		panelcategory.setBackground(new Color(204, 204, 255));
		panelcategory.setBounds(12, 177, 160, 213);
		frame.getContentPane().add(panelcategory);
		panelcategory.setLayout(new BorderLayout(0, 0));
		
		//panelSearch
		panelSearch = new JPanel();
		panelSearch.setBackground(new Color(204, 204, 255));
		panelSearch.setBounds(12, 399, 160, 23);
		frame.getContentPane().add(panelSearch);
		panelSearch.setLayout(null);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("D2Coding", Font.PLAIN, 12));
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setForeground(new Color(0, 0, 0));
		textSearch.setText("키워드 입력");
		textSearch.setBounds(0, 0, 116, 22);
		panelSearch.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("...");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyword = textSearch.getText();
				AppSearch.showAppSearch(frame, AppMain.this, keyword);
				textSearch.setText("");
				loadData();
			}
		});
		btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnSearch.setBounds(117, 0, 43, 22);
		panelSearch.add(btnSearch);
		//panelSearch
		
		
		//panelMainButtonBox
		panelMainCB = new JPanel();
		panelMainCB.setBackground(new Color(204, 204, 255));
		panelMainCB.setBounds(12, 142, 160, 23);
		frame.getContentPane().add(panelMainCB);
		
		btnMPre = new JButton("<");
		btnMPre.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnMPre.setBounds(0, 0, 20, 23);
		btnMPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBut();
				cal.add(Calendar.MONTH, -1);
				setMianCal();
			}
		});
		panelMainCB.setLayout(null);
		btnMPre.setBackground(new Color(255, 255, 255));
		panelMainCB.add(btnMPre);
		
		btnMNext = new JButton(">");
		btnMNext.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnMNext.setBounds(140, 0, 20, 23);
		btnMNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBut();
				cal.add(Calendar.MONTH, +1);
				setMianCal();
			}
		});
		btnMNext.setBackground(new Color(255, 255, 255));
		panelMainCB.add(btnMNext);
		
		lblMYM = new JLabel("New label");
		lblMYM.setBackground(new Color(102, 102, 255));
		lblMYM.setBounds(20, 0, 120, 23);
		lblMYM.setPreferredSize(new Dimension(130,25));
		lblMYM.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblMYM.setHorizontalAlignment(SwingConstants.CENTER);
		panelMainCB.add(lblMYM);


		//panelMainCal
		panelWeekday = new JPanel();
		panelWeekday.setBackground(new Color(204, 204, 255));
		panelWeekday.setBounds(184, 142, 400, 23);
		panelWeekday.setLayout(new GridLayout(1,0,0,0));
		for(int i = 0; i < weekday.length; i++) {
			weekday[i] = new JLabel();
			panelWeekday.add(weekday[i]);
			weekday[i].setText(columns[i]);
			weekday[i].setFont(new Font("D2Coding", Font.PLAIN, 17));
			weekday[i].setHorizontalAlignment(SwingConstants.CENTER);
			if(i % 7 == 0) weekday[i].setForeground(Color.RED);
		}
		frame.getContentPane().add(panelWeekday);
		
		panelMainCal = new JPanel();
		panelMainCal.setBackground(new Color(204, 204, 255));
		panelMainCal.setBounds(184, 164, 400, 437);
		frame.getContentPane().add(panelMainCal);
		panelMainCal.setLayout(new GridLayout(6, 7, 0, 0));
		for(int i = 0; i < dayButs.length; i++) {
			dayButs[i] = new JButton();
			panelMainCal.add(dayButs[i]);
			
			dayButs[i].setFont(new Font("D2Coding", Font.PLAIN, 17));
		
			if(i % 7 == 0) dayButs[i].setForeground(Color.RED);

			dayButs[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AppEveryday.showEveryday(frame, AppMain.this, setCore(e), sendDatetoEveryday(e));
				}
			});
		}
		setMianCal();
		//panelMainCal

	}


	private String sendDatetoEveryday(ActionEvent e) {
		String my = lblMYM.getText();
		JButton day  = (JButton) e.getSource();
		String d = day.getText();
		String today = my + " " + d + "일";
		return today;
	}


	//dday
	private void deleteDd() {
		int row = tableDday.getSelectedRow();
		int did = dayList.get(row).getDid();
		ddao.delete(did);
		dmodel.removeRow(row);
		resetDD();
	}
	protected void resetDD() {
		dmodel = new DefaultTableModel(null, COLUMN_DAY);
		loadDddata();
		tableDday.setModel(dmodel);
	}
	//dday
	
	//core
	private int setCore(ActionEvent e) {
		String my = lblMYM.getText();
		String mynum = my.replaceAll("[^0-9]", "");
		JButton day  = (JButton) e.getSource();
		String d = day.getText();
		int result = Integer.parseInt(mynum+d);
		System.out.println(result);
		return result;
	}
	//core

	//Monthlygoal
	private void resetMG() {
		gmodel = new DefaultTableModel(null, COLUMN_GOAL);
		loadMGData();
		tablemonGoal.setModel(gmodel);
	}
	
	private void deleteMG() {
		int row = tablemonGoal.getSelectedRow(); 
		int mid = goalList.get(row).getMid();
		gdao.delete(mid); // 리스트에서 연락처 삭제, 파일 업데이트
		gmodel.removeRow(row); // JTable에서 행 삭제
		resetMG();
	}
	private void creatNewMG() throws NullPointerException {
		String goal = textMG.getText();
		MonthlyGoal mg = new MonthlyGoal(0, goal);
		gdao.create(mg);
		textMG.setText(null);
		resetMG();
		
	}
	//Monthlygoal
	
	
	//Main clalendar
		private void resetBut() {
			for(int i = 0; i < dayButs.length; i++) {
				dayButs[i].setText("");
				dayButs[i].setOpaque(false);
			}
			
		}
		private void setMianCal() {
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) +1;
			cal.set(year, month -1, 1);
			int startDay = cal.get(Calendar.DAY_OF_WEEK);
			startDay--;
			
			for(int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
				dayButs[startDay + i -1].setText(String.valueOf(i));
			}
			
			// 오늘 날짜 표시 TODO
			Calendar today = Calendar.getInstance();
			today.getTime();
			int d = 0;
			for(JButton day: dayButs) {
				if (day.getText() != "") {
					d = Integer.parseInt(day.getText());
					if (year == LocalDate.now().getYear() 
							&& month == LocalDate.now().getMonthValue() 
							&& d == LocalDate.now().getDayOfMonth()) {
						day.setBackground(new Color(102, 102, 255));
						day.setOpaque(true);
					}
				}
			}
			
			lblMYM.setText(year + "년 " + month + "월");
		}

	private void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);
		 
	    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.KOREA);
	    int year = cal.get(Calendar.YEAR);
	    labelMini.setText(year + "년 " + month);
	    
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		// 월이 시작하는 위치
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 해당 월의 최대 날짜
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		// 해당 월의 최대 주
		
		mimodel.setRowCount(0);
		mimodel.setRowCount(weeks);
		
		int staerDauIndex = startDay -1; // INDEX라서 -1
		for (int calDay = 1 ; calDay <= numberOfDays ; calDay++ ) {
			mimodel.setValueAt(calDay, staerDauIndex / 7, staerDauIndex % 7);
			staerDauIndex += 1;
		}
	}
	//MainCalendar
}