import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testLambda1();
        testLambda2();
    }

    public static void testLambda1(){
        {
            List<String> movies = new ArrayList<>();

            movies.add("The Godfather 1-3");

            //old-scool way
            for (int i = 0; i < movies.size(); i++){
                System.out.println(movies.get(i));
            }
            System.out.println("----------------------------");

            //lambda
            movies.forEach((element) ->
            {
                System.out.println(element);
                System.out.println(element);


            });


        }
    }

    public static void testLambda2(){


        // new school
        new Thread(() -> {
            System.out.println("Printing form Lambda....");
            System.out.println("Test two");


        }).start();

        //old school
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing form anonymous inner class....");
                System.out.println("Test two");

            }
        });



    }


}