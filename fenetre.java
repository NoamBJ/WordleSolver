import java.awt.*;
import javax.swing.*;

import net.codejava.swing.hyperlink.JHyperlink;

public class fenetre extends JFrame {
    private JButton[] buttons = new JButton[30];

    public fenetre() {

        // dimension de base
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension marge = new Dimension(2 * screenSize.width / 5, screenSize.height);

        // création du Panel supérieur, ce qu'il y a dedans et ses attributs
        JPanel pHaut = new JPanel();
        pHaut.setLayout(new BorderLayout());
        pHaut.setBackground(Color.BLACK);
        JButton help = new JButton(new ImageIcon("iconHelp.png"));
        JTextField wordle = new JTextField("Wordle");
        wordle.setEditable(false);
        wordle.setBackground(Color.black);
        wordle.setFont(new Font("Arial", Font.BOLD, 36));
        wordle.setForeground(Color.white);
        wordle.setBorder(null);
        wordle.setHorizontalAlignment(JTextField.CENTER);

        help.setBackground(Color.black);
        help.setBorderPainted(false);
        help.setOpaque(false);
        help.setBorder(BorderFactory.createEmptyBorder());
        help.setBounds(25, 35, 29, 28);
        help.addActionListener(new ecouteurHelp(this));

        // création de la grille au milieu
        JPanel p2 = new JPanel();
        p2.setBackground(Color.black);
        p2.setLayout(new GridLayout(6, 5, 5, 5)); // lignes,colonnes,espacement vertical et horizontal

        // sert a rien il va falloir remplacer par des textfield ou atre chose jsp
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBorderPainted(true);
            buttons[i].setOpaque(false);
            buttons[i].setBackground(Color.black);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            p2.add(buttons[i]);
        }

        // Panel gauche et droite afin de centrer la grille
        JPanel pGauche = new JPanel();
        pGauche.setBackground(Color.black);
        JPanel pDroit = new JPanel();
        pDroit.setBackground(Color.black);

        // création du Panel du bas
        JPanel pBas = new JPanel();
        pBas.setBackground(Color.black);
        // JTextField auteurs = new JTextField("S.Pignol, P.Rochaix, N.Bires");
        // auteurs.setEditable(false);
        // auteurs.setBackground(Color.black);
        // auteurs.setFont(new Font("Arial", Font.ITALIC, 12));
        // auteurs.setForeground(Color.decode("#B36200"));
        // auteurs.setBorder(null);
        JHyperlink sarah = new JHyperlink("S.Pignol,", "https://www.instagram.com/sarah.pgl/");
        JHyperlink paul = new JHyperlink("P.Rochaix,", "https://www.instagram.com/paulo.rchx/");
        JHyperlink noam = new JHyperlink("N.Bires,", "https://www.instagram.com/noambires/");
        JHyperlink moha = new JHyperlink("Mention honorable à Moha.", "https://www.instagram.com/mohamedfayala/");
        // auteurs.setEditable(false);
        // auteurs.setBackground(Color.black);
        // auteurs.setFont(new Font("Arial", Font.ITALIC, 12));
        // auteurs.setForeground(Color.decode("#B36200"));
        // auteurs.setBorder(null);

        // ajout des composants

        pack();

        pHaut.add(help);
        pHaut.add(wordle);
        add(pHaut, BorderLayout.NORTH);
        pHaut.setPreferredSize(new Dimension(1000, 100));
        add(p2, BorderLayout.CENTER);
        p2.setPreferredSize(new Dimension(200, 200));
        // pBas.add(auteurs);
        pBas.add(sarah);
        pBas.add(paul);
        pBas.add(noam);
        pBas.add(moha);
        add(pBas, BorderLayout.SOUTH);
        pBas.setPreferredSize(new Dimension(1000, screenSize.height / 3));
        add(pGauche, BorderLayout.WEST);
        pGauche.setPreferredSize(marge);
        add(pDroit, BorderLayout.EAST);
        pDroit.setPreferredSize(marge);

        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize.width, screenSize.height);
        setVisible(true);
    }
}
