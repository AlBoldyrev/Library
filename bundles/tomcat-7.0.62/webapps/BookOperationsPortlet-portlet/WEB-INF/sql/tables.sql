create table bookandauthoroperations_Author (
	authorId LONG not null primary key,
	authorName VARCHAR(75) null
);

create table bookandauthoroperations_Book (
	bookId LONG not null primary key,
	bookName VARCHAR(75) null,
	bookDescription VARCHAR(75) null,
	authorId LONG
);