# 🧪 QA Automation Challenge – Login Flow, Security Validation & Bug Reporting

## 🔗 Test Application
[Practice Test Automation Login Page](https://practicetestautomation.com/practice-test-login/)

---

## ✅ Tasks Covered

### 1. Positive Login Flow
- Navigate to the login page
- Use credentials:
  - **Username:** `student`
  - **Password:** `Password123`
- Click on login
- Verify redirection to `/logged-in-successfully/`
- Assert page contains:
  - ✅ "Congratulations" message
  - ✅ Visible **"Log out"** button

---

### 2. Negative Login Scenarios
Test the following combinations:
- ❌ Incorrect username, correct password
- ❌ Correct username, incorrect password
- ❌ Both incorrect

Take screenshots if:
- ❗ Error message is missing
- ❗ UI breaks
- ❗ Unexpected behavior occurs

---

### 3. Security Validation
- Attempt direct access to:  
  `https://practicetestautomation.com/logged-in-successfully/`  
- If access is granted without login → 🔐 **Report as a security issue**

---

### 4. Bug Reporting to Google Sheets
- Use `gspread` or `google-api-python-client`
- Log detected issues in Google Sheet with the following fields:
  - Scenario type
  - Input used
  - Issue description
  - Screenshot path
  - Timestamp

---

### 5. Screenshots
- Save screenshots of failed validations in the `screenshots/` directory

---

### 6. Screen Recording
- Record the entire test session using Loom or OBS  
- Ensure both automation execution and browser behavior are visible

---

## 📦 Deliverables

- 🔗 **Video Demo**: [Watch on Loom](https://www.loom.com/share/d8dc1abda522429cba870b05da291ac8?sid=cc076132-b6c1-4b0f-bd98-07c5f6d9cc94)
- 📄 **Bug Report Sheet**: [Google Sheet](https://docs.google.com/spreadsheets/d/1i11SzoElMmeutu0FQtQvx7NUMh3tklGHmNSQ62ICffM/edit?gid=0#gid=0)
- 🖼️ **Screenshots Folder**: [Google Drive](https://drive.google.com/drive/folders/1F8m-2uC_NBykYq9T6x7TcsdAbIrdBh24)
- 💻 **Source Code**: You're here in this repo!

---

> ℹ️ Tip: Clone the repo and install dependencies to run the automation suite locally.
