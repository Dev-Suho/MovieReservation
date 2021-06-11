package com.java.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.java.dao.MovieDAO;
import com.java.dto.Movie;
import com.java.login.LoginFrame;

public class MovieUploadFrame extends JFrame{

	private JFrame frame;
	private String fileName;
	private File image_save = null;
	private String filePath;
	private File savePath = null;
	private String imgSaveName;
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
		moviePriceLabel.setBounds(445, 250, 100, 25);
		movieUploadPanel.add(moviePriceLabel);
		
		JTextField moviePriceField = new JTextField();
		moviePriceField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		moviePriceField.setBounds(500, 250, 100, 25);
		movieUploadPanel.add(moviePriceField);
		
		JLabel movieReserveLabel = new JLabel("예매 횟수 :");
		movieReserveLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieReserveLabel.setBounds(620, 250, 100, 25);
		movieUploadPanel.add(movieReserveLabel);
		
		JTextField movieReserveField = new JTextField();
		movieReserveField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieReserveField.setBounds(700, 250, 100, 25);
		movieUploadPanel.add(movieReserveField);
		
		JLabel movieRunningTimeLabel = new JLabel("러닝 타임 :");
		movieRunningTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieRunningTimeLabel.setBounds(400, 350, 100, 25);
		movieUploadPanel.add(movieRunningTimeLabel);
		
		JTextField movieRunningTimeField = new JTextField();
		movieRunningTimeField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieRunningTimeField.setBounds(500, 350, 100, 25);
		movieUploadPanel.add(movieRunningTimeField);
		
		JLabel movieTheaterLabel = new JLabel("상영관(A,B,C) :");
		movieTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieTheaterLabel.setBounds(610, 350, 130, 25);
		movieUploadPanel.add(movieTheaterLabel);
		
		JTextField movieTheaterField = new JTextField();
		movieTheaterField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieTheaterField.setBounds(720, 350, 100, 25);
		movieUploadPanel.add(movieTheaterField);
		
		JLabel movieStartDayLabel = new JLabel("상영 날짜 :");
		movieStartDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieStartDayLabel.setBounds(400, 450, 100, 25);
		movieUploadPanel.add(movieStartDayLabel);
		
		JTextField movieStartDayField = new JTextField();
		movieStartDayField.setFont(new Font("맑은 고딕 ", Font.BOLD, 15));
		movieStartDayField.setBounds(500, 450, 100, 25);
		movieUploadPanel.add(movieStartDayField);
		
		JLabel movieStartTimeLabel = new JLabel("상영 시간 :");
		movieStartTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieStartTimeLabel.setBounds(620, 450, 100, 25);
		movieUploadPanel.add(movieStartTimeLabel);
		
		JTextField movieStartTimeField = new JTextField();
		movieStartTimeField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieStartTimeField.setBounds(700, 450, 100, 25);
		movieUploadPanel.add(movieStartTimeField);
		
		JButton movieUploadButton = new JButton("영화 업로드");
		movieUploadButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		movieUploadButton.setBounds(440, 500, 120, 25);
		movieUploadPanel.add(movieUploadButton);
		
		JLabel moviePosterLabel = new JLabel("포스터");
		moviePosterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		moviePosterLabel.setBounds(160, 100, 100, 25);
		movieUploadPanel.add(moviePosterLabel);
		
		JLabel moviePosterPrintLabel = new JLabel();
		//moviePosterPrintLabel.setIcon(new ImageIcon(filePath));
		moviePosterPrintLabel.setBounds(70, 140, 230, 342);
		movieUploadPanel.add(moviePosterPrintLabel);
		
		JButton beforeFrameButton = new JButton("이전화면");
		beforeFrameButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeFrameButton.setBounds(50, 30, 100, 25);
		movieUploadPanel.add(beforeFrameButton);
		
		// 이미지 저장
		JButton moviePosterButton = new JButton("포스터 찾기");
		moviePosterButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		moviePosterButton.setBounds(130, 500, 100, 25);
		movieUploadPanel.add(moviePosterButton);
		
		moviePosterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser movieImageChooser = new JFileChooser();
				movieImageChooser.setDialogTitle("영화 포스터 이미지 불러오기");
				int returnVal = movieImageChooser.showOpenDialog(frame);
				
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				filePath = movieImageChooser.getSelectedFile().getPath();
				fileName = movieImageChooser.getSelectedFile().getName();
				image_save = new File(filePath);
				
				System.out.println(fileName);
				System.out.println(filePath);
				System.out.println(image_save);
				moviePosterPrintLabel.setIcon(new ImageIcon(filePath));
				/*
				JLabel moviePosterPrintLabel = new JLabel();
				moviePosterPrintLabel.setIcon(new ImageIcon(filePath));
				moviePosterPrintLabel.setBounds(70, 140, 230, 342);
				movieUploadPanel.add(moviePosterPrintLabel);
				*/
				}
			}
		});	
		
		movieUploadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser movieImageChooser = new JFileChooser();
				movieImageChooser.setAcceptAllFileFilterUsed(false);
				movieImageChooser.setMultiSelectionEnabled(false);
				movieImageChooser.setFileFilter(new FileNameExtensionFilter("JPG", "JPG"));
				
				
				try {
					BufferedImage bufferImage = ImageIO.read(image_save);
					savePath = new File("images/"+fileName);
					ImageIO.write(bufferImage, "jpg", savePath);
				
				} catch (Exception e2) {
					e2.printStackTrace();
					System.out.println("JFileChooser 오류");
					JOptionPane.showMessageDialog(null, "영화 업로드 실패");
				}
				
				Movie movie = new Movie();
				movie.setM_name(movieNameField.getText());
				movie.setM_poster(fileName);
				System.out.println(fileName);
				int m_price = Integer.parseInt(moviePriceField.getText());
				movie.setM_price(m_price);
				int m_runningTime = Integer.parseInt(movieRunningTimeField.getText());
				movie.setM_runningTime(m_runningTime);
				movie.setM_startDay(movieStartDayField.getText());
				movie.setM_startTime(movieStartTimeField.getText());
				movie.setM_theater(movieTheaterField.getText());
				int m_count = Integer.parseInt(movieReserveField.getText());
				movie.setM_count(m_count);
				
				MovieDAO dao = MovieDAO.getInstance();
				int result = dao.movieUpload(movie);
				
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "영화 업로드 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "영화 업로드 실패");
					dispose();
				}
			}
		});
		
		beforeFrameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MovieManagementFrame frame = new MovieManagementFrame(id);
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
