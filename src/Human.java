import java.util.Objects;

abstract class Human extends Actor{
    int age;
    Gender gender;
    Place place;
    static int noOfObjects = 0;

    abstract void move(Place place, Place.Entry entry);

    @Override
    void interact(String smthng,String discr) {
        System.out.println(name + " взаимодействует с " + smthng + "(" + discr + ")");
    }

    @Override
    void interact(Actor smthng, String discr) {
        System.out.println(name + " взаимодействует с " + smthng.getName() + "(" + discr + ")");
    }

    @Override
    void inspectPlace(){
        System.out.println(name + " осматривает место " + place.getName());
        setCond(Condition.INTERESTED);
        showCond();
        if(place.getDescription() != null) System.out.println(name + " получает информацию о месте: " + place.getDescription());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", place=" + place +
                ", cond=" + cond +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                getName().equals(human.getName()) &&
                getGender() == human.getGender() &&
                Objects.equals(getPlace(), human.getPlace()) &&
                getCond() == human.getCond();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGender(), getPlace(), getCond());
    }

    //getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Place getPlace() {
        return place;
    }
    public Gender getGender() {
        return gender;
    }
    public Condition getCond() {
        return cond;
    }
    public int getNoOfObjects() {return  noOfObjects; }
    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
        else throw new IncorrectAgeException("Возраст должен быть положительным");
    }
    public void setPlace(Place place) {
        this.place = place;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setCond(Condition cond) {
        this.cond = cond;
    }

}
