package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.java.dao.MovieDAO;

public class RecomFrame extends JFrame {

	private JFrame frame;
	private String id;
	
	public RecomFrame() {}
	
	public RecomFrame(String id) {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel recomPanel = new JPanel();
		recomPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(recomPanel);
		recomPanel.setBackground(Color.lightGray);
		recomPanel.setLayout(null);
		
		// dao에서 예매수를 확인해서 포스터의 이름을 가져옮
		MovieDAO dao = MovieDAO.getInstance();
		String movieRate1 = dao.recomRate1();
		String movieRate2 = dao.recomRate2();
		String movieRate3 = dao.recomRate3();
		
		ImageIcon moviePosterRate1 = new ImageIcon("images/" + movieRate1);
		ImageIcon moviePosterRate2  = new ImageIcon("images/" + movieRate2);
		ImageIcon moviePosterRate3  = new ImageIcon("images/" + movieRate3);
		
		JLabel movieRankingLabel = new JLabel("영화 예매 순위");
		movieRankingLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		movieRankingLabel.setBounds(425, 30, 150, 25);
		recomPanel.add(movieRankingLabel);
		
		JLabel movieRanking1Label = new JLabel("Top 1");
		movieRanking1Label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieRanking1Label.setBounds(140, 120, 100, 25);
		recomPanel.add(movieRanking1Label);
		
		JLabel moviePosterRate1Label = new JLabel(moviePosterRate1);
		moviePosterRate1Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		moviePosterRate1Label.setBounds(50, 175, 230, 342);
		recomPanel.add(moviePosterRate1Label);
		
		JLabel movieRanking2Label = new JLabel("Top 2");
		movieRanking2Label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieRanking2Label.setBounds(475, 120, 100, 25);
		recomPanel.add(movieRanking2Label);
		
		JLabel moviePosterRate2Label = new JLabel(moviePosterRate2);
		moviePosterRate2Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		moviePosterRate2Label.setBounds(385, 175, 230, 342);
		recomPanel.add(moviePosterRate2Label);
		
		JLabel movieRanking3Label = new JLabel("Top 3");
		movieRanking3Label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieRanking3Label.setBounds(810, 120, 100, 25);
		recomPanel.add(movieRanking3Label);

		JLabel moviePosterRate3Label = new JLabel(moviePosterRate3);
		moviePosterRate3Label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		moviePosterRate3Label.setBounds(720, 175, 230, 342);
		recomPanel.add(moviePosterRate3Label);
		
		JButton beforeRecomButton = new JButton("이전화면");
		beforeRecomButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeRecomButton.setBounds(50, 30, 100, 30);
		recomPanel.add(beforeRecomButton);
		
		JButton nextReserveButton = new JButton("예매하기");
		nextReserveButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nextReserveButton.setBounds(850, 30, 100, 30);
		recomPanel.add(nextReserveButton);
		
		beforeRecomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame(id);
			}
		});
		
		nextReserveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReservationFrame frame = new ReservationFrame(id);
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RecomFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
