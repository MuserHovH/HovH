import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChessGame extends Frame{
    ChessBoard b=new ChessBoard();
    public ChessGame() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        add("Center",b);
        Panel p=new Panel();
        Button pass=new Button("放弃一次");
        Button color=new Button("变棋盘背景");
        Button fail=new Button("认输");
        Button back=new Button("悔棋");
        p.setLayout(new GridLayout(8,1,10,10));//控制盘部分8行1列，间距为10
        p.add(new Label());//为了美观，第一行空出来
        p.add(pass);
        p.add(color);
        p.add(fail);
        p.add(back);
        add("East",p);
        addWindowListener(new WindowAdapter(){  //内嵌窗体关闭类
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        setSize(500,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        new ChessGame();
    }
}

class ChessBoard extends Canvas{
    int chess[][]=new int[19][19];
    int sx=20,sy=20;//棋盘起始坐标
    int w=20;//棋格宽度
    int cx=200,cy=200;//游标起始位置在棋盘中部
    int player=1;//1是黑子先下，0是白子
    public ChessBoard() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                Graphics g=getGraphics();
                //如果区域是背景颜色，将按画笔颜色替换并画出图形
                g.setXORMode(ChessBoard.this.getBackground());
                g.setColor(Color.RED);
                g.fillRect(cx-w/4, cy-w/4, w/2, w/2);//游标矩形左上角坐标（195，195）

				/*使游标矩形总是定位在十字实线上
				如：游标指到（35，35）位置时，绘制的游标矩形中心位置为（40，40）*/
                if(e.getX()%20>=10) {
                    cx=(e.getX()/10+1)*10;
                }else {
                    cx=e.getX()/10*10;
                }
                if(e.getY()%20>=10) {
                    cy=(e.getY()/10+1)*10;
                }else {
                    cy=e.getY()/10*10;
                }
				/*cx=sx+(e.getX()-sx+w/2)/w*w;
				cy=sy+(e.getY()-sy+w/2)/w*w;*/
                g.fillRect(cx-w/4,cy-w/4, w/2, w/2);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Graphics g=getGraphics();
                if(chess[(cx-sx)/w][(cy-sy)/w]==0) {
                    if(player==1) {
                        g.setColor(Color.BLACK);
                        chess[(cx-sx)/w][(cy-sy)/w]=1;
                    }else {
                        g.setColor(Color.WHITE);
                        chess[(cx-sx)/w][(cy-sy)/w]=2;
                    }
                    g.fillOval(cx-w/2+1,cy-w/2+1, w-2, w-2);
                    g.setXORMode(ChessBoard.this.getBackground());
                    g.setColor(Color.RED);
                    g.fillRect(cx-w/4,cy-w/4, w/2, w/2);
                    player=(player+1)%2;
                }
            }
        });
    }
    public void paint(Graphics g) {
        for(int k=0;k<19;k++) {
            g.drawLine(sx, sy+k*w, sx+w*18, sy+k*w);
        }
        for(int k=0;k<19;k++){
            g.drawLine(sx+k*w, sy, sx+k*w, sy+w*18);
        }
	/*	for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess[0].length;j++) {
				if(chess[i][j]==1) {
					g.setColor(Color.black);
					g.fillOval(sx+i*w-w/2+1, sx+j*w-w/2+1, w-2, w-2);
			}else if(chess[i][j]==2){
				g.setColor(Color.white);
				g.fillOval(sx+i*w-w/2+1, sx+j*w-w/2+1, w-2, w-2);
			}
		  }
	   }
	g.setXORMode(this.getBackground());
	g.setColor(Color.RED);
	g.fillRect(cx-w/4,cy-w/4, w/2, w/2);*/
    }
}
