package edu.java.record.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.record.controller.DPostDaoImpl;
import edu.java.record.model.Dday;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class AppDday extends JFrame {
	
	private final static LocalDateTime NOW = LocalDateTime.now();

	private Component parent;
	private AppMain app;
	private DPostDaoImpl ddao = DPostDaoImpl.getInstance();

	
	private JPanel contentPane;
	private JTextField texttitle;
	private JTextField textYear;
	private JTextField textDay;
	private JTextField textMon;
	private JLabel ym;
	private JLabel md;
	private JLabel title;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void showDday(Component parent, AppMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDday frame = new AppDday(parent, app);
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
	public AppDday(Component parent, AppMain app) {
		this.parent = parent;
		this.app= app;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x, y, 280, 225);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("<D-DAY>");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("D2Coding", Font.PLAIN, 17));
		title.setBounds(30, 30, 220, 30);
		contentPane.add(title);
		
		texttitle = new JTextField();
		texttitle.setFont(new Font("D2Coding", Font.PLAIN, 13));
		texttitle.setColumns(10);
		texttitle.setBounds(30, 55, 220, 37);
		contentPane.add(texttitle);
		
		textYear = new JTextField();
		textYear.setText("YYYY");
		textYear.setHorizontalAlignment(SwingConstants.CENTER);
		textYear.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textYear.setColumns(10);
		textYear.setBounds(30, 98, 70, 30);
		contentPane.add(textYear);
		
		textDay = new JTextField();
		textDay.setText("DD");
		textDay.setHorizontalAlignment(SwingConstants.CENTER);
		textDay.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textDay.setColumns(10);
		textDay.setBounds(190, 98, 60, 30);
		contentPane.add(textDay);
		
		textMon = new JTextField();
		textMon.setText("MM");
		textMon.setHorizontalAlignment(SwingConstants.CENTER);
		textMon.setFont(new Font("D2Coding", Font.PLAIN, 13));
		textMon.setColumns(10);
		textMon.setBounds(115, 98, 60, 30);
		contentPane.add(textMon);
		
		ym = new JLabel("/");
		ym.setHorizontalAlignment(SwingConstants.CENTER);
		ym.setFont(new Font("D2Coding", Font.PLAIN, 13));
		ym.setBounds(100, 98, 15, 30);
		contentPane.add(ym);
		
		md = new JLabel("/");
		md.setHorizontalAlignment(SwingConstants.CENTER);
		md.setFont(new Font("D2Coding", Font.PLAIN, 13));
		md.setBounds(175, 98, 15, 30);
		contentPane.add(md);
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createnewdd();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnSave.setBounds(90, 140, 100, 30);
		contentPane.add(btnSave);
	}

	
	
	private void createnewdd() {
		String dtitle = texttitle.getText();
		
		String dcount = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String iny = textYear.getText();
		String inm = textMon.getText();
		String ind = textDay.getText();
		String ddate = iny + inm + ind;
		Date dd;
		try {
			dd = format.parse(ddate);
			Date today = new Date();
			long count = (dd.getTime() - today.getTime())/(24 * 60 * 60 * 1000) + 1;
			if(count < 0) {
				dcount = "D+" + Math.abs(count);
			} else if (count == 0) {
				dcount = "D-DAY!!";
			} else if (count > 0){
				dcount = "D-" + Math.abs(count);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		Dday dday = new Dday(0, dtitle, dcount);
		ddao.create(dday);
		app.resetDD();
		dispose();
	}
}
