package FunctionTest;

import Function.Function;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;
import static java.lang.Double.NaN;

import java.util.HashMap;
import java.util.Map;

public class FunctionTest extends Assert {
   //Максимальное отклонение сотая
   private final double DELTA = 0.015;
   private HashMap<Double, Double> testValues = new HashMap<>();


   @Before
   public void init(){
      //Проверяем ноль
      testValues.put(0d,0d);

       //Проверяем от 0 до PI/2
       testValues.put(PI/6, sqrt(3)/3);
       testValues.put(PI/4, 1d);
       testValues.put(PI/3, sqrt(3));

       //Проверяем от -PI/2 до 0
       testValues.put(-PI/6, -sqrt(3)/3);
       testValues.put(-PI/4, -1d);
       testValues.put(-PI/3, -sqrt(3));

       //Проверяем границы (не определено)
       testValues.put(PI/2, NaN);
       testValues.put(-PI/2, NaN);
   }

   @After
   public void dead(){
        testValues.clear();
   }

   @Test
   public void testTan(){
        double fact, expected;
       System.out.println("Вывод информации");
       for (Map.Entry<Double, Double> entry :
               testValues.entrySet()) {
           expected = entry.getValue();
           fact = Function.tg(entry.getKey());
           System.out.println("x = " + entry.getKey() + "; " + "Ожидается: " + expected + "; Де-факто: " + fact);
           assertEquals(expected,fact,DELTA);
       }
   }

}
