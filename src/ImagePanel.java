import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.util.Stack;
import java.io.File;
import java.util.Stack;
	public class ImagePanel extends JPanel{
		Mouse mouse;
		Timer timer;
		public Stack st=new Stack();//되돌리기에서 push,pop 사용을 위해 Stack st생성
		static public View view;
		static public ImagePanel imagePanel;
		Score1 score1;
		Score2 score2;
		Score score;
		String f="image/다운로드.png";//같은것을 없애면 채워지는 문자열 선언
		String judimage[][]={{f,f,f,f,f}, //게임을 클리어 했는지 판단피교하기위한 이차원 배열 선언
				{f,f,f,f,f},
				{f,f,f,f,f},
				{f,f,f,f,f},
				{f,f,f,f,f}};
		String bestring[][]=new String[5][5];//되돌리기 하기위해 같은거 없애기 전 이차원배열을 저장하기 위해 선언
		public static String[][] sImage = new String[5][5];
		String sImage1, sImage2;//마우스 눌렀을때,뗐을때 문자열 확인위해 선언
		public static Image image[][] = new Image[5][5];//paint부분에서 실제 그려지는 이미지 선언
		Toolkit toolkit = getToolkit();//Image형에 String형을 넣기 위해 선언
		long endTime; //게임 종료했을때의 시간 
		static int a; //게임 사용시간
		
		public ImagePanel(String[][] sImage) {//ImagePanel의 생성자
			this.sImage = sImage; 
			for(int i=0;i<5;i++)
				for(int j=0; j<5; j++)
					image[i][j] = toolkit.getDefaultToolkit().getImage(sImage[i][j]);			
		} //String형 이차원배열을 Image형 이차원배열에 toolkit을 사용하여 넣음
		public void imgChange(int x, int y) { //ImagePanel의 imgChange메소드	
			image[x][y]=toolkit.getDefaultToolkit().getImage(f);//입력받은 좌표에 image위치에 문자열 f저장
			sImage[x][y]=f;//입력받은 좌표에 sImage위치에 문자열 f저장
						
			int sc=0;//게임을 완료한지 확인하기 위한 정수형 변수 선언
			try{//"호로록"효과음을 시작함
				File file = new File("image/호로록.wav");
				AudioClip audioClip = Applet.newAudioClip(file.toURL());
				audioClip.play();
				}
				catch (MalformedURLException mue){}
			for(int i=0;i<5;i++)
				for(int j=0; j<5; j++)
					if(sImage[i][j]==judimage[i][j])
						sc++;//판단하는 이차원 배열과 같은것이 하나 있을때마다 sc 1씩 증가 
			if(sc==25)//sc가 25라면
			{
				if(view.qwe==1)//view.qwe가 1이라면
				{
					endTime=System.currentTimeMillis();//게임 끝난 시간 
					a=(int)endTime-(int)view.startTime;//게임 끝난 시간-시작한 시간=게임 이용 시간
					try{//"띵똥"음악을 시작
						File file1 = new File("image/노을을바라보는개구리.mid");
						AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
						audioClip1.stop();
						File file = new File("image/띵똥.wav");
						AudioClip audioClip = Applet.newAudioClip(file.toURL());
						audioClip.play();
						}
						catch (MalformedURLException mue){}
					score=new Score();//Score 객체 생성
					score.score(); // Score의 score메소드 호출
					view.frame.dispose();
				}
				else if(view.qwe==2)//view.qwe가 2이라면
				{
					endTime=System.currentTimeMillis();//게임 끝난 시간 
					a=(int)endTime-(int)view.startTime;//게임 끝난 시간-시작한 시간=게임 이용 시간
					try{//"띵똥"음악을 시작
						File file1 = new File("image/노을을바라보는개구리.mid");
						AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
						audioClip1.stop();
						File file = new File("image/띵똥.wav");
						AudioClip audioClip = Applet.newAudioClip(file.toURL());
						audioClip.play();
						}
						catch (MalformedURLException mue){}
					Score1 score1=new Score1();//Score1 객체 생성
					score1.score();// Score1의 score메소드 호출
					view.frame.dispose();
				}
				else if(view.qwe==3)//view.qwe가 3이라면
				{
					endTime=System.currentTimeMillis();//게임 끝난 시간 
					a=(int)endTime-(int)view.startTime;//게임 끝난 시간-시작한 시간=게임 이용 시간
					try{//"띵똥"음악을 시작
						File file1 = new File("image/노을을바라보는개구리.mid");
						AudioClip audioClip1 = Applet.newAudioClip(file1.toURL());
						audioClip1.stop();
						File file = new File("image/띵똥.wav");
						AudioClip audioClip = Applet.newAudioClip(file.toURL());
						audioClip.play();
						}
						catch (MalformedURLException mue){}
					Score2 score2=new Score2();//Score2 객체 생성
					score2.score();// Score2의 score메소드 호출
					view.frame.dispose();
				}				
			}
		}
		public void beimgChange(int a, int b, String c)//되돌리기 버튼 클릭시 입력받은 좌표에 원상복귀하는 메소드
		{
			sImage[a][b]=bestring[a][b];//전 이차원 문자열을 지금 이차원 배열에 다시 넣음
			image[a][b]=toolkit.getDefaultToolkit().getImage(c);//push했던 이미지를 넣음
		}
		public void paint(Graphics g)//사용자에게 이미지를 보여 주는 메소드
		{
			for(int i=0;i<5;i++)
				for(int j=0; j<5; j++)
					g.drawImage(image[i][j],100*(i),(j)*(100),100,100,this);
		}//이미지의 크기를 100으로 하여 차례대로 이미지를 겹치지 않도록 그리게 함
		public void beChange(int a, int b, int x, int y)//되돌리기 버튼을 눌렀을시 전이미지와 지금의 이미지를 확인하는 메소드
		{
			sImage1 = sImage[a][b];
			sImage2 = sImage[x][y];
			if(sImage1==sImage2)//버튼 눌렀을 때와 뗐을때의 이미지가 같을때
			{
				if(a==x){//수직인 상황
					if(b<y)//위에서 아래로
						for(int j=y; j>=b; j--)//그린 반복문과 반대로
							beimgChange(a,j,(String)st.pop());//beimgChange호출
					else if(b>y)//아래에서 위로
						for(int j=b; j>=y; j--)//그린 반복문과 반대로
							beimgChange(a,j,(String)st.pop());//beimgChange호출
				repaint();//변경사항 다시 그려줌
				}
				else if(b==y){//수평 상황
					if(a<x)//왼쪽에서 오른쪽
						for(int j=x; j>=a; j--)//그린 반복문과 반대로
							beimgChange(j,b,(String)st.pop());//beimgChange호출
					else if(a>x)//오른쪽에서 왼쪽
						for(int j=a; j>=x; j--)//그린 반복문과 반대로
							beimgChange(j,b,(String)st.pop());//beimgChange호출
					repaint();//변경사항 다시 그려줌
				}
				else {//대각선 상황
					for(int i=1;i<5;i++)
						if((a+i)==x&&(b+i)==y)//왼쪽 위에서 오른쪽 아래로
						{
							int q,w;
							for(q=x,w=y;q>=a&&w>=b;q--,w--)//그린 반복문과 반대로
								beimgChange(q,w,(String)st.pop());//beimgChange호출
						}	
						else if((x+i)==a&&(y+i)==b)//오른쪽 아래에서 왼쪽 위로
						{
							int q,w;
							for(q=a,w=b;q>=x&&w>=y;q--,w--)//그린 반복문과 반대로
								beimgChange(q,w,(String)st.pop());//beimgChange호출
						}		
						else if((a-i)==x&&(b+i)==y)//오른쪽 위에서 왼쪽 아래로
						{
							int q,w;
							for(q=a,w=b;q>=x&&w<=y;q--,w++)//그린 반복문과 반대로
								beimgChange(q,w,(String)st.pop());//beimgChange호출
						}		
						else if((x-i)==a&&(y+i)==b)//왼쪽 아래에서 오른쪽 위로
						{
							int q,w;
							for(q=x,w=y;q>=a&&w<=b;q--,w++)//그린 반복문과 반대로
								beimgChange(q,w,(String)st.pop());//beimgChange호출
						}	
						repaint();//변경사항 다시 그려줌
				}
		}
	}
		public void Change(int a, int b, int x, int y)//그릴 때 그릴수 있는 상태인지 확인하는 메소드
		{	
			score.num++;//횟수 추가(틀린거든 맞은거든 다)
			score1.num++;//횟수 추가(틀린거든 맞은거든 다)
			score2.num++;//횟수 추가(틀린거든 맞은거든 다)
			sImage1 = sImage[a][b];
			sImage2 = sImage[x][y];
			int stop=0;//그릴수 있는지 표시를 남기는 변수 선언
			if(sImage1==sImage2)// 마우스 눌렀을때와 뗐을때가 같은때
			{
				if(a==x)//수직상황
				{
					if(b<y)//위에서 아래로
						for(int j=b+1; j<y; j++)//마우스 눌렀을때와 뗐을때 사이
						{
							if(sImage[a][j]!=sImage1&&sImage[a][j]!=f){//문제가 있으면 stop을 1로 변환
								stop = 1;
						}}
					if(b>y)//아래에서 위로
						for(int j=y+1; j<b; j++)//마우스 눌렀을때와 뗐을때 사이
						{
							if(sImage[a][j]!=sImage1&&sImage[a][j]!=f)//문제가 있으면 stop을 2로 변환
								stop = 2;
						}
					if(stop!=1 && stop!=2)//stop이 1과2가 아니면 문제가 없으므로
					{
						changea(a,b,x,y);//changea메소드 호출
						score.asd=score.asd+100;//score.asd를 100증가시킴
						score1.asd=score1.asd+100;//score1.asd를 100증가시킴
						score2.asd=score2.asd+100;//score2.asd를 100증가시킴
					}
				}
				else if(b==y)//수평 상황
				{
					if(a<x)//왼쪽에서 오른쪽으로
						for(int j=a+1; j<x; j++)//마우스 눌렀을때와 뗐을때 사이
						{
							if(sImage[j][b]!=sImage1&&sImage[j][b]!=f)//문제가 있으면 stop을 1로 변환
								stop = 1;
						}
					if(a>x)//오른쪽에서 왼쪽으로
						for(int j=x+1; j<a; j++)//마우스 눌렀을때와 뗐을때 사이
						{
							if(sImage[j][b]!=sImage1&&sImage[j][b]!=f)//문제가 있으면 stop을 2로 변환
								stop = 2;
						}
					if(stop!=1 && stop!=2)//stop이 1과2가 아니면 문제가 없으므로
					{
						changeb(a,b,x,y);//changeb메소드 호출
						score.asd=score.asd+100;//score.asd를 100증가시킴
						score1.asd=score1.asd+100;//score1.asd를 100증가시킴
						score2.asd=score2.asd+100;//score2.asd를 100증가시킴
					}
				}
				else //대각선 상황
				{
					for(int i=1;i<5;i++)
					{
						if((a+i)==x&&(b+i)==y)//왼쪽 위에서 오른쪽 아래로
						{
							int q,w;
							for(q=a,w=b;q<=x&&w<=y;q++,w++)//마우스 눌렀을때와 뗐을때 사이
								if(sImage[q][w]!=sImage1&&sImage[q][w]!=f)	//문제가 있으면 stop을 1로 변환
									stop=1;				
						}	
						else if((x+i)==a&&(y+i)==b)//오른쪽 아래에서 왼쪽 위로
						{
							int q,w;
							for(q=x,w=y;q<=a&&w<=b;q++,w++)//마우스 눌렀을때와 뗐을때 사이
								if(sImage[q][w]!=sImage1&&sImage[q][w]!=f)	//문제가 있으면 stop을 2로 변환	
									stop=2;
						}		
						else if((a-i)==x&&(b+i)==y)//오른쪽 위에서 왼쪽 아래로
						{
							int q,w;
							for(q=a,w=b;q>=x&&w<=y;q--,w++)//마우스 눌렀을때와 뗐을때 사이
								if(sImage[q][w]!=sImage1&&sImage[q][w]!=f)	//문제가 있으면 stop을 3로 변환	
									stop=3;
						}		
						else if((x-i)==a&&(y+i)==b)//왼쪽 아래에서 오른쪽 위로
						{
							int q,w;
							for(q=x,w=y;q>=a&&w<=b;q--,w++)//마우스 눌렀을때와 뗐을때 사이
								if(sImage[q][w]!=sImage1&&sImage[q][w]!=f)	//문제가 있으면 stop을 4로 변환	
									stop=4;
						}		
					}
					if(stop!=1&&stop!=2&&stop!=3&&stop!=4)//stop이 1,2,3,4가 아니면 문제가 없으므로
					{
						changec(a,b,x,y);//changec메소드 호출
						score.asd=score.asd+100;//score.asd를 100증가시킴
						score1.asd=score1.asd+100;//score1.asd를 100증가시킴
						score2.asd=score2.asd+100;//score2.asd를 100증가시킴
					}
				}
				repaint();//변경 사항 다시 그려줌
			}	
		}
		public void changea(int a, int b, int x, int y)//수직 그리는 메소드
		{
			view.beb=b;//되돌리기버튼을 위해 좌표 저장
			view.bea=a;//되돌리기버튼을 위해 좌표 저장
			view.bex=x;//되돌리기버튼을 위해 좌표 저장
			view.bey=y;//되돌리기버튼을 위해 좌표 저장
			if(b>y){//아래에서 위로
				for(int i=y; i<=b; i++)//마우스 눌렀을때와 뗐을때와 그 사이
				{
					bestring[a][i]=sImage[a][i];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
					st.push(sImage[a][i]);//그려졌을때의 이미지를 push함
					imgChange(a, i);//이미지를 f이미지로 바꿈
				}
			}
			else if(b<y){//위에서 아래로 
				for(int j=b; j<=y; j++)//마우스 눌렀을때와 뗐을때와 그 사이
				{
					bestring[a][j]=sImage[a][j];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
					st.push(sImage[a][j]);//그려졌을때의 이미지를 push함
					imgChange(a, j);//이미지를 f이미지로 바꿈
				}
			}
		}
		public void changeb(int a, int b, int x, int y)//수평 그리는 메소드
		{
			view.beb=b;//되돌리기버튼을 위해 좌표 저장
			view.bea=a;//되돌리기버튼을 위해 좌표 저장
			view.bex=x;//되돌리기버튼을 위해 좌표 저장
			view.bey=y;//되돌리기버튼을 위해 좌표 저장
			if(a>x){//오른쪽에서 왼쪽
				for(int i=x; i<=a; i++)//마우스 눌렀을때와 뗐을때와 그 사이
				{
					bestring[i][b]=sImage[i][b];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
					st.push(sImage[i][b]);	//그려졌을때의 이미지를 push함	
					imgChange(i, b);//이미지를 f이미지로 바꿈
				}
			}
			else if(a<x){//왼쪽에서 오른쪽
				for(int j=a; j<=x; j++)//마우스 눌렀을때와 뗐을때와 그 사이
				{
					bestring[j][b]=sImage[j][b];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
					st.push(sImage[j][b]);//그려졌을때의 이미지를 push함	
					imgChange(j, b);//이미지를 f이미지로 바꿈
				}
			}
		}
		public void changec(int a, int b, int x, int y)//대각선 그리는 메소드
		{
			view.beb=b;//되돌리기버튼을 위해 좌표 저장
			view.bea=a;//되돌리기버튼을 위해 좌표 저장
			view.bex=x;//되돌리기버튼을 위해 좌표 저장
			view.bey=y;//되돌리기버튼을 위해 좌표 저장
			if(a>x)
			{	
				int w=y, q=y;
				if(b>y)//오른쪽아래에서 왼쪽 위로
					for(int j=x; j<=a; j++)
					{
						bestring[j][q]=sImage[j][q];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
						st.push(sImage[j][q]);//그려졌을때의 이미지를 push함	
						imgChange(j, q);//이미지를 f이미지로 바꿈
						q++;//대각선이여서 같이 내려가기 위해
					}
				if(b<y)//오른쪽 위에서 왼쪽 아래로
					for(int j=x; j<=a; j++)
					{
						bestring[j][w]=sImage[j][w];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
						st.push(sImage[j][w]);//그려졌을때의 이미지를 push함	
						imgChange(j, w);//이미지를 f이미지로 바꿈
						w--;//대각선이여서 같이 올라가기 위해
					}
			}
			else if(a<x)
			{
				int q=b, w=b;
				if(b>y)//왼쪽 아래에서 오른쪽 위로
					for(int j=a; j<=x; j++)
					{
						bestring[j][q]=sImage[j][q];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
						st.push(sImage[j][q]);//그려졌을때의 이미지를 push함	
						imgChange(j, q);//이미지를 f이미지로 바꿈
						q--;//대각선이여서 같이 올라가기 위해
					}
				if(b<y)//왼쪽 위에서 오른쪽 아래로
					for(int j=a; j<=x; j++)
					{
						bestring[j][w]=sImage[j][w];//되돌리기 버튼을 위해 지금 이미지 배열 옮겨놓음
						st.push(sImage[j][w]);//그려졌을때의 이미지를 push함	
						imgChange(j, w);//이미지를 f이미지로 바꿈
						w++;//대각선이여서 같이 내려가기 위해
					}
			}
		}
		
	}
