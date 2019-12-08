public class Cheshire extends Cat implements Telling{

    @Override
    void move(Place place) {
        System.out.println(name + " идет на локацию " + place.getName());
        this.place = place;
    }

    @Override
    void meow() {
        System.out.println("Meow!");
    }
    public void sniff(String smthng) {
        if(smthng != null){
            System.out.println(name + " чует " + smthng + "!");
        }
        else {
            System.out.println(name + " ничего не чует");
        }
    }

    @Override
    void inspectPlace(){
        System.out.println(name + " осматривает место " + place.getName());
        setCond(Condition.INTERESTED);
        showCond();
        if(place.getDescription() != null) System.out.println(name + " получает информацию о месте: " +
                place.getDescription());
    }

    @Override
    void interact(String smthng,String discr) {
        System.out.println(name + " взаимодействует с " + smthng + "(" + discr + ")");
    }

    @Override
    void interact(Actor smthng, String discr) {
        System.out.println(name + " взаимодействует с " + smthng.getName() + "(" + discr + ")");
    }

    @Override
    public void tell(String phrase){
        System.out.println(name + ": \"" + phrase + "\"");
    }
    @Override
    public void think(String phrase){
        System.out.println(name + "(про себя): \"" + phrase + "\"");
    }


    void lay(){
        System.out.println(name + " лежит");
    }

    public Cheshire(String name, int age, Place place) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.place = place;
            this.cond = Condition.SMILE;
            System.out.println("Создан Чеширский Кот по имени " + name + " с возрастом " + age + " находящийся в месте "
                    + place.getName());
        }
    }
    public Cheshire(Place place) {
        this.name = "Чеширский Кот";
        this.place = place;
        this.cond = Condition.SMILE;
        System.out.println("Создан Чеширский Кот" + " находящийся в месте " + place.getName());
    }
}
