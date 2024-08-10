public class InternalProject extends Project {
    private static final int MAX_COLLABORATORS = 2;
    private static final int LIFETIME = 1;
    private static final int DEDICATION_HOURS = 4;

    public InternalProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget
    ) {
        super(name, director, codirector, budget, LIFETIME);
    }

    public InternalProject(
        String name, TitularTeacher director, double budget
    ) {
        super(name, director, budget, LIFETIME);
    }

    public InternalProject(
        String name, TitularTeacher director, TitularTeacher codirector,
        double budget, Teacher... collaborators
    ) throws ExceedCollaboratorsException {
        super(name, director, codirector, budget, LIFETIME, collaborators);
    }

    @Override
    public int getMaxCollaborators() {
        return MAX_COLLABORATORS;
    }

    @Override
    protected int getDedicationHours() {
        return DEDICATION_HOURS;
    }
}
