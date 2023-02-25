Feature: Find the total sales of each staff for each month.
  Scenario Outline: Find the total sales of each staff for each month.
    Given verify given information: "<fullname>", "<month>" , "<sum>"
    Examples:
      | fullname     | month    | sum      |
      | Jon Stephens | April    | 14479.10 |
      | Mike Hillyer | February | 4160.84  |
      | Jon Stephens | March    | 12109.73 |
      | Mike Hillyer | March    | 11776.83 |
      | Jon Stephens | May      | 280.09   |
      | Mike Hillyer | April    | 14080.36 |
      | Mike Hillyer | May      | 234.09   |
      | Jon Stephens | February | 4191.00  |