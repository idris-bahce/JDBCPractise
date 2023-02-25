Feature:  List all the movies with the most copies in store 1 in ordered by film id.

  Scenario Outline:List all the movies with the most copies in store 1 in ordered by film id.
    Given verify the values: "<title>" and "<count>"
    Examples:
      | title                | count |
      | Affair Prejudice     | 4     |
      | Alabama Devil        | 3     |
      | Aladdin Calendar     | 4     |
      | Alamo Videotape      | 4     |
      | Amadeus Holy         | 4     |
      | Amelie Hellfighters  | 3     |
      | Amistad Midsummer    | 4     |
      | Anaconda Confessions | 3     |
      | Analyze Hoosiers     | 4     |
      | Angels Life          | 4     |