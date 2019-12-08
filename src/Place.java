public class Place {
    private String name;
    private String description;

    public Place(String name, String description) {
        this.name = name;
        this.description = description;
        System.out.println("Создана локация " + name + ", описание: " + description);
    }

    public Place(String name) {
        this.name = name;
        System.out.println("Создана локация " + name);
    }

    //getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setters

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    // вложенный класс, представляющий вход в локацию
    public class Entry {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Entry(String name) {
            this.name = name;
            System.out.println("В локацию " + Place.this.getName() + " ведет " + name);
        }
    }
}
