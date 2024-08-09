import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultidisciplinaryProjectTest {
    @Test
    public void Given_MultidisciplinaryProjectAndMoreThanEightInvestigators_When_ProjectAskForValidation_Then_ItIsNotAccepted() {
        Institution institution = new Institution("EPN");
        TitularTeacher lucas = new TitularTeacher("Lucas");
        TitularTeacher edwin = new TitularTeacher("Edwin");

        institution.addProject(
            new MultidisciplinaryProject(
                "Project 1",
                lucas,
                edwin,
                4000.00
            )
        );

        try {
            institution.addProject(
                new MultidisciplinaryProject(
                    "Project 2",
                    lucas,
                    edwin,
                    4000.00,
                    new OccasionalTeacher("A"),
                    new OccasionalTeacher("B"),
                    new OccasionalTeacher("C"),
                    new OccasionalTeacher("D"),
                    new OccasionalTeacher("E"),
                    new OccasionalTeacher("F"),
                    new OccasionalTeacher("G"),
                    new OccasionalTeacher("H")
                )
            );
        } catch (ExceedCollaboratorsException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(1, institution.getProjects().size());
    }
}
