# Java — Day 6 筆記

## Access Modifier

### Java 的四種存取層級

| 修飾詞 | 同一個 class | 同一個 package | 不同 package 的子類別 | 完全不相關的地方 |
|---|---|---|---|---|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| （不寫，default） | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

> `protected`：跟 `private` 類似，但對「繼承」開放

物件導向設計最常見、最標準的模式：**屬性設 `private`，方法設 `public`**

---

## Getter / Setter

上一節把屬性都改成 `private` 之後，你可能會想到一個問題：外部完全不能碰屬性了，那如果我真的需要讀取或修改屬性的值，該怎麼辦？這就是 Getter 和 Setter 存在的原因。

- **Getter**：讀取屬性值的 method。命名慣例：`get` + 屬性名稱（第一個字母大寫），回傳該屬性的型態
- **Setter**：修改屬性值的 method。命名慣例：`set` + 屬性名稱，參數是要設定的新值，通常沒有回傳值（`void`）

Setter 是一個 method，你可以在裡面加入驗證邏輯，這是單純把屬性設成 `public` 做不到的事。

如果 `age` 是 `public`，任何人都可以直接寫 `dog1.age = -5;`，沒有任何機制可以阻止不合理的資料，這就是為什麼「屬性 `private` + 用 Setter 控制修改」比「屬性直接 `public`」安全非常多。

---

## static

- `static` 修飾的東西，會變成整個 class 共用同一份
- `static` 不需要 `new`，用「Class名稱」存取，不用物件
- `static` method 不能直接使用非 `static` 的屬性
- 非 `static` 的 method 可以使用 `static` 變數，因為只要程式有在跑，`static` 變數就一定存在

### static vs 非 static 對照表

| | static | 非 static（Instance） |
|---|---|---|
| 屬於誰 | Class 本身 | 每一個物件各自擁有 |
| 需要 `new` 物件才能用嗎 | 不需要 | 需要 |
| 存取方式 | `ClassName.成員` | `物件名稱.成員` |
| 記憶體 | 整個程式只有一份 | 每個物件各一份 |
| 適合存什麼 | 全域共用的資料/工具方法（計數器、常數、數學運算） | 每個物件獨立的狀態（名字、年齡） |

---

## final

`final` 的核心意思是：**這個東西一旦被賦值/定義，就不能再被改變**。

### 常見用途一：常數（Constant）

`final` 最常見的用法是定義「永遠不會變」的常數，例如圓周率、稅率、最大值限制等。
慣例上會搭配 `static`，並且變數名稱全部大寫、用底線分隔單字。

### 常見用途二：Instance Variable 設 final——建立後不可修改的屬性

### final 用在 method 上

加了 `final`，這個 method 之後不能被子類別覆寫（override）

### final 用在 class 上

這個 class 不能被其他 class 繼承
