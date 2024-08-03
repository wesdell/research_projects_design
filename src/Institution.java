import java.util.ArrayList;

public class Institution {
    private final String name;
    private ArrayList<Project> projects;

    public Institution(String institutionName) {
        name = institutionName;
        projects = new ArrayList<>();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }


    public void addProject(Project project) {
        projects.add(project);
    }

    @Override
    public String toString() {
        return name;
    }
}
