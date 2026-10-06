import com.sun.source.doctree.EscapeTree;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.Scanner;

void main() {

    final String nameFigure[] = {"king", "queen", "rook", "bishop", "knight", "pawn", "elephant"};
    final String nameFigureRus[] = {"король", "ферзь", "ладья", "слон", "конь", "пешка", "слон животное"};
    final String nameColor[] = {"black", "white"};
    final String nameColorRus[] = {"черный", "белый"};
    final String nameForce[] = {"strong", "weak", "middle"};
    final String nameForceRus[] = {"сильный", "слабый", "средний"};
    int nFigure = 0;


//задать массив фигур с помощью RND не получилось, переменная figures становится непонятной компилятору.
    /*Scanner scan = new Scanner(System.in);
      while ((nFigure < 1) || (nFigure > 32)) {
        System.out.println("Введите количество фигур на поле от 1 до 32: ");
         Scanner scanner = new Scanner(System.in);
         nFigure = scan.nextInt();
     }
    //ChessFigure[] figures;
          for (int i = 0; i < nFigure; i++) {
          int randomInRangeFigure = ThreadLocalRandom.current().nextInt(1, nameFigure.length)-1;  // от min до max включительно
          System.out.println("номер случайной фигуры" + randomInRangeFigure);
          int randomInRangeColor = ThreadLocalRandom.current().nextInt(1, nameColor.length+1)-1;  // от min до max включительно. Странно работает RND. при границах 0..1 выдает только черный цвет, а в первом случае вызывает переполнение индекс коиличества фигур
          System.out.println("номер случайного цвета" + randomInRangeColor);
          ChessFigure figures= new ChessFigure(nameFigure[randomInRangeFigure], nameColor[randomInRangeColor]);
          }
*/

    ChessFigure[] figures = {
           new ChessFigure("pawn", "white"),
           new ChessFigure("pawn", "white"),
           new ChessFigure("pawn", "white"),
           new ChessFigure("pawn", "white"),
           new ChessFigure("knight", "white"),
           new ChessFigure("knight", "white"),
           new ChessFigure("king", "white"),
           new ChessFigure("king", "black"),
           new ChessFigure("queen", "white"),
           new ChessFigure("queen", "black"),
           new ChessFigure("knight", "white"),
           new ChessFigure("rook", "white"),
           new ChessFigure("rook", "black"),
           new ChessFigure("pawn", "black"),
           new ChessFigure("pawn", "black"),
           new ChessFigure("pawn", "black"),
           new ChessFigure("pawn", "black"),
           new ChessFigure("pawn", "black"),
           new ChessFigure("bishop", "black"),
           new ChessFigure("bishop", "black"),
           new ChessFigure("bishop", "white"),
           new ChessFigure("bishop", "white") };




    for (int i=0; i < nameForce.length; i++) {
        System.out.println("Количество фигур с характеристикой " + nameForceRus[i]+ " : " + sumByForce(figures, nameForce[i]));
    }

    for (int i=0; i<nameColor.length; i++)
    {
    System.out.println("Количество фигур с цветом " + nameColorRus[i] + " : " + sumByColor(figures, nameColor[i]));
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
    //if ChessFigureName=nameFigure[0]

switch (ChessFigureName) {
        case "pawn":
               ff= f3; // не получается прочитать из массива констант nameForce[1];
                break;
        case "king":
                ff=f3;// не получается прочитать из массива констант nameForce[1];
                break;
        case "rook":
                ff=f1; // не получается прочитать из массива констант nameForce[0];
                break;
        case "queen":
                ff=f1; // не получается прочитать из массива констант nameForce[0];
                break;
        case "knight":
                ff=f2; // не получается прочитать из массива констант nameForce[2];
                break;
        case "bishop":
                ff=f2; // не получается прочитать из массива констант nameForce[2];
                break;
    }
    return ff;
}
