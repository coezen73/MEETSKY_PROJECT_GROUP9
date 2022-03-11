Feature: Add New folder, it should expect all chars as file name


	#{color:#ff0000}*US*{color}
	#
	#As a user, I can upload a file
	#
	#{color:#ff0000}*AC*{color}
	#
	#Add New folder, it should expect all chars as file name
  @ETSKY-345 @wip
  Scenario: Add File functionality automation
    Given the user logged in
    When user should be click the add icon module
    Then user should be able to click "New folder" button
    Then user should be able to write "Şükriye_Doğaç!" file name
    Then user should be able to click confirm icon
    And verify new "Şükriye_Doğaç!" file is shown on the page

  @wip
  Scenario: User can upload a file
    Given the user logged in
    When  user should be click the add icon module
    Then user should be able to upload "HelloMeetSky" file name
    And verify new "HelloMeetSky" file is shown on the page

#*US:*
	#
	#*As a user, I should be able to Delete any selected file under the Files module.*
	#
	#*AC:*
	#
	#*Users can delete any selected item from the Files module.*
	#
	# 
  @ETSKY-325 @wip
  Scenario: Delete File functionality - Cucumber S3

    Given the user logged in
    When user should be able to click file button
    Then verify that Actions button is appeared
    Then user should be able to click delete buttons
    And verify that the file is deleted

