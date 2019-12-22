import java.util.Objects;

abstract class Actor implements ICondition{
    String name;
    Place place;
    Condition cond = Condition.NORMAL;

    abstract void interact(String smthng, String discr);
    abstract void interact(Actor smthng, String discr);
    abstract void inspectPlace();
    abstract void sniff(String dish);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Condition getCond() {
        return cond;
    }

    public void setCond(Condition cond) {
        this.cond = cond;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public void showCond() {
        switch (cond) {
            case CRY:
                System.out.println(name + " плачет :'(");
                break;
            case BORED:
                System.out.println(name + " скучает");
                break;
            case SMILE:
                System.out.println(name + " улыбается");
                break;
            case NORMAL:
                System.out.println(name + " в обычном состоянии");
                break;
            case NEGATIVE:
                System.out.println(name + " в негативном настроении");
                break;
            case POSITIVE:
                System.out.println(name + " в хорошем настроении");
                break;
            case INTERESTED:
                System.out.println(name + " в заинтересованном состоянии");
                break;
            case SNEEZE:
                System.out.println(name + " чихает!");
                break;
            default:
                System.out.println(name + " в неопределенном состоянии");
                break;
        }
    }
    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", place=" + place +
                ", cond=" + cond +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getName(), actor.getName()) &&
                Objects.equals(getPlace(), actor.getPlace()) &&
                getCond() == actor.getCond();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPlace(), getCond());
    }
}
