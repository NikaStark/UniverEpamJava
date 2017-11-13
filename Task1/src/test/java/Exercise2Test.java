import org.junit.Test;

import static org.junit.Assert.fail;

public class Exercise2Test {

    @Test
    public void testSplitVector() throws Exception {
        for (int i = 0; i < 10; i++) {
            testSplitVectorOnce();
        }
    }

    public void testSplitVectorOnce() throws Exception {
        int length = (int) (Math.random() * 100 + 1);
        int[] vector = Util.generatedVector(length);

        Exercise2.splitVector(vector);

        int i = 0;
        while ((i != vector.length) && (vector[i] >= 0)) i++;

        while (i < vector.length) {
            if (vector[i] >= 0) {
                fail("fail!");
            }
            i++;
        }
    }

}