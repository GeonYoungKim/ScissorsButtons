import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.File;
import java.util.Stack;
class Mouse implements MouseListener {	//마우스 이벤트를 다루는 클래스	
	static public View view;
	static public ImagePanel imagePanel;
	int q,w,a,b;
	public void mouseEntered (MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(e.getX()>=100*(i) && e.getX()<=100*(i)+100)
					if(e.getY()>=(j)*(100) && e.getY()<=(j)*(100)+100)
					{
						q=i; //마우스 눌렀을시 x좌표
						w=j; //마우스 눌렀을시 y좌표
					}
	}	
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){
		for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(e.getX()>=100*(i) && e.getX()<=100*(i)+100)
					if(e.getY()>=(j)*(100) && e.getY()<=(j)*(100)+100)
					{	
						a=i;//마우스를 뗐을시 x좌표
						b=j;//마우스를 뗐을시 y좌표
						view.imagePanel.Change(q,w,a,b);//imagepanel의 Change메소드 호출
					}	
	}
}