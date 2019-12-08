public class Adult extends Human implements Telling {

    @Override
    void move(Place place, Place.Entry entry) {
        System.out.println(getName() + " идет на локацию " + place.getName() + " через " + entry.getName());
        this.place = place;
    }

    @Override
     public void sniff(String smthng) {
        if(smthng != null && !smthng.equals("перец")){
            System.out.println(name + " чует " + smthng + "!");
        }
        else if(smthng.equals("перец")) {
            System.out.println(name + " чует " + smthng + "!");
            setCond(Condition.SNEEZE);
            showCond();
        }
        else {
            System.out.println(name + " ничего не чует");
        }
    }

    public void tell(String phrase){
        System.out.println(name + ": \"" + phrase + "\"");
    }
    public void think(String phrase){
        System.out.println(name + "(про себя): \"" + phrase + "\"");
    }

    void whistle(Actor[] actors){
        System.out.println(name + " свистит");
        for(Actor actor : actors) {
            if(!actor.equals(this) && place.equals(actor.getPlace())) {
                actor.setCond(Condition.NEGATIVE); //свист раздражает всех на локации
                actor.showCond();
            }
        }
    }

    public Adult(String name, int age, Gender gender, Place place) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.place = place;
            this.noOfObjects++;
            System.out.println("Создан взрослый человек по имени " + name + " с возрастом " + age + " гендера " +
                    gender + " находящийся в месте " + place.getName());
        }
    }
    public Adult(String name, int age, Gender gender) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.noOfObjects++;
            System.out.println("Создан взрослый человек по имени " + name + " с возрастом " + age + " гендера " + gender);
        }
    }
    public Adult(String name, Gender gender) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.gender = gender;
            this.noOfObjects++;
            System.out.println("Создан взрослый человек по имени " + name + " гендера " + gender);
        }
    }
    public Adult() {
        this.noOfObjects++;
        System.out.println("Создан безликий взрослый человек");
    }
}
