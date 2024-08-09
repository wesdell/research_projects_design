import java.util.ArrayList;
import java.util.List;

public abstract class Project {
    private final int lifetime;
    private final double budget;
    private final String name;
    private final TitularTeacher director;
    private TitularTeacher codirector;
    private final ArrayList<Teacher> collaborators;

    public Project(
        String projectName, TitularTeacher projectDirector, double projectBudget,
        int projectLifetime
    ) {
        name = projectName;
        director = projectDirector;
        budget = projectBudget;
        lifetime = projectLifetime;
        collaborators = new ArrayList<>();
        director.setDedicationHours(getDedicationHours());
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        TitularTeacher projectCodirector, double projectBudget, int projectLifetime
    ) {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        codirector = projectCodirector;
        codirector.setDedicationHours(getDedicationHours());
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        TitularTeacher projectCodirector, double projectBudget,
        int projectLifetime, Teacher[] projectCollaborators
    ) throws ExceedCollaboratorsException {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        codirector = projectCodirector;
        collaborators.addAll(List.of(projectCollaborators));
        codirector.setDedicationHours(getDedicationHours());
        collaborators.forEach(teacher -> teacher.setDedicationHours(getDedicationHours()));
        if (exceedMaxNumberCollaborators()) {
            throw new ExceedCollaboratorsException(
                "There are too many collaborators. Allowed: " + getMaxCollaborators()
            );
        }
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        double projectBudget, int projectLifetime, Teacher[] projectCollaborators
    ) throws ExceedCollaboratorsException {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        collaborators.addAll(List.of(projectCollaborators));
        collaborators.forEach(teacher -> teacher.setDedicationHours(getDedicationHours()));
        if (exceedMaxNumberCollaborators()) {
            throw new ExceedCollaboratorsException(
                "There are too many collaborators. Allowed: " + getMaxCollaborators()
            );
        }
    }

    private boolean exceedMaxNumberCollaborators() {
        return getInvestigators().size() > getMaxCollaborators();
    }

    public ArrayList<Teacher> getInvestigators() {
        ArrayList<Teacher> investigators = new ArrayList<>();
        investigators.add(director);
        if (codirector != null) {
            investigators.add(codirector);
        }
        if (collaborators != null) {
            investigators.addAll(collaborators);
        }
        return investigators;
    }

    public double getBudget() {
        return budget;
    }

    public boolean isInConflict() {
        for (Teacher teacher : collaborators) {
            if (teacher.exceedsNumberOfHours()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }

    protected abstract int getMaxCollaborators();

    protected abstract int getDedicationHours();
}
