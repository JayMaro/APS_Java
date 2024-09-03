programmers.sql

SELECT ii.FLAVOR FROM FIRST_HALF fh LEFT JOIN ICECREAM_INFO ii ON fh.FLAVOR = ii.FLAVOR
WHERE fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC