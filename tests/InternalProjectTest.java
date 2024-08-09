import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InternalProjectTest {
    @Test
    public void Given_ProjectAndDirector_When_ProjectAskForValidation_Then_ItIsAccepted() {
        Institution institution = new Institution("EPN");
        TitularTeacher lucas = new TitularTeacher("Lucas");

        institution.addProject(
            new InternalProject(
                "Project 1",
                lucas,
                5000.00
            )
        );

        assertEquals(1, institution.getProjects().size());
    }

    @Test
    public void Given_ProjectDirectorAndCodirector_When_ProjectAskForValidation_Then_ItIsAccepted() {
        Institution institution = new Institution("EPN");
        TitularTeacher lucas = new TitularTeacher("Lucas");
        TitularTeacher edwin = new TitularTeacher("Edwin");

        institution.addProject(
            new InternalProject(
                "Project 1",
                lucas,
                edwin,
                5000.00
            )
        );

        assertEquals(1, institution.getProjects().size());
    }

    @Test
    public void Given_InternalProjectAndMoreThanTwoInvestigators_When_ProjectAskForValidation_Then_ItIsNotAccepted() {
        Institution institution = new Institution("EPN");
        TitularTeacher lucas = new TitularTeacher("Lucas");
        TitularTeacher edwin = new TitularTeacher("Edwin");
        OccasionalTeacher david = new OccasionalTeacher("David");

        try {
            institution.addProject(
                new InternalProject(
                    "Project 1",
                    lucas,
                    edwin,
                    5000.00,
                    david
                )
            );
        } catch (ExceedCollaboratorsException e) {
            System.out.println(e);
        }

        assertEquals(0, institution.getProjects().size());
    }
}
