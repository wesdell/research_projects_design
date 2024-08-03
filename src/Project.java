public abstract class Project {
    private final String name;
    private final TitularTeacher director;
    private final double budget;
    private final Teacher[] collaborators;

    public Project(
        String projectName, TitularTeacher projectDirector, double projectBudget,
        Teacher... projectCollaborators
    ) {
        name = projectName;
        director = projectDirector;
        budget = projectBudget;
        collaborators = projectCollaborators;
    }
}
