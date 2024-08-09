import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeedProjectTest {
    @Test
    public void Given_SeedProjectAndMoreThanFiveInvestigators_When_ProjectAskForValidation_Then_ItIsNotAccepted() {
        Institution institution = new Institution("EPN");
        TitularTeacher lucas = new TitularTeacher("Lucas");
        TitularTeacher edwin = new TitularTeacher("Edwin");
        OccasionalTeacher david = new OccasionalTeacher("David");

        institution.addProject(
            new SeedProject(
                "Project 1",
                lucas,
                edwin,
                4000.00
            )
        );

        try {
            institution.addProject(
                new SeedProject(
                    "Project 2",
                    lucas,
                    edwin,
                    4000.00,
                    new OccasionalTeacher("A"),
                    new OccasionalTeacher("B"),
                    new OccasionalTeacher("C"),
                    new OccasionalTeacher("D")
                )
            );
        } catch (ExceedCollaboratorsException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(1, institution.getProjects().size());
    }
}
