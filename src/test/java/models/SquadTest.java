package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    Squad squad;

    @BeforeEach
    public void setUp(){
        squad = new Squad("Avengers",7,"save humanity");
    }

    @Test
    @DisplayName("Squad instantiates correctly")
    public void newSquadObjectsGetCreated_true(){
        assertNotNull(squad);
    }

    @Test
    @DisplayName("Squad returns squad Name correctly")
    public void newSquadInstantiateWithName(){
        assertEquals("Avengers",squad.getName());
    }

    @Test
    @DisplayName("Squad returns squad Size successfully")
    public void newSquadInstantiatesWithSize(){
        assertEquals(7,squad.getSize());
    }

    @Test
    @DisplayName("Squad Returns squad cause")
    public void newSquadInstantiatesWithCause(){
        assertEquals("save humanity",squad.getCause());
    }

}