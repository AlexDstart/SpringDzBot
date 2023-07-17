package ru.skypro.lessons.springboot.weblibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.lessons.springboot.weblibrary.dto.PositionDTO;
import ru.skypro.lessons.springboot.weblibrary.model.Position;
import ru.skypro.lessons.springboot.weblibrary.repository.PositionRepository;
import ru.skypro.lessons.springboot.weblibrary.service.PositionService;
import ru.skypro.lessons.springboot.weblibrary.service.PositionServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PositionServiceImplTest {

    @Mock
    private PositionRepository positionRepositoryMock;
    private PositionService positionService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        positionService = new PositionServiceImpl(positionRepositoryMock);
    }

    @DisplayName("Тест для метода сохранения должности в БД")
    @Test
    public void testAddPosition() {

        PositionDTO positionDTO = new PositionDTO("Manager");
        positionDTO.setPositionName("Manager");

        Position mockPosition = new Position("Boss");
        mockPosition.setId(1L);
        mockPosition.setName("Manager");

        when(positionRepositoryMock.save(any(Position.class))).thenReturn(mockPosition);

        positionService.addPosition(positionDTO);

        verify(positionRepositoryMock, times(1)).save(any(Position.class));
    }

    @DisplayName("Тест метода получения всех должностей")
    @Test
    public void testGetAllPositions() {

        Position position1 = new Position("Boss");
        Position position2 = new Position("Manager");
        List<Position> positions = Arrays.asList(position1, position2);

        when(positionRepositoryMock.findAll()).thenReturn(positions);

        List<PositionDTO> result = positionService.getAllPositions();

        assertEquals(positions.size(), result.size());
        assertEquals(position1.getName(), result.get(0).getPositionName());
        assertEquals(position2.getName(), result.get(1).getPositionName());
    }
}
