package Function;

import org.apache.commons.math3.fraction.BigFraction;
import java.math.BigInteger;
import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class Function {

    public Function() {
    }

    public static double tg(double x){
        if (abs(x) < Math.PI / 2) {

            double result = 0;
            int bernoulli;

            for (int k = 1; k < 7; k++) {
                bernoulli = 2 * k;
                result += abs(bernoulli(bernoulli))
                        * ((pow(2, 2 * k) * (pow(2, 2 * k) - 1)) / fact(2 * k))
                        * pow(x, 2 * k - 1);
            }
            return result;
        } else {
            return Double.NaN;
        }
    }

    private static int fact(int x){
        if (x <= 1) return 1;
        else return x * (fact(x - 1));
    }

    private static double bernoulli(int n){
        BigFraction result = BigFraction.ZERO;
        for (int k = 0; k <= n; k++) {
            BigFraction jSum = BigFraction.ZERO;
            BigInteger bInt = BigInteger.ONE;
            for (int j = 0; j <= k; j++) {
                BigInteger jPownN = (new BigInteger("" + j)).pow(n);
                if (j % 2 == 0){
                    jSum = jSum.add(bInt.multiply(jPownN));
                } else {
                    jSum = jSum.subtract(bInt.multiply(jPownN));
                }

                /*
                update binomual(k,j) recirsively
                 */
                bInt = bInt.multiply(new BigInteger("" + (k - j))).
                        divide(new BigInteger("" + (j + 1)));
            }
            result = result.add(jSum.divide(new BigInteger("" + (k + 1))));
        }
        return result.doubleValue();
    }
}
