Feature: Verify all the Hyperlinks are working on https://www.gtri.gatech.edu/
	@sanity
  Scenario Outline: verify all hyperlinks are working on gtri homepage
    Given User visited to the gtri home page
    When User click on each hyperlink
    Then User can launch the page successfully