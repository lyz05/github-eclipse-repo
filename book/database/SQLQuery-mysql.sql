/* 删除BookDB1数据库及用户 */
use mysql;
drop database BookDB1;

/*创建数据库（BookDB1）*/
CREATE DATABASE BookDB1;

/*转到（BookDB1）数据库*/
use BookDB1;

/*创建表结构*/
CREATE TABLE User
(
	username char(8) primary key,
	password char(255) not null,
	role char(8) not null
) ENGINE=INnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Book
(
	bookno char(10) primary key,
	bookname char(40) not null,
	author char(20) not null,
	press char(30) not null,
	price decimal(7,2) not null,
	publishdate date not null,
	shopnum int not null
) ENGINE=INnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Reader
(
	readerno char(8) primary key,
	readername char(8) not null,
	sex char(2) not null,
	identitycard char(18) not null,
	workunit char(50) not null,
	foreign key(readerno) references User(username) ON DELETE CASCADE
) ENGINE=INnoDB DEFAULT CHARSET=utf8;

CREATE TABLE Borrow
(
	readerno char(8),
	bookno char(10),
	borrowdate date not null,
	shoulddate date not null,
	returndate date,
	foreign key(bookno) references Book(bookno) ON DELETE CASCADE,
	foreign key(readerno) references Reader(readerno) ON DELETE CASCADE
) ENGINE=INnoDB DEFAULT CHARSET=utf8;

/* 为JDBC连接创建用户 */

/* 修改基本表约束 */
alter table Borrow add constraint CKtime check(borrowdate<=shoulddate);

/* 创建视图 */
-- 借阅未还视图
create view ViewBorrownotReturn
as
select * from Borrow where returndate is null;

-- 读者借阅视图
create view ViewBorrow
as
select Borrow.readerno,readername,Borrow.bookno,bookname,author,press,borrowdate,shoulddate,returndate from Borrow,Book,Reader where Borrow.bookno=Book.bookno and Borrow.readerno=Reader.readerno;

-- 读者图书视图
create view ViewBook
as
select Book.bookno,bookname,author,press,publishdate,shopnum,shopnum-count(ViewBorrownotReturn.bookno) curnum from ViewBorrownotReturn
right join Book on ViewBorrownotReturn.bookno=Book.bookno 
left join Reader on ViewBorrownotReturn.readerno=Reader.readerno
group by Book.bookno,bookname,author,press,publishdate,shopNum;

-- 管理员读者视图
create view ViewReaderAdmin 
as
select Reader.readerno,readername,sex,identitycard,workunit,count(Borrow.readerno) totalborrownum,count(Borrow.readerno)-count(Borrow.returndate) notreturnnum from Borrow
right join Reader on Borrow.readerno=Reader.readerno
left join Book on Borrow.bookno=Book.bookno 
group by Reader.readerno,Borrow.readerno,readername,sex,identitycard,workUnit;

-- 管理员图书视图
create view ViewBookAdmin
as
select Book.bookno,bookname,author,press,price,publishdate,shopNum,shopNum-count(ViewBorrownotReturn.bookno) curnum from ViewBorrownotReturn
right join Book on ViewBorrownotReturn.bookno=Book.bookno 
left join Reader on ViewBorrownotReturn.readerno=Reader.readerno
group by Book.bookno,bookname,author,press,publishdate,shopNum,price;

/*用户表(User)数据*/
INSERT INTO User VALUES('admin','','admin');
INSERT INTO User VALUES('R2005001','','reader');
INSERT INTO User VALUES('R2006001','','reader');
INSERT INTO User VALUES('R2007001','','reader');
INSERT INTO User VALUES('R2008001','','reader');
INSERT INTO User VALUES('R2009001','','reader');
INSERT INTO User VALUES('R2005002','','reader');
INSERT INTO User VALUES('R2006002','','reader');
INSERT INTO User VALUES('R2007002','','reader');
INSERT INTO User VALUES('R2008002','','reader');
INSERT INTO User VALUES('R2009002','','reader');
                                      
/*读者表（Reader）数据：*/
INSERT INTO Reader VALUES('R2005001','张小娟','女','412723199001014321','统一股份有限公司');
INSERT INTO Reader VALUES('R2006001','刘凤','女','412723199003014321','联合股份有限公司');
INSERT INTO Reader VALUES('R2007001','高代鹏','男','412723199005014321','洪都股份有限公司');
INSERT INTO Reader VALUES('R2008001','陈辉','男','412723199111014321','南昌市电脑研制公司');
INSERT INTO Reader VALUES('R2009001','李虹冰','女','412723199208014321','富士康科技集团');
INSERT INTO Reader VALUES('R2005002','张露','女','412723199002014321','兴隆股份有限公司');
INSERT INTO Reader VALUES('R2006002','喻自强','男','412723199004014321','万事达股份有限公司');
INSERT INTO Reader VALUES('R2007002','张晓梅','女','412723199112014321','世界技术开发公司');
INSERT INTO Reader VALUES('R2008002','张良','男','412723199110014321','上海生物研究室');
INSERT INTO Reader VALUES('R2009002','韩福平','男','412723199209014321','合生元有限公司');

/*图书表(Book)数据：*/
INSERT INTO Book VALUES('B200101001','政治经济学','宋涛','中国人民大学出版社',31.80,'19910101',5);
INSERT INTO Book VALUES('B200201001','大学英语','郑树棠','外语教学与研究出版社',35.20,'19920101',3);
INSERT INTO Book VALUES('B200301001','数据库系统原理','吴京慧','清华大学出版社',58.20,'19930101',3);
INSERT INTO Book VALUES('B200101002','微观经济学','张蕊','高等教育出版社',41.80,'19910102',2);
INSERT INTO Book VALUES('B200101003','宏观经济学','袁明圣','中国财经经济出版社',51.80,'19910103',2);
INSERT INTO Book VALUES('B200201002','商务英语','马升烨','上海外语学院出版社',45.20,'19920102',5);
INSERT INTO Book VALUES('B200201003','商务英语2','江宇佳','西安交通大学出版社',55.20,'19920103',3);
INSERT INTO Book VALUES('B200301002','组网技术','万征','浙江大学出版社',38.20,'19930102',1);
INSERT INTO Book VALUES('B200301003','人工智能','费翔林','电子工业出版社',43.20,'19930103',5);
INSERT INTO Book VALUES('B200301004','算法设计与分析','陈慧南','科学出版社',58.20,'19930104',10);

/*借阅表（Borrow）数据：*/
INSERT INTO Borrow VALUES('R2005001','B200101001','20110901','20111001',null);
INSERT INTO Borrow VALUES('R2006001','B200101001','20110907','20111007','20111005');
INSERT INTO Borrow VALUES('R2007001','B200201001','20110913','20111013','20111010');
INSERT INTO Borrow VALUES('R2008001','B200301001','20110915','20111015','20111013');
INSERT INTO Borrow VALUES('R2009001','B200301001','20110918','20111018',null);
INSERT INTO Borrow VALUES('R2005001','B200101002','20110902','20111002',null);
INSERT INTO Borrow VALUES('R2005001','B200101003','20110903','20111003',null);
INSERT INTO Borrow VALUES('R2005002','B200101001','20110904','20111004','20111003');
INSERT INTO Borrow VALUES('R2005002','B200101002','20110905','20111005',null);
INSERT INTO Borrow VALUES('R2005002','B200101003','20110906','20111006','20111008');
INSERT INTO Borrow VALUES('R2006001','B200101002','20110908','20111008','20111006');
INSERT INTO Borrow VALUES('R2006001','B200101003','20110909','20111009',null);
INSERT INTO Borrow VALUES('R2009002','B200201001','20110910','20111010','20111008');
INSERT INTO Borrow VALUES('R2006002','B200201002','20110911','20111011','20111008');
INSERT INTO Borrow VALUES('R2006002','B200201003','20110912','20111012','20111008');
INSERT INTO Borrow VALUES('R2007001','B200201002','20110914','20111014',null);
INSERT INTO Borrow VALUES('R2007001','B200201003','20110915','20111015','20111010');
INSERT INTO Borrow VALUES('R2009002','B200201001','20110916','20111016','20111014');
INSERT INTO Borrow VALUES('R2007002','B200201002','20110917','20111017','20111014');
INSERT INTO Borrow VALUES('R2007002','B200201003','20110917','20111017','20111014');



/* 测试用 */
delete from Borrow where bookno='B200301002'
select bookno from book where shopNum=1;
select * from User;
select * from Reader;
select * from Borrow;
select * from book;
select * from ViewBorrow;
select * from ViewBook;
select * from ViewReaderAdmin;
select * from ViewBookAdmin;
