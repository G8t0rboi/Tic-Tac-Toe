import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {
    private int turn = 1;
    private int xCount = 0;
    private int oCount = 0;
    private JButton[][] bo = new JButton[3][3];
    private int[][] scores =  new int[3][3];

    public static void main(String[] args) {
        Board boi = new Board();
        boi.setUp();
    }

    public void setUp() {
        GridLayout grid = new GridLayout(3,3);
        JFrame frame = new JFrame("Boi");
        frame.setLayout(grid);
        for ( int i = 0; i < bo.length; i++ ) {
            for ( int a = 0; a < bo[0].length; a++ ) {
                bo[i][a] = new JButton();
                frame.add(bo[i][a]);
            }
        }
        for ( JButton[] butt : bo ) {
            for ( JButton boot : butt ) {
                boot.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ( checkWin() )  {

                        }
                        if ( boot.getText().equals("") ) {
                            boot.setText( checkTurn() );
                        }
                    }
                });
            }
        }
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public String checkTurn() {

        if ( turn % 2 != 0 ) {
            turn++;
            xCount++;
            return "X";
        }
        else {
            turn++;
            oCount--;
            return "O";
        }
    }

    public boolean checkWin() {
        int toprow = scores[0][0] + scores[0][1] + scores[0][2];
        int midrow = scores[1][0] + scores[1][1] + scores[1][2];
        int botrow = scores[2][0] + scores[2][1] + scores[2][2];
        int fstcol = scores[0][0] + scores[1][0] + scores[2][0];
        int sndcol = scores[0][1] + scores[1][1] + scores[2][1];
        int lstcol = scores[0][2] + scores[1][2] + scores[2][2];
        int forwarddiag = scores[2][0] + scores[1][1] + scores[0][2];
        int backwarddiag = scores[0][0] + scores[1][1] + scores[2][2];
        if ( toprow == 3 || toprow == -3) {
            return true;
        }
        else if ( midrow == 3 || midrow == -3) {
            return true;
        }
        else if ( botrow == 3 || botrow == -3) {
            return true;
        }
        else if ( fstcol == 3 || fstcol == -3) {
            return true;
        }
        else if ( sndcol == 3 || sndcol == -3) {
            return true;
        }
        else if ( lstcol == 3 || lstcol == -3) {
            return true;
        }
        else if ( forwarddiag == 3 || forwarddiag == -3) {
            return true;
        }
        else if ( backwarddiag == 3 || backwarddiag == -3) {
            return true;
        }
        else {
            return false;
        }
    }
}
