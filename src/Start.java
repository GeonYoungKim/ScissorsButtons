import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import java.io.File;
import java.awt.event.*;
import java.util.Stack;
public class Start {
	JFrame frame;	
	View view;	
	public void go() //처음 1,2,3판 중에서 선택할수 있는 프레임 생성 메소드
	{
		frame = new JFrame("게임 선택 창"); //"게임 선택 창"프레임 생성
		Container contentPane = frame.getContentPane();	//컨텐트페인을 리턴하는 메소드
		frame.setLocation(700,100); // 프레임 생성 위치
		frame.setPreferredSize(new Dimension(800,500)); // 프레임 크기
		ImageIcon im=new ImageIcon("image/1.png"); //ImageIcon으로 이미지를 im에 저장
		ImageIcon im1=new ImageIcon("image/2.png"); //ImageIcon으로 이미지를 im1에 저장
		ImageIcon im2=new ImageIcon("image/3.png"); //ImageIcon으로 이미지를 im2에 저장
		
		JButton button1=new JButton(im); //im을 button1에 넣음
		JButton button2=new JButton(im1); //im1을 button2에 넣음
		JButton button3=new JButton(im2); //im2을 button3에 넣음
		
		GridLayout layout = new GridLayout(1,3); // 1행 3열의 그리드레이아웃 layout을 생성
		contentPane.setLayout(layout); //컨텐트페인에 layout형태로 세팅
		
		contentPane.add(button1); //컨텐트페인에 button1추가
		contentPane.add(button2); //컨텐트페인에 button2추가
		contentPane.add(button3); //컨텐트페인에 button3추가
		
		button1.addActionListener(new First()); //button1에 First 엑션이벤트 클래스 추가.
		button2.addActionListener(new Second()); //button2에 Second 엑션이벤트 클래스 추가.
		button3.addActionListener(new Third()); //button3에 Third 엑션이벤트 클래스 추가.
		
		frame.pack(); //프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true); //이 프레임을 보여줌
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x를 누르면 시스템이 종료되도록함
	}
	public class First implements ActionListener //First 엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){ //버튼 클릭시 이벤트 수행부분
			view=new View(); // View클래스 생성
			view.a(); //View클래스의 a메소드 생성
			try{ //a메소드가 생성됨과 동시에 "노을을바라보는개구리" 음악을 시작함
				File file1 = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
				audioClip1.loop();//<-노래가 끝나도 다시 노래 시작하도록함
				}
				catch (MalformedURLException mue){}
		}
	}
	public class Second implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			view=new View(); // View클래스 생성
			view.b(); //View클래스의 b메소드 생성
			try{ //b메소드가 생성됨과 동시에 "노을을바라보는개구리" 음악을 시작함
				File file1 = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
				audioClip1.loop();
				}
				catch (MalformedURLException mue){}
		}
	}
	public class Third implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			view=new View(); // View클래스 생성
			view.c(); //View클래스의 c메소드 생성
			try{ //c메소드가 생성됨과 동시에 "노을을바라보는개구리" 음악을 시작함
				File file1 = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
				audioClip1.loop();
				}
				catch (MalformedURLException mue){}
		}
	}
}