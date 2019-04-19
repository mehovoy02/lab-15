import java.util.ArrayList;
public class Matrix {
    private char[] z = {1059,1076,1086,1074,1077,1085,1082,1086,32,1055,1069,45,49,55,49};
    private ArrayList<ArrayList<Float>>  m =  new ArrayList<ArrayList<Float>>();
    private int row;
    private int col;
    private int max;
    private int min;

    Matrix(int rows, int columns, int max_element, int min_element){
        this.row =  rows;
        this.col =  columns;
        this.max = max_element;
        this.min = min_element;
        System.out.println("Исходная матрица:\n");
        for(int r =  0; r <  row; r++) {
            ArrayList<Float> rr =  new ArrayList<>();
            for( int c =  0; c <  col; c++) {
                rr.add((float) (Math.random() *  ++ max) +  min);
            }
            m.add(rr);
            System.out.print(rr + "\n");
        }
    }

    void set_item_value(int x, int y, Float value) {
        ArrayList<Float> r = m.get(y);
        r.set(x, value);
        m.set(y,r);
    }

    Float get_item_value(int x, int y) {
        return m.get(y).get(x);
    }

    ArrayList<ArrayList<Float>> get_matrix() {
        ArrayList<Float> g = new ArrayList<>();
        for (int y = 0, x = 0; y < row; y++, x++) {
            g.add(get_item_value(x, y));
        }
        for(char c: z){
            System.out.print(c);
        } System.out.print("\n");
        System.out.println("Главная диагональ: " + g + "\n");
        float g_sum = 0;
        for (float f: g) {
            g_sum += f;
        }
        float g_sz = g_sum/g.size();
        for(char c: z){
            System.out.print(c);
        } System.out.print("\n");
        System.out.println("Среднее значение элементов главной диагонали: " + g_sz + "\n");

        ArrayList<Float> p = new ArrayList<>();
        for (int y = 0, x = col - 1; y < row; y++, x--) {
            p.add(get_item_value(x, y));
        }
        for(char c: z){
            System.out.print(c);
        } System.out.print("\n");
        System.out.println("Побочная диагональ: " + p + "\n");
        float p_sum = 0;
        for (float f: p) {
            p_sum += f;
        }
        float p_sz = p_sum/p.size();
        for(char c: z){
            System.out.print(c);
        } System.out.print("\n");
        System.out.println("Среднее значение элементов побочной диагонали: " + p_sz + "\n");
        int i = row / 2;
        int y = (row - 1) - i;
        int j = col / 2;
        int x = (col - 1) - j;
        if (g_sz > p_sz) {
            set_item_value(x,y,g_sz);
        } else {
            set_item_value(x,y,p_sz);
        }
        return m;
    }
}
