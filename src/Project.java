public abstract class Project {
    private final int lifetime;
    private final double budget;
    private final String name;
    private final TitularTeacher director;
    private TitularTeacher codirector;

    public Project(
        String projectName, TitularTeacher projectDirector, double projectBudget,
        int projectLifetime
    ) {
        name = projectName;
        director = projectDirector;
        budget = projectBudget;
        lifetime = projectLifetime;
    }

    public Project(
        String projectName, TitularTeacher projectDirector,
        TitularTeacher projectCodirector, double projectBudget, int projectLifetime
    ) {
        this(projectName, projectDirector, projectBudget, projectLifetime);
        codirector = projectCodirector;
    }
}
