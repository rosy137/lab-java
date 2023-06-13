package edu.java.record.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.record.controller.SPostDaoImpl;
import edu.java.record.model.Culture;
import edu.java.record.model.Everyday;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppSearch extends JFrame {

	private static final String[] COLUMN_EVERYDAY = {"CONTENT" ,"MOOD", "WORKOUT", "CREATED_DATE"};
	private static final String[] COLUMN_CULTURE = {"CATEGORY", "TITLE", "CONTENT", "CREATED_DATE" };
	
	private Component parent;
	private AppMain app;
	private String keyword;
	
	private JPanel contentPane;
	private JTable tableEver;
	private JScrollPane scrollEvery;
	private JLabel lblE;
	private DefaultTableModel emodel;
	private DefaultTableModel cmodel;
	
	private List<Everyday> EveList;
	private List<Culture> CulList;
	
	private SPostDaoImpl sdao = SPostDaoImpl.getInstance();
	
	private JLabel lblC;
	private JScrollPane scrollCul;
	private JTable tableCul;

	/**
	 * Launch the application.
	 * @param appMain 
	 * @param frame 
	 */
	public static void showAppSearch(Component parent, AppMain app, String keyword) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppSearch frame = new AppSearch(parent, app, keyword);
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
	public AppSearch(Component parent, AppMain app, String keyword) {
		this.parent = parent;
		this.app = app;
		this.keyword = keyword;
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollEvery = new JScrollPane();
		scrollEvery.setBounds(20, 50, 460, 200);
		contentPane.add(scrollEvery);
		
		tableEver = new JTable();
		tableEver.setColumnSelectionAllowed(true);
		
		EveList = sdao.readE(keyword);
		System.out.println(EveList);
		emodel = new DefaultTableModel(null, COLUMN_EVERYDAY);
		for (Everyday e: EveList) {
			Object[] erow = {e.getContent() ,e.getTodaysMood(), e.getWorkout(), e.getCreatedTime()};
			emodel.addRow(erow);
		}
	
		tableEver.setModel(emodel);
		tableEver.getTableHeader().setFont(new Font("D2Coding", Font.BOLD,13));
		tableEver.getTableHeader().setBackground(Color.WHITE);
		scrollEvery.setViewportView(tableEver);
		
		lblE = new JLabel("<일상 기록>");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblE.setBounds(20, 20, 100, 30);
		contentPane.add(lblE);
		
		lblC = new JLabel("<문화 생활 기록>");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblC.setBounds(20, 267, 140, 30);
		contentPane.add(lblC);
		
		scrollCul = new JScrollPane();
		scrollCul.setBounds(20, 297, 460, 200);
		contentPane.add(scrollCul);
		
		tableCul = new JTable();
		tableCul.setColumnSelectionAllowed(true);
		
		CulList = sdao.readC(keyword);
		System.out.println(CulList);
		cmodel = new DefaultTableModel(null, COLUMN_CULTURE);
		for (Culture c: CulList) {
			Object[] crow = {c.getCategory(), c.getTitle(), c.getContent(), c.getCreatedTime()};
			cmodel.addRow(crow);
		}
	
		tableCul.setModel(cmodel);
		tableCul.getTableHeader().setFont(new Font("D2Coding", Font.BOLD,13));
		tableCul.getTableHeader().setBackground(Color.WHITE);
		
		
		scrollCul.setViewportView(tableCul);
		scrollEvery.setViewportView(tableEver);
		
		
	}

			
		
	
}
