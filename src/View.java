import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.File;
import java.util.Stack;
public class View {
	static public ImagePanel imagePanel;
	static public JFrame frame;
	Mouse mouse;
	Score score;
	Score1 score1;
	Score2 score2;
	View view;
	Timeover timeover;
	Timer timer;
	String a="image/라면.png";
	String b="image/치킨.png";
	String c="image/햄버그.png";
	String d="image/생선.png";
	String e="image/케이크.png";
	String f="image/파스.png";
	String g="image/비빔밥.png";
	String sImage[][]= //String형식 이차원 배열(게임틀)
		{{a,a,a,b,c},
		{d,a,e,d,e},
		{d,b,c,e,c},
		{b,a,b,d,c},
		{c,e,b,d,c}};
	String sImage11[][]= //String형식 이차원 배열(게임틀)
		{{a,e,d,g,c},
		{d,a,g,e,b},
		{d,d,c,e,e},
		{g,a,b,a,e},
		{c,b,c,c,c}};
	String sImage111[][]= //String형식 이차원 배열(게임틀)
		{{c,a,e,g,g},
		{c,c,g,e,c},
		{e,a,e,b,e},
		{a,c,a,a,g},
		{c,b,b,b,b}};	
	static int qwe; //Start 클래스에서 1,2,3탄중 어떤것을 선택하였는지 표시할 변수
	static long startTime; //게임을 시작하는 시간
	static int bea,beb,bex,bey; //되돌리기 버튼을 위해 삭제할때의 두 x,y좌표값
	public void a()
	{	
		score.num=0;//횟수 초기화
		score1.num=0;//횟수 초기화
		score2.num=0;//횟수 초기화
		score.asd=0;//점수 초기화	
		score1.asd=0;//점수 초기화
		score2.asd=0;//점수 초기화
		startTime=System.currentTimeMillis(); //게임을 시작한 시간을 저장
		view.qwe=1; // a메소드를 호출했다는 것을 표시(다른 메소드들을 호출하기도 하여 static으로 함 )
		frame = new JFrame("buttons&scissors 1탄"); // 1탄의 프레임 생성
		Container contentPane = frame.getContentPane();	//컨텐트페인을 리턴하는 메소드	
		frame.setLocation(700,100);// 프레임 생성 위치
		frame.setPreferredSize(new Dimension(665,537));// 프레임 크기
		
		Mouse mouse = new Mouse();//마우스 이벤트를 사용하기 위하여  Mouse객체 생성
		frame.addMouseListener(mouse);	//마우스 이벤트를 프레임에 사용하도록함.
		
		ImageIcon exit=new ImageIcon("image/나가기.png");//ImageIcon으로 이미지를 exit에 저장
		ImageIcon re=new ImageIcon("image/되돌리기화살표.png");//ImageIcon으로 이미지를 re에 저장
		JButton button1 = new JButton(exit);//exit을 button1에 넣음
		JButton button2 = new JButton(re);//re을 button2에 넣음
		
		GridLayout layout1 = new GridLayout(2,1);// 2행 1열의 그리드레이아웃 layout1을 생성
		imagePanel = new ImagePanel(sImage); //Imagepanel 생성자 호출 String형식의 이차원 배열 받음
		JPanel panel =new JPanel(); //JPanel생성
		panel.setPreferredSize(new Dimension(150,50)); //panel의 크기 조정
		panel.setLayout(layout1);//panel을 layout1 형태로 세팅
		panel.add(button1);//panel에 button1을 추가
		panel.add(button2);//panel에 button2을 추가
		contentPane.add(imagePanel);//컨텐트페인에 imagepanel 추가
		contentPane.add(panel,BorderLayout.EAST);//컨텐트페인에 panel을 보더레이아웃 중 동쪽에 추가
		
		button1.addActionListener(new first()); //button1에 first 엑션이벤트 클래스 추가.
		button2.addActionListener(new second()); //button2에 second 엑션이벤트 클래스 추가.
		
		timer = new Timer(); //Timer객체 생성
		timer.schedule(new JobTask(),60000); //1분동안 jobTask를 실시함
		frame.pack();//프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);	 //이 프레임을 보여줌	
	}	
	public void b()
	{	
		score.num=0;//횟수 초기화
		score1.num=0;//횟수 초기화
		score2.num=0;//횟수 초기화
		score.asd=0;	//점수 초기화
		score1.asd=0;//점수 초기화
		score2.asd=0;//점수 초기화
		startTime=System.currentTimeMillis();//게임을 시작한 시간을 저장
		view.qwe=2;// b메소드를 호출했다는 것을 표시(다른 메소드들을 호출하기도 하여 static으로 함 )
		frame = new JFrame("buttons&scissors 2탄");// 2탄의 프레임 생성
		Container contentPane = frame.getContentPane();//컨텐트페인을 리턴하는 메소드		
		frame.setLocation(700,100);// 프레임 생성 위치
		frame.setPreferredSize(new Dimension(665,537));// 프레임 크기
		
		Mouse mouse = new Mouse();//마우스 이벤트를 사용하기 위하여  Mouse객체 생성
		frame.addMouseListener(mouse);	//마우스 이벤트를 프레임에 사용하도록함.
		
		ImageIcon exit=new ImageIcon("image/나가기.png");//ImageIcon으로 이미지를 exit에 저장
		ImageIcon re=new ImageIcon("image/되돌리기화살표.png");//ImageIcon으로 이미지를 re에 저장
		JButton button1 = new JButton(exit);//exit을 button1에 넣음
		JButton button2 = new JButton(re);//re을 button2에 넣음
		
		GridLayout layout1 = new GridLayout(2,1);// 2행 1열의 그리드레이아웃 layout1을 생성
		imagePanel = new ImagePanel(sImage11);//Imagepanel 생성자 호출 String형식의 이차원 배열 받음
		JPanel panel =new JPanel();//JPanel생성
		panel.setPreferredSize(new Dimension(150,50)); //panel의 크기 조정
		panel.setLayout(layout1);//panel을 layout1 형태로 세팅
		panel.add(button1);//panel에 button1을 추가
		panel.add(button2);//panel에 button2을 추가
		contentPane.add(imagePanel);//컨텐트페인에 imagepanel 추가
		contentPane.add(panel,BorderLayout.EAST);//컨텐트페인에 panel을 보더레이아웃 중 동쪽에 추가
		
		button1.addActionListener(new first());//button1에 first 엑션이벤트 클래스 추가.
		button2.addActionListener(new second());//button2에 second 엑션이벤트 클래스 추가.
		
		timer = new Timer();//Timer객체 생성
		timer.schedule(new JobTask(),60000);//1분동안 jobTask를 실시함
		frame.pack();//프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);	 //이 프레임을 보여줌	
	}	
	public void c()
	{	
		score.num=0;//횟수 초기화
		score1.num=0;//횟수 초기화
		score2.num=0;//횟수 초기화
		score.asd=0;//점수 초기화
		score1.asd=0;//점수 초기화
		score2.asd=0;//점수 초기화
		startTime=System.currentTimeMillis();//게임을 시작한 시간을 저장
		view.qwe=3;// c메소드를 호출했다는 것을 표시(다른 메소드들을 호출하기도 하여 static으로 함 )
		frame = new JFrame("buttons&scissors 3탄");// 3탄의 프레임 생성
		Container contentPane = frame.getContentPane();	//컨텐트페인을 리턴하는 메소드		
		frame.setLocation(700,100);// 프레임 생성 위치
		frame.setPreferredSize(new Dimension(665,537));// 프레임 크기
		
		Mouse mouse = new Mouse();//마우스 이벤트를 사용하기 위하여  Mouse객체 생성
		frame.addMouseListener(mouse);	//마우스 이벤트를 프레임에 사용하도록함.
		
		ImageIcon exit=new ImageIcon("image/나가기.png");//ImageIcon으로 이미지를 exit에 저장
		ImageIcon re=new ImageIcon("image/되돌리기화살표.png");//ImageIcon으로 이미지를 re에 저장
		JButton button1 = new JButton(exit);//exit을 button1에 넣음
		JButton button2 = new JButton(re);//re을 button2에 넣음
		
		GridLayout layout1 = new GridLayout(2,1);// 2행 1열의 그리드레이아웃 layout1을 생성
		imagePanel = new ImagePanel(sImage111); //Imagepanel 생성자 호출 String형식의 이차원 배열 받음
		JPanel panel =new JPanel();//JPanel생성
		panel.setPreferredSize(new Dimension(150,50));//panel의 크기 조정
		panel.setLayout(layout1);//panel을 layout1 형태로 세팅
		panel.add(button1);//panel에 button1을 추가
		panel.add(button2);//panel에 button2을 추가
		contentPane.add(imagePanel);//컨텐트페인에 imagepanel 추가
		contentPane.add(panel,BorderLayout.EAST);//컨텐트페인에 panel을 보더레이아웃중 동쪽에 추가
		
		button1.addActionListener(new first());//button1에 first 엑션이벤트 클래스 추가.
		button2.addActionListener(new second());//button2에 second 엑션이벤트 클래스 추가.
		
		timer = new Timer();//Timer객체 생성
		timer.schedule(new JobTask(),60000);//1분동안 jobTask를 실시함
		frame.pack();//프레임을 적절한 크기로 만드는 메소드
		frame.setVisible(true);	//이 프레임을 보여줌		
	}
	public class first implements ActionListener //first엑션이벤트 클래스
	{
		public void actionPerformed(ActionEvent e){//버튼 클릭시 이벤트 수행부분
			frame.dispose(); //이 프레임 하나를 닫음
			timer.cancel();	//시간이 흐르고있는 timer취소
			try{ //"노을을바라보는개구리"음악을 취소 시킴 
				File file = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip = Applet.newAudioClip(file.toURL());
				audioClip.stop();//<-취소 부분
				}
				catch (MalformedURLException mue){}
		}	
	}
	public class second implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			imagePanel.beChange(bea,beb,bex,bey); //imagepanel에 beChange()메소드 호출	
			Score.asd=Score.asd-50; //Score.asd를 50 내림(점수)
			Score1.asd=Score1.asd-50; //Score1.asd를 50 내림(점수)
			Score2.asd=Score2.asd-50; //Score2.asd를 50 내림(점수)
			try{//"건담_기동음"효과음 나옴
				File file = new File("image/건담_기동음.wav");
				AudioClip audioClip = Applet.newAudioClip(file.toURL());
				audioClip.play();
				}
				catch (MalformedURLException mue){}
		}
}
	public class JobTask extends TimerTask{
		public void run()
		{
			int x=0; //정수형 변수 x를 0으로 초기값 설정
			for(int i=0;i<5;i++)
				for(int j=0; j<5; j++)
					if(imagePanel.sImage[i][j]==imagePanel.judimage[i][j])
						x++; // imagepanel.sImage와 imagepanel.judimage(판단하기 위해 만든 이차원 배열)를 비교하여 같은부분이 있을때마다 x값 1씩 증가
			if(x<25) //x가 25미만이라면
			{
			try{//"노을을바라보는개구리"음악 취소
				File file = new File("image/노을을바라보는개구리.mid");
				AudioClip audioClip = Applet.newAudioClip(file.toURL());
				audioClip.stop();//<-취소 부분
				}
				catch (MalformedURLException mue){}			
			timeover=new Timeover();//Timeover객체 생성
			timeover.over();//Timeover의 over메소드 호출
			try{//"폭발"음악 나옴
				File file = new File("image/폭발.wav");
				AudioClip audioClip = Applet.newAudioClip(file.toURL());
				audioClip.play();//한번만 나옴
				}
				catch (MalformedURLException mue){}
			}
		}
	}
}
