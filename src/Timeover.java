import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Stack;
import java.applet.*;
import java.net.*;
import java.io.File;
public class Timeover {
	JFrame frame;
	View view;
	Start start;
	public void over()
	{
		frame = new JFrame("Game Over");//"Game Over"프레임 생성
		Container contentPane = frame.getContentPane();	//컨텐트페인을 리턴하는 메소드	
		frame.setLocation(700,100); // 프레임 생성 위치
		frame.setPreferredSize(new Dimension(800,550));// 프레임 크기
		ImageIcon returnimg=new ImageIcon("image/다시화살표.png");//ImageIcon으로 이미지를 returnimg에 저장
		ImageIcon nextimg=new ImageIcon("image/x.png");//ImageIcon으로 이미지를 nextimg에 저장
		ImageIcon gameover=new ImageIcon("image/게임오버.png");//ImageIcon으로 이미지를 gameover에 저장
		
		JButton button1=new JButton(returnimg);//returnimg을 button1에 넣음
		JButton button2=new JButton(nextimg);//nextimg을 button2에 넣음
		JButton button3=new JButton(gameover);//gameover을 button3에 넣음
		Dimension button3Size=new Dimension(1000,230);//button3Size의 사이즈를 정함
		button3.setPreferredSize(button3Size);//button3의 사이즈를 button3Size로 세팅
		JPanel panel=new JPanel(); //JPanel panel 생성
		JPanel panel1=new JPanel(); //JPanel panel1 생성
		GridLayout layout = new GridLayout(1,2);//1행 2열의 그리드레이아웃 layout을 생성
		panel.setLayout(layout);//panel에 layout형태로 세팅
		panel.add(button1);//panel에 button1추가
		panel.add(button2);//panel에 button2추가
		panel1.add(button3);//panel에 button3추가
		contentPane.add(panel1,BorderLayout.NORTH);//컨텐트페인에 panel1을 보더레이아웃의 북쪽에 추가
		contentPane.add(panel);//컨텐트페인에 panel1을 추가
		button1.addActionListener(new first());//button1에 first 엑션이벤트 클래스 추가.
		button2.addActionListener(new second());//button2에 second 엑션이벤트 클래스 추가.
		frame.pack();//프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);//이 프레임을 보여줌
	}
	public class first implements ActionListener//first 엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){
			view=new View();//View클래스 생성
			if(view.qwe==1)//View에 a메소드에 남겨둔 표시가 있다면
				view.a();//a메소드 호출
			else if(view.qwe==2)//View에 b메소드에 남겨둔 표시가 있다면
				view.b();//b메소드 호출
			else if(view.qwe==3)//View에 c메소드에 남겨둔 표시가 있다면
				view.c();//c메소드 호출
			frame.dispose();//이 프레임 하나를 닫음
		}
	}
	public class second implements ActionListener//second 엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){
			System.exit(0);//시스템이 모두 종료됨
		}
	}
}