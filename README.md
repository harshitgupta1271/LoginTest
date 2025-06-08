
📋 Summary
This project automates end-to-end QA testing for a login-protected application:
🔗 Practice Test Automation Login Page

The tasks cover the following:

Positive Login Flow
Automate a successful login using valid credentials and verify redirection to /logged-in-successfully/, checking for confirmation messages and visibility of the "Log out" button.

Negative Login Scenarios
Test combinations of invalid username and/or password inputs. Verify that appropriate error messages are displayed. Take screenshots when:

Error message is missing

UI breaks

Unexpected behavior occurs

Security Validation
Attempt direct access to the success page without authentication. Report it as a security issue if access is granted.

Automated Bug Reporting to Google Sheets
Detected issues are logged into a Google Sheet using the gspread library, including:

Scenario type

Input used

Issue description

Screenshot path

Timestamp

Screenshots
All failed validations are captured and saved in the screenshots/ directory.

Screen Recording
Entire test run is recorded using Loom to demonstrate automation execution and browser behavior.

Deliverables
Item	Status	Link
Video Demo	Watch on Loom
📄 Google Sheet (Bug Log)		View Sheet
🖼️ Screenshots Folder		Open Google Drive Folder
💻 Source Code (This Repo)		You're already here!

