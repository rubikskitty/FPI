import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

/*<applet code="test"width=400 height=400></applet>*/

public class partA extends Applet implements ActionListener, MouseListener {

  Graphics backg;
  Image backbuffer;
  Timer timeCount;
  Image picture;
  Image piece;
  Image pieceBlack;
  Image pieceRed;
  int x = 0;
  Color selected = new Color(110, 89, 31);
  int board[][] = new int[9][9];
  int empty = 0;
  int black = 1;
  int red = 2;


  public void init() {

      backbuffer = createImage( 1000, 1000 );
      backg = backbuffer.getGraphics();
      setSize(1000, 1000);
      backg.setColor( Color.black );
      backg.fillRect( 0, 0, 1000, 1000);
      addMouseListener(this);
      timeCount = new Timer(50, this);
      timeCount.start();
      picture = getImage(getDocumentBase(), "checker.jpg");
      pieceBlack = getImage(getDocumentBase(), "black.png");
      pieceRed = getImage(getDocumentBase(), "red.png");


          for (int i = 1; i < 9; i++) {
              for (int j = 1; j <= 3; j++) {
                if (((j % 2 != 0) && (i % 2 == 0)) || ((j % 2 == 0) && (i % 2 != 0))) {
                  board[i][j] = 1;
                }
              }
            }
      //
      for (int i = 1; i < 9; i++) {
          for (int j = 5; j <= 8; j++) {
            if (((j % 2 == 0) && (i % 2 == 0)) || ((j % 2 != 0) && (i % 2 != 0))) {
              board[i][j] = 2;
            }
          }
        }



    for(int i =1; i < 9; i++) {
	     for (int j = 1; j< 9; j++) {
	    System.out.print(board[j][i]);
	   }
     System.out.println("");
    }

    }

  public void paint( Graphics g ) {
      update( g );
  }

  public void mouseClicked(MouseEvent e) {

	  }
	  //make something that checks if something is currently selected

  public void start(){
      timeCount.start();
  }

  public void stop(){
      timeCount.stop();
  }

  public void destroy(){
      //System.exit(0);
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource() == timeCount) {


      backg.setColor(Color.white);
      backg.fillRect( 0, 0, 1000, 1000);
      backg.drawImage(picture, 0, 0, 500,500 ,this);

  for (int i = 1; i < 9; i++) {
	   for (int j = 1; j <= 8; j++) {

	      if (board[i][j] == 1) {

	          backg.drawImage(pieceBlack, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);
	           //put the piece at the supposed location as black
	          }

	      else if(board[i][j-1] == 2) {

	         backg.drawImage(pieceRed, ((i-1)*63) + 2, ((j-1)*63) + 4, 55, 55, this);
	          //put the piece at the supposed location as red
	         }

	        }
      }
}
}

  public void update( Graphics g ) {
    g.drawImage( backbuffer, 0, 0, this );
    repaint();
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }
}
