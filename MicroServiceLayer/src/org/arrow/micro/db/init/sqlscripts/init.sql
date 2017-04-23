create table axk167131.login (Id number(10,0) not null, password varchar2(255 char), userId number(10,0) not null, username varchar2(255 char), primary key (Id))
create table axk167131.AuctionEventModel (AuctionId number(10,0) not null, actualEndDate timestamp, description varchar2(255 char), minBidIncrement double precision, name varchar2(255 char), reserveAmount double precision, scheduledEndDate timestamp, startDateTime timestamp, startingBid double precision, status number(10,0) not null, item_Itemid number(10,0), primary key (AuctionId))
create table axk167131.BidModel (BidId number(10,0) not null, UserId number(10,0) not null, amount double precision, dateTime timestamp, transactionId varchar2(255 char), primary key (BidId))
create table axk167131.Bids (AuctionId number(10,0) not null, bidModels_BidId number(10,0) not null, BidId number(19,0) not null, primary key (BidId))
create table axk167131.ItemModel (Itemid number(10,0) not null, Category varchar2(255 char), description varchar2(255 char), imageURL varchar2(255 char), name varchar2(255 char), primary key (Itemid))
alter table AXK167131.LOGIN add LoginId number(10,0) not null
alter table axk167131.Bids drop constraint UK_9oc72g4w25qetffc7yjmxdti8
alter table axk167131.Bids add constraint UK_9oc72g4w25qetffc7yjmxdti8 unique (bidModels_BidId)
create sequence axk167131.auctionids start with 1 increment by 1
create sequence axk167131.Bidids start with 1 increment by 1
create sequence axk167131.itemids start with 1 increment by 1
alter table axk167131.AuctionEventModel add constraint FK9s8qduh6sebreq1j1trwqxkcf foreign key (item_Itemid) references axk167131.ItemModel
alter table axk167131.Bids add constraint FKrgqixuiubbr9m9ea7e2s71djp foreign key (bidModels_BidId) references axk167131.BidModel
alter table axk167131.Bids add constraint FK93icc0qxj1gc4qe9svga9w0qt foreign key (AuctionId) references axk167131.AuctionEventModel
