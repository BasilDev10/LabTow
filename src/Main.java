import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        QuestionOne();
        QuestionTwo();
        QuestionThree();
        QuestionFour();
        QuestionFive();
        QuestionSix();
        QuestionSeven();
        QuestionEight();

    }

    public static void QuestionOne(){
        Scanner input = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        String userInput = "";
        do {
            System.out.println("Enter text or type out to exit: ");
            userInput = input.nextLine();
            if(userInput.equals("out")){
                break;
            }
            text.add(userInput);
        }while(true);


        System.out.println("All word : "+text+"\nLargest words :"+ findAllLargestWords(text));
    }
    public static ArrayList<String> findAllLargestWords(ArrayList<String> text){
        ArrayList<String> largestWords = new ArrayList<>();

        for (String word : text){
            if(largestWords.isEmpty() || word.length() > largestWords.get(0).length()){
                largestWords.clear();
                largestWords.add(word);
            }else if(word.length() == largestWords.get(0).length()){
                largestWords.add(word);
            }
        }

        return largestWords;
    }
    public static void QuestionTwo(){
        int [] numbers = {1,1,1,3,3,5};
        Scanner input = new Scanner(System.in);
        String userInput = "";


        do {
            System.out.println("Enter number or type out to exit: ");
            userInput = input.nextLine();
            if(userInput.equals("out")){
                break;
            }

            System.out.println(Arrays.toString(numbers)+"\n"+ userInput +" occurrence "+checkOccurrence(numbers, Integer.parseInt(userInput))+" times");
        }while(true);

    }
    public static int checkOccurrence(int [] numbers , int checkNumber){

        int countOccurrence = 0;

        for(int item : numbers){
            if(item == checkNumber){
                countOccurrence++;
            }
        }
        return countOccurrence;
    }
    public static void QuestionThree(){
        int [] numbers = {1,4,17,7,25,3,100};
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number :");
        int userInput = input.nextInt();
        ArrayList<Integer> largestNumber = new ArrayList<>();

        System.out.println("All numbers : "+Arrays.toString(numbers) );
        int largestNumberElement = 0;
        for(int i =0;i < userInput;i++){
            largestNumberElement = largestByOrder(numbers);
            largestNumber.add(largestNumberElement);
            numbers = removeElement(numbers,largestNumberElement);

        }

        System.out.println("Largest number : "+largestNumber);


    }
    public static int largestByOrder(int [] numbers){
        int largest = 0;
        for (Integer number : numbers){
            if(number > largest){
                largest = number;
            }
        }
        return largest;
    }
    public static int [] removeElement(int [] array, int element){
        int [] newArray = new int[array.length-1];

        int k= 0;
        for (int i = 0; i < array.length-1; i++){
            if(array[i] == element){
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }
    public static void QuestionFour(){

        int [] numbers = {5,4,3,2,1};
        int arrlength = numbers.length-1;
        int swapNumber1 =0;
        int swapNumber2 =0;
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < (numbers.length/2); i++){

            swapNumber1 = numbers[i];
            swapNumber2 = numbers[arrlength];

            numbers[i] = swapNumber2;
            numbers[arrlength] = swapNumber1;
            arrlength--;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void QuestionFive(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        String [] menuArray = new String[input.nextInt()];


        String userInputMenu = "";
        int addIndex = 0;

        String searchElement = "";
        boolean found = false;
        boolean exit = false;

        do{
            System.out.println("Enter number menu to make action \n1- Add element \n2- Display elements \n3- Search element \n4- Sort array \n5- Exit");

            userInputMenu = input.next();
            switch (userInputMenu){
                case "1":
                    if(addIndex < menuArray.length ){
                        System.out.println("Enter new element : ");
                        menuArray[addIndex] = input.next();
                        addIndex++;

                    }else{
                        System.out.println("Array is full you entered the maximum length of array");
                    }
                    break;
                    case "2":
                        System.out.println("Display elements : \n"+Arrays.toString(menuArray));
                        break;
                        case "3":
                            System.out.println("Enter search element : ");
                            searchElement = input.next();
                            for (String item : menuArray){
                                if(item.equals(searchElement)){
                                    System.out.println("Found the search element : "+ item);
                                    found = true;
                                    break;
                                }
                                found = false;
                            }
                            if(found == false){
                                System.out.println("Element not found");
                            }
                            break;
                            case "4":
                                Arrays.sort(menuArray);
                                System.out.println("Sort array : \n"+Arrays.toString(menuArray));
                                break;
                                case "5":
                                    System.out.println("Exit");
                                    exit = true;
                                    break;
                                    default:
                                        System.out.println("Invalid menu");
                                        break;
            }
            if (exit == true){
                break;
            }



        }while (true);

    }

    public static void QuestionSix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the minimum number of the range : ");
        int min = input.nextInt();
        System.out.println("Enter the maximum number of the range : ");
        int max = input.nextInt();
        System.out.println("Enter the number of random numbers to generate : ");
        int numRandom = input.nextInt();

        String strRandom = "";
        for (int i = 0; i < numRandom; i++){
            if (i == 0){
                strRandom += generateRandomNumber(min, max);
            }else strRandom += " - "+ generateRandomNumber(min, max);
        }

        System.out.println("Random numbers : "+strRandom);
    }
    public static int generateRandomNumber(int min, int max){
        return (int)(Math.random() * (max - min) + (min+1));
    }
    public static void QuestionSeven(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter password :");
        String password = input.nextLine();

        int scorePoint = checkLength(password)+checkSpicalCharacter(password)+checkUpperLowerCase(password);
        if(scorePoint < 5){
            System.out.println("You password is weak");
        }else if(scorePoint < 7 && scorePoint >= 5){
            System.out.println("You password is moderately");
        }else System.out.println("You password is Strong");

    }
    public static int checkLength(String password){
        if(password.length() >= 0 && password.length() <= 5){

            return 0;
        }else if(password.length() > 5 && password.length() <= 7){

            return 2;
        }else{
            return 3;
        }
    }
    public static int checkSpicalCharacter(String password){

        boolean found = false;
       for (int i = 0; i < password.length(); i++){
           if(!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))  ){

               found = true;
               break;
           }
       }
       if(found == false){
           return 0;
       }else{
           return 2;
       }
    }

    public static int checkUpperLowerCase(String password){
        int countUpper = 0;
        int countLower = 0;
        for (int i = 0; i < password.length(); i++){

            if(!Character.isLetter(password.charAt(i)))continue;

            if (Character.isUpperCase(password.charAt(i))){

                countUpper++;
            }
            if (Character.isLowerCase(password.charAt(i))){
                countLower++;
            }
            if(countUpper > 0 && countLower > 0){
                break;
            }
        }
        if(countUpper > 0 && countLower > 0){
            return 3;
        }else return 0;
    }
    public static void QuestionEight(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of Fibonacci terms to generate : ");
        int numFibonacci = input.nextInt();

        System.out.println(Arrays.toString(getFibonacciSequence(numFibonacci)));

    }
    public static int[] getFibonacciSequence(int numFibonacci){
        int[] fibonacciSequence = new int[numFibonacci];
        for (int i = 1; i < numFibonacci; i++){
            if (i == 1){
                fibonacciSequence[i] = 1;
            }else{
                fibonacciSequence[i] = fibonacciSequence[i-1] + fibonacciSequence[i-2];
            }
        }

        return fibonacciSequence;
    }
}