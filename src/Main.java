import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.File;
import java.util.Stack;
public class Main //게임의 메인 부분
{ 
	static public Start start;
	static public Score score;
	public static void main(String[] args)
	{
		start = new Start(); //처음 시작하는 프레임의 클래스인 Start 생성
		start.go(); //Start의 go메소드 호출
	}
}