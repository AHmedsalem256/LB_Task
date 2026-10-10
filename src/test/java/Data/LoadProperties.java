package Data;

import java.io.FileInputStream;
import java.util.Properties;

public class LoadProperties {
    public static Properties prop ;

    public static Properties LoadTheData(String File_Path ){
        prop = new Properties();
        try(FileInputStream file = new FileInputStream(File_Path)){
            prop.load(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        return prop ;
    }

}
