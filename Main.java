import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static int lcm_f(int a, int b){
        int i=2, max,LCM=1;                                 
        if(a>b){
            max=a;
        }
        else{
            max=b;
        }
        while(i<=max){                             
            while((a%i==0)||(b%i==0)){           
                LCM=LCM*i;
                if(a%i==0){
                    a=a/i;
                }
                if(b%i==0){
                    b=b/i;
                }
            }
            i++;
        }
        return LCM;        
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    int lcm_org=1;
        for(int j=0;j<a.size();j++){
        lcm_org=lcm_f(lcm_org,a.get(j));
        }
        //Absolute correct value of lcm
        int mul=1,count=0;
        int lcm=lcm_org;
        while(lcm<=Collections.min(b)){
        boolean flag=true;
        for(int i=0;i<b.size();i++){
            if(b.get(i)%lcm!=0){
                flag=false;
            }
            else{
                continue;
            }
        }
        
        if(flag==true){
            count++;
        }
        mul++;
        lcm=lcm_org*mul;
    }
    return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
