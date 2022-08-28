package Task1;
import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        int [][] arr=new int[10][10];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        double avg=0.0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
            arr[i][j]=random();
            System.out.print(arr[i][j]+"\t");
            if(arr[i][j]>max){
                max=arr[i][j];
            }
            if(arr[i][j]<min){
                min=arr[i][j];
            }
            avg+=arr[i][j];
            }
            System.out.println("");
        }
        avg=avg/(arr.length * arr.length);
        System.out.println("max="+max+ "; min="+min+"; avg="+avg);
    }
public static int random() {
    ArrayList<String> list=new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
    list.add("8");
    list.add("9");
    Collections.shuffle(list);
    if (Integer.parseInt(list.get(0))>5)
    {
        return Integer.parseInt(list.get(0)+list.get(1)+list.get(2)+list.get(3));
    }else return -Integer.parseInt(list.get(0)+list.get(1)+list.get(2)+list.get(3));
}


}
