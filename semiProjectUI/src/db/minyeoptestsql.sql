DROP SEQUENCE SELL_BOARD_TB_SEQ;
DROP TABLE SELL_BOARD_TB;

CREATE TABLE SELL_BOARD_TB
(
    SELL_SEQ        NUMBER            NOT NULL, 
    SELLER          NUMBER            NULL, 
    TRADE_LAT       VARCHAR2(200)     NULL, 
    TRADE_LON       VARCHAR2(200)     NULL, 
    SELL_CONTENT    VARCHAR2(4000)    NULL, 
    STATUS          VARCHAR2(20)      NULL, 
    TITLE           VARCHAR2(200)     NULL, 
    REG_DATE        DATE              NULL, 
    CATEGORY        VARCHAR2(200)     NULL, 
    TAG             VARCHAR2(200)     NULL, 
    CONSTRAINT SELL_BOARD_TB_PK PRIMARY KEY (SELL_SEQ)
)
/

CREATE SEQUENCE SELL_BOARD_TB_SEQ
START WITH 1
INCREMENT BY 1;
/

--37.499036, 127.032909 KH 정보교육원 좌표 section에 넣자
--37.498197, 127.027642 강남역 좌표
--37.514242, 126.941627 노량진역 좌표
--37.266602, 126.999429 수원역 좌표

INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 1, '37.498197', '127.027642', 'SELL_CONTENT 1', 'STATUS 1', '강남역', sysdate, 'CATEGORY 1', 'TAG 1');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 2, '37.514242', '126.941627', 'SELL_CONTENT 2', 'STATUS 2', '노량진역', sysdate, 'CATEGORY 2', 'TAG 2');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 3, '37.266602', '126.999429', 'SELL_CONTENT 3', 'STATUS 3', '수원역', sysdate, 'CATEGORY 3', 'TAG 3');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 01, '37.455029', '126.898052', 'SELL_CONTENT 01', 'STATUS 01', 'TITLE 01', sysdate, 'CATEGORY 01', 'TAG 01');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 02, '36.247245', '127.252352', 'SELL_CONTENT 02', 'STATUS 02', 'TITLE 02', sysdate, 'CATEGORY 02', 'TAG 02');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 03, '37.342355', '126.236234', 'SELL_CONTENT 03', 'STATUS 03', 'TITLE 03', sysdate, 'CATEGORY 03', 'TAG 03');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 04, '37.342355', '127.252352', 'SELL_CONTENT 04', 'STATUS 04', 'TITLE 04', sysdate, 'CATEGORY 04', 'TAG 04');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 05, '36.247245', '126.898052', 'SELL_CONTENT 05', 'STATUS 05', 'TITLE 05', sysdate, 'CATEGORY 05', 'TAG 05');
INSERT INTO SELL_BOARD_TB (SELL_SEQ, SELLER, TRADE_LAT, TRADE_LON, SELL_CONTENT, STATUS, TITLE, REG_DATE, CATEGORY, TAG) VALUES (SELL_BOARD_TB_SEQ.NEXTVAL, 06, '37.342355', '127.252352', 'SELL_CONTENT 06', 'STATUS 06', 'TITLE 06', sysdate, 'CATEGORY 06', 'TAG 06');