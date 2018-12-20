package model;

import com.google.gson.JsonObject;

public class Student {
    private int id;
    private String name;
    private int age;
    private String homeCity;
    private boolean payment;

    private Student(int id, String name, int age, String homeCity, boolean payment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.homeCity = homeCity;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public boolean isPayment() {
        return payment;
    }

    public JsonObject setPayment(boolean payment) {
        this.payment = payment;
        return StudentSerializer.toJSON(this);
    }

    public static class StudentSerializer {
        public static JsonObject toJSON(Student student) {
            JsonObject object = new JsonObject();
            object.addProperty("ID", student.id);
            object.addProperty("Name", student.name);
            object.addProperty("Age", student.age);
            object.addProperty("HomeCity", student.homeCity);
            object.addProperty("Payment", student.payment);

            return object;
        }

        public static Student toStudent(JsonObject object) {
            int id = object.get("ID").getAsInt();
            String name = object.get("Name").getAsString();
            int age = object.get("Age").getAsInt();
            String homeCity = object.get("HomeCity").getAsString();
            boolean payment = object.get("Payment").getAsBoolean();

            return new Student(id, name, age, homeCity, payment);
        }
    }
}
