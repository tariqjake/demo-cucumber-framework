@db
  Feature: Homework DB verification

    Scenario: Verify the homework first questions's answer with DB
      Given the phone number "912257250465" should match the DB record

    Scenario: Verify the homework second questions's answer with DB
      Given the title "Dragon Squad" and rating "NC-17" should match the DB record

    Scenario: Verify the homework third questions's answer with DB
      Given the movie amount "5" should match the DB record

#    Scenario: Verify the homework forth questions's answer with DB
#      Given the movie count 0 should match the DB record