package ru.job4j;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        assertThat(bishopBlack.position(), is(Cell.C7));
    }
    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.copy(Cell.A2).position(), is(Cell.A2));
    }
    @Test
    public void  wayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell[] validWay = new Cell[]{Cell.D7, Cell.E6, Cell.F5, Cell.G4};
        assertThat(bishopBlack.way(bishopBlack.position(), Cell.G4), is(validWay));
    }
    @Test
    public void  wayBackTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G4);
        Cell[] validWay = new Cell[]{Cell.F5, Cell.E6, Cell.D7, Cell.C8};
        assertThat(bishopBlack.way(bishopBlack.position(), Cell.C8), is(validWay));
    }
}
