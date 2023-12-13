package Calculator;


import java.util.Scanner;
import java.util.Stack;

public class index {

    String history[][] = new String[100][2];
     int count = 0;

    public int priority(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return 0;
    }

    public boolean cheak(char ch){
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
            return true;
        }
        return false;
    }
    public  String Calculate(String word){
        Stack<Character> store = new Stack<>();
        String ans = "";
        for(int i =0;i<word.length();i++) {

            char ch = word.charAt(i);
            if(cheak(word.charAt(0))||cheak(word.charAt(word.length()-1))){
                return null;
            }
            if(cheak(ch) && cheak(word.charAt(i+1))){
                return null;
            }


            if (ch == '(') {
                store.push(ch);
            } else if (ch == ')') {
                while (!store.isEmpty() && store.peek() != '(') {
                    ans += store.pop();
                }
                store.pop();
            } else if (ch == '+' || ch == '*' || ch == '-' || ch == '/') {
                while (!store.isEmpty() && priority(store.peek()) >= priority(ch)) {
                    ans += store.pop();
                }
                store.add(ch);
            } else {
                ans += ch;
                int j = i;
                boolean found = false;
                while ( j+1<word.length() && Character.isDigit(word.charAt(j + 1))) {
                    j++;
                    found = true;
                }
                if(found) {
                    ans = ans.substring(0,ans.length()-1);
                    ans += " ";

                    while(i<=j){

                        ans += word.charAt(i);
                        i++;
                    }
                    i = i-1;
                    ans += " ";
                }
            }
        }
        while(!store.isEmpty()){
            ans += store.pop();
        }
        return ans;
    }

    public String calculate_Ans(String word){

        history[count][0] =  word;

        String result = Calculate(word);
        if(result==null){
            throw new RuntimeException("Invalid operators and operands");
        }
        Stack<Double> store = new Stack<>();
        for(int i =0;i<result.length();i++){

            char ch = result.charAt(i);

            if(ch == ' '){

                String ans = "";
                int j = i+1;
                while(result.charAt(j)!=' '){
                    ans += result.charAt(j);
                    j++;
                }

                store.push((double)Integer.parseInt(ans));
                i = j;
                continue;
            }

           if(Character.isDigit(ch)){
               store.push((double)ch-'0');
           }
           else{
               double val1 = (double)store.pop();
               double val2 = (double)store.pop();
               switch (ch){
                   case '+':
                       store.push(val2+val1);
                       break;
                   case '-':
                       store.push(val2-val1);
                       break;
                   case '*':
                       store.push(val2*val1);
                       break;
                   case '/':
                       store.push(val2/val1);
                       break;
                   case '^':
                       double ans = (Math.pow(val2,val1));
                       store.push(ans);
                       break;
               }
           }

        }
        history[count][1] = String.valueOf(store.peek());
        count++;
        return String.valueOf(store.pop());
    }
    public void watch_History(){
        System.out.println("::::::::::::::::::::Recent History::::::::::::::::::::::");
        for(int i =0;i<count;i++){
            System.out.printf("%s\n=> %s\n",history[i][0],history[i][1]);
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }

    public static void  Calculator_app(){
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::::::::::::::::::::::::CALCULATOR::::::::::::::::::::::::");

        String ans = "";
        String word = "";
        index cal = new index();
        Scanner sc = new Scanner(System.in);
        while(true) {
            while (true) {

                System.out.print("Enter:->");
                Scanner in = new Scanner(System.in);
                word = in.nextLine();
                word = word.replaceAll("\\s","");
                if(!Character.isDigit(word.charAt(0))){
                    word = ans+word;
                }

                ans = cal.calculate_Ans(word);
                System.out.printf("\t=>%s\n", ans);
                System.out.printf("Continue:0\t\t\texit:1->\t");
                int check = sc.nextInt();
                if (check == 1) {
                    break;
                }
            }
            System.out.print("History:1\t\t\t\texit:0->\t");
            int check = sc.nextInt();
            if (check == 0) {
                break;
            } else {
                cal.watch_History();
                break;
            }
        }

    }
    public static void main(String[] args) {
        Calculator_app();
    }
}
