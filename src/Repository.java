
import java.io.FileInputStream;
import java.util.Properties;

/*
 *  
Java18-OOJ
 */

/**
 *
 * @author xingao
 */
public class Repository {
    
    private Properties p= new Properties();
    public Repository(){
        try {
            p.load(new FileInputStream("src/bankomat/Settings.properties"));
//            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
}
