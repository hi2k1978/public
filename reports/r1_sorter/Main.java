import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.function.Function;

import item.IItem; // Interface of Book
import item.Book;
import item.Cuisine;
import sorter.SorterFacade;
import sorter.SorterFactory;
import sorter.SortOrder; // Accend / Descend
import sorter.algorithm.SortAlgorithm; // ex: BubbleSort, MergeSort(no impl), ...

/**
 * Mainは、ソートプログラムのメインクラスです。
 * @author H.I.
 */
public class Main {
    /**
     * 全てのソート対象オブジェクトに格納されたデータを出力するメソッドです。<br/>
     * @param prefix データ出力のプレフィックスです。
     * @param items オブジェクトTの配列です。
     */
    public static <T extends IItem> void printData(String prefix, ArrayList<T> items) {
        System.out.println(prefix + ": n=" + items.size());
        items.forEach((item) -> item.printData());
        System.out.println("");        
    }
        
    /**
     * メインメソッドです。<br/>
     * オブジェクトの配列データを作成し、ソート結果を出力します。<br/>
     * 本のソートは、(1)本のタイトルを昇順、(2)本の出版年月日を降順の2パターン実行します。
     * 料理のソートは、(1)料理名を昇順、(2)料理の代表国を降順の2パターン実行します。
     *
     * @param args 引数(未使用)
     */
    public static void main(String[] args) {
        try {
            // ソートに用いる配列データの作成
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
            ArrayList<Book> books = new ArrayList<>();
            books.add(new Book("finnegans wake", dateFormatter.parse("1939/05/04")));
            books.add(new Book("no longer human", dateFormatter.parse("1948/07/25")));
            books.add(new Book("santai", dateFormatter.parse("2019/07/04")));;
            books.add(new Book("licoris recoil", dateFormatter.parse("2022/07/01")));
            books.add(new Book("parasyte", dateFormatter.parse("1990/01/01")));;
            books.add(new Book("dogra magra", dateFormatter.parse("1935/01/01")));
            books.add(new Book("devil mountain", dateFormatter.parse("1924/11/01")));;
            books.add(new Book("madaremu jien", dateFormatter.parse("1990/05/25")));;

            printData("[sort:unsort]", books);
            
            // ソート器の作成
            SorterFactory<Book> bookSorterFactory = new SorterFactory<>();
            SorterFacade<Book> bookSorterFacade = new SorterFacade<>(bookSorterFactory);
            // 1. ソートの実行:タイトル昇順
            ArrayList<Book> sortedBooks1 = bookSorterFacade.sort(books, SortAlgorithm.BubbleSort, SortOrder.Accend, (book) -> book.getTitle());
            printData("[sort:title] accend",sortedBooks1);
            // 2. ソートの実行:出版年月日降順
            // ※ 出版年月日は、文字列比較によりソートされる(本来はDateオブジェクト同士の比較であるべき)。
            ArrayList<Book> sortedBooks2 = bookSorterFacade.sort(books, SortAlgorithm.BubbleSort, SortOrder.Descend, (book) -> book.getDate());
            printData("[sort:date] descend", sortedBooks2);
                
            // ソートに用いる配列データの作成
            ArrayList<Cuisine> cuisines = new ArrayList<>();
            cuisines.add(new Cuisine("sushi", "Japan"));
            cuisines.add(new Cuisine("star gazer pie", "England"));
            cuisines.add(new Cuisine("asado", "Argentina"));
            cuisines.add(new Cuisine("kimuchi", "Korea"));
            cuisines.add(new Cuisine("tacos", "Mexico"));
            cuisines.add(new Cuisine("mapo tofu", "China"));
            cuisines.add(new Cuisine("ratatouille", "France"));
            cuisines.add(new Cuisine("pizza", "Italy"));

            printData("[sort:unsort]", cuisines);

            // ソート器の作成
            SorterFactory<Cuisine> cuisineSorterFactory = new SorterFactory<>();
            SorterFacade<Cuisine> cuisineSorterFacade = new SorterFacade<>(cuisineSorterFactory);
            // 1. ソートの実行:料理名昇順
            ArrayList<Cuisine> sortedCuisines1 = cuisineSorterFacade.sort(cuisines, SortAlgorithm.BubbleSort, SortOrder.Accend, (cuisine) -> cuisine.getName());
            printData("[sort:name] accend", sortedCuisines1);
            // 2. ソートの実行:代表国降順
            ArrayList<Cuisine> sortedCuisines2 = cuisineSorterFacade.sort(cuisines, SortAlgorithm.BubbleSort, SortOrder.Descend, (cuisine) -> cuisine.getCountry());
            printData("[sort:country] descend", sortedCuisines2);
            
        } catch(ParseException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

