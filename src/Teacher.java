public abstract class Teacher {
    private final String name;

    public Teacher(String teacherName) {
        name = teacherName;
    }

    @Override
    public String toString() {
        return name;
    }
}
