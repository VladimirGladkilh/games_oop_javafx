package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = false;
        boolean diag = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];

            if (predicate.test(cell)) {
                if (monoHorizontal(predicate, startX) || monoVertical(predicate, startY)) {
                    result = true;
                    break;
                }

            }else {
                diag = false;
            }
            System.out.println(result + " " + diag);
            startX += deltaX;
            startY += deltaY;
        }
        return result || diag;
    }
    public  boolean monoHorizontal(Predicate<Figure3T> predicate, int row) {
        boolean result = true;
        for (int i = 0; i < this.table.length; i++) {
            Figure3T cell = this.table[row][i];
            result = predicate.test(cell);
            if (!result) {
                break;
            }
        }
        return result;
    }

    public boolean monoVertical(Predicate<Figure3T> predicate, int column) {
        boolean result = true;
        for (int i = 0; i < this.table.length; i++) {
            Figure3T cell = this.table[i][column];
            result = predicate.test(cell);
            if (!result) {
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {

        boolean r2 =         this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ;
        boolean r = this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0);
        boolean r1 =         this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1) ;
        boolean r3 =         this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
        return r|| r1||r2||r3;
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0) ||
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                Figure3T cell = this.table[i][j];
                if (cell.isClean()) {
                    return true;
                }
            }
        }
        return false;
    }
}
