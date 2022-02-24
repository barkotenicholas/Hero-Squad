package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    Squad squad;

    @BeforeEach
    public void setUp(){
        squad = new Squad();
    }

    @Test
    @DisplayName("Squad instantiates correctly")
    public void newSquadObjectsGetCreated_true(){
        assertNotNull(squad);
    }

}