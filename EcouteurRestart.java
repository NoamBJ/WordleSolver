import java.awt.event.*;

public class EcouteurRestart implements ActionListener {
    private fenetre fen;

    public EcouteurRestart(fenetre fen) {
        this.fen = fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fen.dispose();
        new fenetre();
    }
}
