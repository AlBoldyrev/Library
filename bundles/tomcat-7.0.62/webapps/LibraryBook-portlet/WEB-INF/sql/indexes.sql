create index IX_9BA3690 on librarian_Book (authorId);
create index IX_E286C41E on librarian_Book (bookName);

create index IX_2DBE094C on librarian_Books_Authors (authorId);
create index IX_AFD098AA on librarian_Books_Authors (bookId);