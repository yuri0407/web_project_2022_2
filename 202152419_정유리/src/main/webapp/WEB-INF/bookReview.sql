# 도서
CREATE TABLE br_book(
	bNo INT(3) PRIMARY KEY,
	bName VARCHAR(70),
	writer VARCHAR(40),
	publisher VARCHAR(70),
	pDate VARCHAR(30),
	category VARCHAR(3),
	bContent VARCHAR(20000)
	bImage VARCHAR(70)
	);
	
# 회원
CREATE TABLE br_member(
	id VARCHAR(30) PRIMARY KEY,
	pwd VARCHAR(30),
	email VARCHAR(40)
);

# Q&A
CREATE TABLE br_question(
	qNo INT(3) PRIMARY KEY,
	qTitle varchar(500),
	qContent VARCHAR(1000),
	qDate Date,
	mAnswer VARCHAR(1000)
	);
	
# 도서추가요청
CREATE TABLE br_request(
	rNo INT(3) PRIMARY KEY,
	rName VARCHAR(30),
	rContent VARCHAR(3000),
	rDate Date);
	
# 도서리뷰	
CREATE TABLE br_review(
	rNum INT(3) PRIMARY KEY,
	nickName VARCHAR(30),
	bname VARCHAR(70),
	content VARCHAR(3000));
	
	
# 샘플 데이터
INSERT INTO br_book
VALUES(NULL, 'the midnight library', 'Haig, matt', 'Cannongate', '2021-02-18', 800, '도서소개', 'the midnight library.jpg');

INSERT INTO br_book
VALUES(NULL, '오늘도, 우리는 코딩을 합니다.', '이진현', '비제이퍼블릭', '2021-04-29', 500, '도서소개', '오늘도 우리는 코딩을 합니다.jpg');

INSERT INTO br_book
VALUES(NULL, '크리스마스 타일', '김금희', '창비', '2022-11-25', 800, '도서소개', '크리스마스 타일.jpg');

INSERT INTO br_book
VALUES(NULL, '불편한 편의점', '김호연', '나무옆의자', '2021-04-20', 800, '도서소개', '불편한 편의점.jpg');

INSERT INTO br_book
VALUES(NULL, '오늘 밤, 세계에서 이 사랑이 사라진다 해도', '이치조 미사키', '모모', '2021-06-28', 800, '도서소개', '오늘밤_세계_사랑.jpg');


INSERT INTO br_member
VALUES('wjddbfl1029', 'wjddbfl!@#$', 'wjddbfl1029@naver.com');

INSERT INTO br_member
VALUES('asdf1029', 'asdf!@', 'asdf1029@gmail.com');

INSERT INTO br_member
VALUES('dbfl1234', 'dbfl!@#$', 'dbfl1234@gmail.com');


INSERT INTO br_question
VALUES(NULL, '로그인 관련해서 질문있습니다.','아이디를 잊어버려서 찾고 싶은데 이 사이트에 가입할 때 등록했던 이메일이 지금은 사용할 수 없는
                    메일주소라서 아이디를 찾을 수가 없습니다.. 어떻게 해야 할지 알려주시면 감사하겠습니다.', NOW(), '');


INSERT INTO br_request
VALUES(NULL, '유리', 'the midnight library라는 책을 추가해주셨으면 좋겠습니다.', NOW()); 

INSERT INTO br_request
VALUES(NULL, 'stella', '[불편한 편의점] 추가해주세요.', NOW());
                   
                    
INSERT INTO br_review
VALUES(NULL, '유리', 'the midnight library', '영어공부하기 좋았습니다. 재밌게 잘 읽었어요..!');

INSERT INTO br_review
VALUES(NULL, '유리', '오늘부터 개발자', '너무 어려웠어요.. 개발자 때려치우려구요.');