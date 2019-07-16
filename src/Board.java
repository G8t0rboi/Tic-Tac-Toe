import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {
    private int turn = 1;
    private ArrayList<String> bo = new ArrayList<>();

    public static void main(String[] args) {
        Board boi = new Board();
        boi.setUp();
    }

    public void setUp() {
        GridLayout grid = new GridLayout(3,3);
        JFrame frame = new JFrame("Boi");
        frame.setLayout(grid);
        JButton tl = new JButton();
        tl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tl.getText() == "") {
                    tl.setText(checkTurn());
                }
            }
        });
        JButton tm = new JButton();
        tm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tm.getText() == "") {
                    tm.setText(checkTurn());
                }
            }
        });
        JButton tr = new JButton();
        tr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tr.getText() == "") {
                    tr.setText(checkTurn());
                }
            }
        });
        JButton ml = new JButton();
        ml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (ml.getText() == "") {
                    ml.setText(checkTurn());
                }
            }
        });
        JButton mm = new JButton();
        mm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mm.getText() == "") {
                    mm.setText(checkTurn());
                }
            }
        });
        JButton mr = new JButton();
        mr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (mr.getText() == "") {
                    mr.setText(checkTurn());
                }
            }
        });
        JButton bl = new JButton();
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (bl.getText() == "") {
                    bl.setText(checkTurn());
                }            }
        });
        JButton bm = new JButton();
        bm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (bm.getText() == "") {
                    bm.setText(checkTurn());
                }            }
        });
        JButton br = new JButton();
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (br.getText() == "") {
                    br.setText(checkTurn());
                }            }
        });
        frame.add(tl);
        frame.add(tm);
        frame.add(tr);
        frame.add(ml);
        frame.add(mm);
        frame.add(mr);
        frame.add(bl);
        frame.add(bm);
        frame.add(br);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public String checkTurn() {
        if ( turn % 2 != 0 ) {
            turn++;
            return "X";
        }
        else {
            turn++;
            return "O";
        }
    }
}
