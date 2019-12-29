package ru.tropin;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import ru.tropin.transfer.BugCreationDto;
import ru.tropin.model.Bug;
import static org.junit.Assert.assertEquals;

public class BugDtoTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkBugCreation() {
        BugCreationDto bugCreationDto = new BugCreationDto();
        bugCreationDto.setTitle("title_val");
        bugCreationDto.setDescription("description_val");

        Bug bug = modelMapper.map(bugCreationDto, Bug.class);

        assertEquals(bugCreationDto.getTitle(), bug.getTitle());
        assertEquals(bugCreationDto.getDescription(), bug.getDescription());
        assertEquals(bugCreationDto.getProject(), bug.getProject());
    }


}
