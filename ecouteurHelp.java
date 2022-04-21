import java.awt.event.*;

public class ecouteurHelp implements ActionListener {
    private fenetre fen;

    public ecouteurHelp(fenetre fen) {
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fen.setVisible(false);
        new HelpFenetre(fen);
    }

}
