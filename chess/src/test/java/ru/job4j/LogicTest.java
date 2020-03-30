package ru.job4j;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

public class LogicTest {
    @Test
    public void findFigure() {
        Cell source = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(source);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        assertThat(logic.findBy(source) > -1, is(true));
    }
    @Test
    public void wayFigure() {
        Cell source = Cell.G4;
        Cell dest = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(source);
        PawnBlack pawnBlack = new PawnBlack(Cell.C7);
        PawnWhite pawnWhite = new PawnWhite( Cell.D7);
        //Cell[] validWay = new Cell[]{Cell.F5, Cell.E6, Cell.D7, Cell.C8};
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        logic.add(pawnWhite);
        assertThat(logic.move(source, dest), is(false));
    }


    @Test
    public void wayFigureMove() {
        Cell source = Cell.G4;
        Cell dest = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(source);
        PawnBlack pawnBlack = new PawnBlack(Cell.C7);
        //Cell[] validWay = new Cell[]{Cell.F5, Cell.E6, Cell.D7, Cell.C8};
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        assertThat(logic.move(source, dest), is(true));
    }
}
