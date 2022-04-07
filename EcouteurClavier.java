import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class EcouteurClavier implements ActionListener{
    //actionPerformed indique les instructions a executer au clic du bouton
    private fenetre fen;
    
    public EcouteurClavier(fenetre fen){
		this.fen = fen;
	}
	
    public void actionPerformed(ActionEvent ae){
		String motEntre = fen.chargerMot();
    ArrayList <String> lettres = new ArrayList<String>();
		if(motEntre.length() == 5){
      if(fen.verifieMot(motEntre)){
        for( int i = 0; i<motEntre.length(); i++){
          String l = Character.toString(motEntre.charAt(i));
          lettres.add(l);
          EcouteurLettre ec = new EcouteurLettre(fen, l, fen.tabButtons(), fen.getX());
          ec.effectuer();
        }
      }

    }

    }
    
    
}