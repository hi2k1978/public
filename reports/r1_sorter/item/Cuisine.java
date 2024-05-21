package item;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cuisineは、各国の料理の情報を格納するクラスです。<br/>
 * このオブジェクトの配列が、ソート対象になります。
 * @author H.I.
 */
public class Cuisine implements IItem {
    private final String name;
    private final String country;

    /**
     * コンストラクターです。<br/>
     * @param name 料理名です。
     * @param country 料理の代表国です。
     */
    public Cuisine(String name, String country) {
        this.name = name;
        this.country = country;
    }
    /**
     * 料理名を出力するメソッドです。
     */
    public String getName() {
        return this.name;
    }

    /**
     * 料理の代表国を出力するメソッドです。
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 料理の全データを出力するメソッドです。
     */
    @Override
    public void printData() {
        System.out.printf("[Cuisine] name: %-15s\tcountry: %-20s\n", this.getName(), this.getCountry());
    }
}

