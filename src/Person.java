public class Person {
    public static int getMaxAge_s() {
        return MAX_AGE;
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public static void setMaxAge(int maxAge) {
        MAX_AGE = maxAge;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String name;
    private int age;
    private int weight;
    private String gender;
    private final int MIN_AGE = 0;
    private static int MAX_AGE = 150;


    public Person(String name, int age, int weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public Person()
    {
        name = "";
        age = 0;
        weight = 0;
        gender = "";
    }

    public void grow()
    {
        age ++;
    }

    public void LosingWeight(int x)
    {
        weight -= x;
    }
}
