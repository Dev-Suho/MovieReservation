package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class RecomFrame extends JFrame {

	private JFrame frame;
	
	public RecomFrame() {
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
		
		JButton beforeRecomButton = new JButton("이전화면");
		beforeRecomButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeRecomButton.setBounds(30, 450, 100, 30);
		recomPanel.add(beforeRecomButton);
		
		ImageIcon recomMovie1 = new ImageIcon("images/비와 당신의 이야기.jpg");
		ImageIcon recomMovie2 = new ImageIcon("images/미나리.jpg");
		ImageIcon recomMovie3 = new ImageIcon("images/분노의 질주.jpg");
		
		JButton recomMovieBtn1 = new JButton(recomMovie1);
		recomMovieBtn1.setBounds(40, 50, 230, 342);
		recomPanel.add(recomMovieBtn1);
		JButton recomMovieBtn2 = new JButton(recomMovie2);
		JButton recomMovieBtn3 = new JButton(recomMovie3);
		
		JSlider movieSlider = new JSlider();
		movieSlider.setBounds(300, 380, 400, 40);
		recomPanel.add(movieSlider);
		
		beforeRecomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame();
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
