package ����ã��2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
public class board { int bomb = 40; static int[][] boardarrayreplica= new int[16][16];
tile[][] tilearray = new tile[16][16];
int flags = bomb;	 int bombs = bomb;
 		int[][] boardarray = {
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
int boardwidth = boardarray[1].length; int boardheight = boardarray.length; 
public board() { while(bomb !=0) { 		// boardarray�� ��ź�� ��ġ�ϰ�,
int x = (int)(Math.random()*boardwidth); int y = (int)(Math.random()*boardheight);
if(boardarray[y][x]!=1) {boardarray[y][x] = 1; bomb--;} else continue;
//field2
for(int y1=0; y1<boardheight;y1++) {					// boardarrayreplica�� �� Ÿ�� �ֺ��� ��ź�� ��� �ִ����� �����Ѵ�.
for(int x1=0; x1<boardwidth; x1++) {if(boardarray[y1][x1]==1) {boardarrayreplica[y1][x1]=9;} else {
if(x1==0&&y1==0) {boardarrayreplica[y1][x1]=boardarray[y1+1][x1]+boardarray[y1+1][x1+1]+boardarray[y1][x1+1];}
else if(x1==0&&y1==boardheight-1) {boardarrayreplica[y1][x1]= boardarray[y1-1][x1]+boardarray[y1-1][x1+1]+boardarray[y1][x1+1];}									
else if(x1==boardwidth-1&&y1==0) {boardarrayreplica[y1][x1]= boardarray[y1][x1-1]+boardarray[y1+1][x1-1]+boardarray[y1+1][x1];}
else if(x1==boardwidth-1&&y1==boardheight-1) {boardarrayreplica[y1][x1]= boardarray[y1][x1-1]+boardarray[y1-1][x1-1]+boardarray[y1-1][x1];}
else if(x1==0) {boardarrayreplica[y1][x1]=boardarray[y1+1][x1]+boardarray[y1+1][x1+1]+boardarray[y1][x1+1]+boardarray[y1-1][x1]+boardarray[y1-1][x1+1];}
else if(x1==boardwidth-1) {boardarrayreplica[y1][x1] = boardarray[y1-1][x1-1]+boardarray[y1-1][x1]+boardarray[y1][x1-1]+boardarray[y1+1][x1-1]+boardarray[y1+1][x1];}
else if(y1==0) {boardarrayreplica[y1][x1] = +boardarray[y1][x1-1]+boardarray[y1][x1+1]+boardarray[y1+1][x1-1]+boardarray[y1+1][x1]+boardarray[y1+1][x1+1];}
else if(y1==boardheight-1) {boardarrayreplica[y1][x1] = boardarray[y1-1][x1-1]+boardarray[y1-1][x1]+boardarray[y1-1][x1+1]+boardarray[y1][x1-1]+boardarray[y1][x1+1];}
else {boardarrayreplica[y1][x1] = boardarray[y1-1][x1-1]+boardarray[y1-1][x1]+boardarray[y1-1][x1+1]+boardarray[y1][x1-1]+boardarray[y1][x1+1]+boardarray[y1+1][x1-1]+boardarray[y1+1][x1]+boardarray[y1+1][x1+1];}
}}}
for(int y1=0; y1<boardheight;y1++) {
for(int x1=0; x1<boardwidth; x1++) {
tilearray[y1][x1]= new tile(this); tilearray[y1][x1].x=x1; tilearray[y1][x1].y=y1; tilearray[y1][x1].meaning = boardarrayreplica[y1][x1]; if(boardarrayreplica[y1][x1]==9) {tilearray[y1][x1].isitboom = true;} else {tilearray[y1][x1].isitboom = false;}
}}}}




	public static void main(String[] args) {
	Main mainclass = new Main();
	
	}}


class tile extends JLabel{
int x;
int y; // �迭������ ��ġ
boolean isitboom; // �����ΰ� �ƴѰ�
int meaning; // �ֺ� ��ź�� ����
boolean isopened = false;
boolean isflagged = false;
board board;
tile(board board){
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setSize(30,30); this.board = board;
	addMouseListener(new tileistener());
}
public void setFontBackground(tile tile) {
	switch((tile.x+tile.y)%2) {case 0: tile.setBackground(new Color(228,194,159)); break; case 1: setBackground(new Color(215,184,153)); break; }
	switch(tile.meaning) {
	case 1: tile.setForeground(Color.blue); break;
 	case 2: tile.setForeground(Color.green); break;
	case 3: tile.setForeground(Color.red); break;
	case 4: tile.setForeground(Color.ORANGE); break;
	case 5:tile.setForeground(Color.red); break;
	case 6:tile.setForeground(Color.red); break;
	case 7:tile.setForeground(Color.red); break;
	case 8:tile.setForeground(Color.red); break;
	}
}
 //���� opensafeblock �޼ҵ常 ��� �պ��� �� �� �ϴ�. �̷��� �׻� ������ ���� ������.
public void boomtileopen() {
	if(isflagged == false) {
	for(int y=0; y<board.boardheight; y++) {for(int x=0; x<board.boardwidth; x++) {
	if(board.tilearray[y][x].isitboom!=true)
	{board.tilearray[y][x].setText(Integer.toString(board.tilearray[y][x].meaning)); board.tilearray[y][x].isitboom=true;} 
	else board.tilearray[y][x].setText("*"); board.tilearray[y][x].isopened=true;}}
	JOptionPane.showMessageDialog(null,"���� ����"+board.bombs+"�� �ٽ� �����ϼ���" , "����", JOptionPane.ERROR_MESSAGE);}}
public void safetileopen(int y, int x) {
	if(isflagged == false) {
	board.tilearray[y][x].setText(Integer.toString(meaning));board.tilearray[y][x].isopened=true;}}
public void supersafetileopen(int y , int x) {
if(isflagged == false) {
if(board.tilearray[y][x].isopened == false) { board.tilearray[y][x].isopened = true; // �� �� �� �� �������.
board.tilearray[y][x].setText(Integer.toString(board.tilearray[y][x].meaning));
if(x<board.boardwidth-1&&board.tilearray[y][x+1].isopened ==false) {board.tilearray[y][x+1].setText(Integer.toString(board.tilearray[y][x+1].meaning));}
if(x>0&&board.tilearray[y][x-1].isopened ==false) {board.tilearray[y][x-1].setText(Integer.toString(board.tilearray[y][x-1].meaning));}
if(y<board.boardheight-1&&board.tilearray[y+1][x].isopened ==false){board.tilearray[y+1][x].setText(Integer.toString(board.tilearray[y+1][x].meaning));}
if(y>0&&board.tilearray[y-1][x].isopened ==false){board.tilearray[y-1][x].setText(Integer.toString(board.tilearray[y-1][x].meaning));}
if(y>0&&x>0&&board.tilearray[y-1][x-1].isopened ==false) {board.tilearray[y-1][x-1].setText(Integer.toString(board.tilearray[y-1][x-1].meaning));}
if(y<board.boardheight-1&&x<board.boardwidth-1&&board.tilearray[y+1][x+1].isopened ==false){board.tilearray[y+1][x+1].setText(Integer.toString(board.tilearray[y+1][x+1].meaning));}
if(y<board.boardheight-1&&x>0&&board.tilearray[y+1][x-1].isopened ==false){board.tilearray[y+1][x-1].setText(Integer.toString(board.tilearray[y+1][x-1].meaning));}
if(y>0&&x<board.boardwidth-1&&board.tilearray[y-1][x+1].isopened ==false) {board.tilearray[y-1][x+1].setText(Integer.toString(board.tilearray[y-1][x+1].meaning));}
if(x<board.boardwidth-1&&board.tilearray[y][x+1].meaning == 0&&board.tilearray[y][x+1].isopened ==false) {supersafetileopen(y,x+1);}
if(x>0&&board.tilearray[y][x-1].meaning == 0&&board.tilearray[y][x-1].isopened ==false) {supersafetileopen(y,x-1);}
if(y<board.boardheight-1&&board.tilearray[y+1][x].meaning == 0&&board.tilearray[y+1][x].isopened ==false) {supersafetileopen(y+1,x);}
if(y>0&&board.tilearray[y-1][x].meaning == 0&&board.tilearray[y-1][x].isopened ==false) {supersafetileopen(y-1,x);}
}}}
public void flag() {
if(this.getText()=="") {
if(isflagged ==false) {
setText("��");  isflagged=true; board.flags--; if(isitboom==true) {board.bombs--;}
}}
else if(isflagged == true) {		//�̹� ����� ���� ���¿��� ��Ŭ���� �� ��  
setText(""); isflagged=false;board.flags++; if(isitboom==true) {board.bombs++;}}

if(board.bombs ==0) {String name =JOptionPane.showInputDialog("�̸��� �Է��ϼ���: "); if(name ==null) {}}
Panelclass.flagsleft.setText("���� ��� ����:"+Integer.toString(board.flags));
}



class tileistener extends MouseAdapter{ //���� Ŭ�������� ������ ����.
	public void mouseClicked(MouseEvent e)  { //(���⿡ ���������� �ƴ����� �ǰ����ϰ�, �������ڽ� ���̶�� ���빰 ���� ����)
//Ŭ���� Ÿ���� isitboom�� true�� ���� �ϰ������ ���̾�.. x,y���� �� Ÿ���� x,y���� ������ ���� isitboom�� Ÿ���� isitboom�� ������ ���δ�. �� isitboom�� ���󰡺���.		
	if(e.getButton()==MouseEvent.BUTTON1) {
	if(meaning ==9) { boomtileopen();
	}else {if(meaning==0) {supersafetileopen(y,x);} else{safetileopen(y,x);}}}
	if(e.getButton()==MouseEvent.BUTTON3) {flag();}
	
	}
	public void mouseEntered(MouseEvent e) {switch((x+y)%2) {
		case 0: setBackground(new Color(240,240,240)); break;	
		case 1: setBackground(new Color(160,160,160)); break;
	}}
	public void mouseExited(MouseEvent e) {switch((x+y)%2) {
	case 0: setBackground(Color.white); break;	
	case 1: setBackground(Color.LIGHT_GRAY); break;
} }
	
}

}
class Panel extends JPanel{
	board board;
	tile[][] tilearray;

	Panel(board board){ this.board = board;   this.tilearray = board.tilearray;
	this.setSize(480,480);
	// �ǳڿ� �� Ÿ�� ���� ������.
	this.setLayout(null);
	for(int y=0; y<board.boardheight;y++) {
	for(int x=0; x<board.boardwidth; x++) {
	this.add(tilearray[y][x]); tilearray[y][x].setLocation(30*x,30*y);
	}}}}
class Panelclass extends JPanel{
	URL imageURL = getClass().getClassLoader().getResource("sadcat.gif");
	ImageIcon sadcat = new ImageIcon(imageURL);
	int color = 0;
	board boardinstance = new board();
	Panel panelinstance = new Panel(boardinstance);
	static JTextArea ranking = new JTextArea();
	static JLabel flagsleft = new JLabel("���� ��� ��:"+40);
	public void attach() {
	Panelclass.flagsleft.setText("���� ��� ��:"+Integer.toString(40));
	timer.time=0; 
	this.remove(panelinstance);
	boardinstance = new board();
	panelinstance = new Panel(boardinstance);
	this.add(panelinstance);
	panelinstance.setLocation(0,0);
	color = 0;
	for(int y=0; y<boardinstance.boardheight;y++) {
		for(int x=0; x<boardinstance.boardwidth; x++) { boardinstance.tilearray[y][x].setOpaque(true);
		if(color%2==0) {boardinstance.tilearray[y][x].setBackground(Color.white);}
		else {boardinstance.tilearray[y][x].setBackground(Color.lightGray);}
		color++;} color++;
		}
	
	}
	Panelclass(){
	this.setSize(1000,600); this.add(panelinstance); this.setLayout(null); panelinstance.setLocation(0,0);
	this.setVisible(true); 
	for(int y=0; y<boardinstance.boardheight;y++) {
	for(int x=0; x<boardinstance.boardwidth; x++) { boardinstance.tilearray[y][x].setOpaque(true);
	if(color%2==0) {boardinstance.tilearray[y][x].setBackground(Color.white);}
	else {boardinstance.tilearray[y][x].setBackground(Color.lightGray);}
	color++;} color++;
	}
/*	add(ranking); ranking.setLocation(0,480); ranking.setSize(600,100);*/
	timer timerinstance = new timer(boardinstance); new Thread(timerinstance).start();
	add(timerinstance); timerinstance.setLocation(480,0); 
	JButton start = new JButton("restart"); start.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {attach();}});
	start.setSize(100,100); start.setLocation(140,480); add(start);
	flagsleft.setLocation(480,30); this.add(flagsleft); flagsleft.setSize(100,100);
	JLabel sadcatlabel1 = new JLabel(sadcat); sadcatlabel1.setLocation(560,200); sadcatlabel1.setSize(300,300); this.add(sadcatlabel1);
	}
}
class timer extends JLabel implements Runnable {
	board board;
	static int time=0; 
	timer(board board){
	this.board = board;
	setSize(100,100);
	}
	public void run() {  
	while(board.bombs != 0) {
		
		time++; try {
		Thread.sleep(1000); 
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		setText(Integer.toString(time));
		}
	}
}
class Main extends JFrame{
	URL imageURL = getClass().getClassLoader().getResource("������� �����.gif");
	JButton letsstart = new JButton("���� ã�� ����");
	Container contentpane = getContentPane();
	JButton start = new JButton("restart");
	ImageIcon sadcat2 = new ImageIcon(imageURL);
	JLabel sadcatlabel = new JLabel(sadcat2);
	Main(){
		this.setTitle("����ã��");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentpane.setLayout(null); contentpane.add(letsstart); 
		this.setVisible(true);
		this.setSize(1000,600); 
		letsstart.setLocation(400, 200); letsstart.setSize(200, 50);
		contentpane.add(sadcatlabel); sadcatlabel.setSize(300,300); sadcatlabel.setLocation(300,300);
		letsstart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Panelclass panel = new Panelclass();
		contentpane.add(panel);
		panel.attach();
		letsstart.setSize(0,0);
		contentpane.add(start); start.setLocation(140,480); start.setSize(100,100);
		sadcatlabel.setSize(0,0);
		}
		});
	}
}

  



// ���� �� �� : �迭�� �������� ����, ���� ã��