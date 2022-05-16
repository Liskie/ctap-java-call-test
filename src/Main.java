import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static List<String> runShell(String shStr) {
        List<String> strList = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            process.waitFor();
            while ((line = input.readLine()) != null){
                strList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strList;
    }
    
    public static void main(String[] args) {
        List<String> allRes = runShell("main/main \"你好世界！\"");
        for (String resStr : allRes) {
            resStr = resStr.trim();
            String[] resSplit = resStr.split(":");
            System.out.println(resSplit[0].trim());
            System.out.println(resSplit[1].trim());
        }
        
    }
}
