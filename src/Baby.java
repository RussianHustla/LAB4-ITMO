public class Baby extends Human {
    private String favoriteColor;

    @Override
    void move(Place place, Place.Entry entry) {
        System.out.println(getName() + " ползет на локацию " + place.getName() + " через " + entry.getName());
        this.place = place;
    }

    @Override
    public void sniff(String smthng) {
        if(smthng != null && smthng != "перец"){
            System.out.println(name + " чует " + smthng + "!");
        }
        else if(smthng == "перец") {
            System.out.println(name + " чует " + smthng + "!");
            setCond(Condition.SNEEZE);
            showCond();
            setCond(Condition.CRY);
            showCond();
        }
        else {
            System.out.println(name + " ничего не чует");
        }
    }

    void sleep() {
        System.out.println(getName() + " Спит");
    }
    void fingersuck() {
        System.out.println(getName() + " Сосет палец");
    }

    public Baby(String name, int age, Gender gender, Place place, String favoriteColor) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.place = place;
            this.favoriteColor = favoriteColor;
            this.noOfObjects++;
            System.out.println("Создан ребенок по имени " + name + " с возрастом " + age + " гендера " + gender + " находящийся в месте " + place.getName() + "любимый цвет которого " + favoriteColor);
        }
    }
    public Baby(String name, int age, Gender gender, Place place) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.place = place;
            this.noOfObjects++;
            System.out.println("Создан ребенок по имени " + name + " с возрастом " + age + " гендера " + gender +
                    " находящийся в месте " + place.getName());
        }
    }
    public Baby(String name, int age, Gender gender) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.noOfObjects++;
            System.out.println("Создан ребенок по имени " + name + " с возрастом " + age + " гендера " + gender);
        }
    }
    public Baby(String name) {
        this.name = name;
        this.noOfObjects++;
        System.out.println("Создан ребенок по имени " + name);
    }
    public Baby() {
        this.noOfObjects++;
        System.out.println("Создан безликий ребенок");
    }
    //getters
    public String getFavoriteColor() {
        return favoriteColor;
    }
    //setters
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

}
