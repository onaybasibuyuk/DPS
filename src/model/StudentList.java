package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Collection;
import java.util.Iterator;

public class StudentList implements Collection<Student> {
    private JsonArray studentList;

    public StudentList(JsonArray studentList) {
        this.studentList = studentList;
    }

    @Override
    public int size() {
        return studentList.size();
    }

    @Override
    public boolean isEmpty() {
        return studentList.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Student))
            return false;

        for (JsonElement obj : studentList) {
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());
            if (s.equals(o))
                return true;
        }

        return false;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(studentList);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            JsonObject obj = studentList.get(i).getAsJsonObject();
            array[i] = Student.StudentSerializer.toStudent(obj);
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size())
            throw new ArrayIndexOutOfBoundsException(a.length + " < " + size());

        for (int i = 0; i < size(); i++) {
            JsonObject obj = studentList.get(i).getAsJsonObject();
            a[i] = (T) Student.StudentSerializer.toStudent(obj);
        }

        return a;
    }

    @Override
    public boolean add(Student student) {
        try {
            studentList.add(Student.StudentSerializer.toJSON(student));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Student))
            return false;

        for (int i = 0; i < size(); i++) {
            JsonElement obj = studentList.get(i);
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());

            if (s.equals(o)) {
                studentList.remove(i);
                return true;
            }
        }

        return false;
    }

    public Student get(int id) {
        for (JsonElement obj : studentList) {
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());
            if (s.getId() == id)
                return s;
        }

        return null; // Not Found!
    }

    public Student get(String name) {
        for (JsonElement obj : studentList) {
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());
            if (s.getName().equals(name))
                return s;
        }

        return null; // Not Found!
    }

    public void setPayment(int id, boolean payment) {
        for (JsonElement obj : studentList) {
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());
            if (s.getId() == id)
                s.setPayment(payment);
        }
    }

    public void setPayment(String name, boolean payment) {
        for (JsonElement obj : studentList) {
            Student s = Student.StudentSerializer.toStudent(obj.getAsJsonObject());
            if (s.getName().equals(name))
                s.setPayment(payment);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll is not implemented!");
    }

    @Override
    public boolean addAll(Collection<? extends Student> c) {
        throw new UnsupportedOperationException("addAll is not implemented!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll is not implemented!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll is not implemented!");
    }

    @Override
    public void clear() {
        studentList = new JsonArray();
    }
}
