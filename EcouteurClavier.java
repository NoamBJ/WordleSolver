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
		fen.chargerMot();
		//fen.affichePresents();
    }
    
    
}