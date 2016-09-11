create table librarian_Author (
	authorId LONG not null primary key,
	authorName VARCHAR(75) null,
	numberOfBooks LONG
);

create table librarian_Book (
	bookId LONG not null primary key,
	bookName VARCHAR(75) null,
	bookDescription VARCHAR(75) null,
	authorId LONG,
	authorName VARCHAR(75) null
);

create table librarian_Books_Authors (
	authorId LONG not null,
	bookId LONG not null,
	primary key (authorId, bookId)
);