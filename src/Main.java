import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static List<String> runShell(String shStr) {
        List<String> strList = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shStr}, null, new File("./"));
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            process.waitFor();
            while ((line = input.readLine()) != null) {
                strList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strList;
    }
    
    public static void main(String[] args) {
        String shStr = "main/main \"你好世界！\"";
//        String testString = "touch testfile.txt";
        List<String> allRes = runShell(shStr);
        System.out.println(allRes);
        for (String resStr : allRes) {
            resStr = resStr.trim();
            String[] resSplit = resStr.split(":");
            System.out.println(resSplit[0].trim());
            System.out.println(resSplit[1].trim());
        }
        System.out.println("Complete!");
    }
}
