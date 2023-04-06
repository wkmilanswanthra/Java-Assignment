import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String name;
    private String email;
    private int age;

    String regex = "^(.+)@(.+)$";
    Pattern pattern = Pattern.compile(regex);


    public Person() {
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches())
            throw new IllegalArgumentException("Enter a valid email");
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>150)
            throw new IllegalArgumentException("Enter a valid age");
        this.age = age;
    }
}
