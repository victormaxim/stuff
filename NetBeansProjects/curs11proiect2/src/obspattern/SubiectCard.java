/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obspattern;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface SubiectCard {
    ArrayList<CardListener> obs = new ArrayList<CardListener>();
    
    public void addCardListener(CardListener cl);
    public void notifica();
    
    
}
