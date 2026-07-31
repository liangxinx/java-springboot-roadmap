# Java + Spring Boot 學習規劃

## 🎯 學習目標

完成 Java 基礎、SQL、Spring Boot 學習，並將原本使用 Python Flask 開發的專案改寫成 Java Spring Boot。

目標：
- 熟悉 Java 基礎語法
- 理解 Java 物件導向
- 熟悉 SQL 基本操作
- 學會 Spring Boot 後端開發流程（對齊古古的實戰脈絡）
- 完成 REST API
- 完成 Python Flask 專案移植

---

# 📅 25天總進度

| 時間 | 內容 | 完成狀態 |
|---|---|---|
| Day 1-10 | Java 基礎語法、物件導向與 SQL 同步練習 | ⬜ |
| Day 11-20 | Spring Boot 核心與資料庫（壓縮對齊古古課程） | ⬜ |
| Day 21-25 | Python Flask 專案改寫與前後端整合 | ⬜ |

---

# 第一階段：Java 基礎語法（Day 1-10）

# Day 01｜Java 開發環境與基本語法

Java：

- [X] 安裝與設定 Java 開發環境
- [X] IntelliJ IDEA 基本操作
- [X] Java 程式結構
- [X] main method 理解
- [X] 變數與資料型態
- [X] Primitive Type
- [X] Scanner 輸入

SQL：

- [X] SQLZoo Chapter 1
- [X] SQLZoo Chapter 2

---

# Day 02｜流程控制

Java：

- [X] 算術運算子
- [X] 比較運算子
- [X] 邏輯運算子
- [X] if / else
- [X] switch
- [X] for 迴圈
- [X] while 迴圈
- [X] break / continue


SQL：

- [X] SQLZoo Chapter 3
- [X] SQLZoo Chapter 4


今日產出：

- [X] 完成判斷式與迴圈練習


---

# Day 03｜Method 與 Array

Java：

- [X] Method 建立
- [X] Parameter 參數
- [X] Return 回傳值
- [X] Method 呼叫流程
- [X] Method Overloading
- [X] Array 陣列
- [X] 二維陣列


SQL：

- [X] SQLZoo Chapter 5

---

# Day 04｜String 與資料處理

Java：

- [X] String 基本概念
- [X] String 常用方法
- [X] equals 比較
- [X] StringBuilder
- [X] Arrays 工具類


SQL：

- [X] SQLZoo Chapter 6

---

# Day 05｜Class 與 Object

Java：

- [X] Class 類別
- [X] Object 物件
- [X] 屬性與方法
- [X] Constructor 建構子
- [X] this 關鍵字
- [X] Instance Variable


SQL：

- [X] SQLZoo Chapter 7


今日產出：

- [X] 建立第一個物件導向程式


---

# Day 06｜封裝與物件設計

Java：

- [X] Access Modifier
- [X] public
- [X] private
- [X] protected
- [X] Getter / Setter
- [X] static
- [X] final


SQL：

- [X] SQLZoo Chapter 8


今日產出：

- [X] 完成簡單 Java Class 設計


---

# Day 07｜繼承與多型

Java：

- [X] Inheritance 繼承
- [X] extends
- [X] super
- [X] Method Override
- [X] Polymorphism 多型
- [X] instanceof


SQL：

- [X] SQLZoo Chapter 9


今日產出：

- [X] 完成繼承與多型練習


---

# Day 08｜Interface 與 Exception

Java：

- [X] Interface
- [X] Abstract Class
- [X] Exception 概念
- [X] try / catch
- [X] finally
- [X] throws


SQL：

- [X] SQLZoo Chapter 10


今日產出：

- [X] 完成例外處理練習


---

# Day 09｜Collection Framework

Java：

- [X] ArrayList
- [X] LinkedList
- [X] HashMap
- [X] HashSet
- [X] Collection 使用情境


SQL：

- [X] SQLZoo Chapter 11
- [X] SQLZoo Chapter 12


今日產出：

- [X] 使用 Collection 完成資料管理


---

# Day 10｜Java整理與小專案

Java：

- [ ] Java語法總整理
- [ ] OOP概念整理
- [ ] Collection整理
- [ ] Exception整理


SQL：

- [ ] SQLZoo Chapter 13
- [ ] SQLZoo Chapter 14


實作：

完成 Java 小專案：

學生管理系統

功能：

- [ ] 新增學生
- [ ] 修改學生資料
- [ ] 刪除學生
- [ ] 查詢學生資料


今日產出：

- [ ] 完成 Java 基礎階段


---

# 第二階段：Spring Boot 核心與資料庫（Day 11-20，濃縮古古課程精華）

## Day 11 (對齊古古 Day 1-3)
- [ ] Spring Boot 簡介
- [ ] 開發環境安裝（Mac 版）
- [ ] 開發環境安裝（Windows 版）

## Day 12 (對齊古古 Day 4-6)
- [ ] 第一個 Spring Boot 程式
- [ ] Spring IoC 簡介
- [ ] IoC、DI、Bean 的介紹

## Day 13 (對齊古古 Day 7-9)
- [ ] Bean 的創建和注入 - @Component、@Autowired
- [ ] 指定注入的 Bean - @Qualifier
- [ ] Bean 的初始化 - @PostConstruct

## Day 14 (對齊古古 Day 10-12)
- [ ] 讀取 Spring Boot 設定檔 - @Value、application.properties
- [ ] Spring AOP 簡介
- [ ] Spring AOP 的用法 - @Aspect

## Day 15 (對齊古古 Day 13-15)
- [ ] Spring MVC 簡介
- [ ] Http 協議介紹
- [ ] Url 路徑對應 - @RequestMapping

## Day 16 (對齊古古 Day 16-18)
- [ ] 結構化的呈現數據 - JSON 格式介紹
- [ ] 返回值改成 JSON 格式 - @RestController
- [ ] 常見的 Http method - GET 和 POST

## Day 17 (對齊古古 Day 19-21)
- [ ] 取得請求參數（上）- @RequestParam、@RequestBody
- [ ] 取得請求參數（下）- @RequestHeader、@PathVariable
- [ ] RESTful API 介紹

## Day 18 (對齊古古 Day 22-24)
- [ ] RESTful API 實作 - @GetMapping、@PostMapping...
- [ ] Http Status Code（Http 狀態碼）介紹
- [ ] Spring JDBC 簡介

## Day 19 (對齊古古 Day 25-27)
- [ ] 資料庫連線設定、IntelliJ 資料庫管理工具介紹
- [ ] Spring JDBC 的用法（上）- 執行 INSERT、UPDATE、DELETE SQL
- [ ] Spring JDBC 的用法（下）- 執行 SELECT SQL

## Day 20 (對齊古古 Day 28-30)
- [ ] MVC 架構模式 - Controller-Service-Dao 三層式架構
- [ ] 實戰演練 - 打造一個簡單的圖書館系統
- [ ] Spring Boot 零基礎入門總結


---

# 第三階段：Python Flask → Spring Boot 專案移植（Day 21-25）

## Day 21
分析原 Python 專案：
- [ ] 梳理原 Flask 專案的資料表結構與 API 路由
- [ ] 在 Spring Boot 中建立對應的 Entity 與 Database Model

## Day 22
後端邏輯移植：
- [ ] 將 Flask 的商業邏輯改寫為 Spring Boot 的 Service
- [ ] 建立對應的 Repository 與資料庫互動

## Day 23
API 測試與 Debug：
- [ ] 使用 Postman 進行全面的 REST API 測試
- [ ] 修正型別對應、例外處理與邏輯上的 Bug

## Day 24
前後端串接與跨域設定：
- [ ] 處理前端與 Spring Boot 的 JSON 資料交換
- [ ] 設定 CORS 解決跨域問題

## Day 25
專案收尾與成果展示：
- [ ] 程式碼重構 (Refactor) 與專案清理
- [ ] 撰寫 README 說明文件
