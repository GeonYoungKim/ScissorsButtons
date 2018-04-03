import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.File;
import java.util.Stack;
public class Score {
	JFrame frame;
	Mouse mouse;
	View view;
	Start start;
	ImagePanel imagePanel;
	static int asd;
	static int num;
	public void score()
	{
		String q="시간 : ";
		String w="점수 : ";
		String s=" 횟수 : ";
		double c=imagePanel.a/1000.00;//게임한판을 한 시간
		double b;//double형 b
		if(c<=10)//게임 한 시간이 10초 이하면
			b=c*70+asd;
		else if(c>10&&c<=15)//게임 한 시간이 10초 초과,15초 이하면
			b=c*60+asd;
		else if(c>15&&c<=20)//게임 한 시간이 15초 초과,20초 이하면
			b=c*50+asd;
		else if(c>20&&c<=25)//게임 한 시간이 20초 초과,25초 이하면
			b=c*40+asd;
		else if(c>25&&c<=30)//게임 한 시간이 25초 초과,30초 이하면
			b=c*30+asd;
		else if(c>30&&c<=35)//게임 한 시간이 30초 초과,35초 이하면
			b=c*20+asd;
		else if(c>35&&c<=40)//게임 한 시간이 35초 초과,40초 이하면
			b=c*10+asd;
		else // 40초 초과는 보너스 점수 없음
			b=c+asd;
		int bbb=(int)(b);//double형 b를 int형 bbb로 바꿔줌
		String a=Integer.toString(bbb);//int형 bbb를 String형 a로 바꿔줌
		String sn=Integer.toString(num);//int형 num을 String형 sn으로 바꿔줌
		String d= Double.toString(c);//double형 c를 String형 d로 바꿔줌
		frame = new JFrame("점수,시간,선택 창");//"점수,시간,선택 창"프레임 생성
		Container contentPane = frame.getContentPane();	//컨텐트페인을 리턴하는 메소드			
		frame.setLocation(700,100);// 프레임 생성 위치
		frame.setPreferredSize(new Dimension(1100,500));// 프레임 크기
		
		ImageIcon returnimg=new ImageIcon("image/다시화살표.png");//ImageIcon으로 이미지를 returnimg에 저장
		ImageIcon nextimg=new ImageIcon("image/다음화살표.png");//ImageIcon으로 이미지를 nextimg에 저장
		
		JButton button2=new JButton(returnimg);//returnimg을 button2에 넣음
		JButton button3=new JButton(nextimg);//nextimg을 button3에 넣음
		
		JLabel label=new JLabel(a);//label에 a추가
		JLabel label1=new JLabel(d);//label1에 d추가
		JLabel label2=new JLabel(q);//label2에 q추가
		JLabel label3=new JLabel(w);//label3에 w추가
		JLabel label4=new JLabel(s);//label4에 s추가
		JLabel label5=new JLabel(sn);//label5에 sn추가
		
		Font fnt = new Font("궁서",Font.PLAIN,50);//궁서체의 크기 50인 Font fnt생성
		label.setFont(fnt);//label에 fnt로 세팅
		label1.setFont(fnt);//label1에 fnt로 세팅
		label2.setFont(fnt);//label2에 fnt로 세팅
		label3.setFont(fnt);//label3에 fnt로 세팅
		label4.setFont(fnt);//label4에 fnt로 세팅
		label5.setFont(fnt);//label5에 fnt로 세팅
		GridLayout layout1 = new GridLayout(1,6);// 1행 6열의 그리드레이아웃 layout1을 생성
		JPanel panel=new JPanel();	//JPanel panel 생성	
		JPanel panel1=new JPanel(); //JPanel panel1 생성
		panel.setLayout(layout1);//panel을 layout1 형태로 세팅
		panel.add(label2);//panel에 label2 추가
		panel.add(label1);//panel에 label1추가
		panel.add(label4);//panel에 label4추가
		panel.add(label5);//panel에 label5추가
		panel.add(label3);//panel에 label3추가
		panel.add(label);//panel에 label추가
		panel1.add(button2);//panel1에 button2 추가
		panel1.add(button3);//panel에 button3 추가
		contentPane.add(panel);//컨텐트페인에 panel추가
		contentPane.add(panel1,BorderLayout.SOUTH);//컨텐트페인에 panel1을 보더레이아웃중 남쪽에 추가
		
		button2.addActionListener(new second());//button2에 second 엑션이벤트 클래스 추가.
		button3.addActionListener(new third());//button3에 third 엑션이벤트 클래스 추가.
		frame.pack();//프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);//이 프레임을 보여줌	
		
	}
	public class second implements ActionListener//second 엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){
			view=new View();//View객체 생성
			view.a();//View에 a메소드 호출
			frame.dispose();//이 프레임 하나를 닫음	
			try{// "노을을바라보는 개구리"음악을 시작
				File file1 = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
				audioClip1.loop();
				}
				catch (MalformedURLException mue){}
		}
	}
	public class third implements ActionListener//third 엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){
			
			view=new View();//View객체 생성
			view.b();//View에 b메소드 호출
			frame.dispose();//이 프레임 하나를 닫음
			try{// "노을을바라보는 개구리"음악을 시작				
				File file1 = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
				audioClip1.loop();
				}
				catch (MalformedURLException mue){}
		}
	}
}