Feature: OMDBWS


  @theBatman
  Scenario: The Batman Movie
    #The Batman IMDBI
    When Send GET method request for The Batman movie ımdbIDSearch
    Then status 200
    * Verify "The Batman" for movie with "Search[2].Title" the response path
    * Verify "2022" for movie with "Search[2].Year" the response path
    * Verify "tt1877830" for movie with "Search[2].imdbID" the response path
    * Verify "movie" for movie with "Search[2].Type" the response path
    #Rotten Tomatoes Rating Value
    * Set movieImdbID to ratingValueSearch in the movies file
    When Send GET method request for ratingValueSearch
    Then status 200
    * Verify "85%" for movie with "Ratings[1].Value" the response path

  @SherlockandTheHobbit
  Scenario: Movie and Series Match
    #Sherlock Series
    When Send GET method request for sherlockSeries
    Then status 200
    * Verify "9.1" for movie with "imdbRating" the response path

    #The Hobbit: The Battle of the Five Armies Movie
    When Send GET method request for theHobbitMovie
    Then status 200
    * Verify "7.4" for movie with "imdbRating" the response path
    #Karşılaştırma
    * Compare sherlockSeries imdbRating values of theHobbitMovie
    * Verify sherlockActors actors contains theHobbitActors actors


  @ShawshankandConAir
  Scenario: Movie and Movie Match
    #The Shawshank Movie
    When Send GET method request for theShawshankMovie
    Then status 200
    * Verify "1994" for movie with "Year" the response path

    #Con Air Movie
    When Send GET method request for conAirMovie
    Then status 200
    * Verify "1997" for movie with "Year" the response path
    Then status 200
    #Karşılaştırma
    * Compare theShawshankMovie imdbRating values of conAirMovie
    * Verify theShawshankActors actors contains conAirActors actors
