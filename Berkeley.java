import java.util.Scanner;

public class Berkeley {

    public static void main(String[] args) {
        int n;
        long master_time = 10800;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of nodes:");
        n = sc.nextInt();
        System.out.println("Nodes are:" + n);
        long[] time_nodes = new long[n+1];
        System.out.println("Enter the time seconds for each node:");
        for (int i = 1; i < n+1; i++) {
            long time = sc.nextLong();
            time_nodes[i] = time;

        }
        long minutes[]=new long[n+1];
        long hours[]=new long[n+1];
        for(int i=0;i<n+1;i++){
            if(i==0){
                long s=master_time%60;
                long h=master_time/60;
                long m=h%60;
                h=h/60;
                minutes[i]=m;
                hours[i]=h;
            }
            else{
                long s=time_nodes[i]%60;
                long h=time_nodes[i]/60;
                long m=h%60;
                h=h/60;
                minutes[i]=m;
                hours[i]=h;
            }

        }
        for(int i=0;i<n+1;i++){
            if(i==0){
                System.out.println("Time of master node "+i+" is"+hours[i]+":"+minutes[i]);
            }
            else{
                System.out.println("Time of node "+i+" is"+hours[i]+":"+minutes[i]);

            }
//            System.out.println("Time of node "+i+" is"+hours[i]+":"+minutes[i]);
        }
        long time_diff[] =new long[n+1];
        for(int i=1;i<n+1;i++){
            if(hours[i]<hours[0]){
                System.out.println("Yes");
                if(minutes[i]>30){
                    time_diff[i]=minutes[i]-60;
                }
            }
            else {
                time_diff[i]=minutes[i];
            }
        }
        for (int i=1;i<n+1;i++){
            System.out.println("Time differences are: "+time_diff[i]);
        }


    }
}