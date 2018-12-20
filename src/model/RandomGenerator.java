package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RandomGenerator {
    private static int studentCounter = 0;

    public static JsonObject generate(int studentSize) {
        JsonArray students = generateStudentList(studentSize);

        return students.getAsJsonObject();
    }

    private static JsonArray generateStudentList(int studentSize) {
        JsonArray students = new JsonArray();
        for (int i = 0; i < studentSize; i++)
            students.add(generateStudent());

        return students;
    }

    private static JsonObject generateStudent() {
        // TODO Name and HomeCity will be random

        int id = studentCounter;
        int age = 18 + (int) (Math.random() * 4);
        String name = "Önay";
        String homeCity = "Malatya";
        boolean payment = false;

        JsonObject student = new JsonObject();
        student.addProperty("ID", id);
        student.addProperty("Name", name);
        student.addProperty("Age", age);
        student.addProperty("HomeCity", homeCity);
        student.addProperty("Payment", payment);

        studentCounter++;

        return student;
    }
}
