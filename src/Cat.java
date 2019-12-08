abstract class Cat extends Actor{
    int age;
    Place place;

    //getters

    public int getAge() {
        return age;
    }

    public Condition getCond() {
        return cond;
    }
    @Override
    public Place getPlace() {
        return place;
    }

    //setters

    public void setCond(Condition cond) {
        this.cond = cond;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    abstract void move(Place place);
    abstract void meow();

}
