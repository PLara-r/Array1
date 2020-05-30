import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
          numbers[i] = i + 5;
        System.out.println (numbers[5]);


        int[] numbers1 = { 6, 9, 1 };
        Arrays.sort(numbers1);
        for (int i = 0; i < numbers1.length; i++)
            System.out.println (numbers1[i] +  " ");



    }}
