import com.gmail.erin618c.ten10mod.block.RPSGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSGameTests {

    @Test
    void playGameReturnsYWhenPlayerWins() {
        assertEquals('y', RPSGame.playGame(0, 2));
        assertEquals('y', RPSGame.playGame(1, 0));
        assertEquals('y', RPSGame.playGame(2, 1));
    }

    @Test
    void playGameReturnsNWhenPlayerLoses() {
        assertEquals('n', RPSGame.playGame(0, 1));
        assertEquals('n', RPSGame.playGame(1, 2));
        assertEquals('n', RPSGame.playGame(2, 0));
    }

    @Test
    void playGameReturnsDWhenPlayerDraws() {
        assertEquals('d', RPSGame.playGame(0, 0));
        assertEquals('d', RPSGame.playGame(1, 1));
        assertEquals('d', RPSGame.playGame(2, 2));
    }
}
