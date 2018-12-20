package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.Iterator;

public class StudentIterator implements Iterator<Student> {
    private Iterator<JsonElement> iterator;

    public StudentIterator(JsonArray students) {
        this.iterator = students.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Student next() {
        return Student.StudentSerializer.toStudent(iterator.next().getAsJsonObject());
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
