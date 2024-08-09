public class TitularTeacher extends Teacher {
    private static final int MAX_NUMBER_DEDICATION_HOURS = 20;

    public TitularTeacher(String teacherName) {
        super(teacherName);
    }

    @Override
    protected int getMaxNumberOfDedicationHours() {
        return MAX_NUMBER_DEDICATION_HOURS;
    }
}
