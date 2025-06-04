import gspread
from google.oauth2.service_account import Credentials
from datetime import datetime


scopes = ["https://www.googleapis.com/auth/spreadsheets"]
creds = Credentials.from_service_account_file("credentials.json", scopes=scopes)
client = gspread.authorize(creds)


sheet_id = "1i11SzoElMmeutu0FQtQvx7NUMh3tklGHmNSQ62ICffM"
sheet = client.open_by_key(sheet_id)
worksheet = sheet.sheet1 


worksheet.clear()


header = ["Scenario", "Input Used", "Issue Found", "Screenshot Path", "Timestamp (Date)", "Timestamp (Time)"]
worksheet.append_row(header)

current_date = datetime.now().strftime("%Y-%m-%d")
current_time = datetime.now().strftime("%H:%M")


bug_reports = [
    ["Login", "Incorrect username, correct password", "Error message shown", "LoginFailed_20250603_223703.png", current_date, current_time],
    ["Login", "Correct username, incorrect password", "Error message shown", "screenshots/invalid_password.png", current_date, current_time],
    ["Login", "Both username and password incorrect", "Error message shown", "BothIncorrect_WrongMessage_20250603_223022.png", current_date, current_time],
    ["Access Control", "Accessed restricted page without login", "Security issue – no redirect or error", "AccessControl_SecurityIssue_20250603_223031.png", current_date, current_time]
]


for bug in bug_reports:
    worksheet.append_row(bug)

print("Bug reports (without 'Negative') added successfully.")
