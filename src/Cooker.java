import static java.lang.Math.random;

public class Cooker extends Human implements Telling{
    private Grade grade;
    private String lastDish = null;
    private boolean isHandsClean = false;

    @Override
    void move(Place place, Place.Entry entry) {
        System.out.println(getName() + " идет на локацию " + place.getName() + " через " + entry.getName());
        this.place = place;
    }

    @Override
    public void sniff(String smthng) {
        if(smthng != null){
            System.out.println(name + " чует " + smthng + "!");
        }
        else {
            System.out.println(name + " ничего не чует");
        }
    }

    @Override
    public void tell(String phrase){
        System.out.println(name + ": \"" + phrase + "\"");
    }

    @Override
    public void think(String phrase){
        System.out.println(name + "(про себя): \"" + phrase + "\"");
    }

    void washHands(){
        isHandsClean = true;
    }

    void petCat(Cat cat) {
        System.out.println(name + " гладит " + cat.getName());
        cat.setCond(Condition.POSITIVE);
        isHandsClean = false;
    }

    void cook(String dish, String spice, Actor[] actors) throws DirtyHandsException {
        if (isHandsClean == true) {
            System.out.println(name + " готовит " + dish);
            System.out.println("На локации " + place.getName() + " дым стоит коромыслом!");
            System.out.println(name + " добавляет " + spice + " в " + dish);
            boolean fail = false;
            if (random() > getAccuracy()) {
                System.out.println(name + " просыпает " + spice);
                tell("лять!");
                setCond(Condition.NEGATIVE);
                fail = true;
            }
            System.out.println("Блюдо " + dish + " готово!");
            lastDish = dish;
            for (Actor actor : actors) {
                if (actor.getPlace().equals(place)) {
                    actor.sniff(dish);
                    if (fail) actor.sniff(spice);
                }
            }
        }
        else {
            throw new DirtyHandsException("У повара грязные руки");
        }
    }

    void cook(String dish, Actor[] actors) throws DirtyHandsException {
        if (isHandsClean) {
            System.out.println(name + " готовит " + dish);
            System.out.println("На локации " + place.getName() + " дым стоит коромыслом!");
            System.out.println("Блюдо " + dish + " готово!");
            lastDish = dish;
            for (Actor actor : actors) {
                if (actor.getPlace().equals(place)) {
                    actor.sniff(dish);
                }
            }
        }
        else {
            throw new DirtyHandsException("У повара грязные руки");
        }
    }

    void feed(Human target, String dish) throws NonExistentFoodException {
        if (dish.equals(lastDish)) System.out.println(name + " кормит " + target.getName() + " блюдом " + dish);
        else {
            throw new NonExistentFoodException("Это блюдо еще не приготовлено");
        }
    }

    public Cooker(String name, int age, Gender gender, Grade grade, Place place) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.place = place;
            this.grade = grade;
            this.noOfObjects++;
            System.out.println("Создан повар по имени " + name + " " +
                    grade + " разряда " + " с возрастом " + age + " гендера " + gender +
                    " находящийся в месте " + place.getName());
        }
    }
    public Cooker(String name, int age, Gender gender, Grade grade) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.grade = grade;
            this.noOfObjects++;
            System.out.println("Создан повар по имени " + name + " " + grade + " разряда " +
                    " с возрастом " + age + " гендера " + gender);
        }
    }
    public Cooker(String name, int age, Gender gender) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.noOfObjects++;
            System.out.println("Создан повар по имени " + name + " с возрастом " + age + " гендера " + gender);
        }
    }
    public Cooker(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.noOfObjects++;
        System.out.println("Создан повар по имени " + name + " гендера " + gender);
    }
    public Cooker() {
        this.noOfObjects++;
        System.out.println("Создан безликий повар");
    }
    //getters
    public String getLastDish() {
        return lastDish;
    }
    public Grade getGrade() {
        return grade;
    }
    public double getAccuracy() {
        switch (grade) {
            case II: return 0.5;
            case III: return 0.65;
            case IV: return 0.72;
            case V: return 0.8;
            case VI: return 0.95;
        }
        return 0;
    }
    //setters
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
