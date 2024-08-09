import java.util.Comparator;

public class ProjectByBudgetComparator implements Comparator<Project> {
    @Override
    public int compare(Project firstProject, Project secondProject) {
        return (int) (secondProject.getBudget() - firstProject.getBudget());
    }
}
