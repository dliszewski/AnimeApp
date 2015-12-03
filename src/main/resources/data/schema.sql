DROP TABLE IF EXISTS Episodes;
DROP TABLE IF EXISTS Tags;
DROP TABLE IF EXISTS Series;

CREATE TABLE Series
(
  id         SERIAL PRIMARY KEY NOT NULL,
  title      VARCHAR(250),
  typ        VARCHAR(50),
  status     VARCHAR(50),
  summary    VARCHAR(1500),
  orgtitle   VARCHAR(250),
  coverImg   VARCHAR(250),
  seotitle   VARCHAR(250),
  rating     INTEGER,
  timesrated INTEGER,
  views      INTEGER
);

CREATE TABLE Episodes
(
  id          SERIAL PRIMARY KEY NOT NULL,
  seriesId     INT,
  title       VARCHAR(250),
  number      INTEGER,
  summary     VARCHAR(250),
  added       DATE,
  view        INTEGER,
  rating      FLOAT,
  timesrated  INTEGER,
  video       VARCHAR(1000),
  seotitle    VARCHAR(250),
  videomirror VARCHAR(1000)
);
ALTER TABLE Episodes ADD CONSTRAINT FK_Episodes_SeriesId FOREIGN KEY (seriesId) REFERENCES Series (id);

CREATE TABLE Tags
(
  id          SERIAL PRIMARY KEY NOT NULL,
  seriesId    INT,
  name       VARCHAR(250),
  seoname      VARCHAR(250)
);
ALTER TABLE Tags ADD CONSTRAINT FK_Tags_seriesId FOREIGN KEY (seriesId) REFERENCES Series (id);

