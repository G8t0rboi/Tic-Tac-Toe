import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;


public class Board {
    private int turn = 1;
    private JButton[][] bo = new JButton[3][3];
    private int[][] scores = new int[3][3];
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true );
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ( "hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognized greeting");
        }

    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {
        Board boi = new Board();
        boi.setUp();
    }

    public void setUp() {
        GridLayout grid = new GridLayout(3, 3);
        JFrame frame = new JFrame("Boi");
        frame.setLayout(grid);
        for (int i = 0; i < bo.length; i++) {
            for (int a = 0; a < bo[0].length; a++) {
                bo[i][a] = new JButton();
                frame.add(bo[i][a]);
            }
        }
        for (int a = 0; a < bo.length; a++) {
            for (int b = 0; b < bo[a].length; b++) {
                JButton boot = bo[a][b];
                int row = a;
                int col = b;
                boot.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (boot.getText().equals("")) {
                            boot.setText(checkTurn(row, col));
                        }
                    }
                });
            }
        }
        frame.setSize(500, 500);
        frame.setVisible(true);
        for(;;) {
            if (checkWin()) {
                if ( turn % 2 != 0 ) {
                    System.out.println("Os won the game!");
                }
                else {
                    System.out.println("Xs won the game!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(1);
            }
        }
    }

    public String checkTurn(int row, int col) {

        if (turn % 2 != 0) {
            turn++;
            scores[row][col]++;
            return "X";
        } else {
            turn++;
            scores[row][col]--;
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
        if (toprow == 3 || toprow == -3) {
            return true;
        } else if (midrow == 3 || midrow == -3) {
            return true;
        } else if (botrow == 3 || botrow == -3) {
            return true;
        } else if (fstcol == 3 || fstcol == -3) {
            return true;
        } else if (sndcol == 3 || sndcol == -3) {
            return true;
        } else if (lstcol == 3 || lstcol == -3) {
            return true;
        } else if (forwarddiag == 3 || forwarddiag == -3) {
            return true;
        } else if (backwarddiag == 3 || backwarddiag == -3) {
            return true;
        } else {
            return false;
        }


    }

}
