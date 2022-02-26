import java.awt.*;
import javax.swing.*;

public class HelpFenetre extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private fenetre fen;

    public HelpFenetre(fenetre fen) {
        this.fen = fen;

        JPanel a = new JPanel();
        JButton b = new JButton(new ImageIcon("x_icon.png"));
        a.setBackground(Color.black);
        JLabel pic = new JLabel(new ImageIcon("help_pop_up.png"));

        b.setBackground(Color.black);
        b.setBorderPainted(false);

        b.setBorder(BorderFactory.createEmptyBorder());
        b.setBounds(screenSize.width - 50, 50, 30, 30);
        b.addActionListener(new EcouteurX(this, fen));
        b.setFocusable(false);

        pack();

        a.add(pic);
        a.add(b);
        add(a);

        setBackground(Color.BLACK);
        setSize(screenSize.width, screenSize.height);
        setVisible(true);

    }

}
