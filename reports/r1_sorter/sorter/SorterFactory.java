package sorter;

import java.lang.Exception;
import sorter.algorithm.ISorter; // Interface of BubbleSorter, ...
import sorter.algorithm.BubbleSorter;
import sorter.algorithm.SortAlgorithm;

/**
   ソート器のFactoryクラスです。
*/
public class SorterFactory <T> {
    /**
     * コンストラクターです。
     */
    public SorterFactory() {
    }

    /**
     * 引数に指定したソートアルゴリズムをもとに、ソート器を生成するメソッドです。<br/>
     *
     * @param sortAlgorithm ソートアルゴリズム
     *
     * @return ソート器
     *
     * @exception Exception 適合するソートアルゴリズムがない場合、送出されます。通常時、起こりえない異常です。
     */
    public ISorter<T> create(SortAlgorithm sortAlgorithm) throws Exception {
        
        switch (sortAlgorithm) {
        case BubbleSort:
            return new BubbleSorter<T>();
        default:
            throw new Exception("invalid switch case: no sorting algorithm is selected.");
        }
    }
}
