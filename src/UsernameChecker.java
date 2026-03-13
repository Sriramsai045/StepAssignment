import java.util.*;

public class UsernameChecker {

    static HashMap<String,Integer> users = new HashMap<>();
    static HashMap<String,Integer> attempts = new HashMap<>();

    static boolean checkAvailability(String name){
        attempts.put(name, attempts.getOrDefault(name,0)+1);
        return !users.containsKey(name);
    }

    static List<String> suggestAlternatives(String name){

        List<String> list = new ArrayList<>();

        for(int i=1;i<=3;i++)
            list.add(name+i);

        list.add(name.replace("_","."));

        return list;
    }

    static String getMostAttempted(){

        String user="";
        int max=0;

        for(String u:attempts.keySet()){
            if(attempts.get(u)>max){
                max=attempts.get(u);
                user=u;
            }
        }

        return user;
    }

    public static void main(String[] args){

        users.put("john_doe",1);
        users.put("admin",2);

        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));

        System.out.println(suggestAlternatives("john_doe"));

        System.out.println(getMostAttempted());
    }
}