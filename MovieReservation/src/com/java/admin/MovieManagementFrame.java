package com.java.admin;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.dao.MemberDAO;
import com.java.dao.MovieDAO;
import com.java.dto.Movie;

public class MovieManagementFrame extends JFrame {

	private JFrame frame;
	private String id;
	private DefaultTableModel tableModel;
	
	public MovieManagementFrame() {
		this(null);
	}
	
	public MovieManagementFrame(String id) {
		this.id = id;
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		/*
		if (id == null) {
			JOptionPane.showMessageDialog(null, "인증되지 않은 사용자입니다");
			dispose();
			frame.dispose();
		}
		else {
			frame.setVisible(true);
		}
		*/
		
		JPanel movieManagementPanel = new JPanel();
		movieManagementPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(movieManagementPanel);
		movieManagementPanel.setBackground(Color.lightGray);
		movieManagementPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel movieListLabel = new JLabel("영화 목록");
		movieListLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		movieListLabel.setPreferredSize(new Dimension(100, 40));
		movieManagementPanel.add(movieListLabel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel(new GridLayout(1, 3));
		JButton memberDeleteButton = new JButton("영화 삭제");
		JButton beforeButton = new JButton("이전화면");
		JButton movieUploadButton = new JButton("영화 업로드");
		southPanel.add(memberDeleteButton);
		southPanel.add(beforeButton);
		southPanel.add(movieUploadButton);
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberDeleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieUploadButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieManagementPanel.add(southPanel, BorderLayout.SOUTH);
		
		
		MovieDAO dao = MovieDAO.getInstance();
		Vector<String> movieList = dao.getMovieList();
		Vector<Movie> movies = dao.findByAllMovie();
		
		tableModel = new DefaultTableModel(movieList, 0);
		
		for (int i = 0; i < movies.size(); i++) {
			Vector<Object> row = new Vector<>();
			
			row.addElement(movies.get(i).getM_name());
			row.addElement(movies.get(i).getM_poster());
			row.addElement(movies.get(i).getM_startTime());
			row.addElement(movies.get(i).getM_endTime());
			row.addElement(movies.get(i).getM_runningTime());
			row.addElement(movies.get(i).getM_price());
			tableModel.addRow(row);
		}
		
		JTable movieTable = new JTable(tableModel);
		movieTable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		movieTable.setBounds(100, 100, 800, 400);
		movieManagementPanel.add(movieTable, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(movieTable);
		movieManagementPanel.add(scrollPane, BorderLayout.CENTER);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminFrame frame = new AdminFrame(id);
			}
		});
		
		movieUploadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MovieUploadFrame frame = new MovieUploadFrame(id);
			}
		});
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MovieManagementFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
