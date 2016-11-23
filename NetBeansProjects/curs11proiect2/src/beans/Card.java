package beans;


public class Card implements java.io.Serializable{
private String serie;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

public Card(){}

public Card(String serie){
this.serie=serie;
}

@Override
public String toString(){
return serie;
}


    
    
}
