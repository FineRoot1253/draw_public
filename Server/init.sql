CREATE TABLE TB_MEMBER(
id varchar(20) PRIMARY KEY,
pwd varchar(20) NOT NULL,
name varchar(20) NOT NULL,
nickName varchar(20) NOT NULL,
birth date NOT NULL
);
CREATE TABLE TB_BF(
bf_id varchar(20) ,
bf_nickName varchar(20) NOT NULL,
FOREIGN KEY (bf_id) REFERENCES TB_MEMBER(id)
);
CREATE TABLE TB_STATE(
st_id varchar(20),
member_state INTEGER,
roomNum INTEGER,
FOREIGN KEY (st_id) REFERENCES TB_MEMBER (id)
);
CREATE TABLE TB_ROOM(
bf_id varchar(20) ,
bf_nickName varchar(20) NOT NULL,
FOREIGN KEY (bf_id) REFERENCES TB_MEMBER(id)
);
CREATE TABLE TB_GAMERECORD(
gr_id varchar(20) NOT NULL,
gr_traitor integer,
gr_sheriff integer,
gr_aide integer,
gr_desperado integer,
gr_roundsum integer,
FOREIGN KEY (gr_id) REFERENCES TB_MEMBER(id)
);
create table TB_ROOM( 
ro_ch varchar(20) NOT NULL, 
ro_num varchar(20) NOT NULL, 
ro_people INTEGER NOT NULL
);
