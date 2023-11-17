package com.ozcanarpaci.stepdefinitions;

import com.ozcanarpaci.base.HttpClient;
import com.ozcanarpaci.utilites.CommonMethods;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class MovieComparisonSteps {

    private Response response;
    private String movieImdbID;
    private String sherlockImdb;
    private String sherlockActors;
    private String theHobbitImdb;
    private String theHobbitActors;
    private String theShawshankMovieImdb;
    private String theShawshankMovieActors;
    private String conAirMovieImdb;
    private String conAirMovieActors;
    HashMap<String, Object> map = new HashMap<>();


    @When("Set movieImdbID to ratingValueSearch in the movies file")
    public void setMoviesFileRatingValueSearchMovieImdbID() {
        //CommonMethods.setMoviesFileRatingValueSearchMovieImdbID(movieImdbID);
        movieImdbID = response.jsonPath().getString("Search[2].imdbID");
    }


    @Then("Verify {string} for movie with {string} the response path")
    public void verifyMovieInTheResponse(String expected, String responsePath) {
        response = HttpClient.get(map);
        Assertions.assertEquals(expected, response.jsonPath().getString(responsePath));
    }

    @Then("status {int}")
    public void verifyResponseStatus(int statusCode) {
        CommonMethods.verifyStatusCode(response, statusCode);
    }

    @When("Send GET method request for The Batman movie ımdbIDSearch")
    public void sendGETRequestImdbIDSearch() {

        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("ımdbIDSearch", "apikey"));
        map.put("s", CommonMethods.getMovieInfoFromMovieJson("ımdbIDSearch", "s"));
        response = HttpClient.get(map);
    }

    @When("Send GET method request for sherlockSeries")
    public void sendGETRequestISherlockSeries() {
        map.clear();
        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("sherlockSeries", "apikey"));
        map.put("t", CommonMethods.getMovieInfoFromMovieJson("sherlockSeries", "t"));
        response = HttpClient.get(map);
        sherlockImdb = response.jsonPath().getString("imdbRating");
        sherlockActors = response.jsonPath().getString("Actors");

    }

    @When("Send GET method request for ratingValueSearch")
    public void sendGETRequestRatingValueSearch() {
        map.clear();
        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("ratingValueSearch", "apikey"));
        map.put("i", movieImdbID);
        response = HttpClient.get(map);

    }

    @When("Send GET method request for theHobbitMovie")
    public void sendGETRequestTheHobbitMovie() {

        map.clear();
        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("theHobbitMovie", "apikey"));
        map.put("t", CommonMethods.getMovieInfoFromMovieJson("theHobbitMovie", "t"));
        response = HttpClient.get(map);
        theHobbitImdb = response.jsonPath().getString("imdbRating");
        theHobbitActors = response.jsonPath().getString("Actors");
    }

    @When("Send GET method request for theShawshankMovie")
    public void sendGETRequestTheShawshankMovie() {

        map.clear();
        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("theShawshankMovie", "apikey"));
        map.put("t", CommonMethods.getMovieInfoFromMovieJson("theShawshankMovie", "t"));
        response = HttpClient.get(map);
        theShawshankMovieImdb = response.jsonPath().getString("imdbRating");
        theShawshankMovieActors = response.jsonPath().getString("Actors");
    }

    @When("Send GET method request for conAirMovie")
    public void sendGETRequestConAirMovie() {

        map.clear();
        map.put("apikey", CommonMethods.getMovieInfoFromMovieJson("conAirMovie", "apikey"));
        map.put("t", CommonMethods.getMovieInfoFromMovieJson("conAirMovie", "t"));
        response = HttpClient.get(map);
        conAirMovieImdb = response.jsonPath().getString("imdbRating");
        conAirMovieActors = response.jsonPath().getString("Actors");
    }

    @Then("Compare sherlockSeries imdbRating values of theHobbitMovie")
    public void compareSherlockSeriesToTheHobbitMovie() {
        CommonMethods.compareString(Double.parseDouble(sherlockImdb), Double.parseDouble(theHobbitImdb));
    }

    @Then("Compare theShawshankMovie imdbRating values of conAirMovie")
    public void compareTheShawshankMovieToConAirMovie() {
        CommonMethods.compareString(Double.parseDouble(theShawshankMovieImdb), Double.parseDouble(conAirMovieImdb));
    }

    @Then("Verify sherlockActors actors contains theHobbitActors actors")
    public void containsSherlockActorsActorsToTheHobbitActors() {
        Assertions.assertTrue(!CommonMethods.containsControl(sherlockActors, theHobbitActors).isEmpty(),
                "The actors in the same movies :" +CommonMethods.containsControl(sherlockActors, theHobbitActors));
    }

    @Then("Verify theShawshankActors actors contains conAirActors actors")
    public void containsTheShawshankActorsActorsToConAirActors() {
        Assertions.assertTrue(!CommonMethods.containsControl(theShawshankMovieActors, conAirMovieActors).isEmpty(),
                "The actors in the same movies : "+CommonMethods.containsControl(theShawshankMovieActors, conAirMovieActors));
    }

}



