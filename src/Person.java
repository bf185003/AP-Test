public class Person {
    private String name;
    private int age;
    private int weight;
    private String gender;

    private final int MIN_AGE = 0;//注意final的属性，要么在定义的时候赋值，要么在构造函数中定义，一旦构造好了，其他函数就不能改值了。
    public static int MAX_AGE = 150;

    //constructor构造函数，和类同名，无返回值
    public Person()
    {
        name = "";
        age = 0;
        weight = 0;
        gender = "";
    }
    //
    public Person(String name, int age, int weight, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public String toString(){
        return "name:" + name + " age:" + age;
    }

    public static int getMaxAge_s() {return MAX_AGE;}

    public int getMaxAge() {return MAX_AGE;}

    public static void setMaxAge(int maxAge) {MAX_AGE = maxAge;}

    public String getName() {return name;}

    public int getAge() {return age;}

    public int getWeight() {return weight;}

    public String getGender() {return gender;}

    public void setName(String name) {this.name = name;}

    public void setAge(int age) {this.age = age;}

    public void setWeight(int weight) {this.weight = weight;}

    public void setGender(String gender) { this.gender = gender;}


    public void grow()
    {
        age ++;
    }

    public void LosingWeight(int x)
    {
        weight -= x;
    }
}
