public class MultidisciplinaryProject extends Project {
    private static final int LIFETIME = 3;
    private static final int MAX_COLLABORATORS = 8;
    private static final int DEDICATION_HOURS = 8;

    public MultidisciplinaryProject(
        String name, TitularTeacher director, double budget
    ) {
        super(name, director, budget, LIFETIME);
    }

    public MultidisciplinaryProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget
    ) {
        super(name, director, codirector, budget, LIFETIME);
    }

    public MultidisciplinaryProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget,
        Teacher... collaborators
    ) throws ExceedCollaboratorsException {
        super(name, director, codirector, budget, LIFETIME, collaborators);
    }

    public MultidisciplinaryProject(
        String name, TitularTeacher director, double budget, Teacher... collaborators
    ) throws ExceedCollaboratorsException {
        super(name, director, budget, LIFETIME, collaborators);
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
