package com.java.guest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.dao.MovieDAO;
import com.java.dto.Movie;

public class ReservationFrame extends JFrame {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private String id;
	
	public ReservationFrame() {}
	
	public ReservationFrame(String id) {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel rsvPanel = new JPanel();
		rsvPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(rsvPanel);
		rsvPanel.setBackground(Color.lightGray);
		rsvPanel.setLayout(new BorderLayout(0,0));
		
		JPanel southPanel = new JPanel(new GridLayout(1, 2));
		JButton beforeFrameButton = new JButton("이전화면");
		JButton nextReserveButton = new JButton("영화 선택");
		southPanel.add(beforeFrameButton);
		southPanel.add(nextReserveButton);
		beforeFrameButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nextReserveButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		rsvPanel.add(southPanel, BorderLayout.SOUTH);
		
		MovieDAO dao = MovieDAO.getInstance();
		Vector<String> movieList = dao.getMovieReserveList();
		Vector<Movie> movies = dao.findByAllMovie();
		
		tableModel = new DefaultTableModel(movieList, 0);
		
		for (int i = 0; i < movies.size(); i++) {
			Vector<Object> row = new Vector<>();
			
			row.addElement(movies.get(i).getM_name());
			row.addElement(movies.get(i).getM_theater());
			row.addElement(movies.get(i).getM_startDay());
			row.addElement(movies.get(i).getM_startTime());
			row.addElement(movies.get(i).getM_runningTime());
			row.addElement(movies.get(i).getM_price());
			row.addElement(movies.get(i).getM_poster());
			tableModel.addRow(row);
		}
		
		JTable movieTable = new JTable(tableModel);
		movieTable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		movieTable.setBounds(100, 100, 800, 400);
		rsvPanel.add(movieTable, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(movieTable);
		rsvPanel.add(scrollPane, BorderLayout.CENTER);
		
		JLabel rsvLabel = new JLabel("영화 목록");
		rsvLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		rsvLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rsvLabel.setPreferredSize(new Dimension(100, 40));
		rsvPanel.add(rsvLabel, BorderLayout.NORTH);
		
		beforeFrameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame(id);
			}
		});
		
		nextReserveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = movieTable.getSelectedRow();
				if(row < 0) {
					row = movieTable.getRowCount()-1;
				}
				String m_name = (String)movieTable.getValueAt(row, 0);
				String m_theater = (String)movieTable.getValueAt(row, 1);
				String m_startDay = (String)movieTable.getValueAt(row, 2);
				String m_startTime = (String)movieTable.getValueAt(row, 3);
				int m_price = (Integer)movieTable.getValueAt(row, 5);
				String m_poster = (String)movieTable.getValueAt(row, 6);
				frame.dispose();
				ChoiceSeatFrame frame = new ChoiceSeatFrame(id,m_name,m_theater,m_startDay,m_startTime,m_price,m_poster);
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ReservationFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
