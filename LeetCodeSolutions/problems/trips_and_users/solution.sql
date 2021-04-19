# Write your MySQL query statement below
SELECT t.Request_at AS Day, ROUND(COUNT(IF(t.Status != 'completed', TRUE, NULL))/COUNT(1),2) AS 'Cancellation Rate'  FROM TRIPS t
WHERE t.Request_at BETWEEN '2013-10-01' and '2013-10-03'
    AND t.Client_Id IN (SELECT Users_Id FROM USERS WHERE BANNED='No')
    AND t.Driver_Id IN (SELECT Users_Id FROM USERS WHERE BANNED='No')
GROUP BY t.Request_at;
