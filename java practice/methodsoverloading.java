class methodoverloading
{
    public static int add(int a, int b) {
        return a + b;
        }
        int a = 10;
        int b = 20;
        int c = 30;
        public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        methodoverloading obj = new methodoverloading();
        System.out.println("Sum of two numbers: " + obj.add(10, 20));
        System.out.println("Sum of three numbers: " + add(10, 20, 30)); 
        System.out.println("Sum of two numbers: " + obj.add(10, 20));
}
}
