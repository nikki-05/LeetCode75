# Write your MySQL query statement below
SELECT 
    ROUND(
        100.0 * SUM(CASE WHEN D.order_date = D.customer_pref_delivery_date THEN 1 ELSE 0 END)
        / COUNT(*), 
        2
    ) AS immediate_percentage
FROM Delivery D
JOIN (
    -- Step 1: Get the first order (earliest order_date) for each customer
    SELECT customer_id, MIN(order_date) AS first_order_date
    FROM Delivery
    GROUP BY customer_id
) F
ON D.customer_id = F.customer_id AND D.order_date = F.first_order_date;
