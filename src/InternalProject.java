public class InternalProject extends Project {
    public static final int LIFETIME = 1;

    public InternalProject(
        String name, TitularTeacher director, double budget, Teacher... collaborators
    ) {
        super(name, director, budget, LIFETIME);
    }

    public InternalProject(
        String name, TitularTeacher director, TitularTeacher codirector, double budget
    ) {
        super(name, director, codirector, budget, LIFETIME);
    }
}
