import java.awt.*;
import javax.swing.*;

import net.codejava.swing.hyperlink.JHyperlink;

public class fenetre extends JFrame {
    private JButton[][] txtlettre = new JButton[6][5];
    private JButton[] toucheClavier = new JButton[26];
    int x = 0;

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
        for (int i = 0; i < txtlettre.length; i++) {
            for (int j = 0; j < txtlettre[i].length; j++) {
                txtlettre[i][j] = new JButton();
                txtlettre[i][j].setEnabled(false);
                txtlettre[i][j].setForeground(Color.white);
                txtlettre[i][j].setBackground(Color.black);
                txtlettre[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                txtlettre[i][j].setOpaque(false);
                txtlettre[i][j].setFont(new Font("Arial", Font.BOLD, 42));

                p2.add(txtlettre[i][j]);
            }

        }

        // Panel gauche et droite afin de centrer la grille
        JPanel pGauche = new JPanel();
        pGauche.setBackground(Color.black);
        JPanel pDroit = new JPanel();
        pDroit.setBackground(Color.black);

        // création du Panel du bas
        JPanel pBas = new JPanel();
        pBas.setLayout(new BorderLayout());
        JPanel clavier = new JPanel();
        JPanel noms = new JPanel();
        JPanel ligne1 = new JPanel();
        JPanel ligne2 = new JPanel();
        JPanel ligne3 = new JPanel();
        pBas.setBackground(Color.black);
        noms.setBackground(Color.black);
        ligne1.setBackground(Color.black);
        ligne2.setBackground(Color.black);
        ligne3.setBackground(Color.black);
        clavier.setBackground(Color.black);

        ligne1.setPreferredSize(new Dimension(screenSize.width, 50));
        ligne2.setPreferredSize(new Dimension(screenSize.width, 50));
        ligne3.setPreferredSize(new Dimension(screenSize.width, 50));

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
        // // auteurs.setBorder(null);
        // JTextField saisie = new JTextField(50);
        // saisie.setBackground(Color.black);
        // saisie.setForeground(Color.WHITE);
        // saisie.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));

        // JButton enter = new JButton("ENTER");
        // enter.setBorderPainted(true);
        // enter.setOpaque(false);
        // enter.setForeground(Color.WHITE);
        // enter.setBackground(Color.black);
        // enter.setPreferredSize(new Dimension(100, 50));
        // enter.setFocusable(false);
        // enter.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));

        String row1 = "QWERTYUIOP";
        for (int i = 0; i < row1.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(row1.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(row1.charAt(i)), txtlettre, x));
            ligne1.add(toucheClavier[i]);

        }

        String row2 = "ASDFGHJKL";
        for (int i = 0; i < row2.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(row2.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(row2.charAt(i)), txtlettre, x));
            ligne2.add(toucheClavier[i]);
        }

        JButton enter = new JButton("ENTER");
        enter.setBorderPainted(true);
        enter.setOpaque(false);
        enter.setForeground(Color.WHITE);
        enter.setBackground(Color.black);
        enter.setPreferredSize(new Dimension(60, 40));
        enter.setFocusable(false);
        enter.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
        enter.addActionListener(new EcouteurEnter(this, txtlettre));

        ligne3.add(enter);

        String row3 = "ZXCVBNM";
        for (int i = 0; i < row3.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(row3.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(row3.charAt(i)), txtlettre, x));
            ligne3.add(toucheClavier[i]);
        }

        JButton delete = new JButton(new ImageIcon("delete_icon.png"));
        delete.setBackground(Color.black);
        delete.setBorderPainted(true);
        delete.setOpaque(false);
        delete.setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
        delete.setPreferredSize(new Dimension(60, 40));
        delete.setFocusable(false);
        delete.addActionListener(new EcouteurDelete(this, txtlettre, x));
        delete.setContentAreaFilled(false);
        ligne3.add(delete);

        // ajout des composants

        pack();

        pHaut.add(help);
        pHaut.add(wordle);
        add(pHaut, BorderLayout.NORTH);
        pHaut.setPreferredSize(new Dimension(1000, 100));
        add(p2, BorderLayout.CENTER);
        p2.setPreferredSize(new Dimension(200, 200));
        // pBas.add(auteurs);
        noms.add(sarah);
        noms.add(paul);
        noms.add(noam);
        noms.add(moha);
        pBas.add(noms, BorderLayout.NORTH);
        clavier.add(ligne1);
        clavier.add(ligne2);
        clavier.add(ligne3);
        // zoneSaisie.add(saisie);
        // zoneSaisie.add(enter);
        pBas.add(clavier, BorderLayout.CENTER);
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

    public int caseVide() {
        int val = -1;

        for (int i = 0; i < txtlettre[x].length; i++) {
            if (txtlettre[x][i].getText() == "") {
                val = i;
                break;
            } else if (txtlettre[x][txtlettre[x].length - 1].getText() != "") {
                val = txtlettre[x].length;
                break;
            }
        }
        return val;
    }

    public void changementLigne() {
        x++;
    }

    public int getX() {
        return x;
    }

}
