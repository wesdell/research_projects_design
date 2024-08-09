public class OccasionalTeacher extends Teacher {
    private static final int MAX_NUMBER_DEDICATION_HOURS = 10;

    public OccasionalTeacher(String teacherName) {
        super(teacherName);
    }

    @Override
    protected int getMaxNumberOfDedicationHours() {
        return MAX_NUMBER_DEDICATION_HOURS;
    }
}
