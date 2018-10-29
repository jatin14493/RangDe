package RangDe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  [[1], 2, [[3, 4], 5], [[[]]], [[[6]]], 7, 8, []]

public class ListOfLists {

    public static void main(String[] args) {

        List<Object> main = new ArrayList();

        List <Object>a = new ArrayList();
        a.add(1);

        List<Object> b = new ArrayList(Arrays.asList(3,4));
        List <Object>c = new ArrayList();
        List d = new ArrayList();
        List<List<Object>> e = Arrays.asList(d);
        List<List<List<Object>>> f =(Arrays.asList(e));

        //Creating List of Lists
        c.add(b);
        c.add(5);
        d.add(6);
        main.add(a);
        main.add(2);
        main.add(c);
        main.add(e);
        main.add(f);
        String abc = main.toString();


        abc = abc.replace("[" , "");
        abc = abc.replace("]" , "");
        abc = abc.replace("," , "");
        String[] str = abc.split(" ");

        List<Object> result = new ArrayList<>(str.length);

        for(int i=0; i<str.length; i++)
            result.add(str[i]);

        System.out.println(result);


    }


}
