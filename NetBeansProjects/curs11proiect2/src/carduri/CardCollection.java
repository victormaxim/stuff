
package carduri;

import beans.Card;
import java.util.ArrayList;
import obspattern.CardListener;
import obspattern.SubiectCard;


public class CardCollection implements SubiectCard{
    private ArrayList<Card> carduri = new ArrayList<Card>();
    private static CardCollection singleton = null;
    
    private CardCollection(){}
    
    public static CardCollection getInstance(){
    if(singleton==null) singleton = new CardCollection();
    return singleton;
    }
    
    public void addCard(Card card){
    carduri.add(card);
    }    
    
    
    
    public ArrayList<Card> getCarduri(){
    return carduri;
    }
    
    @Override
    public void addCardListener(CardListener cl){
    obs.add(cl);
    }
    @Override
    public void notifica(){
    for(CardListener cl: obs){
    cl.cardModificat();
    }
    }
    
    
    
    
}
