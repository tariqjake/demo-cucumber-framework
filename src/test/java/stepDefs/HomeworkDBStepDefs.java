package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class HomeworkDBStepDefs {

    @Given("the phone number {string} should match the DB record")
    public void the_phone_number_should_match_the_DB_record(String myAnswer) {
        String first = "SELECT phone FROM address a\n" +
                "INNER JOIN customer c\n" +
                "ON a.address_id = c.address_id\n" +
                "WHERE CONCAT(c.first_name, ' ', c.last_name) = 'Pamela Baker';";
        List<Map<String, Object>> resultMap = DBUtils.getQueryResultMap(first);
        String expectedResult = resultMap.get(0).get("phone").toString();
        System.out.println(expectedResult);

    }

    @Given("the title {string} and rating {string} should match the DB record")
    public void the_title_and_rating_should_match_the_DB_record(String myTitle, String myRating) {
        String second = "SELECT title, rating\n" +
                "FROM film\n" +
                "WHERE titl*-e LIKE 'Dragon%' AND length=170;";
        List<Map<String, Object>> resultMap = DBUtils.getQueryResultMap(second);
        String expectedTitle = resultMap.get(0).get("title").toString();
        String expectedRating = resultMap.get(0).get("rating").toString();
        System.out.println("DB title: " + expectedTitle);
        System.out.println("DB rating: " + expectedRating);
        Assert.assertEquals(myTitle, expectedTitle);
        Assert.assertEquals(myRating, expectedRating);
    }

    @Given("the movie amount {string} should match the DB record")
    public void the_movie_amount_should_match_the_DB_record(String myMovieAmount) {
        String third = "SELECT COUNT(film_id) AS movie_amount\n" +
                "FROM film\n" +
                "WHERE title LIKE '%fight%' AND length > 100;";
        List<Map<String, Object>> resultMap = DBUtils.getQueryResultMap(third);

        String expectedMovAmount = resultMap.get(0).get("movie_amount").toString();
        System.out.println("expected movie amount from DB record: " + expectedMovAmount);
        Assert.assertEquals(myMovieAmount, expectedMovAmount);
    }

}
