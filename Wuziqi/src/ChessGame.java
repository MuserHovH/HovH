import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChessGame extends Frame implements ActionListener{
    ChessBoard b=new ChessBoard();
    public ChessGame() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());
        add("Center",b);
        Panel p=new Panel();
        Button pass=new Button("重开一局");
        Button color=new Button("变棋盘背景");
        Button fail=new Button("认输");
        p.setLayout(new GridLayout(8,1,10,10));//控制盘部分8行1列，间距为10
        //rows 行  cols 列
        p.add(new Label());//为了美观，第一行空出来
        p.add(pass);
        p.add(color);
        p.add(fail);
        add("East",p);
        addWindowListener(new WindowAdapter(){  //内嵌窗体关闭类
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        pass.addActionListener(this);
        color.addActionListener(this);
        fail.addActionListener(this);
        setSize(500,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        // TODO 自动生成的方法存根
        if(e.getActionCommand().equals("重开一局")) {
            dispose();
            new ChessGame();
        }
        if(e.getActionCommand().equals("变棋盘背景")) {
            b.setBackground(Color.pink);
        }
        if(e.getActionCommand().equals("认输")) {
            String s="黑";
            if(b.player==1){s="白";}
            JOptionPane.showMessageDialog(b, "恭喜"+s+"棋获胜！");
            dispose();
            new ChessGame();
        }
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
                int r=(cx-sx)/w,c=(cy-sy)/w;//r代表二维数组的行，c代表列
                if(chess[r][c]==0) {
                    if(player==1) {
                        g.setColor(Color.BLACK);
                        chess[r][c]=1;
                    }else {
                        g.setColor(Color.WHITE);
                        chess[r][c]=2;
                    }
                    g.fillOval(cx-w/2+1,cy-w/2+1, w-2, w-2);
                    g.setXORMode(ChessBoard.this.getBackground());
                    g.setColor(Color.RED);
                    g.fillRect(cx-w/4,cy-w/4, w/2, w/2);
                    player=(player+1)%2;
                    String s="黑";
                    if(player==1) {s="白";}
                    if(success(r, c)){
                        JOptionPane.showMessageDialog(getParent(), "恭喜"+s+"棋获胜！");
                        repaint();
                    }
                }
            }
        });
    }

    public boolean success(int r,int c) {//判断是否五子
        boolean re=false;
        int num=1;
        try {
            for(int k=0;k<chess.length-1;k++) {//水平五子
                if(chess[k][c]!=0) {
                    if (chess[k][c] == chess[k + 1][c]) {
                        num++;
                        if (num >= 5) {
                            re = true;
                        }
                    }else {
                        num=1;
                    }
                }}
            num=1;
            for(int k=0;k<chess[r].length-1;k++) {//垂直五子
                if(chess[r][k]!=0) {
                    if (chess[r][k] == chess[r][k+1]) {
                        num++;
                        if (num >= 5) {
                            re = true;
                        }
                    }else {
                        num=1;
                    }
                }}
            num=1;
            for (int k = -chess.length; k < chess.length; k++) {// 左斜五子
                for (int j = 1; j < chess.length; j++) {
                    if (((k + j) >= 0) && ((k + j) < chess.length)) {
                        if (chess[j][j + k] != 0) {
                            if (chess[j][k + j] == chess[j + 1][k + j + 1]) {
                                num++;
                                if (num >= 5) {
                                    re = true;
                                }
                            }else {
                                num=1;
                            }
                        }}}}
            num=1;
            for (int k = 0; k < chess.length*2-1; k++) {// 右斜五子
                for (int j = 1; j < chess.length; j++) {
                    if (((k - j) >= 0) && ((k - j) < chess.length)) {
                        if(chess[j][k-j]!=0){
                            if(chess[j][k-j]==chess[j-1][k-j+1]){
                                num++;
                                if (num >= 5) {
                                    re = true;
                                }
                            }else {
                                num=1;
                            }
                        }}}}}catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            return re;
        }
        return re;
    }

    public void paint(Graphics g) {
        for(int k=0;k<19;k++) {
            g.drawLine(sx, sy+k*w, sx+w*18, sy+k*w);
        }
        for(int k=0;k<19;k++){
            g.drawLine(sx+k*w, sy, sx+k*w, sy+w*18);
        }
/*	g.setXORMode(this.getBackground());
	g.setColor(Color.RED);
	g.fillRect(cx-w/4,cy-w/4, w/2, w/2);*/
    }
}
