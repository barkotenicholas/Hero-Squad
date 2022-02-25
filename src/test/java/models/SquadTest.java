package models;

import org.junit.jupiter.api.AfterEach;
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

    @Test
    @DisplayName("check if all squad returns")
    public void allSquadMembersReturns_true(){
        Squad dc = new Squad("dc",7,"evil");
        assertEquals(2,Squad.getAll().size());
    }

    @Test
    @DisplayName("check if all squad  contains a squad")
    public void allSquadContainSquad_true(){

        Squad dc = new Squad("dc",7,"evil");
        assertTrue(Squad.getAll().contains(dc));
        assertTrue(Squad.getAll().contains(squad));
    }

    @AfterEach
    void afterEach() {
        Squad.clearAll();
    }
}