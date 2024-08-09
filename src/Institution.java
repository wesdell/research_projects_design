import java.util.ArrayList;

public class Institution {
    private final String name;
    private final ArrayList<Project> projects;

    public Institution(String institutionName) {
        name = institutionName;
        projects = new ArrayList<>();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Project> getProjectsInConflict() {
        ArrayList<Project> projectsInConflict = new ArrayList<>();
        for (Project project : projects) {
            if (project.isInConflict()) {
                projectsInConflict.add(project);
            }
        }
        return projectsInConflict;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public ArrayList<Project> orderProjectsInConflictByBudget() {
        projects.sort(new ProjectByBudgetComparator());
        return projects;
    }

    @Override
    public String toString() {
        return name;
    }
}
