package BootcampDioListaCircular;

public class Main {

    public static void main(String[] args) {

        ListaCircular<Integer> l1 = new ListaCircular<>();
        l1.add(1);
        System.out.println(l1);
        System.out.println("____________________________");

        l1.remove(0);
        System.out.println(l1);
        System.out.println("____________________________");

        l1.add(1);
        l1.add(2);
        l1.add(3);
        System.out.println(l1);

        l1.add(4);
        System.out.println(l1);
        System.out.println("____________________________");

        l1.remove(2);
        System.out.println(l1);
        System.out.println("____________________________");





    }
}