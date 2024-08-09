import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectRequirementsTest {
    @Test
    public void Given_TitularTeacher_When_IsOnMultipleProjects_Then_SomeProjectsMustBeInConflict() {
        Institution epn = new Institution("EPN");
        TitularTeacher carlos = new TitularTeacher("Carlos");
        TitularTeacher rambo = new TitularTeacher("Rambo");

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                5000.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                5000.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                5000.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                rambo,
                5000.00
            )
        );

        assertEquals(0, epn.getProjectsInConflict().size());
    }

    @Test
    public void Given_MultipleProjects_When_ThereAreInConflict_Then_ProjectsMustBeOrderedByHighestBudget() {
        Institution epn = new Institution("EPN");
        TitularTeacher carlos = new TitularTeacher("Carlos");

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                3250.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                4891.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                5000.00
            )
        );

        epn.addProject(
            new SeedProject(
                "Proyecto 1",
                carlos,
                3780.00
            )
        );

        assertEquals(
            5000.00,
            epn.orderProjectsInConflictByBudget().getFirst().getBudget(), 0.01
        );
    }
}
