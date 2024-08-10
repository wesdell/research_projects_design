public class SeedProject extends Project {
    private static final int MAX_COLLABORATORS = 5;
    private static final int LIFETIME = 2;
    private static final int DEDICATION_HOURS = 6;

    public SeedProject(
        String name, TitularTeacher director, double budget
    ) {
        super(name, director, budget, LIFETIME);
    }

    public SeedProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget
    ) {
        super(name, director, codirector, budget, LIFETIME);
    }

    public SeedProject(
        String name, TitularTeacher director, double budget,
        Teacher... collaborators
    ) throws ExceedCollaboratorsException {
        super(name, director, budget, LIFETIME, collaborators);
    }

    public SeedProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget,
        Teacher... collaborators
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
