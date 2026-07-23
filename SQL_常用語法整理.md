# SQL 語法整理

### DISTINCT

**用途：** 去除重複資料。

``` sql
SELECT DISTINCT continent
FROM world;
```
------------------------------------------------------------------------

### LIKE

### `%` 前後任意字數

``` sql
WHERE name LIKE 'C%';
WHERE name LIKE '%C';
```
------------------------------------------------------------------------

### ORDER BY

由小到大：

``` sql
ORDER BY population;
```

由大到小：

``` sql
ORDER BY population DESC;
```

------------------------------------------------------------------------

### LIMIT
**用途：** 顯示前10筆資料

``` sql
SELECT *
FROM world
LIMIT 10;
```

------------------------------------------------------------------------

### HAVING

``` sql
SELECT continent, COUNT(*)
FROM world
GROUP BY continent
HAVING COUNT(*) > 10;
```

> WHERE：分組前篩選資料。\
> HAVING：分組後篩選結果。

------------------------------------------------------------------------

### 子查詢.

``` sql
SELECT name
FROM world
WHERE population >
(
    SELECT AVG(population)
    FROM world
);
```

### IN + 子查詢

``` sql
SELECT name
FROM world
WHERE continent IN
(
    SELECT continent
    FROM world
    WHERE name='Taiwan'
);
```

### NOT IN + 子查詢

``` sql
SELECT DISTINCT yr
FROM nobel
WHERE subject='Medicine'
AND yr NOT IN
(
    SELECT yr
    FROM nobel
    WHERE subject='Peace'
);
```
------------------------------------------------------------------------


