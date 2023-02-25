Feature: Homework

  Scenario: Find out the customer id, name, surname, the city and the country of the customers who make the most purchases and how much money they have spent ?
    Given customer_id must match with "148" in first row

  Scenario Outline: Find out the customer id, name, surname, the city and the country of the customers who make the most purchases and how much money they have spent ?
    Given verify given information: "<id>", "<fullname>", "<city>","<country>","<total_amount>"
    Examples:
      | id  | fullname       | city                | country       | total_amount |
      | 148 | Eleanor Hunt   | Saint-Denis         | Runion        | 211.55       |
      | 526 | Karl Seal      | Cape Coral          | United States | 208.58       |
      | 178 | Marion Snyder  | Santa Brbara dOeste | Brazil        | 194.61       |
      | 137 | Rhonda Kennedy | Apeldoorn           | Netherlands   | 191.62       |
      | 144 | Clara Shaw     | Molodetno           | Belarus       | 189.60       |
      | 459 | Tommy Collazo  | Qomsheh             | Iran          | 183.63       |
      | 181 | Ana Bradley    | Memphis             | United States | 167.67       |
      | 410 | Curtis Irby    | Richmond Hill       | Canada        | 167.62       |
      | 236 | Marcia Dean    | Tanza               | Philippines   | 166.61       |
      | 403 | Mike Way       | Valparai            | India         | 162.67       |


