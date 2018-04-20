
SELECT * FROM menu 
WHERE '/yiyuan/registration/index.html' LIKE CONCAT('%',href,'%') AND myx!=0 AND LENGTH(href)>0

SELECT MID AS id,TEXT,CONCAT(href,'?toyz=',MID) AS href FROM Menu WHERE myx=1

SELECT *,1 FROM Usee INNER JOIN Role ON Usee.rid=Role.rid WHERE '张三' LIKE CONCAT('%',uname,'%')

SELECT MID FROM Jur WHERE rid=1


SELECT * FROM Menu WHERE TEXT LIKE '%'
LIMIT 0,5

SELECT * FROM 

SELECT COUNT(1) FROM (SELECT * FROM Menu WHERE TEXT LIKE CONCAT('%','','%')) AS T

SELECT * FROM Menu WHERE TEXT LIKE CONCAT('%','','%') LIMIT 0,5


SELECT * FROM role;
UPDATE usee SET rid=NULL WHERE rid=5


SELECT * FROM Menu;
SELECT * FROM Role;
SELECT * FROM Jur;
SELECT * FROM Usee;
SELECT * FROM KeRome;
SELECT * FROM Doctor;
SELECT * FROM GuaHao;
SELECT * FROM ZhuYuan;
SELECT * FROM Pay;
SELECT * FROM PayRed;
SELECT * FROM Yao;
SELECT * FROM FaYao;

SELECT COUNT(1) FROM (
	SELECT Usee.*,Role.rname,Role.rstate FROM Usee INNER JOIN Role ON Usee.rid=Role.rid WHERE uname LIKE CONCAT('%','','%')
) AS T


SELECT *,(SELECT kname FROM KeRome WHERE kid=Doctor.did) AS kname 
FROM Doctor 
WHERE did LIKE CONCAT('%','','%') AND d_zsname LIKE CONCAT('%','','%') 
AND kid IN (
	SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%','','%') 
)

SELECT *,(SELECT kname FROM KeRome WHERE kid=GuaHao.kid) AS kname,
(SELECT d_zsname FROM Doctor WHERE did=GuaHao.did) AS d_zsname  
FROM GuaHao

WHERE gid LIKE CONCAT('%','','%') 
AND did IN (SELECT did FROM Doctor WHERE d_zsname LIKE CONCAT('%','刘','%'))
AND kid IN (SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%','','%')) 
AND g_data BETWEEN '2001-1-1' AND '2020-2-2'

SELECT * FROM Yao 
WHERE y_name LIKE CONCAT('%','','%') AND `y_type`=1

SELECT * FROM ZhuYuan 
WHERE gid IN (
	SELECT gid FROM GuaHao
	WHERE gid LIKE CONCAT('%','','%') 
	AND did IN (SELECT did FROM Doctor WHERE d_zsname LIKE CONCAT('%','','%'))
	AND kid IN (SELECT kid FROM KeRome WHERE kname LIKE CONCAT('%','','%')) 
)
AND z_zydate BETWEEN '2001-1-1' AND '2020-2-2'

UPDATE Zhuyuan SET z_huli='小红2',z_cw='0022' WHERE zid=2


SELECT COUNT(1) FROM (SELECT *,(SELECT pname FROM Pay WHERE pid=PayRed.gid) AS pname FROM PayRed WHERE gid=1001) AS T

