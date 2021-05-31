package com.java.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.dao.MovieDAO;
import com.java.dto.Movie;
import com.java.login.LoginFrame;

public class MovieUploadFrame extends JFrame{

	private JFrame frame;
	
	public MovieUploadFrame() {
		this(null);
	}
	
	public MovieUploadFrame(String id) {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel movieUploadPanel = new JPanel();
		movieUploadPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(movieUploadPanel);
		movieUploadPanel.setBackground(Color.lightGray);
		movieUploadPanel.setLayout(null);
		
		JLabel movieUploadLabel = new JLabel("영화 업로드");
		movieUploadLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieUploadLabel.setBounds(450,30, 120, 25);
		movieUploadPanel.add(movieUploadLabel);
		
		JLabel movieNameLabel = new JLabel("영화 제목 :");
		movieNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieNameLabel.setBounds(400, 150, 100, 25);
		movieUploadPanel.add(movieNameLabel);
		
		JTextField movieNameField = new JTextField();
		movieNameField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieNameField.setBounds(500, 150, 300, 25);
		movieUploadPanel.add(movieNameField);
		
		JLabel moviePriceLabel = new JLabel("가격 :");
		moviePriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		moviePriceLabel.setBounds(450, 250, 100, 25);
		movieUploadPanel.add(moviePriceLabel);
		
		JTextField moviePriceField = new JTextField();
		moviePriceField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		moviePriceField.setBounds(500, 250, 100, 25);
		movieUploadPanel.add(moviePriceField);
		
		JLabel movieRunningTimeLabel = new JLabel("상영 시간 :");
		movieRunningTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieRunningTimeLabel.setBounds(400, 350, 100, 25);
		movieUploadPanel.add(movieRunningTimeLabel);
		
		JTextField movieRunningTimeField = new JTextField();
		movieRunningTimeField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieRunningTimeField.setBounds(500, 350, 100, 25);
		movieUploadPanel.add(movieRunningTimeField);
		
		JLabel movieStartTimeLabel = new JLabel("상영 날짜 :");
		movieStartTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieStartTimeLabel.setBounds(400, 450, 100, 25);
		movieUploadPanel.add(movieStartTimeLabel);
		
		JTextField movieStartTimeField = new JTextField();
		movieStartTimeField.setFont(new Font("맑은 고딕 ", Font.BOLD, 15));
		movieStartTimeField.setBounds(500, 450, 100, 25);
		movieUploadPanel.add(movieStartTimeField);
		
		JLabel movieEndTimeLabel = new JLabel("종영 날짜 :");
		movieEndTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieEndTimeLabel.setBounds(620, 450, 100, 25);
		movieUploadPanel.add(movieEndTimeLabel);
		
		JTextField movieEndTimeField = new JTextField();
		movieEndTimeField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieEndTimeField.setBounds(700, 450, 100, 25);
		movieUploadPanel.add(movieEndTimeField);
		
		JButton movieUploadButton = new JButton("영화 업로드");
		movieUploadButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieUploadButton.setBounds(440, 500, 120, 25);
		movieUploadPanel.add(movieUploadButton);
		
		JLabel moviePosterLabel = new JLabel("포스터");
		moviePosterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		moviePosterLabel.setBounds(160, 100, 100, 25);
		movieUploadPanel.add(moviePosterLabel);
		
		// 이미지 저장
		JButton moviePosterButton = new JButton("포스터 찾기");
		moviePosterButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		moviePosterButton.setBounds(130, 500, 100, 25);
		movieUploadPanel.add(moviePosterButton);
		
		moviePosterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileDialog dialog = new FileDialog(frame, "이미지 저장", FileDialog.LOAD);
				dialog.setDirectory(".");	// .은 지금폴더
				dialog.setVisible(true);		
				if(dialog.getFile() == null) return;	// 비정상 종료
				
				String filePath = dialog.getDirectory() + dialog.getFile();
				System.out.println(filePath);
				ImageIcon movieImage = new ImageIcon(filePath);
				JLabel moivePosterPrintLabel = new JLabel(movieImage);
				moivePosterPrintLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
				moivePosterPrintLabel.setBounds(70, 140, 230, 342);
				movieUploadPanel.add(moivePosterPrintLabel);
				/*
				try {
				File moviePoster = new File(filePath);
				FileInputStream fis = new FileInputStream(moviePoster);
				}
				catch (Exception e1) {
					e1.printStackTrace();
					System.out.println("FileInputStream 오류");
				}
				*/
			}
		});	
		
		movieUploadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Movie movie = new Movie();
				movie.setM_name(movieNameField.getText());
				movie.setM_poster(movieNameField.getText());	// 고칠부분
				int m_price = Integer.parseInt(moviePriceField.getText());
				movie.setM_price(m_price);
				int m_runningTime = Integer.parseInt(movieRunningTimeField.getText());
				movie.setM_runningTime(m_runningTime);
				movie.setM_startTime(movieStartTimeField.getText());
				movie.setM_endTime(movieEndTimeField.getText());
				
				MovieDAO dao = MovieDAO.getInstance();
				int result = dao.movieUpload(movie);
				
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "영화 업로드 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "영화 업로드 실패");
					dispose();
				}
				frame.dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieUploadFrame frame = new MovieUploadFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
