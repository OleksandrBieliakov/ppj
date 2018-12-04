package someTasks;

public
    class Task12 {

    public static void main(String[] args){
        //problem1();
        //problem2();
        problem3();
    }

    public static  void problem3(){
        int[] arr = {1, 2, 3, 4, 5};

        int tmp = arr[0];
        for(int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = tmp;
    }


    public static void problem2(){
        int[] arr = {1, 5, 8, 2, 6};

        int maxValueIndex = 0;
        for( int i=1; i<arr.length - 1; i++){
            if( arr[maxValueIndex] < arr[i])
                maxValueIndex = i;
        }

        int maxValue = arr[maxValueIndex];
        for(int i = maxValue; i > 0; i--){
            for(int j=0; j<arr.length; j++){
                System.out.print(
                    i <= arr[j] ? "*" : " "
                );
            }
            System.out.println();
        }

    }


    public static void problem1(){
        int[] arr = new int[10];

        for( int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*10);
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        int firstOddIndex = -1,
            lastEvenIndex = -1;

        int i = 0;
        while(i<arr.length && firstOddIndex != -1) {
            if (arr[i] % 2 != 0) {
                firstOddIndex = i;
            }
            i++;
        }

        i = arr.length-1;
        while(i>= 0 && lastEvenIndex != -1) {
            if (arr[i] % 2 == 0) {
                lastEvenIndex = i;
            }
            i--;
        }

        if( firstOddIndex == -1 || lastEvenIndex == -1){
            System.out.println("Problem");
        }else{
            int tmp = arr[firstOddIndex];
            arr[firstOddIndex] = arr[lastEvenIndex];
            arr[lastEvenIndex] = tmp;
        }

    }

    public static void showIntArray(int[] arr){
        for( int i=0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    public static void fillIntArray(int[] arr, int range){
        for( int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*range);
        }
    }
}
