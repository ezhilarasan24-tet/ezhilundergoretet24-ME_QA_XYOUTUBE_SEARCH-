# ezhilundergoretet24-ME_QA_XYOUTUBE_SEARCH-
# 🎬 YouTube Automation Testing Framework (Selenium & TestNG)

An end-to-end UI test automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Gradle** to automate and validate key user workflows on [YouTube](https://youtube.com).

---

## 🛠️ Tech Stack & Tools
* **Language:** Java 11
* **Automation Tool:** Selenium WebDriver (v4.21.0)
* **Test Framework:** TestNG
* **Build Tool:** Gradle
* **Data-Driven Testing:** Apache POI (Excel `.xlsx` DataProvider)
* **Design Pattern:** Reusable Wrapper Methods (`Wrappers.java`) & Explicit Waits

---

## 📋 Automated Test Scenarios

| Test Case | Module / Section | Validation & Assertions |
| :--- | :--- | :--- |
| **`testCase01`** | **About YouTube** | Navigates to YouTube, verifies the URL, opens the **About** page, and logs the official mission statement. |
| **`testCase02`** | **Movies / Films** | Navigates to the **Movies & TV** section, scrolls to the end of the **Top Selling** carousel, and performs **Soft Assertions** on the maturity rating (`A`) and genre category (`Comedy`, `Animation`, `Drama`). |
| **`testCase03`** | **Music Tab** | Opens the **Music** section, navigates to the rightmost playlist in the first shelf, prints its title, and **Soft Asserts** that the track count is `<= 50`. |
| **`testCase04`** | **News Tab** | Navigates to the **News** section, extracts the title and body of the top 3 **Latest News Posts**, and calculates the total number of likes. |
| **`testCase05`** | **Data-Driven Search** | Uses TestNG `@DataProvider` with Apache POI to read search terms (`Movies`, `Music`, `Games`, `India`, `UK`) from `data.xlsx`, dynamically scrolls search results, and sums video views until reaching **10 Crore (100M)** views. |

---

## 📁 Project Structure

```text
├── src/test/java/demo/
│   ├── TestCases.java             # TestNG test methods & assertions
│   ├── utils/
│   │   └── ExcelDataProvider.java # Reads test data from Excel sheets
│   └── wrappers/
│       └── Wrappers.java          # Reusable Selenium actions, waits & parsers
├── src/test/resources/
│   ├── data.xlsx                  # Input data for data-driven search tests
│   └── testng.xml                 # TestNG suite configuration
├── build.gradle                   # Project dependencies & Gradle configuration
└── README.md                      # Project documentation
```

---

## 🚀 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com
   cd ezhilundergoretet24-ME_QA_XYOUTUBE_SEARCH-
   ```

2. **Run all TestNG tests using Gradle:**
   ```bash
   ./gradlew test
   ```

3. **View Test Reports:**
   Open `build/reports/tests/test/index.html` in any browser to view the detailed TestNG execution report.

---

## 👨‍💻 Author
**Ezhilarasan**  
[GitHub Profile](https://github.com)
# 🎬 YouTube Automation Testing Framework (Selenium & TestNG)

An end-to-end UI test automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Gradle** to automate and validate key user workflows on [YouTube](https://youtube.com).

---

## 🛠️ Tech Stack & Tools
* **Language:** Java 11
* **Automation Tool:** Selenium WebDriver (v4.21.0)
* **Test Framework:** TestNG
* **Build Tool:** Gradle
* **Data-Driven Testing:** Apache POI (Excel `.xlsx` DataProvider)
* **Design Pattern:** Reusable Wrapper Methods (`Wrappers.java`) & Explicit Waits

---

## 📋 Automated Test Scenarios

| Test Case | Module / Section | Validation & Assertions |
| :--- | :--- | :--- |
| **`testCase01`** | **About YouTube** | Navigates to YouTube, verifies the URL, opens the **About** page, and logs the official mission statement. |
| **`testCase02`** | **Movies / Films** | Navigates to the **Movies & TV** section, scrolls to the end of the **Top Selling** carousel, and performs **Soft Assertions** on the maturity rating (`A`) and genre category (`Comedy`, `Animation`, `Drama`). |
| **`testCase03`** | **Music Tab** | Opens the **Music** section, navigates to the rightmost playlist in the first shelf, prints its title, and **Soft Asserts** that the track count is `<= 50`. |
| **`testCase04`** | **News Tab** | Navigates to the **News** section, extracts the title and body of the top 3 **Latest News Posts**, and calculates the total number of likes. |
| **`testCase05`** | **Data-Driven Search** | Uses TestNG `@DataProvider` with Apache POI to read search terms (`Movies`, `Music`, `Games`, `India`, `UK`) from `data.xlsx`, dynamically scrolls search results, and sums video views until reaching **10 Crore (100M)** views. |

---

## 📁 Project Structure

```text
├── src/test/java/demo/
│   ├── TestCases.java             # TestNG test methods & assertions
│   ├── utils/
│   │   └── ExcelDataProvider.java # Reads test data from Excel sheets
│   └── wrappers/
│       └── Wrappers.java          # Reusable Selenium actions, waits & parsers
├── src/test/resources/
│   ├── data.xlsx                  # Input data for data-driven search tests
│   └── testng.xml                 # TestNG suite configuration
├── build.gradle                   # Project dependencies & Gradle configuration
└── README.md                      # Project documentation
```

---

## 🚀 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com
   cd ezhilundergoretet24-ME_QA_XYOUTUBE_SEARCH-
   ```

2. **Run all TestNG tests using Gradle:**
   ```bash
   ./gradlew test
   ```

3. **View Test Reports:**
   Open `build/reports/tests/test/index.html` in any browser to view the detailed TestNG execution report.

---

## 👨‍💻 Author
**Ezhilarasan**  
[ezhilarasan24-tet](https://github.com)
