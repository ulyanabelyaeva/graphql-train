insert into author (id, name) values (1, 'Chekhov');
insert into author (id, name) values (2, 'Dostoevsky');
insert into author (id, name) values (3, 'Pushkin');

insert into genre (id, name) values (1, 'Fantasy');
insert into genre (id, name) values (2, 'Horror');
insert into genre (id, name) values (3, 'Drama');

insert into book (id, name, page_count, author_id) values (1, 'Harry Potter', 1030, 1);
insert into book (id, name, page_count, author_id) values (2, 'Foo', 1030, 2);
insert into book (id, name, page_count, author_id) values (3, 'Game of Thrones', 1030, 3);
insert into book (id, name, page_count, author_id) values (4, 'Spring in Action', 1030, 2);

insert into book_genre_relation (id, book_id, genre_id) values (1, 1, 1);
insert into book_genre_relation (id, book_id, genre_id) values (2, 2, 2);
insert into book_genre_relation (id, book_id, genre_id) values (3, 3, 3);
insert into book_genre_relation (id, book_id, genre_id) values (4, 4, 1);