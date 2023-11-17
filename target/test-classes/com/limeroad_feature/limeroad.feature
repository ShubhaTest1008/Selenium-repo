


Feature: Limeroad order

Scenario: Select Women Module

When User launch the URL "https://www.limeroad.com"

Then User Clicks on Shop Women option 


Scenario:  Add women earrings to cart

Given User clicks on "Women" option

When User clicks on Earring option

And User selects the earring

Then User clicks on "Add to cart"

And User close the browser
