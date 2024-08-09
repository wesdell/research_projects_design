public abstract class Teacher {
    private final String name;
    private int dedicationHours;

    public Teacher(String teacherName) {
        name = teacherName;
        dedicationHours = 0;
    }

    public void setDedicationHours(int newDedicationHours) {
        dedicationHours += newDedicationHours;
    }

    public boolean exceedsNumberOfHours() {
        return dedicationHours > getMaxNumberOfDedicationHours();
    }

    @Override
    public String toString() {
        return name;
    }

    protected abstract int getMaxNumberOfDedicationHours();
}
