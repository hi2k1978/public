package item;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Bookは、本の情報を格納するクラスです。<br/>
 * このオブジェクトの配列が、ソート対象になります。
 * @author H.I.
 */
public class Book implements IItem {
    private final String title;
    private final Date date;

    /**
     * コンストラクターです。<br/>
     * @param title 本のタイトルです。
     * @param date 本の出版年月日です。
     */
    public Book(String title, Date date) {
        this.title = title;
        this.date = date;
    }
    /**
     * 本のタイトルを出力するメソッドです。
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 本の出版年月日を出力するメソッドです。
     */
    public String getDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormatter.format(this.date);
    }

    /**
     * 本の全データを出力するメソッドです。
     */
    @Override
    public void printData() {
        System.out.printf("[Book] title: %-15s\tdate: %-20s\n", this.getTitle(), this.getDate());
    }
}
