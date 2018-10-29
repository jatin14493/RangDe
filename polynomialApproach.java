package RangDe;

import java.util.*;

public class polynomialApproach {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String str = s.nextLine();
        int val = s.nextInt();

        str = str.replace(" ","");
        System.out.println(str);

        //key as degree
        //coefficient as value
        Map<Integer,Integer> hashMap = new TreeMap<>();
        LinkedList<Character> queue = new LinkedList<Character>();

        int coefficient = 1;
        int degree = 1;
        char prev = 0;

        //flag =true after processing coefficient
        //flag = false after processing degree
        Boolean flag = false;

        for(int i=0; i<str.length(); i++){

            Character t = str.charAt(i);
            if(t=='x'){

                String temp_val = "";
                while(!queue.isEmpty()){
                    temp_val = temp_val + queue.removeFirst();
                }
                try{
                    if(!flag){
                        if(temp_val.contains("+")){
                            temp_val = temp_val.replace("+","");
                        }
                        else if(temp_val.contains("-")){

                            if(temp_val.length()==1)
                            temp_val = temp_val.replace("-","");

                            if(temp_val.length()==0){

                                coefficient =-1;
                            }
                        }

                        if(coefficient!=-1)
                        coefficient = Integer.parseInt(temp_val);
                    }
                    else
                        degree = Integer.parseInt(temp_val);

                }catch (Exception e){

                }
                if(!flag){
                    flag =true;
                }
                else{
                    flag =false;
                    hashMap.put(degree,coefficient);
                    degree =1;
                    coefficient =1;
                }

            }

            else{

                if(prev=='x' && (t=='+' || t=='-')){
                    degree = 1;
                    hashMap.put(degree,coefficient);
                    flag =false;
                    degree =1;
                    coefficient =1;
                }else if(flag && (t=='+' || t=='-')){
                    String temp_val = "";
                    while(!queue.isEmpty()){
                        temp_val = temp_val + queue.removeFirst();
                    }

                    try{

                        degree = Integer.parseInt(temp_val);

                    }catch (Exception e){

                    }

                        flag =false;
                        hashMap.put(degree,coefficient);
                        degree =1;
                        coefficient =1;

                }



                queue.add(t);
            }


            prev = t;
        }



        //For handling of constants
        if(!queue.isEmpty()){

        String temp_val ="";
        while(!queue.isEmpty()){
            char c = queue.removeFirst();
            temp_val = temp_val + c;
        }

            if(temp_val.contains("+")){
                temp_val = temp_val.replace("+","");
                coefficient = Integer.parseInt(temp_val);
            }else if(temp_val.contains("-")){
                temp_val = temp_val.replace("-","");
                coefficient = Integer.parseInt(temp_val);
                coefficient = coefficient *-1;
            }


            degree = 0;
            hashMap.put(degree, coefficient);


        }


       // hashMap.entrySet().forEach(entry -> System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue()));

        Long answer = 0l;

        for(Map.Entry entry : hashMap.entrySet()){
            int cff = (int)entry.getValue();
            int deg = (int)entry.getKey();
            long value = 1;

            while(deg>0){
                value = value * val;
                deg--;
            }
            value = value * cff;
            answer = answer + value;

        }

        System.out.println("Answer is :" + answer);
    }
}
