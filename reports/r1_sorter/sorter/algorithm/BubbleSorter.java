package sorter.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

/**
 * バブルソートを実行するソート器のクラスです。
 * @author H.I.
 */
public class BubbleSorter<T> implements ISorter<T> {
    /**
     * コンストラクターです。
     */
    public BubbleSorter() {
    }

    /**
     * 配列をソートするメソッドです。
     *
     * @param items ソート対象となるオブジェクトの配列です。
     * @param evalFunc ソート時の数値の大小比較に用いるデータを取得する高階関数です。
     *
     * @return ソート結果のデータ配列
     */
    @Override
    public ArrayList<T> sort(ArrayList<T> items, Function<T, String> evalFunc) {
        int last = items.size() - 1;
        for (int ii = 0; ii < last; ii++) {
            for(int jj = last; jj > ii; jj--) {
                String lhs = evalFunc.apply(items.get(jj-1));
                String rhs = evalFunc.apply(items.get(jj));
                if (lhs.compareTo(rhs) > 0) {
                    Collections.swap(items, jj-1, jj);
                }
            }
        }
        return items;
    }
}
