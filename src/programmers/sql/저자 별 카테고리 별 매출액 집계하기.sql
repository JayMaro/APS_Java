SELECT b.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, SUM(bs.sales* b.price)  AS TOTAL_SALES
FROM book AS b
         INNER JOIN author AS a ON b.author_id = a.author_id
         INNER JOIN book_sales AS bs ON b.book_id = bs.book_id
WHERE bs.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY b.author_id, b.category
ORDER BY b.author_id ASC, b.category DESC