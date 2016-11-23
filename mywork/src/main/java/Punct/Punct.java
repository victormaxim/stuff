package Punct;

public class Punct
{
    int x, y;
    private int z;
    

    public Punct(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int miscaPunct(int x){
    this.x=x;
    return this.x;
    
    }
    
    public Punct(){
    this(11,101);
    
    }
    
    public int getZ(){
        return this.z;
    }
    
}
