package sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

import sorter.algorithm.ISorter; // Interface of BubbleSorter, ...
import sorter.algorithm.BubbleSorter;
import sorter.algorithm.SortAlgorithm;

/**
 * ソートのFACADEクラスです。<br/>
 * @author H.I.
 */
public class SorterFacade <T> {
    /**
       ソートアルゴリズムのFactoryです。
     */
    private final SorterFactory<T> sorterFactory;

    /**
     * コンストラクターです。
     *
     * @param sortAlgorithmFactory ソートアルゴリズムのFactory
     */
    public SorterFacade(SorterFactory<T> sorterFactory) {
        this.sorterFactory = sorterFactory;
    }
    
    /*
     * 配列をソートするメソッドです。<br/>
     * 引数に、ソートアルゴリズムを指定します。<br/>
     * 引数に、ソートの昇順/降順を指定します。
     *
     * @param items ソート対象となるオブジェクトの配列です。
     * @param sortAlgorithm ソートアルゴリズムです。
     * @param sortOrder ソートの昇順/降順設定です。
     * @param evalFunc ソート時の数値の大小比較に用いるデータを取得する高階関数です。
     *
     * @return ソート結果のデータ配列
     *
     * @exception Exception 適合するソートアルゴリズムがFactoryで生成できない場合、送出されます。
     */
    public ArrayList<T> sort(ArrayList<T> items, SortAlgorithm sortAlgorithm, SortOrder sortOrder, Function<T, String> evalFunc) throws Exception {

        // ソート対象となるオブジェクトの配列
        ArrayList<T> nItems = new ArrayList<>(items); // copy: non-destructive
        
        // ソートアルゴリズムを選択し、ソートを実行
        ISorter<T> sorter = this.sorterFactory.create(sortAlgorithm);
        ArrayList<T> sortedItems = sorter.sort(nItems, evalFunc);

        // 降順設定の場合、ソートしたデータを降順に再ソート
        if (sortOrder == SortOrder.Descend) {
            Collections.reverse(sortedItems);
        }
        return sortedItems;
    }
}
