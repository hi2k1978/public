package sorter.algorithm;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * ソート器のインターフェースです。
 * @author H.I.
 */
public interface ISorter<T> {
    /**
     * 配列をソートするメソッドです。
     *
     * @param items ソート対象となるオブジェクトの配列です。
     * @param evalFunc ソート時の数値の大小比較に用いるデータを取得する高階関数です。
     *
     * @return ソート結果のデータ配列
     */
    public abstract ArrayList<T> sort(ArrayList<T> items, Function<T, String> evalFunc);
}


