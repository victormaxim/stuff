package login;
import beans.User;
import java.util.ArrayList;

public class LoginContainer implements java.io.Serializable {

    private ArrayList<User> useri = new ArrayList<User>();
    private static LoginContainer container = null;
  
    
    private LoginContainer(){}
    
    public static LoginContainer getInstance(){
    if(null==container)container = new LoginContainer();
    return container;
    
    }
    
    public static void setInstance(LoginContainer container){
        LoginContainer.container = container;
    }
        
    
    public void addUser(User user){
    useri.add(user);
    }
    
    public User getUser(String user){
    for(User u: useri){
      System.out.printf("-%s-?-%s- \n", u.getNume(), user);
    if(u.getNume().equals(user)) {
        System.out.printf("-%s===%s- \n", u.getNume(), user);
        return u;
    };
    }
    return null;
    //    return u;
    }
    
    public String getUsers(String stringu){
    String x = "";     
    for(User u: useri){
    x += "-" + u.getNume() + "-\n";
    //System.out.println(u.getNume());
        //return x;
    }
        return x;
    }
}
