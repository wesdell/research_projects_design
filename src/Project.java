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
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        TitularTeacher projectCodirector, double projectBudget, int projectLifetime
    ) {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        codirector = projectCodirector;
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        TitularTeacher projectCodirector, double projectBudget,
        int projectLifetime, Teacher[] projectCollaborators
    ) throws ExceedCollaboratorsException {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        codirector = projectCodirector;
        collaborators.addAll(List.of(projectCollaborators));
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

    @Override
    public String toString() {
        return name;
    }

    public abstract int getMaxCollaborators();
}
