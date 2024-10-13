SELECT
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    IFNULL(SUM(1), 0) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
        YEAR(START_DATE) = 2022
  AND (MONTH(START_DATE) > 7 AND MONTH(START_DATE) < 11)
  AND CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
            YEAR(START_DATE) = 2022
      AND (MONTH(START_DATE) > 7 AND MONTH(START_DATE) < 11)
    GROUP BY CAR_ID
    HAVING IFNULL(SUM(1), 0) >= 5
)
GROUP BY MONTH, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC
#
## BETWEEN과 COUNT를 활용용SELECT
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(1) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
  AND CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(1) >= 5
)
GROUP BY MONTH, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC