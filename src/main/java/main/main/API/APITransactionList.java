package main.main.API;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APITransactionList {
    public String url;
    private List<String> countryFromList = new ArrayList<>();
    private List<String> countryToList = new ArrayList<>();
    private List<String> cityFromList = new ArrayList<>();
    private List<String> cityToList = new ArrayList<>();
    private List<String> postalCodeFromList = new ArrayList<>();
    private List<String> postalCodeToList = new ArrayList<>();

    public APITransactionList(String country_From, String country_To, String city_From, String city_to) {
        url = "https://ttrans.eu/pl/transport/from-" + country_From + "-" + city_From + "/to-" + country_To + "-" + city_to + "/cur_page/1/count/60/";
    }

    public void getTransaction() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements country = doc.getElementsByClass("trans-offer-list-country");
        Elements city = doc.getElementsByClass("trans-offer-list-locality");
        Elements postalCode = doc.getElementsByClass("trans-offer-list-postal-code");
        for (int i = 1; i < country.size(); i = i + 2) {
            countryFromList.add(country.get(i - 1).text());
            countryToList.add(country.get(i).text());
            cityFromList.add(city.get(i - 1).text());
            cityToList.add(city.get(i).text());
            postalCodeFromList.add(postalCode.get(i - 1).text());
            postalCodeToList.add(postalCode.get(i).text());
//            System.out.println("Miejsce załadunku: "+country.get(i-1).text() + " " + city.get(i-1).text() + " " + postalCode.get(i-1).text()
//            + " Miejsce rozładunku: " +country.get(i).text() + " " + city.get(i).text() + " " + postalCode.get(i).text() ) ;
        }
    }

    public List<String> getCountryFromList() {
        return countryFromList;
    }

    public List<String> getCountryToList() {
        return countryToList;
    }

    public List<String> getCityFromList() {
        return cityFromList;
    }

    public List<String> getCityToList() {
        return cityToList;
    }

    public List<String> getPostalCodeFromList() {
        return postalCodeFromList;
    }

    public List<String> getPostalCodeToList() {
        return postalCodeToList;
    }
}
