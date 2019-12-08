public class Main {

    public static void main(String[] args){
        //creating space

        Place Outdoor = new Place("улица","возле дома");

        Place BigKitchen = new Place("Большая кухня", "зачетная кухня, воняет только чем то...");
        Place.Entry BigKitchensdoor = BigKitchen.new Entry("дверь");
        System.out.println("_____________________");

        //creating characters

        Adult Alice = new Adult("Алиса", 12, Gender.FEMALE,Outdoor);
        Adult Doorman = new Adult("Швейцар-головастик",15,Gender.MALE,Outdoor);
        Adult Gertsoginya = new Adult("Герцогиня", 40, Gender.FEMALE,
                BigKitchen);
        Cooker Cooker = new Cooker("Повариха", 38, Gender.FEMALE, Grade.II, BigKitchen);
        Baby Baby = new Baby("Младенец", 1, Gender.MALE, BigKitchen);
        Cheshire CheshireCat = new Cheshire(BigKitchen);

        Actor[] actors = new Actor[]{Doorman,Alice,Gertsoginya,Cooker,Baby,CheshireCat};
        System.out.println("_____________________");


        //action!

        Doorman.tell("Все, что хочешь!");
        Doorman.whistle(actors);
        Alice.think("Да что с ним говорить! Это просто какой-то идиотик!");
        Alice.move(BigKitchen, BigKitchensdoor);
        Alice.inspectPlace();
        Gertsoginya.interact(Baby,"держит на коленях");
        Cooker.washHands();
        try {
            Cooker.cook("суп", "перец", actors);
        } catch (DirtyHandsException e) {
            System.err.println(e.getMessage());
            System.err.println("Необходимо помыть руки перед готовкой!");
        }
        CheshireCat.lay();
        CheshireCat.showCond();
    }
}

