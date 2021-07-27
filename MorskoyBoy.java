import java.util.Random;

public class MorskoyBoy {
    private static int SIZE = 10;
    static int[][] matrix = new int[SIZE][SIZE];
    public static void main(String args[]) {
    }
    static int rand(int a) {
        Random random = new Random();
        return random.nextInt(a);
    }
    static boolean addShip(int raz) {
        int orientation, x, y;
        do {
            orientation = rand(2);
            x = rand(SIZE);
            y = rand(SIZE);
        } while (!checkBusyShip(x, y, orientation, raz));
        placeShip(x, y, orientation, raz);
        return true;
    }
    static boolean checkBusyShip(int x, int y, int orientation, int raz) {
        if (orientation == 1) {
            for (int i = x; i < x + raz; i++) {
                if (i >= SIZE || matrix[x][i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean placeShip(int x, int y, int orientation, int raz) {
        if(orientation==0) {


            int xStart = x - 1;
            if (xStart < 0) {
                xStart = xStart + 1;
            }
            int xEnd = x + raz + 1;
            if (xEnd >= SIZE) {
                xEnd = xEnd - 1;
            }

            for (int i = xStart; i < xEnd; i = i + 1) {
                int yCurr = y - 1;
                if (yCurr < 0) {
                    yCurr = yCurr + 1;
                }
                matrix[i][yCurr] = 2;

                yCurr = y + 1;
                if (yCurr >= SIZE) {
                    yCurr = yCurr - 1;
                }
                matrix[i][yCurr] = 2;
            }

            matrix[xStart][y] = 2;
            matrix[xEnd][y] = 2;

            for (int i = x; i < x + raz; i = i + 1) {
                matrix[i][y] = 1;
            }

        }
        if (orientation==1) {
            int yStart = y-1;
            if (yStart < 0){
                yStart = yStart + 1;
            }
            int yEnd = y+raz+1;
            if (yEnd>=SIZE){
                yEnd=yEnd-1;

            }
            for (int j = yStart; j<yEnd; j++){
                int xCurr=x-1;
                if (xCurr<0){
                    xCurr = xCurr+1;
                }
                matrix[j][xCurr] = 2;
            }
            matrix[x][yStart] = 2;
            matrix[x][yEnd] = 2;
            for (int p = y; p<y+raz; p++){
                matrix[x][p] = 1;
            }

        }
        return true;
    }
    static boolean ifshootsuceed(int x, int y){
        boolean flag;
        if(matrix[x][y]==1){
            flag = true;
            aftershootmapchange(x,y);
        }
        else {
            flag = false;
            aftershootmapchange(x, y);
        }
        return flag;
    }
    static boolean aftershootmapchange (int x, int y) {
        if (matrix[x][y]==1){
            matrix[x][y]=4;
        }
        if (matrix[x][y]==0||matrix[x][y]==2){
            matrix[x][y]=3;
        }
        return true;
    }
    static boolean proverka (int x, int y){
        return true;
    }
}
/*1)Написать игроку, что его ход
2)x = getInt(SIZE,.....)
y = getInt(SIZE,.....)
3)Запуск shoot(x,y)
4)if (shoot(x,y)-true){
....}
else{...}
 */
