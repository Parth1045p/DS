package tokenring;

import java.util.*;

public class token_ring{

public static void main(String [] args){
System.out.println("Enter the no of nodes");
int n;
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
System.out.println("Ring forms as below:");
for(int i=0;i<n;i++){
System.out.print(i+" ");
}
System.out.println(0);
int ch=0;

do{
System.out.println("Sender");
int sender=sc.nextInt();
System.out.println("Receiver");
int receiver=sc.nextInt();
System.out.println("data");
int data=sc.nextInt();
int token=0;
System.out.println("Token Passing");
for(int i=token;i<sender;i++){
System.out.print(" "+i+"->");

}
System.out.println(""+sender);
System.out.println("Sender "+sender+"Sending data"+data);
for(int i=sender;i!=receiver;i=(i+1)%n){
System.out.println("Data "+data+"forwarded by"+i);

}
System.out.println("Receiver "+receiver+" data"+data);
token=sender;
System.out.println("Do you want to send data again? yes 1 /no 0");
ch=sc.nextInt();


}while(ch==1);

}

}