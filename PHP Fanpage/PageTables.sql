CREATE TABLE pic (
idpic INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
caption VARCHAR(45) NOT NULL,
img VARCHAR(100) NOT NULL,
PRIMARY KEY(idpic)
);

insert into pic values (1, "Gattaca", 'Gattaca.jpg');
insert into pic values (2, "The Thing", 'TheThing.jpg');
insert into pic values (3, "Alien", 'Alien.jpg');
insert into pic values (4, "The Matrix", 'TheMatrix.png');
insert into pic values (5, "Logan's Run", 'LogansRun.jpg');

CREATE TABLE note (
idnote INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
note VARCHAR(250) NOT NULL,
PRIMARY KEY(idnote)
);

insert into note values (1, "Gattaca, Directed by Andrew Niccol");
insert into note values (2, "The Thing, Directed by John Carpenter");
insert into note values (3, "Alien, Directed by Ridley Scott");
insert into note values (4, "The Matrix, Directed by Lana and Lilly Wachowski");
insert into note values (5, "Logan's Run, Directed by Michael Anderson");
insert into note values (6, "Fantastic Symbolism");
insert into note values (7, "John Carpenter's Best Horror Work");
insert into note values (8, "Suspense Used Masterfully to Engross");
insert into note values (9, "Reality Bending Action Sequences That Are Still Unmatched");
insert into note values (10, "A Vintage SciFi Film that Inspired So Many Afterwards");
insert into note values (11, "Compelling Soundtrack");
insert into note values (12, "Outstanding Cast Including Kurt Russel and Keith David");
insert into note values (13, "Great Use of Miniatures Make This Classic Hold Up");
insert into note values (14, "Its Parallel Storytelling Keeps This One An Interesting Watch");
insert into note values (15, "Has A Vast Amount of Beautiful Scenery");
insert into note values (16, "Powerful Illustration of Pure Humanity");
insert into note values (17, "Nihilism Made Even More Grounded Through Outstanding Realism");
insert into note values (18, "One of Sigourney Weaver's Best Performances Next to its Sequel");
insert into note values (19, "Extremely Original Concept");
insert into note values (20, "Amazing Interpretation of the Novel");

CREATE TABLE submission (
email VARCHAR(200) NOT NULL,
mess VARCHAR(250) NOT NULL
);