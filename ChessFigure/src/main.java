import com.sun.source.doctree.EscapeTree;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Scanner;

public class Const{
    public static final String nameFigure[] ={"king", "queen", "rook", "bishop", "knight", "pawn", "elephant"};
    public static final String nameFigureRus[] = {"король", "ферзь", "ладья", "слон", "конь", "пешка", "слон животное"};
    public static final String nameColor[] = {"black", "white"};
    public static final String nameColorRus[] = {"черный", "белый"};
    public static final String nameForce[] = {"strong", "weak", "middle"};
    public static final String nameForceRus[] = {"сильный", "слабый", "средний"};
}

void main() {

       int nFigure = 0;

//задать массив фигур с помощью RND не получилось, переменная figures становится непонятной компилятору.

    Scanner scan = new Scanner(System.in);
      while ((nFigure < 1) || (nFigure > 32)) {
        System.out.println("Введите количество фигур на поле от 1 до 32: ");
         Scanner scanner = new Scanner(System.in);
         nFigure = scan.nextInt();
     }
    ChessFigure[] figures;
    figures = new ChessFigure[nFigure];

          for (int i = 0; i < nFigure; i++) {
          int randomInRangeFigure = ThreadLocalRandom.current().nextInt(1, Const.nameFigure.length)-1;  // от min до max включительно
          int randomInRangeColor = ThreadLocalRandom.current().nextInt(1, Const.nameColor.length+1)-1;  // от min до max включительно. Странно работает RND. при границах 0..1 выдает только черный цвет, а в первом случае вызывает переполнение индекс коиличества фигур
          figures[i] = new ChessFigure(Const.nameFigure[randomInRangeFigure], Const.nameColor[randomInRangeColor]);
          }

    for (int i=0; i < Const.nameForce.length; i++) {
        System.out.println("Количество фигур с характеристикой " + Const.nameForceRus[i]+ " : " + sumByForce(figures, Const.nameForce[i]));
    }

    for (int i=0; i<Const.nameColor.length; i++)
    {
    System.out.println("Количество фигур с цветом " + Const.nameColorRus[i] + " : " + sumByColor(figures, Const.nameColor[i]));
    }
}

            static int sumByColor(ChessFigure[] figures, String color){
            int qn=0; //инициализация
            for (ChessFigure cf: figures) {
                if (cf.color.equalsIgnoreCase(color))
                qn++;
            }
                return qn;

}
            static double percentByColor(ChessFigure[] figures, String color){
                    return (double) sumByColor(figures, color) / figures.length * 100;
        }

            static int sumByForce(ChessFigure[] figures, String force) {
              int qn = 0;
                int i = 0;
              for (i = 0; i < figures.length; i++) {

                  if (forceFigure(figures[i].name).equalsIgnoreCase(force))
                    {
                        qn++;
                    }
                }
              return qn;
            }

static String forceFigure(String ChessFigureName) {
    String f1 ="strong";
    String f2 ="middle";
    String f3 ="weak";

    String ff="undefined"; //значение по умолчанию для сила фигуры

switch (ChessFigureName) {
        case "pawn":
               ff= Const.nameForce[1];
                break;
        case "king":
                ff=Const.nameForce[1];;
                break;
        case "rook":
                ff=Const.nameForce[0];;
                break;
        case "queen":
                ff=Const.nameForce[0];;
                break;
        case "knight":
                ff=Const.nameForce[2];;
                break;
        case "bishop":
                ff=Const.nameForce[2];;
                break;
    }
    return ff;
}
