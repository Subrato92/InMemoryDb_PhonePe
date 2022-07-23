import org.json.JSONObject;
import queryRepo.QueryManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InMemoryDb {

    public static void main(String[] args){
        System.out.println("============[ Welcome to In-Memory dB ]=============");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cmd = "";

        do{
            System.out.println("Please Type In Your Query [OR] Enter -1 to exit ...");

            try {
                cmd = reader.readLine();
                JSONObject query = new JSONObject(cmd);
                QueryManager.operate(query);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Sorry, Exception Occured, Try Again !!!");
            }

        }while(!cmd.equals("-1"));


    }
}
