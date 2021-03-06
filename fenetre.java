import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import net.codejava.swing.hyperlink.JHyperlink;

public class fenetre extends JFrame {
    private JButton[][] txtlettre = new JButton[6][5];
    private JButton[] toucheClavier = new JButton[26];
    int x = 0;

    // création liste tableau
    String nomDuFichierALire = "wordListOrdered.txt";
    Texte leTexte = new Texte(nomDuFichierALire);
    String[] tableauGroupesLettres = leTexte.decoupe();
    List<String> list = Arrays.asList(tableauGroupesLettres);
    ArrayList<String> liste_mots = new ArrayList<>(list);

    Texte mots_reponse = new Texte("wordle-guesses.txt");
    String[] tableau_reponse = mots_reponse.decoupe();
    List<String> liste_reponse = Arrays.asList(tableau_reponse);
    ArrayList<String> array_reponse = new ArrayList<>(liste_reponse);

    Texte permutations = new Texte("permutations.txt");
    String[] tableau_permutations = permutations.decoupe();
    Quintuple[] possibility = permutations.decoupeToQuintuples(tableau_permutations);

    // réponse
    String reponse = tableau_reponse[(int) (Math.random() * tableau_reponse.length)];

    String alphabet = "AZERTYUIOPQSDFGHJKLMWXCVBN";
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    JTextArea areaTriche;

    private JTextField clavierArea;

    Color couleurBoutonVal = new Color(0, 71, 148, 200);

    findWord robot = new findWord(liste_mots, array_reponse, possibility);

    public fenetre() {

        // dimension de base
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension marge = new Dimension(2 * screenSize.width / 5, screenSize.height);

        for (int i = 0; i < alphabet.length(); i++) {
            map.put(String.valueOf(alphabet.charAt(i)), i);
        }

        // création du Panel supérieur, ce qu'il y a dedans et ses attributs
        JPanel pHaut = new JPanel();
        pHaut.setLayout(new BorderLayout());
        pHaut.setBackground(Color.BLACK); // ICI IMAAAAGE
        JLabel imageHaut = new JLabel(new ImageIcon("image_haut.png"));
        JButton help = new JButton(new ImageIcon("iconHelp.png"));
        JLabel wordle = new JLabel("WORDLE");
        wordle.setFocusable(false);
        wordle.setBackground(Color.BLUE);
        wordle.setFont(new Font("Montserrat", Font.BOLD, 36));
        wordle.setForeground(Color.white);
        wordle.setBorder(null);
        wordle.setHorizontalAlignment(JTextField.CENTER);

        // PANEL TRICHE
        JPanel triche = new JPanel();
        triche.setLayout(new BorderLayout());
        triche.setBackground(Color.BLACK);
        triche.setBorder(BorderFactory.createMatteBorder(screenSize.height/30, 1, screenSize.height/30, screenSize.width/20, Color.BLACK));
        // triche.setBounds(70, 50, 40, 60);
        triche.setVisible(true);
        areaTriche = new JTextArea("Best opener is : Slane");
        areaTriche.setEditable(false);
        areaTriche.setPreferredSize(new Dimension(screenSize.width/5, screenSize.height/3 ));
        areaTriche.setBackground(new Color(108, 140, 137));
        areaTriche.setForeground(Color.BLACK);
        areaTriche.setFont(new Font("Gill Sans MT Ext Condensed Bold", Font.PLAIN, 30));
        Border bord = BorderFactory.createLoweredBevelBorder();
        areaTriche.setBorder(BorderFactory.createTitledBorder(bord, "- LOCOBOTUS - IA -",
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Gill Sans MT Ext Condensed Bold", Font.PLAIN, 30),
                Color.DARK_GRAY));
        triche.add(areaTriche);

        //Panel Bouton stop triche
        JPanel noTriche = new JPanel();
        ImageIcon gif = new ImageIcon("giphy2.gif");
        noTriche.setLayout(new BorderLayout());
        noTriche.setBackground(Color.green);
        noTriche.setPreferredSize(new Dimension((int)(screenSize.width/(4)), screenSize.height/4));
        JButton boutton_triche = new JButton(gif);
        boutton_triche.setBackground(Color.black);
        boutton_triche.setForeground(Color.white);
        boutton_triche.setOpaque(true);
        boutton_triche.setFocusable(false);
        boutton_triche.setPreferredSize(new Dimension(screenSize.width/(5), screenSize.height/4));
        noTriche.setBorder(BorderFactory.createMatteBorder(screenSize.height/35, screenSize.width/40 , screenSize.height/35, screenSize.width/40, 
        Color.BLACK));
        boutton_triche.addActionListener(new EcouteurTriche(this, areaTriche));
        noTriche.add(boutton_triche, BorderLayout.CENTER);

        //Texte locomotus Panel du haut
        JPanel locom = new JPanel();
        locom.setLayout(new GridLayout());
        locom.setBackground(Color.BLACK);
        JTextField locomotus = new JTextField("by LOCOMOTUS");
        locomotus.setEditable(false);
        locomotus.setBackground(Color.black);
        locomotus.setFont(new Font("Montserrat", Font.BOLD, 15));
        locomotus.setForeground(Color.white);
        locomotus.setBorder(null);
        locomotus.setHorizontalAlignment(JTextField.CENTER);
        //Bouton help
        help.setBackground(Color.black);
        help.setBorderPainted(false);
        help.setOpaque(false);
        help.setBorder(BorderFactory.createEmptyBorder());
        help.setBounds(25, 35, 29, 28);
        help.addActionListener(new ecouteurHelp(this));

        // création de la grille au milieu

        JPanel centralCee = new JPanel(); // 667 équipe
        centralCee.setBackground(Color.BLACK);
        centralCee.setLayout(new BorderLayout());

        JPanel p2 = new JPanel();
        p2.setBackground(Color.black);
        p2.setLayout(new GridLayout(6, 5, 5, 5)); // lignes,colonnes,espacement vertical et horizontal

        //Panel du haut pour entrer le mot
        JPanel textArea = new JPanel();
        textArea.setBackground(Color.BLACK);
        clavierArea = new JTextField(12);
        clavierArea.setBackground(Color.DARK_GRAY);
        clavierArea.setForeground(Color.WHITE);
        clavierArea.setFont(new Font("Montserrat", Font.ITALIC, 15));
        clavierArea.setPreferredSize(new Dimension(screenSize.width/8,screenSize.height/30));
        clavierArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            //Bouton valider mot
        JButton valide = new JButton("Valider mot");
        valide.setBorderPainted(true);
        valide.setOpaque(true);
        valide.setForeground(Color.WHITE);
        valide.setBackground(couleurBoutonVal);
        valide.setPreferredSize(new Dimension(screenSize.width/17, screenSize.height/27));
        valide.setFocusable(false);
        valide.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        valide.addActionListener(new EcouteurClavier(this));

        textArea.add(clavierArea);
        textArea.add(valide);

        for (int i = 0; i < txtlettre.length; i++) {
            for (int j = 0; j < txtlettre[i].length; j++) {
                txtlettre[i][j] = new JButton();
                txtlettre[i][j].setForeground(Color.white);
                txtlettre[i][j].setBackground(Color.BLACK);
                txtlettre[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                txtlettre[i][j].setOpaque(true);
                txtlettre[i][j].setFont(new Font("Arial", Font.BOLD, 42));
                txtlettre[i][j].setFocusable(false);

                p2.add(txtlettre[i][j]);
            }

        }

        // Panel gauche et droite afin de centrer la grille
        JPanel pGauche = new JPanel();
        JLabel imageGauche = new JLabel(new ImageIcon("image_gauche.gif"));
        pGauche.setBackground(Color.black);
        JPanel pDroit = new JPanel();
        JLabel imageDroite = new JLabel(new ImageIcon("image_droite.gif"));
        pDroit.setBackground(Color.black);

        // création du Panel du bas
        JPanel pBas = new JPanel();
        pBas.setLayout(new BorderLayout());
        JPanel clavier = new JPanel();
        JPanel noms = new JPanel();
        JPanel ligne1 = new JPanel();
        JPanel ligne2 = new JPanel();
        JPanel ligne3 = new JPanel();
        JPanel ligne4 = new JPanel();
        pBas.setBackground(Color.black);
        noms.setBackground(Color.black);
        ligne1.setBackground(Color.black);
        ligne2.setBackground(Color.black);
        ligne3.setBackground(Color.black);
        ligne4.setBackground(Color.black);
        clavier.setBackground(Color.black);

        ligne1.setPreferredSize(new Dimension(screenSize.width, 50));
        ligne2.setPreferredSize(new Dimension(screenSize.width, 50));
        ligne3.setPreferredSize(new Dimension(screenSize.width, 50));
        ligne4.setPreferredSize(new Dimension(screenSize.width, 50));

        //Liens externes insta
        JHyperlink sarah = new JHyperlink("S.Pignol,", "https://www.instagram.com/sarah.pgl/");
        JHyperlink paul = new JHyperlink("P.Rochaix,", "https://www.instagram.com/paulo.rchx/");
        JHyperlink noam = new JHyperlink("N.Bires,", "https://www.instagram.com/noambires/");
        JHyperlink clara = new JHyperlink("C.Lemiere,", "https://www.instagram.com/c.l.banana/");
        JHyperlink satine = new JHyperlink("S.Mialon,", "https://www.instagram.com/sat.mln11/");
        JHyperlink moha = new JHyperlink("Mention honorable à Moha.", "https://www.instagram.com/mohamedfayala/");
       

        //Ajout du clavier
        String row1 = "AZERTYUIOP";
        for (int i = 0; i < row1.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(alphabet.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(alphabet.charAt(i)), txtlettre, x));
            ligne1.add(toucheClavier[i]);

        }

        String row2 = "QSDFGHJKLM";
        for (int i = row1.length(); i < row1.length() + row2.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(alphabet.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(alphabet.charAt(i)), txtlettre, x));
            ligne2.add(toucheClavier[i]);
        }
        //Bouton enter clavier
        JButton enter = new JButton("ENTER");
        enter.setBorderPainted(true);
        enter.setOpaque(true);
        enter.setForeground(Color.WHITE);
        enter.setBackground(couleurBoutonVal);
        enter.setPreferredSize(new Dimension(60, 40));
        enter.setFocusable(false);
        enter.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        enter.addActionListener(new EcouteurEnter(this, txtlettre, toucheClavier, map, areaTriche));

        ligne3.add(enter);

        String row3 = "WXCVBN";
        for (int i = row1.length() + row2.length(); i < row1.length() + row2.length() + row3.length(); i++) {
            toucheClavier[i] = new JButton();
            toucheClavier[i].setText(Character.toString(alphabet.charAt(i)));
            toucheClavier[i].setBorderPainted(true);
            toucheClavier[i].setOpaque(false);
            toucheClavier[i].setBackground(Color.black);
            toucheClavier[i].setForeground(Color.white);
            toucheClavier[i].setFocusable(false);
            toucheClavier[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 2));
            toucheClavier[i].setPreferredSize(new Dimension(40, 40));
            toucheClavier[i]
                    .addActionListener(
                            new EcouteurLettre(this, Character.toString(alphabet.charAt(i)), txtlettre, x));
            ligne3.add(toucheClavier[i]);
        }
        
        //Bouton Restart
        JButton restart = new JButton("RESTART");
        restart.setBackground(new Color(94, 17, 20, 150));
        restart.setBorderPainted(true);
        restart.setOpaque(true);
        restart.setForeground(Color.WHITE);
        restart.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        restart.setPreferredSize(new Dimension(150, 40));
        restart.setFocusable(false);
        restart.addActionListener(new EcouteurRestart(this));

        ligne4.add(restart);

        //Bouton supprimer
        JButton delete = new JButton(new ImageIcon("delete_icon.png"));
        delete.setPreferredSize(new Dimension(60, 40));
        delete.setOpaque(true);
        delete.setBorderPainted(true);
        delete.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        delete.setFocusable(false);
        delete.addActionListener(new EcouteurDelete(this, txtlettre, x));
        delete.setContentAreaFilled(false);
        ligne3.add(delete);

        // ajout des composants dans leurs panels respectifs

        pack();
        locom.add(locomotus);
        pHaut.add(imageHaut);
        pHaut.add(help);
        pHaut.add(locom, BorderLayout.SOUTH);
        pHaut.add(wordle);
        add(pHaut, BorderLayout.NORTH);
        pHaut.setPreferredSize(new Dimension(1000, 100));
        centralCee.add(p2);
        centralCee.add(textArea, BorderLayout.NORTH);
        add(centralCee, BorderLayout.CENTER);
        centralCee.setPreferredSize(new Dimension(200, 200));
        
        noms.add(sarah);
        noms.add(paul);
        noms.add(noam);
        noms.add(clara);
        noms.add(satine);
        noms.add(moha);
        pBas.add(noms, BorderLayout.NORTH);

        clavier.add(ligne1);
        clavier.add(ligne2);
        clavier.add(ligne3);
        clavier.add(ligne4);

        pGauche.add(imageGauche);
        pDroit.add(imageDroite);
        pBas.add(clavier, BorderLayout.CENTER);
        pBas.add(noTriche, BorderLayout.WEST);
        pBas.add(triche, BorderLayout.EAST);

        //Ajout des différents panels
        add(pBas, BorderLayout.SOUTH);
        pBas.setPreferredSize(new Dimension(1000, screenSize.height / 3));
        add(pGauche, BorderLayout.WEST);
        pGauche.setPreferredSize(marge);
        add(pDroit, BorderLayout.EAST);
        pDroit.setPreferredSize(marge);

        // testHashmap();

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

    public boolean changementLigne() {
        boolean b = false;
        if (txtlettre[x][txtlettre[x].length - 1].getText() != "") {
            x++;
            b = true;
        }
        return b;
    }

    public int getX() {
        return x;
    }

    public void setX(int y) {
        this.x = y;
    }

    public boolean verifieMot(String s) {
        boolean b = false;
        s.toLowerCase();
        if (list.contains(s)) {
            b = true;
        } else {
            JOptionPane.showMessageDialog(this, "The word you entered is incorrect.");
        }
        return b;
    }

    public String getMot() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < txtlettre[getX()].length; i++) {
            sb.append(txtlettre[getX()][i].getText().toLowerCase());
        }
        return sb.toString();
    }

    public String getReponse() {
        return reponse.toLowerCase();
    }

    public void testHashmap() {
        for (Map.Entry<String, Integer> a : map.entrySet()) {
            System.out.println(a.getKey() + "/" + a.getValue());
        }
    }

    public void nouvRep() {
        this.reponse = tableau_reponse[(int) (Math.random() * tableau_reponse.length)];
    }

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public void changeBackground(Color c, int posi, int posj) {
        txtlettre[posi][posj].setForeground(c);
    }

    public void setTimeout(Object changeBackground, int delay) {
    }

    public String chargerMot() {
        String nouveauMot = clavierArea.getText();
        nouveauMot = nouveauMot.toLowerCase();
        System.out.println(nouveauMot);
        clavierArea.setText("");
        return nouveauMot;

    }

    public JButton[][] tabButtons() {
        return this.txtlettre;
    }

    public JButton[] getClavier() {
        return this.toucheClavier;
    }

    public HashMap<String, Integer> getlaHmap() {
        return this.map;
    }

    public JTextArea getTextArea() {
        return this.areaTriche;
    }

}
